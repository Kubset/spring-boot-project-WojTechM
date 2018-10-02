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
public class MineController extends AbstractController<Mine>{
    private final IMineService service;

    @Autowired
    MineController(MineService mineService) {
       this.service = mineService;

    }
    @GetMapping
    public List<Mine> getAllMines() {
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
    ResponseEntity<Mine> insertNewMine(@RequestBody Mine mine) {
        boolean isSuccess = service.insertMine(mine);
        return getResponseEntity(isSuccess);
    }

    @PutMapping
    ResponseEntity<Mine> updateMine(@RequestBody Mine mine) {
        boolean isSuccess = service.updateMine(mine);
        return getResponseEntity(isSuccess);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Mine> deleteMine(@PathVariable(value = "id") long id) {
        boolean isSuccess = service.deleteMine(id);
        return getResponseEntity(isSuccess);
    }

}
