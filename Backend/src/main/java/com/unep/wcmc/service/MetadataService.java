package com.unep.wcmc.service;

import com.unep.wcmc.helper.ReflectionUtils;
import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.SpeciesRepository;
import com.unep.wcmc.repository.UserRepository;
import com.unep.wcmc.security.SecurityUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.javers.common.collections.Optional;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.NewObject;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.ReferenceChange;
import org.javers.core.diff.changetype.ValueChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@SuppressWarnings("all")
public class MetadataService {

    @Autowired
    private Javers javers;

    @Autowired
    private SpeciesRepository speciesRepo;

    @Autowired
    private UserRepository userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ChangeLog> retrieveMetadata(Species species) {
        List<ChangeLog> result = new ArrayList<>();

        Species existing = speciesRepo.getFetchLoadedById(species.getId());
        Diff diff = javers.compare(existing, species);

        if (diff.hasChanges()) {
            // processing the value changes on diff
            List<ValueChange> valueChanges = diff.getChangesByType(ValueChange.class);
            for (ValueChange change : valueChanges) {
                ChangeLog changeLog = createChangeLog(change, null, species, ChangeLog.ChangeType.VALUE_CHANGE);
                result.add(changeLog);
            }
            // processing the reference changes on diff
            List<ReferenceChange> refChanges = diff.getChangesByType(ReferenceChange.class);
            for (ReferenceChange change : refChanges) {
                // processing the new object added on diff
                if (change.getLeft() == null) {
                    NewObject newObject = diff.getChangesByType(NewObject.class)
                            .stream().filter(obj -> obj.getAffectedGlobalId().equals(change.getRight()))
                            .findFirst().orElse(null);
                    ChangeLog changeLog = createChangeLog(change, newObject, species, ChangeLog.ChangeType.NEW_OBJECT);
                    result.add(changeLog);
                }

            }
            // processing the removed object changes on diff
//            List<ObjectRemoved> removedChanges = diff.getChangesByType(ObjectRemoved.class);
//            for (ObjectRemoved change : removedChanges) {
//                ChangeLog changeLog = createChangeLog(species, change, ChangeLog.ChangeType.REMOVED_OBJECT);
//                result.add(changeLog);
//            }
        }
        return result;
    }

    public ChangeLog createChangeLog(PropertyChange propertyChange, Change added, Species species, ChangeLog.ChangeType type) {
        ChangeLog changeLog = new ChangeLog();
        changeLog.setRequestedBy(userRepo.findByUsername(SecurityUtils.getUser()));
        changeLog.setRequestedDate(new Date());
        changeLog.setUpdatedAt(new Date());
        changeLog.setSpecies(species);
        changeLog.setStatus(ChangeLog.ChangeStatus.REQUESTED);
        changeLog.setFieldName(propertyChange.getPropertyName());
        changeLog.setType(type);
        changeLog.setChangeRequestDesc(species.getChangeRequestDesc());
        if (type == ChangeLog.ChangeType.NEW_OBJECT && added != null) {
            String newAddLog = javers.getJsonConverter().toJson(added.getAffectedObject());
            changeLog.setNewAddLog(newAddLog);
        }
        String log = javers.getJsonConverter().toJson(propertyChange);
        changeLog.setChangeLog(log);
        return changeLog;
    }



    public Change loadFromChangeLog(ChangeLog changeLog) {
        Change change = javers.getJsonConverter().fromJson(changeLog.getChangeLog(), Change.class);
        if (change instanceof NewObject) {
            Optional<Object> cdo = javers.getJsonConverter().fromJson(changeLog.getNewAddLog(), Optional.class);
            change = new NewObject(change.getAffectedGlobalId(), cdo);

        }
        return change;
    }

    protected void processValueChange(ValueChange valueChange, ChangeLog changeLog) throws Exception {
        Class clazz = Class.forName(valueChange.getAffectedGlobalId().getCdoClass().getName());
        String property = null;
        if (!clazz.equals(Species.class)) {
            property = ReflectionUtils.findAttributeName(Species.class, clazz, "") +
                    "." + valueChange.getPropertyName();
        } else {
            property = valueChange.getPropertyName();
        }
        Object value = valueChange.getRight();
        PropertyUtils.setProperty(changeLog.getSpecies(), property, value);
    }

    protected void processNewObjectChange(ReferenceChange refChange, ChangeLog changeLog) throws Exception {
        Optional<Object> cdo = javers.getJsonConverter().fromJson(changeLog.getNewAddLog(), Optional.class);
        if (cdo.get() != null) {
            PropertyUtils.setProperty(changeLog.getSpecies(), refChange.getPropertyName(), cdo.get());
        }
    }

    protected void processRemoveObjectChange(ReferenceChange refChange, ChangeLog changeLog) throws Exception {
        Optional<Object> cdo = javers.getJsonConverter().fromJson(changeLog.getNewAddLog(), Optional.class);
        if (cdo.get() != null) {
            PropertyUtils.setProperty(changeLog.getSpecies(), refChange.getPropertyName(), cdo.get());
        }
    }

    public ChangeLog applyMetadata(ChangeLog changeLog) throws Exception {
        if (changeLog.getStatus() == ChangeLog.ChangeStatus.REQUESTED) {
            Change change = loadFromChangeLog(changeLog);
            if (change instanceof ValueChange) {
                processValueChange((ValueChange) change, changeLog);
            } else if (change instanceof ReferenceChange) {
                if (changeLog.getType() == ChangeLog.ChangeType.NEW_OBJECT) {
                    processNewObjectChange((ReferenceChange) change, changeLog);
                } else if (changeLog.getType() == ChangeLog.ChangeType.REMOVED_OBJECT) {
                    // TODO removeObject metadata change
                }
            }
        }
        return changeLog;
    }
}
