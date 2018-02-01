package com.goura.spring.data.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="managers")
@ToString
@AllArgsConstructor
@NoArgsConstructor()
public class Manager extends Employee {

	@OneToMany(mappedBy="manager")
	List<Employee> employees;
}
