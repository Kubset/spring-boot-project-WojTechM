package com.codecool.service;

import com.codecool.model.Excavation;

import java.util.List;

public interface IExcavationService {
    public List<Excavation> getAllExcavations();

    public Excavation getExcavationById(long id);

    boolean deleteExcavation(long id);

    boolean insertExcavation(Excavation excavation);

    boolean updateExcavation(Excavation excavation);
}
