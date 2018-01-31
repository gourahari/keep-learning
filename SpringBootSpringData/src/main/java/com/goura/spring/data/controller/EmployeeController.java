package com.goura.spring.data.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goura.spring.data.bean.Employee;
import com.goura.spring.data.repository.EmployeeRepository;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return Arrays.asList();
	}
}
