package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyOrder;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.repository.HierarchyOrderRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class HierarchyOrderService extends AbstractService<HierarchyOrder, HierarchyOrderRepository> {

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public HierarchyOrder findOrSave(HierarchyOrder order) {
        if (order != null) {
            HierarchyOrder existing = repo.findByName(order.getName());
            if (existing == null) {
                if (order.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(order.getIntegrationSource().getSource());
                    order.setIntegrationSource(integration);
                }
                order = repo.save(order);
            } else {
                order = existing;
            }
        }
        return order;
    }
}
