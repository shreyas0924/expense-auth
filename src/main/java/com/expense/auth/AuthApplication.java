package com.expense.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.expense.auth.entities" })
@EnableJpaRepositories(basePackages = { "com.expense.auth.repository" })
@ComponentScan(basePackages = { "com.expense.auth.auth", "com.expense.auth.controller", "com.expense.auth.service",
		"com.expense.auth.eventProducer" })
public class AuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
