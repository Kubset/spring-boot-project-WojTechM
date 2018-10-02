package com.codecool.service;

import com.codecool.model.Excavation;

import java.util.List;

public interface IExcavationService {
    public List<Excavation> getAllExcavations();
    public Excavation getExcavationById(long id);
    void deleteExcavation(long id);
    void insertExcavation(Excavation excavation);
    void updateExcavation(Excavation excavation);
}
