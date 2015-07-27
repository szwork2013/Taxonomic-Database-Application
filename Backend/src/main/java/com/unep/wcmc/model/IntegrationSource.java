package com.unep.wcmc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class IntegrationSource implements BaseEntity {

    public enum Source { SPECIES_PLUS, FLORA, FAUNA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Source source;

    private String name;

    @OneToMany
    @JoinColumn(name = "integration_source_id")
    @OrderBy("updatedAt desc")
    @JsonIgnore
    private List<IntegrationHistory> history;

    public IntegrationSource() {
        super();
    }

    public IntegrationSource(Source source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IntegrationHistory> getHistory() {
        return history;
    }

    public void setHistory(List<IntegrationHistory> history) {
        this.history = history;
    }
}