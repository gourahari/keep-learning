package com.goura.spring.data;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.goura.spring.data.bean.Employee;
import com.goura.spring.data.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootSpringDataApplication {

	private static final String[] names = new String[] {"Gourahari Das", "Gitanjali Sabat",
			"Kunmun Mandal", "Mardaraj Subudhi", "Manoj Pujari", "Susant Apoto"};
	private static final String[] roles = {"Developer", "Manager", "Recruiter", "IT Engineer"};

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringDataApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(EmployeeRepository repository) {
		// Clean up all employees table
		repository.deleteAll();

		return args -> {
			Stream.of(names)
				.map(name -> {
					String[] n = name.split(" ");
					Employee e = new Employee();
					e.setFirstName(n[0]);
					e.setLastName(n[1]);
					e.setRole(randomRole());
					return e;
				})
				.map(repository::save)
				.forEach(e -> {});
		};
	}

	private static String randomRole() {
		return roles[new Random().nextInt(roles.length)];
	}
}
