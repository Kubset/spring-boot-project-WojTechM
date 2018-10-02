package com.codecool.service;

import com.codecool.model.Resource;

import java.util.List;

public interface IResourceService {

    List<Resource> getAllResources();
    Resource getResourceById(long id);
    void deleteResource(long id);
    void insertResource(Resource resource);
    void updateResource(Resource resource);
}
