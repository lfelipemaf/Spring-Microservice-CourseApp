package com.Moriondo.services.CourseCatalogApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseCatalogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseCatalogAppApplication.class, args);
	}

}
