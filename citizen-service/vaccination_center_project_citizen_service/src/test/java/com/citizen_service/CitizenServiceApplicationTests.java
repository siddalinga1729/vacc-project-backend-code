package com.citizen_service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.citizen_service.entity.Citizen;
import com.citizen_service.repository.CitizenRepository;
import com.citizen_service.services.CitizenService;

@SpringBootTest
class CitizenServiceApplicationTests {
	/*
	 * @Autowired private CitizenRepository citizenRepo;
	 * 
	 * @Test void saveCitizen() { Citizen s1 = new Citizen(); s1.setId(30);
	 * s1.setCitizenName("siddu"); s1.setMobileNumber(8106595594l);
	 * s1.setAdhaarNumber(244025543261l); s1.setVaccinationCenterId(1);
	 * citizenRepo.save(s1);
	 * 
	 * assertThat(s1.getId()).isGreaterThan(0);
	 * 
	 * }
	 * 
	 * @Test void gatAllCitizens() { List<Citizen> allCitizens =
	 * citizenRepo.findAll();
	 * 
	 * assertThat(allCitizens).size().isGreaterThan(0); }
	 * 
	 * @Test void deleteCitizenById() { citizenRepo.deleteById(2l);
	 * Optional<Citizen> deletedCitizen = citizenRepo.findById(2l);
	 * 
	 * 
	 * assertThat(deletedCitizen).isEmpty(); }
	 * 
	 * @Test void getCitizenById() { Optional<Citizen> findById =
	 * citizenRepo.findById(1l); Citizen citizen = findById.get();
	 * assertThat(citizen.getId()).isEqualTo(1); }
	 * 
	 * @Test void updateCitizen() { Optional<Citizen> findById =
	 * citizenRepo.findById(1l); Citizen citizen = findById.get();
	 * citizen.setAdhaarNumber(244025553621l); citizenRepo.save(citizen);
	 * 
	 * assertThat(citizen.getAdhaarNumber()).isEqualTo(244025553621l); }
	 * 
	 */
	
	@MockBean
	CitizenRepository citizenRepository;
	@Autowired
	CitizenService citizenService;
	
	@Test
	public void testGetAll() {
		when(citizenRepository.findAll()).thenReturn(Arrays.asList(new Citizen(),new Citizen()));
		List<Citizen> findAll = citizenService.getAll();
		assertEquals(1,findAll.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
