package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Map implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file")
    private byte[] file;

    @Column(name = "projection")
    private String projection;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "author")
    private String auhtor;

    @Column(name = "date")
    private Date date;

    @Column(name = "caption")
    private String caption;

    @Column(name = "description")
    private String description;

    @Column(name = "set_as_cover")
    private Boolean isCover;

    public Map() {
        super();
    }

    public Map(String projection, String type, String author, Date date, String caption, String description, Boolean isCover) {
        this.projection = projection;
        this.type = type;
        this.auhtor = author;
        this.date = date;
        this.caption = caption;
        this.description = description;
        this.isCover = isCover;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Boolean getIsCover() {
        return isCover;
    }

    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuhtor() {
        return auhtor;
    }

    public void setAuhtor(String auhtor) {
        this.auhtor = auhtor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }


}
