package com.codecool.repository;

import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IMineRepository extends JpaRepository<Mine, Long> {



}
