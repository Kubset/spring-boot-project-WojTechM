package com.codecool.repository;

import com.codecool.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMineRepository extends JpaRepository<Mine, Long> {

    @Query(value = "SELECT * FROM Mine where is_archived = false", nativeQuery = true)
    public List<Mine> findAll();
}
