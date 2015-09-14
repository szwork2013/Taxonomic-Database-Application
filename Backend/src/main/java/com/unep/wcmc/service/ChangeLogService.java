package com.unep.wcmc.service;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.repository.ChangeLogRepository;
import com.unep.wcmc.security.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unep.wcmc.model.UserRole.RoleType.*;

@Service
public final class ChangeLogService extends AbstractService<ChangeLog, ChangeLogRepository> {

    @Override
    public List<ChangeLog> list() {
        if (SecurityUtils.hasAnyRole(ADMIN, SUPERADMIN, EXPERT)) {
            return super.list();
        } else {
            return repo.findByRequestedByUsername(SecurityUtils.getUser());
        }
    }
}
