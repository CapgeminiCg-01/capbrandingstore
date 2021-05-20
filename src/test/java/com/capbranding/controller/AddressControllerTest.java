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

import com.capbranding.services.AddressService;
import com.capbranding.entities.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AddressController.class)
class AddressControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT
	@MockBean
	private AddressService addressService;

	@Test
	void Test() throws Exception {
		
		Address a = new Address();
		a.setAddressId(1);
		a.setStreetNo("1-134");
		a.setBuildingName("Mahesh House");
		a.setCity("Vijayawada");
		a.setState("AndhraPradesh");
		a.setCountry("India");
		a.setPincode("521323");
		
		// LEARNING 2
		// providding the implemenation of findById method.
		// mocking the findById method on MockObject employeeService
		Mockito.when(addressService.viewAddress(Mockito.anyInt())).thenReturn(a);
		
		mockMvc.perform(get("/onlineshopping/address/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.addressId").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.buildingName").value("Mahesh House"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Vijayawada"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.state").value("AndhraPradesh"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.country").value("India"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.pincode").value("521323"));
	}
	
	
	@Test
	void createaddressTest() throws Exception {
		
		Address a = new Address();
		a.setStreetNo("1-134");
		a.setBuildingName("Mahesh House");
		a.setCity("Vijayawada");
		a.setState("AndhraPradesh");
		a.setCountry("India");
		a.setPincode("521323");
		
		// LEARNING 2
		// providding the implemenation of createEmployee method.
		// mocking the findById method on MockObject employeeService
		Mockito.when(addressService.addAddress(Mockito.any())).thenReturn(a);
		
		
		mockMvc.perform(post("/onlineshopping/address")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(a))
						)
		.andExpect(MockMvcResultMatchers.jsonPath("$.streetNo").value("1-134"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.buildingName").value("Mahesh House"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Vijayawada"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.state").value("AndhraPradesh"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.country").value("India"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.pincode").value("521323"));
				
	}
}
