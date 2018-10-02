package com.codecool.service;

import com.codecool.model.Location;

import java.util.List;

public interface ILocationService {

    List<Location> getAllLocations();
    Location getLocationById(long id);
    boolean deleteLocation(long id);
    boolean insertLocation(Location location);
    boolean updateLocation(Location location);
}
