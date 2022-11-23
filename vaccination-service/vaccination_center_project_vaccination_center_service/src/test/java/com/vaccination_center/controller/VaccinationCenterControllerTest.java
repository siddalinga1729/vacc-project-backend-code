package com.vaccination_center.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaccination_center.entity.Citizen;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.services.VaccinationCenterService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VaccinationCenterController.class)
public class VaccinationCenterControllerTest {
	@MockBean
	private VaccinationCenterService vaccinationCenterService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAll() throws Exception {
		Instant instant = Instant.now();
		VaccinationCenter vacc = new VaccinationCenter(12, "Govt.Hospital", "Hyderabad", 518310,LocalDate.now(),
				Timestamp.from(instant), Timestamp.from(instant), 127.058, 90.12);
		List<VaccinationCenter> findAll = new ArrayList<>();
		findAll.add(vacc);
		when(vaccinationCenterService.getAll()).thenReturn(findAll);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vaccinationcenter/getAll");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	@Test
	public void testGetCitizenByVcId() throws Exception {
		Citizen citizen=new Citizen();
		List<Citizen> findAll = new ArrayList<>();
		findAll.add(citizen);
		when(vaccinationCenterService.getCitizensByVcId(1)).thenReturn(findAll);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vaccinationcenter/id/1");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void testAddVaccinationCenter() throws Exception {
		Instant instant = Instant.now();
		VaccinationCenter vacc = new VaccinationCenter(12, "Govt.Hospital", "Hyderabad", 518310,LocalDate.now(),
				Timestamp.from(instant), Timestamp.from(instant), 127.058, 90.12);
		ObjectMapper objectMapper=new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(vacc);
		when(vaccinationCenterService.save(vacc)).thenReturn(vacc);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/vaccinationcenter/add")
				.accept(MediaType.APPLICATION_JSON)
				.content(writeValueAsString)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
	}
	@Test
	public void testDeleteVaccinationCentreById() throws Exception {
		when(vaccinationCenterService.deleteById(1)).thenReturn(true);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/vaccinationcenter/delete/1");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
}
