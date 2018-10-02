package com.codecool.controller;

import com.codecool.model.Mine;
import com.codecool.repository.IMineRepository;
import com.codecool.service.IMineService;
import com.codecool.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mine")
public class MineController {
    IMineService service;

    @Autowired
    MineController(MineService mineService) {
       this.service = mineService;

    }
    @GetMapping
    public List<Mine> getMines() {

        return service.getAllMines();

    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Mine> getMineById(@PathVariable(value = "id") long id) {
        Mine entity = service.getMineById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    void insertNewMine(@RequestBody Mine mine) {
        service.insertMine(mine);
    }

    @PutMapping
    void updateLocation(@RequestBody Mine mine) {
        service.updateMine(mine);
    }

    @DeleteMapping(path = "/{id}")
    void deleteLocation(@PathVariable(value = "id") long id) {
        service.deleteMine(id);
    }

}
