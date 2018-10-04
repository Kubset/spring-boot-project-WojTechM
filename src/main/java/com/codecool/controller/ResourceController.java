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
public class ResourceController extends AbstractController<Resource> {

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
    ResponseEntity<Resource> insertNewLocation(@RequestBody Resource resource) {
        boolean isSuccess = service.insertResource(resource);
        return getResponseEntity(isSuccess);
    }

    @PutMapping
    ResponseEntity<Resource> updateLocation(@RequestBody Resource resource) {
        boolean isSuccess = service.updateResource(resource);
        return getResponseEntity(isSuccess);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Resource> deleteLocation(@PathVariable(value = "id") long id) {
        boolean isSuccess = service.deleteResource(id);
        return getResponseEntity(isSuccess);
    }
}
