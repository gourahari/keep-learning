package com.goura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.goura.spring.data.bean.Employee;

@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
