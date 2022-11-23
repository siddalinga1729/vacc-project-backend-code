package com.vaccination_center;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.repo.CenterRepo;

@SpringBootTest
class VaccinationCenterApplicationTests {
	@Autowired
	private CenterRepo centerRepo;

	@Test
	void saveVaccinationCenter() {
		VaccinationCenter v1 = new VaccinationCenter();
		v1.setVaccinationCenterName("Govt.Hospital");
		v1.setCenterAddress("hyderabad");
		v1.setPincode(560001);
		centerRepo.save(v1);

		assertThat(v1.getId()).isGreaterThan(0);
	}

	@Test
	void gatAllVaccinationCenters() {
		List<VaccinationCenter> vaccinationCenters = centerRepo.findAll();

		assertThat(vaccinationCenters).size().isGreaterThan(0);
	}

	@Test
	void deleteCitizenById() {
		centerRepo.deleteById(2);
		Optional<VaccinationCenter> deletedCenter = centerRepo.findById(2);

		assertThat(deletedCenter).isEmpty();
	}

	@Test
	void getVaccinationCenterById() {
		Optional<VaccinationCenter> findById = centerRepo.findById(1);
		VaccinationCenter vcc = findById.get();

		assertThat(vcc.getId()).isEqualTo(1);
	}

	@Test
	void updateVaccinationCenter() {
		Optional<VaccinationCenter> findById = centerRepo.findById(1);
		VaccinationCenter vaccinationcenter = findById.get();
		vaccinationcenter.setPincode(560066);
		;
		centerRepo.save(vaccinationcenter);

		assertThat(vaccinationcenter.getPincode()).isEqualTo(560066);
	}
	
	

}
