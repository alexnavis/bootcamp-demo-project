package com.bootcamp.demo_project.dao;

import com.bootcamp.demo_project.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDAO extends CrudRepository<Project, Integer> {
}
