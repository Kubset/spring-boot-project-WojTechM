package com.codecool.repository;

import com.codecool.model.Excavation;
import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IExcavationRepository extends JpaRepository<Excavation, Long> {

    @Query(value = "SELECT * FROM Excavation where is_archived = false", nativeQuery = true)
    public List<Excavation> findAll();
}
