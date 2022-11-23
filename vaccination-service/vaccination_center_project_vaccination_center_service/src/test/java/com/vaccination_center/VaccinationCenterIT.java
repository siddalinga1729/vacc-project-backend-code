package com.vaccination_center;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vaccination_center.entity.VaccinationCenter;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = VaccinationCenterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VaccinationCenterIT {

//	@LocalServerPort
//	private int port;
//
//	TestRestTemplate restTemplate = new TestRestTemplate();
//
//	HttpHeaders headers = new HttpHeaders();
//
//	@Test
//	public void testRetrieveVaccinationCenters() {
//
//		HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/vaccinationcenter/getAll"), HttpMethod.GET,
//				entity, String.class);
//
//		HttpStatus expected = HttpStatus.OK;
//
//		assertEquals(expected, response.getStatusCode());
//	}
//
//	@Test
//	public void testAddVaccinationCenter()  {
//
//		Instant instant = Instant.now();
//		;
//		VaccinationCenter vacc = new VaccinationCenter(20, "Govt.Hospital", "Hyderabad", 515303,  Timestamp.from(instant),
//				Timestamp.from(instant),127.88,90.12);
//
//		HttpEntity<VaccinationCenter> entity = new HttpEntity<VaccinationCenter>(vacc, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/vaccinationcenter/add"), HttpMethod.POST,
//				entity, String.class);
//
//		HttpStatus expected = HttpStatus.OK;
//
//		assertEquals(expected, response.getStatusCode());
//	}
//
//
//
//	private String createURLWithPort(String uri) {
//		return "http://localhost:" + port + uri;
//	}
}
