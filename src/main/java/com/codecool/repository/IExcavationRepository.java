package com.codecool.repository;

import com.codecool.model.Excavation;
import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IExcavationRepository extends JpaRepository<Excavation, Long> {

    @Query(value = "SELECT * FROM Excavation where is_archived = false", nativeQuery = true)
    public List<Excavation> findAll();

    @Query(value = "SELECT * FROM Excavation where is_archived = false AND id = :id", nativeQuery = true)
    public Optional<Excavation> findById(@Param("id") long id);

    @Query(value = "UPDATE Excavation SET is_archived = true WHERE id = :id RETURNING *", nativeQuery = true)
    public Optional<Excavation> deleteById(@Param("id") long id);
}
