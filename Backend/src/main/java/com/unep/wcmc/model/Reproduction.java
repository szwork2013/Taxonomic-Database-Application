package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Reproduction implements Serializable {

    private Integer maximumSize;

    public Integer getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Integer maximumSize) {
        this.maximumSize = maximumSize;
    }

}
