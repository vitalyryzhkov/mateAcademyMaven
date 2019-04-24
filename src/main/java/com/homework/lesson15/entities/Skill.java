package com.homework.lesson15.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Log4j
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "language", length = 255)
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", length = 255)
    private LevelType level;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skill")
    private Set<Developer> developers = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Skill.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Skill.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Skill.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Skill.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Skill.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Skill.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Skill.onPostLoad()");
    }
}
