package com.codecool.controller;

import com.codecool.model.Location;
import com.codecool.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping()
    List<Location> getAllLocations() {
        return service.getAllLocations();
    }

    @GetMapping(path = "/{id}")
    Location getLocationById(@PathVariable(value = "id") long id) {
        return service.getLocationById(id);
    }

    @PostMapping(consumes = "application/json")
    void insertNewLocation(Location location) {
        System.out.println(location.toString());
        return;
    }
}
