package com.goura.spring.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<Employee> getAll() {
		Iterable<Employee> iterable = repository.findAll();
		List<Employee> target = new ArrayList<>();
		iterable.forEach(target::add);
		return target;
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
