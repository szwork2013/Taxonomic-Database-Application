package com.unep.wcmc.model;

import org.javers.core.metamodel.annotation.DiffIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Family implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family")
    private String name;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    @DiffIgnore
    private Date lastModified;

    public Family() {
        super();
    }

    public Family(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
