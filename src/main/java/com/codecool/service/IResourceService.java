package com.codecool.service;

import com.codecool.model.Resource;

import java.util.List;

public interface IResourceService {

    List<Resource> getAllResources();
    Resource getResourceById(long id);
    boolean deleteResource(long id);
    boolean insertResource(Resource resource);
    boolean updateResource(Resource resource);
}
