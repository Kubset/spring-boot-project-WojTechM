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
public class LocationController extends AbstractController<Location> {

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
    ResponseEntity<Location> insertNewLocation(@RequestBody Location location) {
        boolean isSuccess = service.insertLocation(location);
        return getResponseEntity(isSuccess);
    }

    @PutMapping
    ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        boolean isSuccess = service.updateLocation(location);
        return getResponseEntity(isSuccess);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Location> deleteLocation(@PathVariable(value = "id") long id) {
        boolean isSuccess = service.deleteLocation(id);
        return getResponseEntity(isSuccess);
    }
}
