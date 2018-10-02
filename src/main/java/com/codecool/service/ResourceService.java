package com.codecool.service;

import com.codecool.model.Resource;
import com.codecool.repository.IResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService implements IResourceService {

    private final IResourceRepository repository;

    @Autowired
    public ResourceService(IResourceRepository resourceRepository) {
        this.repository = resourceRepository;
    }

    @Override
    public List<Resource> getAllResources() {
        return repository.findAll();
    }

    @Override
    public Resource getResourceById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteResource(long id) {
        repository.deleteById(id);
    }

    @Override
    public void insertResource(Resource resource) {
        repository.save(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        repository.save(resource);
    }
}
