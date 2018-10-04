package com.codecool.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Excavation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = Mine.class)
    private Mine mine;

    @ManyToOne(targetEntity = Resource.class)
    private Resource resource;

    private long excavation;
    private boolean isArchived;

    public Excavation() {
        this.isArchived = false;
    }

    public Excavation(Mine mine, Resource resource, long excavation) {
        this.mine = mine;
        this.resource = resource;
        this.excavation = excavation;
        this.isArchived = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @JsonIgnore
    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
}
