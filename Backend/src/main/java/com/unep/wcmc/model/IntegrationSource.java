package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class IntegrationSource {

    public enum Source { SPECIES_PLUS, ICMBIO }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Source source;

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
}