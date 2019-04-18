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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Log4j
@MappedSuperclass
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "companies")
    private Set<Developer> developers = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Company.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Company.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Company.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Company.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Company.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Company.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Company.onPostLoad()");
    }
}
