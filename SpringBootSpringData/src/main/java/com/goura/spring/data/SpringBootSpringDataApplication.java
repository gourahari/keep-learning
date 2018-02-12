package com.goura.spring.data;

import static com.goura.spring.data.Constants.MANAGER;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.goura.spring.data.bean.Employee;
import com.goura.spring.data.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootSpringDataApplication {

	private static final String[] managers = new String[] {"Robin Singh", "Sachin Tendulkar",
			"Sourav Ganguly"};
	private static final String[] employees = new String[] {"Gourahari Das", "Gitanjali Sabat",
			"Kunmun Mandal", "Mardaraj Subudhi", "Manoj Pujari", "Susant Apoto"};
	private static final String[] roles = {"Developer", "Sales", "Recruiter", "IT Engineer"};

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringDataApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(EmployeeRepository repository) {
		// Clean up all employees table
		repository.deleteAll();

		return args -> {
			// Load all managers. Managers are also employees.
			List<Employee> managerList = Stream.of(managers)
				.map(name -> {
					String[] n = name.split(" ");
					Employee e = new Employee();
					e.setFirstName(n[0]);
					e.setLastName(n[1]);
					e.setRole(MANAGER);
					return e;
				})
				.map(repository::save)
				.collect(Collectors.toList());

			// Load all employees.
			Stream.of(employees)
				.map(name -> {
					String[] n = name.split(" ");
					Employee e = new Employee();
					e.setFirstName(n[0]);
					e.setLastName(n[1]);
					e.setRole(randomRole());
					e.setManager(randomManager(managerList));
					return e;
				})
				.map(repository::save)
				.forEach(e -> {});
		};
	}

	private static String randomRole() {
		return roles[new Random().nextInt(roles.length)];
	}

	private static Employee randomManager(List<Employee> list) {
		return list.get(new Random().nextInt(list.size()));
	}
}
