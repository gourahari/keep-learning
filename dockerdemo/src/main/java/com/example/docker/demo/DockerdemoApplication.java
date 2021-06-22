package com.example.docker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.docker.demo")
public class DockerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerdemoApplication.class, args);
	}

}
