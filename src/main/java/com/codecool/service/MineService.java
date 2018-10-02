package com.codecool.service;

import com.codecool.model.Mine;
import com.codecool.repository.IMineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService {

    private final IMineRepository mineRepository;

    public MineService(IMineRepository mineRepository) {
        this.mineRepository = mineRepository;
    }

    public List<Mine> getAllMines() {
        return mineRepository.findAll();
    }
}
