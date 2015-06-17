package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public final class Image extends Multimedia {

    @Column
    private byte[] coverImage;
}
