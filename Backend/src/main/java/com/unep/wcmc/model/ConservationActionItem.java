package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ConservationActionItem implements Serializable {

    private String action;

    private String local;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
