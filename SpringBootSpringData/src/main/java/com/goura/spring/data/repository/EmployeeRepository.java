package com.goura.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goura.spring.data.bean.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByLastName(String lastName);
}
