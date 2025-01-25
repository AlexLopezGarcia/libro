package com.grupLibros.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.grupLibros.bussiness.services",
		"com.grupLibros.presentation",
		"com.grupLibros.backend.config"
})
public class LibroApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibroApplication.class, args);
	}

}
