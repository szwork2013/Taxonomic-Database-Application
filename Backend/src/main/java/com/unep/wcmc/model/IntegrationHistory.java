package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IntegrationHistory implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "integration_source_id")
    private IntegrationSource integrationSource;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String status;

    @Column(name = "records_processed")
    private Integer recordsProcessed;

    @Column(name = "records_inserted")
    private Integer recordsInserted;

    @Column(name = "records_updated")
    private Integer recordsUpdated;

    @Column(name = "total_exceptions")
    private Integer totalExceptions;

    private boolean completed;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public IntegrationSource getIntegrationSource() {
        return integrationSource;
    }

    public void setIntegrationSource(IntegrationSource integrationSource) {
        this.integrationSource = integrationSource;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRecordsProcessed() {
        return recordsProcessed;
    }

    public void setRecordsProcessed(Integer recordsProcessed) {
        this.recordsProcessed = recordsProcessed;
    }

    public Integer getRecordsInserted() {
        return recordsInserted;
    }

    public void setRecordsInserted(Integer recordsInserted) {
        this.recordsInserted = recordsInserted;
    }

    public Integer getRecordsUpdated() {
        return recordsUpdated;
    }

    public void setRecordsUpdated(Integer recordsUpdated) {
        this.recordsUpdated = recordsUpdated;
    }

    public Integer getTotalExceptions() {
        return totalExceptions;
    }

    public void setTotalExceptions(Integer totalExceptions) {
        this.totalExceptions = totalExceptions;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
