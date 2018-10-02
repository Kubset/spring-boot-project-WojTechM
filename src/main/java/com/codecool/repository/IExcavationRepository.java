package com.codecool.repository;

import com.codecool.model.Excavation;
import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExcavationRepository extends JpaRepository<Excavation, Long> {
}
