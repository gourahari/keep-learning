package com.goura.spring.data.controller;

import static com.goura.spring.data.Constants.FIRST_NAME;
import static com.goura.spring.data.Constants.LAST_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.goura.spring.data.bean.Employee;
import com.goura.spring.data.error.NotFoundException;
import com.goura.spring.data.error.RestException;
import com.goura.spring.data.repository.EmployeeRepository;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAll(
			@RequestParam(required=false) String firstName,
			@RequestParam(required=false) String lastName) {
		String query = null;
		int count = 0;
		if (null != firstName) {
			query = FIRST_NAME;
			count++;
		}

		if (null != lastName) {
			query = LAST_NAME;
			count++;
		}

		if (1 == count) {
			switch (query) {
			case FIRST_NAME:
				return repository.findByFirstName(firstName);

			case LAST_NAME:
				return repository.findByLastName(lastName);

			default:
				return Collections.emptyList();
			}
		} else {
			final List<Employee> target = new ArrayList<>();
			repository.findAll()
				.forEach(e -> {
					boolean flag = true;
					if (null != firstName && !firstName.equalsIgnoreCase(e.getFirstName())) {
						flag = false;
					}
					if (flag && null != lastName && !lastName.equalsIgnoreCase(e.getLastName())) {
						flag = false;
					}

					if (flag) {
						target.add(e);
					}
				});
			return target;
		}
	}

	@GetMapping("/employees/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee getById(@PathVariable Long id) throws RestException {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Employee with id: [%s] doesn't exist.", id)));
	}

	@DeleteMapping("/employees/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws RestException {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException(String.format("Employee with id: [%s] doesn't exist.", id));
		}
	}
}
