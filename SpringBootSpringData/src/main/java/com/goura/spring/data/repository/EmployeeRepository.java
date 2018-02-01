package com.goura.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goura.spring.data.bean.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByFirstName(@Param("q") String firstName);

	List<Employee> findByLastName(@Param("q") String lastName);
}
