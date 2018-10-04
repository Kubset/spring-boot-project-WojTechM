package com.codecool.repository;

import com.codecool.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "SELECT * FROM Location where is_archived = false", nativeQuery = true)
    public List<Location> findAll();
}
