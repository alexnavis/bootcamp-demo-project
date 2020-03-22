package com.bootcamp.demo_project.services;

import java.util.Optional;

import com.bootcamp.demo_project.repository.ProjectRepository;
import com.bootcamp.demo_project.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    @Override
    public Iterable<Project> get() {
        return projectRepository.findAll();
    }

    @Transactional
    @Override
    public Project get(int id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.orElse(null);
    }

    @Transactional
    @Override
    public void save(Project employee) {
        projectRepository.save(employee);

    }

    @Transactional
    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}