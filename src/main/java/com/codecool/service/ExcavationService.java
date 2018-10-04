package com.codecool.service;

import com.codecool.model.Excavation;
import com.codecool.repository.IExcavationRepository;
import com.codecool.repository.IMineRepository;
import com.codecool.repository.IResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcavationService implements IExcavationService {

    private final IExcavationRepository excavationRepository;
    private final IMineRepository mineRepository;
    private final IResourceRepository resourceRepository;

    public ExcavationService(IExcavationRepository excavationRepository, IMineRepository mineRepository, IResourceRepository resourceRepository) {
        this.excavationRepository = excavationRepository;
        this.mineRepository = mineRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Excavation> getAllExcavations() {
        return excavationRepository.findAll();
    }

    @Override
    public Excavation getExcavationById(long id) {
        return excavationRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteExcavation(long id) {
        if (excavationRepository.findById(id).isPresent()) {
            excavationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
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
        if (excavationRepository.findById(id).isPresent() && !excavation.isArchived()) {
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
        excavationRepository.save(excavation);
        return true;
    }

    private boolean mineByIdExists(long id) {
        return mineRepository.findById(id).isPresent();
    }

    private boolean resourceByIdExists(long id) {
        return resourceRepository.findById(id).isPresent();
    }
}
