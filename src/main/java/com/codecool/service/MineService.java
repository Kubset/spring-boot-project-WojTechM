package com.codecool.service;

import com.codecool.model.Mine;
import com.codecool.repository.ILocationRepository;
import com.codecool.repository.IMineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService implements IMineService {

    private final IMineRepository mineRepository;
    private final ILocationRepository locationRepository;


    public MineService(IMineRepository mineRepository, ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.mineRepository = mineRepository;
    }

    public List<Mine> getAllMines() {
        return mineRepository.findAll();
    }

    @Override
    public Mine getMineById(long id) {
        return mineRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteMine(long id) {
        mineRepository.deleteById(id);

        return false;
    }

    @Override
    public boolean insertMine(Mine mine) {
        if(mine.getId() == 0) {
            return persistMine(mine);
        } else {
            return false;
        }
    }

    @Override
    public boolean updateMine(Mine mine) {
        if(mineRepository.findById(mine.getId()).isPresent()) {
            return persistMine(mine);
        } else {
            return false;
        }
    }

    private boolean persistMine(Mine mine) {
        long locationId = mine.getLocation().getId();

        if(locationRepository.findById(locationId).isPresent()) {
            mineRepository.save(mine);
            return true;
        } else {
            return false;
        }
    }
}
