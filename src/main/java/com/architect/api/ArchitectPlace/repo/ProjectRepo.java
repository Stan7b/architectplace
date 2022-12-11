package com.architect.api.ArchitectPlace.repo;

import com.architect.api.ArchitectPlace.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

    Optional<Project> findById(Integer id);

}
