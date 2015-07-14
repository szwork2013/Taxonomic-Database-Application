package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class HierarchyClass implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "integration_source")
    private IntegrationSource integrationSource;

    public HierarchyClass() {
        super();
    }

    public HierarchyClass(String name) {
        this.name = name;
    }

    public HierarchyClass(String name, IntegrationSource integrationSource) {
        this(name);
        this.integrationSource = integrationSource;
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

    public IntegrationSource getIntegrationSource() {
        return integrationSource;
    }

    public void setIntegrationSource(IntegrationSource integrationSource) {
        this.integrationSource = integrationSource;
    }
}