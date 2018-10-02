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
public class ExcavationController extends AbstractController {
    private final IExcavationService service;

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
    ResponseEntity<Excavation> insertNewExcavation(@RequestBody Excavation excavation) {
        boolean isSuccess = service.insertExcavation(excavation);
        return getResponseEntity(isSuccess);
    }

    @PutMapping
    ResponseEntity<Excavation> updateExcavation(@RequestBody Excavation excavation) {
        boolean isSuccess = service.updateExcavation(excavation);
        return getResponseEntity(isSuccess);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Excavation> deleteExcavation(@PathVariable(value = "id") long id) {
        boolean isSuccess = service.deleteExcavation(id);
        return getResponseEntity(isSuccess);
    }
}
