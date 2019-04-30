package com.homework.lesson17.beanpostprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
@SpringBootApplication
public class BeanpostprocessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeanpostprocessorApplication.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MyPrototype firstPrototype = ctx.getBean(MyPrototype.class);
        firstPrototype.setName("prototype");
        log.info(firstPrototype.getName());

        MyPrototype secondPrototype = ctx.getBean(MyPrototype.class);
        log.info(secondPrototype.getName());

        MySingleton firstSingleton = ctx.getBean(MySingleton.class);
        firstSingleton.setName("singleton");
        log.info(firstSingleton.getName());

        MySingleton secondSingleton = ctx.getBean(MySingleton.class);
        log.info(secondSingleton.getName());

        ctx.registerShutdownHook();
    }
}
