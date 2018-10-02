package com.codecool.service;

import com.codecool.model.Resource;
import com.codecool.repository.IResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService implements IResourceService {

    private final IResourceRepository resourceRepository;

    @Autowired
    public ResourceService(IResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource getResourceById(long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteResource(long id) {
        if(resourceRepository.findById(id).isPresent()) {
            resourceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertResource(Resource resource) {
        if(resource.getId() == 0) {
            resourceRepository.save(resource);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateResource(Resource resource) {
         if(resourceRepository.findById(resource.getId()).isPresent()) {
            resourceRepository.save(resource);
            return true;
        } else {
            return false;
        }
    }
}
