package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Image extends Multimedia {

    @Column(name = "cover_image")
    private byte[] coverImage;

    public byte[] getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage) {
        this.coverImage = coverImage;
    }

}