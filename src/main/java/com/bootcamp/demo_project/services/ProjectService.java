package com.bootcamp.demo_project.services;

import com.bootcamp.demo_project.models.Project;

public interface ProjectService {

    Iterable<Project> get();

    Project get(int id);

    void save(Project employee);

    void delete(int id);
}
