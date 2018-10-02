package com.codecool.service;

import com.codecool.model.Mine;
import com.codecool.repository.IMineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService implements IMineService {

    private final IMineRepository repository;

    public MineService(IMineRepository repository) {
        this.repository = repository;
    }

    public List<Mine> getAllMines() {
        return repository.findAll();
    }

    @Override
    public Mine getMineById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteMine(long id) {
        repository.deleteById(id);
    }

    @Override
    public void insertMine(Mine mine) {
        repository.save(mine);

    }

    @Override
    public void updateMine(Mine mine) {
        repository.save(mine);
    }
}
