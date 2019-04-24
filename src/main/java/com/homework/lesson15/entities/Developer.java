package com.homework.lesson15.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Log4j
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexType sex;

    @ManyToMany
    @JoinTable(name = "developer_skill",
            joinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "developers")
    @JoinTable(name = "developer_project",
            joinColumns = @JoinColumn(name = "developer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Developer.onPrePersist()");

    }

    @PostPersist
    public void postPersist() {
        log.info("Developer.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Developer.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Developer.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Developer.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Developer.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Developer.onPostLoad()");
    }
}
