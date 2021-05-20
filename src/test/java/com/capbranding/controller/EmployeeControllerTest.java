package com.capbranding.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capbranding.services.EmployeeService;
import com.capbranding.entities.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT
	@MockBean
	private EmployeeService employeeService;

	@Test
	void findEmployeeTest() throws Exception {
		
		Employee e = new Employee();
		e.setEmail("saisai@gmail.com");
		e.setFirstName("Sankurathri");
		e.setLastName("Mahesh");
		e.setMobileNumber("9618383646");
		e.setAddress("Raja veedhi");
		
		// LEARNING 2
		// providding the implemenation of findById method.
		// mocking the findById method on MockObject employeeService
		Mockito.when(employeeService.viewEmployee(Mockito.anyInt())).thenReturn(e);
		
		mockMvc.perform(get("/Onlineshopping/employee/2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Sankurathri"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Mahesh"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.mobileNumber").value("9618383646"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Raja veedhi"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("saisai@gmail.com"));
	}
	
	
	@Test
	void createEmployeeTest() throws Exception {
		
		Employee e = new Employee();
		e.setEmail("saisai@gmail.com");
		e.setFirstName("Sankurathri");
		e.setLastName("Mahesh");
		e.setMobileNumber("9618383646");
		e.setAddress("Raja veedhi");
		
		
		// LEARNING 2
		// providding the implemenation of createEmployee method.
		// mocking the findById method on MockObject employeeService
		Mockito.when(employeeService.addEmployee(Mockito.any())).thenReturn(e);
		
		
		mockMvc.perform(post("/Onlineshopping/employee")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(e))
						)
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Sankurathri"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Mahesh"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.mobileNumber").value("9618383646"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Raja veedhi"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("saisai@gmail.com"));
				
	}
}

