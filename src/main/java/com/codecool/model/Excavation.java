package com.codecool.model;

public class Excavation {

    private long mineId;
    private long resourceId;
    private long excavation;

    public Excavation() {
    }

    public Excavation(long mineId, long resourceId, long excavation) {
        this.mineId = mineId;
        this.resourceId = resourceId;
        this.excavation = excavation;
    }

    public long getMineId() {
        return mineId;
    }

    public void setMineId(long mineId) {
        this.mineId = mineId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public long getExcavation() {
        return excavation;
    }

    public void setExcavation(long excavation) {
        this.excavation = excavation;
    }
}
