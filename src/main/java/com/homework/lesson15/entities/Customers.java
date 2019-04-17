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

@Log4j
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "customers")
    private Set<Companies> companies = new HashSet<>();

    @PrePersist
    public void prePersist() {
        log.info("Customers.onPrePersist()");
    }

    @PostPersist
    public void postPersist() {
        log.info("Customers.onPostPersist()");
    }

    @PreUpdate
    public void preUpdate() {
        log.info("Customers.onPreUpdate()");
    }

    @PostUpdate
    public void postUpdate() {
        log.info("Customers.onPostUpdate()");
    }

    @PreRemove
    public void preRemove() {
        log.info("Customers.onPreRemove()");
    }

    @PostRemove
    public void postRemove() {
        log.info("Customers.onPostRemove()");
    }

    @PostLoad
    public void postLoad() {
        log.info("Customers.onPostLoad()");
    }
}
