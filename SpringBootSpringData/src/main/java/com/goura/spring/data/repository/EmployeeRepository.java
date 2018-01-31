package com.goura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goura.spring.data.bean.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
