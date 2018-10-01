package com.codecool.service;

import com.codecool.model.Location;

import java.util.List;

public interface ILocationService {

    List<Location> getAllLocations();
    Location getLocationById(long id);
    void deleteLocation(long id);
    void insertLocation(Location location);
    void updateLocation(Location location);
}
