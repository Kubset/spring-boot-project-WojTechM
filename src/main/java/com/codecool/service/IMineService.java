package com.codecool.service;

import com.codecool.model.Mine;

import java.util.List;

public interface IMineService {

    public List<Mine> getAllMines();
    public Mine getMineById(long id);
    void deleteMine(long id);
    void insertMine(Mine mine);
    void updateMine(Mine mine);
}
