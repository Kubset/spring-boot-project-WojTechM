package com.codecool.service;

import com.codecool.model.Excavation;
import com.codecool.repository.IExcavationRepository;
import com.codecool.repository.IMineRepository;
import com.codecool.repository.IResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcavationService implements IExcavationService {

    private final IExcavationRepository repository;
    private final IMineRepository mineRepository;
    private final IResourceRepository resourceRepository;

    public ExcavationService(IExcavationRepository repository, IMineRepository mineRepository, IResourceRepository resourceRepository) {
        this.repository = repository;
        this.mineRepository = mineRepository;
        this.resourceRepository = resourceRepository;
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
    public boolean deleteExcavation(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean insertExcavation(Excavation excavation) {
        if (excavation.getId() == 0) {
            return persistExcavation(excavation);
        }
        return false;
    }

    @Override
    public boolean updateExcavation(Excavation excavation) {
        long id = excavation.getId();
        if (repository.findById(id).isPresent()) {
            return persistExcavation(excavation);
        }
        return false;
    }

    private boolean persistExcavation(Excavation excavation) {
        long mineId = excavation.getMine().getId();
        long resourceId = excavation.getResource().getId();
        if (!mineByIdExists(mineId) || !resourceByIdExists(resourceId)) {
            return false;
        }
        repository.save(excavation);
        return true;
    }

    private boolean mineByIdExists(long id) {
        return mineRepository.findById(id).isPresent();
    }

    private boolean resourceByIdExists(long id) {
        return resourceRepository.findById(id).isPresent();
    }
}
