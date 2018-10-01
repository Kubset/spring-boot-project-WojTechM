package com.codecool.model;



public class Mine {

    private long id;
    private long locationId;
    private String name;

    public Mine() {
    }

    public Mine(long id, long locationId, String name) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

