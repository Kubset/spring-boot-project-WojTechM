package com.codecool.controller;

import com.codecool.model.Location;
import com.codecool.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final ILocationService service;

    @Autowired
    public LocationController(ILocationService service) {
        this.service = service;
    }

    @GetMapping
    List<Location> getAllLocations() {
        return service.getAllLocations();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Location> getLocationById(@PathVariable(value = "id") long id) {
        Location entity = service.getLocationById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    void insertNewLocation(@RequestBody Location location) {
        service.insertLocation(location);
    }

    @PutMapping
    void updateLocation(@RequestBody Location location) {
        service.updateLocation(location);
    }

    @DeleteMapping(path = "/{id}")
    void deleteLocation(@PathVariable(value = "id") long id) {
        service.deleteLocation(id);
    }
}
