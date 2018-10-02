package com.codecool.repository;

import com.codecool.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResourceRepository  extends JpaRepository<Resource, Long> {
}
