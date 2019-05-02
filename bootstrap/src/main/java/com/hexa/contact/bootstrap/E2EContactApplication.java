package com.hexa.contact.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hexa.contact.*"})
@ComponentScan(basePackages = {"com.hexa.contact.*"})
@EntityScan("com.hexa.contact.*")
public class E2EContactApplication {
    public static void main(String[] args) {
        SpringApplication.run(E2EContactApplication.class, args);
    }
}
