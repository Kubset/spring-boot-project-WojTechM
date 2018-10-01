package com.codecool.service;

import com.codecool.model.Location;
import com.codecool.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    private final ILocationRepository repository;

    @Autowired
    public LocationService(ILocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }

    @Override
    public Location getLocationById(long id) {
        return null;
    }

    @Override
    public void deleteLocation(long id) {

    }

    @Override
    public void insertLocation(Location location) {

    }

    @Override
    public void updateLocation(Location location) {

    }
}
