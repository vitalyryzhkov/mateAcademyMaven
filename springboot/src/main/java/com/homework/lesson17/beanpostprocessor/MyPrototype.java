package com.homework.lesson17.beanpostprocessor;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j
@Getter
@Setter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyPrototype {
    private String name;

    @PostConstruct
    public void init() {
        log.info("Message: Inside @PostConstruct method");
    }

    @PreDestroy
    public void destroy() {
        log.info("Message: Inside @PreDestroy method");
    }
}
