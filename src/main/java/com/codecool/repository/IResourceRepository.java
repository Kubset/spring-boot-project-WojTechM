package com.codecool.repository;

import com.codecool.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResourceRepository  extends JpaRepository<Resource, Long> {

    @Query(value = "SELECT * FROM Mine where is_archived = false", nativeQuery = true)
    public List<Resource> findAll();
}
