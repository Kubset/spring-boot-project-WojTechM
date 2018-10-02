package com.codecool.service;

import com.codecool.model.Mine;

import java.util.List;

public interface IMineService {

    public List<Mine> getAllMines();
    public Mine getMineById(long id);
    boolean deleteMine(long id);
    boolean insertMine(Mine mine);
    boolean updateMine(Mine mine);
}
