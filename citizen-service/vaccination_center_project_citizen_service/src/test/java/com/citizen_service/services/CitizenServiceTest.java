package com.citizen_service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.citizen_service.entity.Citizen;
import com.citizen_service.repository.CitizenRepository;

@SpringBootTest
public class CitizenServiceTest {
	
	@MockBean
	CitizenRepository citizenRepository;
	@Autowired
	CitizenService citizenService;
	
	@Test
	public void testSave() {
		Citizen citizen =new Citizen();
		when(citizenRepository.save(citizen)).thenReturn(citizen);
		assertEquals(citizen,citizenService.save(citizen));
	}
	
	@Test
	public void testGetAll() {
		when(citizenRepository.findAll()).thenReturn(Arrays.asList(new Citizen(1,"dfgh",2,45778998877L,987665544L,"male",LocalDate.now())));
		List<Citizen> findAll = citizenService.getAll();
		assertEquals(1,findAll.size());
	}
	@Test
	public void testGetById() {	
		Optional<Citizen> findById=Optional.of(new Citizen(1,"dfgh",2,45778998877L,987665544L,"male",LocalDate.now()));
		when(citizenRepository.findById(1L)).thenReturn(findById);
		Citizen byId = citizenService.getById(1L);
		assertTrue(byId!=null);	
	}
	
	@Test
	public void testGetAllByVaccinationCenterId() {
		when(citizenRepository.findAllByVaccinationCenterId(2L)).thenReturn(Arrays.asList(new Citizen(1,"dfgh",2,45778998877L,987665544L,"female",LocalDate.now())));
		List<Citizen> allByVaccinationCenterId = citizenService.getAllByVaccinationCenterId(2L);
		assertEquals(1,allByVaccinationCenterId.size());
	}				
}
