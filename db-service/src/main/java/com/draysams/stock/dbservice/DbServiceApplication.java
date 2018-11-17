package com.draysams.stock.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.draysams.stock.dbservice.repository")
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}
}
