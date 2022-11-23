package com.citizen_service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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

import com.citizen_service.entity.Citizen;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CitizenServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitizenServiceIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveCitizens() {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/citizen/getAll"), HttpMethod.GET,
				entity, String.class);
		HttpStatus expected = HttpStatus.OK;
		assertEquals(expected, response.getStatusCode());
	}

	@Test
	public void testAddCitizen()  {
		Citizen citizen = new Citizen(20, "siddu", 1, 2556035566l, 810659554l,"male",LocalDate.now());
		HttpEntity<Citizen> entity = new HttpEntity<Citizen>(citizen, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/citizen/add"), HttpMethod.POST,
				entity, String.class);
		HttpStatus expected = HttpStatus.OK;
		assertEquals(expected, response.getStatusCode());
	}

//    @Test
//    public void testUpdateCitizen() throws NullPointerException {
//
//    	Instant instant = Instant.now(); ;
//		Citizen citizen=new Citizen(20, "siddu", 1, 2556035566l, 810659554l,
//    			Timestamp.from(instant), Timestamp.from(instant));
//
//		HttpEntity<Citizen> entity = new HttpEntity<Citizen>(citizen, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/citizen/delete/1"),
//				HttpMethod.GET, entity, String.class);
//
//		 HttpStatus expected = HttpStatus.OK;
//
//		 assertEquals(expected, response.getStatusCode());
//    }

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
