package com.codecool.controller;

import com.codecool.model.Mine;
import com.codecool.repository.IMineRepository;
import com.codecool.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mine")
public class MineController {
    MineService mineService;

    @Autowired
    MineController(MineService mineService) {
       this.mineService = mineService;

    }
    @GetMapping("")
    public List<Mine> getMines() {

        return mineService.getAllMines();

    }

}
