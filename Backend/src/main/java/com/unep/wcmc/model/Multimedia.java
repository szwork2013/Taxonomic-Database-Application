package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Multimedia implements BaseEntity {

    @Column(name = "legend")
    private String legend;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private Date date;

    @Column(name = "site_description")
    private String site;

    @Column(name = "file")
    private byte[] file;

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
