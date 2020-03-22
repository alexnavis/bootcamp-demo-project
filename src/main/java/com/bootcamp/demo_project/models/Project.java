package com.bootcamp.demo_project.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
@Getter
@Setter
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String sector;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column
    private Boolean isActive;
}
