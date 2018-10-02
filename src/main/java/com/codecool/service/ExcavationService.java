package com.codecool.service;

import com.codecool.model.Excavation;
import com.codecool.model.Mine;
import com.codecool.repository.IExcavationRepository;
import com.codecool.repository.IMineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcavationService implements IExcavationService {

    private final IExcavationRepository repository;

    public ExcavationService(IExcavationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Excavation> getAllExcavations() {
        return repository.findAll();
    }

    @Override
    public Excavation getExcavationById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteExcavation(long id) {
        repository.deleteById(id);
    }

    @Override
    public void insertExcavation(Excavation excavation) {
        repository.save(excavation);
    }

    @Override
    public void updateExcavation(Excavation excavation) {
        repository.save(excavation);
    }
}
