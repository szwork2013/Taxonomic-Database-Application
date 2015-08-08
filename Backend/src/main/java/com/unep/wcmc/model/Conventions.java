package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class Conventions implements Serializable {

    @Column(name = "presence_in_national_endangered_fauna")
    private Boolean presenceNationalEndangeredFauna;

    @Column(name = "presence_in_national_endangered_fauna_desc")
    private String presenceNationalEndangeredFaunaDesc;

    @ElementCollection
    @CollectionTable(name = "convention_item", joinColumns = @JoinColumn(name = "conservation_id"))
    private List<ConventionItem> conventionItems;

    public Boolean getPresenceNationalEndangeredFauna() {
        return presenceNationalEndangeredFauna;
    }

    public void setPresenceNationalEndangeredFauna(Boolean presenceNationalEndangeredFauna) {
        this.presenceNationalEndangeredFauna = presenceNationalEndangeredFauna;
    }

    public String getPresenceNationalEndangeredFaunaDesc() {
        return presenceNationalEndangeredFaunaDesc;
    }

    public void setPresenceNationalEndangeredFaunaDesc(String presenceNationalEndangeredFaunaDesc) {
        this.presenceNationalEndangeredFaunaDesc = presenceNationalEndangeredFaunaDesc;
    }

    public List<ConventionItem> getConventionItems() {
        return conventionItems;
    }

    public void setConventionItems(List<ConventionItem> conventionItems) {
        this.conventionItems = conventionItems;
    }
}