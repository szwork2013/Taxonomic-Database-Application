package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyOrder;
import com.unep.wcmc.repository.HierarchyOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class HierarchyOrderService extends AbstractService<HierarchyOrder, HierarchyOrderRepository> {

    public HierarchyOrder findByName(String name) {
        return repo.findByName(name);
    }

    public HierarchyOrder findOrSave(HierarchyOrder order) {
        if (order != null) {
            HierarchyOrder existing = repo.findByName(order.getName());
            if (existing == null) {
                order.setLastModified(new Date());
                order = repo.save(order);
            } else {
                order = existing;
            }
        }
        return order;
    }
}
