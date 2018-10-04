package com.codecool.repository;

import com.codecool.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "SELECT * FROM Location where is_archived = false", nativeQuery = true)
    public List<Location> findAll();

    @Query(value = "SELECT * FROM Location where is_archived = false AND id = :id", nativeQuery = true)
    public Optional<Location> findById(@Param("id") long id);

    @Query(value = "UPDATE Location SET is_archived = true WHERE id = :id RETURNING *", nativeQuery = true)
    public Optional<Location> deleteById(@Param("id") long id);
}
