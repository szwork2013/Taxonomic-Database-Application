package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class HierarchyOrder implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "integration_source")
    private IntegrationSource integrationSource;

    public HierarchyOrder() {
        super();
    }

    public HierarchyOrder(String name) {
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

    public IntegrationSource getIntegrationSource() {
        return integrationSource;
    }

    public void setIntegrationSource(IntegrationSource integrationSource) {
        this.integrationSource = integrationSource;
    }
}