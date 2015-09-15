package com.unep.wcmc.service;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ChangeLogRepository;
import com.unep.wcmc.repository.UserRepository;
import com.unep.wcmc.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.unep.wcmc.model.UserRole.RoleType.*;

@Service
public final class ChangeLogService extends AbstractService<ChangeLog, ChangeLogRepository> {

    @Autowired
    private MetadataService metadataService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SpeciesService speciesService;

    public Page<ChangeLog> searchAll(Long speciesId, Pageable pageable) {
        if (SecurityUtils.hasAnyRole(ADMIN, SUPERADMIN, EXPERT)) {
            return repo.findBySpeciesId(speciesId, pageable);
        } else {
            return repo.findBySpeciesIdAndRequestedByUsername(speciesId, SecurityUtils.getUser(), pageable);
        }
    }

    public void saveChangeLogs(Species species) {
        List<ChangeLog> changeLogs = metadataService.retrieveMetadata(species);
        repo.save(changeLogs);
    }

    public ChangeLog approveChange(Long id) {
        ChangeLog changeLog = repo.findOne(id);
        if (changeLog != null) {
            try {
                changeLog = metadataService.applyMetadata(changeLog);
                // save the species data with the metadata changed
                speciesService.doSave(changeLog.getSpecies());

                changeLog.setReviewedBy(userRepo.findByUsername(SecurityUtils.getUser()));
                changeLog.setStatus(ChangeLog.ChangeStatus.ACCEPTED);
                changeLog.setUpdatedAt(new Date());
                changeLog = repo.save(changeLog);
            } catch (Exception ex) {

                return null;
            }
        }
        return changeLog;
    }

    public ChangeLog rejectChange(Long id) {
        ChangeLog changeLog = repo.findOne(id);
        if (changeLog != null) {
            changeLog.setReviewedBy(userRepo.findByUsername(SecurityUtils.getUser()));
            changeLog.setStatus(ChangeLog.ChangeStatus.REJECTED);
            changeLog.setUpdatedAt(new Date());
            changeLog = repo.save(changeLog);
        }
        return changeLog;
    }

}
