package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChangeLog implements BaseEntity {

    public enum ChangeStatus { REQUESTED, ACCEPTED, REJECTED }

    public enum ChangeType { NEW_OBJECT, VALUE_CHANGE, REMOVED_OBJECT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedDate;

    @ManyToOne
    @JoinColumn(name = "requested_user_id")
    private User requestedBy;

    private String fieldName;

    @Enumerated(EnumType.STRING)
    private ChangeStatus status;

    @Enumerated(EnumType.STRING)
    private ChangeType type;

    @Column(length = 2000)
    private String changeLog;

    @Column(length = 5000)
    private String newAddLog;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String changeRequestDesc;

    @ManyToOne
    @JoinColumn(name = "reviewed_user_id")
    private User reviewedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public ChangeStatus getStatus() {
        return status;
    }

    public void setStatus(ChangeStatus status) {
        this.status = status;
    }

    public ChangeType getType() {
        return type;
    }

    public void setType(ChangeType type) {
        this.type = type;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public String getNewAddLog() {
        return newAddLog;
    }

    public void setNewAddLog(String newAddLog) {
        this.newAddLog = newAddLog;
    }

    public User getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(User reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getChangeRequestDesc() {
        return changeRequestDesc;
    }

    public void setChangeRequestDesc(String changeRequestDesc) {
        this.changeRequestDesc = changeRequestDesc;
    }
}
