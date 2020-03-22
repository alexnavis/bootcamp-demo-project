package com.bootcamp.demo_project.repository;

import com.bootcamp.demo_project.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
