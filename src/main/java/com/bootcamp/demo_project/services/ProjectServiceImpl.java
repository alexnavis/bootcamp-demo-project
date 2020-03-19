package com.bootcamp.demo_project.services;

import java.util.List;
import java.util.Optional;

import com.bootcamp.demo_project.dao.ProjectDAO;
import com.bootcamp.demo_project.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Transactional
    @Override
    public Iterable<Project> get() {
        return projectDAO.findAll();
    }

    @Transactional
    @Override
    public Project get(int id) {
        Optional<Project> project = projectDAO.findById(id);
        return project.orElse(null);
    }

    @Transactional
    @Override
    public void save(Project employee) {
        projectDAO.save(employee);

    }

    @Transactional
    @Override
    public void delete(int id) {
        projectDAO.deleteById(id);
    }
}