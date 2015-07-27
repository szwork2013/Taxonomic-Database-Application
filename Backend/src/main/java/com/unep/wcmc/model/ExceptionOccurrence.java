package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExceptionOccurrence implements BaseEntity {

    public enum Severity { MAJOR, MINOR }

    public enum Status { DELEGATE, RESOLVED, UNRESOLVED, REJECTED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "active_species_id")
    private Species active;

    @ManyToOne
    @JoinColumn(name = "suggested_species_id")
    private Species suggested;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private Severity severity;

    @ManyToOne
    @JoinColumn(name = "integration_source")
    private IntegrationSource integrationSource;

    @Column(name = "created_date")
    private Date createdAt;

    @Column(name = "updated_date")
    private Date updatedAt;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Species getActive() {
        return active;
    }

    public void setActive(Species active) {
        this.active = active;
    }

    public Species getSuggested() {
        return suggested;
    }

    public void setSuggested(Species suggested) {
        this.suggested = suggested;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public IntegrationSource getIntegrationSource() {
        return integrationSource;
    }

    public void setIntegrationSource(IntegrationSource integrationSource) {
        this.integrationSource = integrationSource;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}