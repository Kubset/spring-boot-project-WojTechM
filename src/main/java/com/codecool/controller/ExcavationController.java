package com.codecool.controller;

import com.codecool.model.Excavation;
import com.codecool.service.ExcavationService;
import com.codecool.service.IExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excavation")
public class ExcavationController {
    IExcavationService service;

    @Autowired
    ExcavationController(ExcavationService excavationService) {
       this.service = excavationService;

    }
    @GetMapping
    public List<Excavation> getAllExcavations() {
        return service.getAllExcavations();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Excavation> getExcavationById(@PathVariable(value = "id") long id) {
        Excavation entity = service.getExcavationById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    void insertNewExcavation(@RequestBody Excavation excavation) {
        service.insertExcavation(excavation);
    }

    @PutMapping
    void updateExcavation(@RequestBody Excavation excavation) {
        service.updateExcavation(excavation);
    }

    @DeleteMapping(path = "/{id}")
    void deleteExcavation(@PathVariable(value = "id") long id) {
        service.deleteExcavation(id);
    }

}
