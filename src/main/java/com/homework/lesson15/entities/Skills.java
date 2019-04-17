package com.homework.lesson15.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
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

@MappedSuperclass
@Log4j
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "language", length = 255)
    private String language;

    @Column(name = "level", length = 255)
    private String level;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private Set<Developers> developers = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Skills.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Skills.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Skills.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Skills.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Skills.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Skills.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Skills.onPostLoad()");
    }
}
