package com.citizen_service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.citizen_service.entity.Citizen;
import com.citizen_service.services.CitizenProducer;
import com.citizen_service.services.CitizenService;
import com.citizen_service.services.SequenceGeneratorService;

@WebMvcTest(value = CitizenController.class)
public class CitizenControllerTest {
	
	@MockBean
	private CitizenService citizenService;
	@MockBean
	private SequenceGeneratorService sequenceGeneratorService; 
	@MockBean
	private CitizenProducer citizenProducer;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testGetAll() throws Exception {
		 Citizen citizen=new Citizen();
		List<Citizen> findAll=new ArrayList<>();
		findAll.add(citizen);
		when(citizenService.getAll()).thenReturn(findAll);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/citizen/getAll");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
	}
	@Test
	public void testGetById() throws Exception {
		 Citizen citizen=new Citizen();
		when(citizenService.getById(1L)).thenReturn(citizen);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/citizen/id/1");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
	}
	
	@Test
	public void testGetAllByVaccinationCenterId() throws Exception {
		Citizen citizen=new Citizen();
		List<Citizen> findAll=new ArrayList<>();
		findAll.add(citizen);
		when(citizenService.getAllByVaccinationCenterId(1L)).thenReturn(findAll);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/citizen/vcid/1");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
	}  
	
}




