package com.codecool.model;

import javax.persistence.ManyToOne;

public class Excavation {

    @ManyToOne(targetEntity = Mine.class)
    private Mine mine;

    @ManyToOne(targetEntity = Resource.class)
    private Resource resource;

    private long excavation;

    public Excavation() {
    }

    public Excavation(Mine mine, Resource resource, long excavation) {
        this.mine = mine;
        this.resource = resource;
        this.excavation = excavation;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public long getExcavation() {
        return excavation;
    }

    public void setExcavation(long excavation) {
        this.excavation = excavation;
    }
}
