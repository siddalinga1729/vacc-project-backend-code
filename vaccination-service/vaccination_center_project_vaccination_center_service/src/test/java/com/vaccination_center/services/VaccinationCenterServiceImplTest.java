package com.vaccination_center.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vaccination_center.entity.Citizen;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.repo.CenterRepo;
import com.vaccination_center.repo.CitizenRepo;
@SpringBootTest
class VaccinationCenterServiceImplTest extends VaccinationCenterServiceImpl {
	@MockBean
	private CenterRepo centerRepo;
	@MockBean
	private CitizenRepo citizenRepo;
	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@Test
	public void testGetAll() {
		Instant instant =Instant.now();
		when(centerRepo.findAll()).thenReturn(Arrays.asList(new VaccinationCenter(1,"govt.hos","cair",875484775L,LocalDate.now(),Timestamp.from(instant),Timestamp.from(instant),127.058,90.12)));
		List<VaccinationCenter> findAll = vaccinationCenterService.getAll();
		assertEquals(1, findAll.size());
	}
	
	/*
	 * @Test public void testDeleteById() { //
	 * when(centerRepo.deleteById(1)).thenReturn(true); boolean deleteById =
	 * vaccinationCenterService.deleteById(1); assertEquals(true, deleteById); }
	 */
	
	@Test
	public void testSave() {
		Instant instant =Instant.now();
		VaccinationCenter vaccinationCenter=new VaccinationCenter(1,"govt.hos","cair",875484775L,LocalDate.now(),Timestamp.from(instant),Timestamp.from(instant),127.058,90.12);
		when(centerRepo.save(vaccinationCenter)).thenReturn(vaccinationCenter);
		VaccinationCenter findAll = vaccinationCenterService.save(vaccinationCenter);
		assertEquals(vaccinationCenter, findAll);
	}
	
	@Test
	public void testGetCitizensByVcId() {
		List<Citizen> list=Arrays.asList(new Citizen());
		when(citizenRepo.findAllByVaccinationCenterId(1)).thenReturn(list);
		List<Citizen> findAll = vaccinationCenterService.getCitizensByVcId(1);
		assertEquals(list.size(), findAll.size());
	}		
}
