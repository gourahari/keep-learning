package com.goura.spring.data.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.goura.spring.data.Constants;
import com.goura.spring.data.bean.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetEmployeeById() {
		// arrange

		// act
		ResponseEntity<Employee> response = getEmployeeById(1);

		//assert
		assertEquals(response.getStatusCode(), HttpStatus.OK);

		Employee e = response.getBody();
		assertEquals(e.getId(), new Long(1));
		assertEquals(e.getFirstName(), "Robin");
		assertEquals(e.getLastName(), "Singh");
		assertEquals(e.getRole(), "Manager");
		assertNull(e.getManager());
	}

	@Test
	public void testGetEmployeeByNonExistingId() {
		ResponseEntity<Employee> response = getEmployeeById(-1);

		//assert
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<Employee> getEmployeeById(long id) {
		return restTemplate.getForEntity(
				String.format(Constants.EMPLOYEES_BY_ID_URL, id), Employee.class);
	}
}
