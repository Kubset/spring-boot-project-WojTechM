package com.codecool.controller;

import com.codecool.model.Resource;
import com.codecool.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private final IResourceService service;

    @Autowired
    public ResourceController(IResourceService service) {
        this.service = service;
    }

    @GetMapping
    List<Resource> getAllLocations() {
        return service.getAllResources();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Resource> getLocationById(@PathVariable(value = "id") long id) {
        Resource entity = service.getResourceById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    void insertNewLocation(@RequestBody Resource resource) {
        service.insertResource(resource);
    }

    @PutMapping
    void updateLocation(@RequestBody Resource resource) {
        service.updateResource(resource);
    }

    @DeleteMapping(path = "/{id}")
    void deleteLocation(@PathVariable(value = "id") long id) {
        service.deleteResource(id);
    }
}
