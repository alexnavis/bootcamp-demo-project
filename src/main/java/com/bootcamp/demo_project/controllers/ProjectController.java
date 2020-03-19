package com.bootcamp.demo_project.controllers;

import com.bootcamp.demo_project.models.Project;
import com.bootcamp.demo_project.services.ProjectService;
import com.bootcamp.demo_project.utils.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public List<Project> get() {
        return IteratorUtils.toList(projectService.get());
    }

    @PostMapping("/project")
    public Project save(@RequestBody Project project) {
        projectService.save(project);
        return project;
    }

    @GetMapping("/project/{id}")
    public Project get(@PathVariable int id) {
        return projectService.get(id);
    }

    @DeleteMapping("/project/{id}")
    public String delete(@PathVariable int id) {
        projectService.delete(id);
        return "Project removed with id " + id;
    }

    @PutMapping("/project")
    public Project update(@RequestBody Project employee) {
        projectService.save(employee);
        return employee;
    }
}
