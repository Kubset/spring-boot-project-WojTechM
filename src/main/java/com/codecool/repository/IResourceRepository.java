package com.codecool.repository;

import com.codecool.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IResourceRepository  extends JpaRepository<Resource, Long> {

    @Query(value = "SELECT * FROM Resource where is_archived = false", nativeQuery = true)
    public List<Resource> findAll();

    @Query(value = "SELECT * FROM Resource where is_archived = false AND id = :id", nativeQuery = true)
    public Optional<Resource> findById(@Param("id") long id);

    @Query(value = "UPDATE Resourcce SET is_archived = true WHERE id = :id RETURNING *", nativeQuery = true)
    public Optional<Resource> deleteById(@Param("id") long id);
}
