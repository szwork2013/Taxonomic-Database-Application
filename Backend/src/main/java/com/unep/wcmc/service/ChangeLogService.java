package com.unep.wcmc.service;

import com.unep.wcmc.helper.MailUtils;
import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.User;
import com.unep.wcmc.model.UserRole;
import com.unep.wcmc.repository.ChangeLogRepository;
import com.unep.wcmc.repository.UserRepository;
import com.unep.wcmc.security.SecurityUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.unep.wcmc.model.UserRole.RoleType.*;

@Service
public final class ChangeLogService extends AbstractService<ChangeLog, ChangeLogRepository> {

    protected static final Log logger = LogFactory.getLog(ChangeLogService.class);

    @Autowired
    private MetadataService metadataService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private MailUtils mailUtils;

    /**
     * Searches all the change logs for a particular species
     *
     * @param speciesId
     * @param pageable
     * @return
     */
    public Page<ChangeLog> searchAll(Long speciesId, Pageable pageable) {
        if (SecurityUtils.hasAnyRole(ADMIN, SUPERADMIN, EXPERT)) {
            return repo.findBySpeciesId(speciesId, pageable);
        } else {
            return repo.findBySpeciesIdAndRequestedByUsername(speciesId, SecurityUtils.getUser(), pageable);
        }
    }

    /**
     * Saves and request the metadata changes for the species
     *
     * @param species
     */
    public void saveChangeLogs(Species species) {
        List<ChangeLog> changeLogs = metadataService.retrieveMetadata(species);
        if (changeLogs != null && !changeLogs.isEmpty()) {
            repo.save(changeLogs);

            // NOTE: only sending emails to the ADMIN (EXPERTs should be associated with the specie anywhere)
            List<User> adminList = userRepo.findByUserRoleRole(UserRole.RoleType.ADMIN.name());
            for (ChangeLog changeLog : changeLogs) {
                sendEmail("Metadata change requested for Species #" + changeLog.getSpecies().getId(),
                        MailUtils.CHANGE_REQUESTED_TEMPLATE, changeLog, adminList);
            }
        }
    }

    /**
     * Approves the metadata change request process
     *
     * @param id
     * @return
     */
    public ChangeLog approveChange(Long id) {
        ChangeLog changeLog = repo.findOne(id);
        if (changeLog != null) {
            try {
                changeLog = metadataService.applyMetadata(changeLog);
                // save the species data with the metadata changed
                speciesService.doSave(changeLog.getSpecies());

                User reviewedUser = userRepo.findByUsername(SecurityUtils.getUser());
                changeLog.setReviewedBy(reviewedUser);
                changeLog.setStatus(ChangeLog.ChangeStatus.ACCEPTED);
                changeLog.setUpdatedAt(new Date());
                changeLog = repo.save(changeLog);

                sendEmail("Metadata change approved for Species #" + changeLog.getSpecies().getId(),
                        MailUtils.CHANGE_APPROVED_TEMPLATE, changeLog);

            } catch (Exception ex) {
                logger.error("Error for approve change on metadata request", ex);
                return null;
            }
        }
        return changeLog;
    }

    /**
     * Rejects the metadata change request process
     *
     * @param id
     * @return
     */
    public ChangeLog rejectChange(Long id) {
        ChangeLog changeLog = repo.findOne(id);
        if (changeLog != null) {
            changeLog.setReviewedBy(userRepo.findByUsername(SecurityUtils.getUser()));
            changeLog.setStatus(ChangeLog.ChangeStatus.REJECTED);
            changeLog.setUpdatedAt(new Date());
            changeLog = repo.save(changeLog);

            sendEmail("Metadata change rejected for Species #" + changeLog.getSpecies().getId(),
                    MailUtils.CHANGE_REJECTED_TEMPLATE, changeLog);
        }
        return changeLog;
    }

    /**
     * Sends the change log email notification to list of users
     *
     * @param template
     * @param changeLog
     * @param toUsers
     */
    private void sendEmail(String subject, String template, ChangeLog changeLog, List<User> toUsers) {
        for (User user : toUsers) {
            Map<String, Object> mailParameters = new HashMap<>();
            mailParameters.put("user", user);
            mailParameters.put("url", "http://especies-qa.unep-wcmc.org/#/specie/" +
                    changeLog.getSpecies().getId());
            mailUtils.sendEmail(user.getEmail(), changeLog.getRequestedBy().getEmail(),
                    subject, template, mailParameters);
        }
    }

    /**
     * Sends the change log email notification
     *
     * @param template
     * @param changeLog
     */
    private void sendEmail(String subject, String template, ChangeLog changeLog) {
        Map<String, Object> mailParameters = new HashMap<>();
        mailParameters.put("user", changeLog.getRequestedBy());
        mailParameters.put("url", "http://especies-qa.unep-wcmc.org/#/specie/" +
                changeLog.getSpecies().getId());
        mailUtils.sendEmail(changeLog.getRequestedBy().getEmail(), changeLog.getReviewedBy().getEmail(),
                subject, template, mailParameters);
    }

}
