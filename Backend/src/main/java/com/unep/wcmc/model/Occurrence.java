package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Occurrence implements Serializable {

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private String projection;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "map_id")
    private Map map;

    public Occurrence() {
        super();
    }

    public Occurrence(String latitude, String longitude, String projection, State state, Map map) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.projection = projection;
        this.state = state;
        this.map = map;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

}
