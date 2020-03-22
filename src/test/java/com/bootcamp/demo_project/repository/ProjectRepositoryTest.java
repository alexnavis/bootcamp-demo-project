package com.bootcamp.demo_project.repository;

import com.bootcamp.demo_project.BaseTest;
import com.bootcamp.demo_project.models.Project;
import com.bootcamp.demo_project.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class ProjectRepositoryTest extends BaseTest {

    @Autowired
    ProjectRepository subject;

    @Test
    public void createProject() {
        Project project = new Project();
        project.setName("p1");
        project.setSector("computer");
        project.setIsActive(true);
        project.setStartDate(DateUtils.now());
        subject.save(project);

        Optional<Project> actual = subject.findById(project.getId());
        assertProject(project, actual.get());
    }

    public void assertProject(Project expected, Project actual) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getIsActive()).isEqualTo(expected.getIsActive());
        assertThat(actual.getSector()).isEqualTo(expected.getSector());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
    }
}