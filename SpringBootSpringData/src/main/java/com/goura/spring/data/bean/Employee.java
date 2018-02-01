package com.goura.spring.data.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="employees")
@ToString
@AllArgsConstructor
@NoArgsConstructor()
@JsonInclude(Include.NON_NULL)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Employee manager;

	private String firstName;
	private String lastName;
	private String role;

	public Employee withRole(String role) {
		this.role = role;
		return this;
	}
}
