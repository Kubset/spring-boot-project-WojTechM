package com.codecool.repository;

import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMineRepository extends JpaRepository<Mine, Long> {

    @Query(value = "SELECT * FROM Mine where is_archived = false", nativeQuery = true)
    public List<Mine> findAll();

    @Query(value = "SELECT * FROM Mine where is_archived = false AND id = :id", nativeQuery = true)
    public Optional<Mine> findById(@Param("id") long id);

    @Query(value = "UPDATE Mine SET is_archived = true WHERE id = :id RETURNING *", nativeQuery = true)
    public Optional<Mine> deleteById(@Param("id") long id);
}
