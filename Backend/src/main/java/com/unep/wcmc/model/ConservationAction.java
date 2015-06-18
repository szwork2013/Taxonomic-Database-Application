package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ConservationAction implements Serializable {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ConservationActionType type;

    public ConservationActionType getType() {
        return type;
    }

    public void setType(ConservationActionType type) {
        this.type = type;
    }
}
