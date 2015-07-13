package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyOrder;
import com.unep.wcmc.repository.HierarchyOrderRepository;
import org.springframework.stereotype.Service;

@Service
public final class HierarchyOrderService extends AbstractService<HierarchyOrder, HierarchyOrderRepository> {

    public HierarchyOrder findOrSave(String name) {
        HierarchyOrder order = repo.findByName(name);
        if (order == null) {
            order = new HierarchyOrder(name);
            order = repo.save(order);
        }
        return order;
    }
}
