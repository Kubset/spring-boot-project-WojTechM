package com.codecool.service;

import com.codecool.model.Location;
import com.codecool.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    private final ILocationRepository locationRepository;

    @Autowired
    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteLocation(long id) {
        if(locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertLocation(Location location) {
        if(location.getId() == 0) {
            locationRepository.save(location);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateLocation(Location location) {
         if(locationRepository.findById(location.getId()).isPresent()) {
            locationRepository.save(location);
            return true;
        } else {
            return false;
        }
    }
}
