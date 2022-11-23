package com.citizen_service.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen_service.dto.CitizenDto;
import com.citizen_service.entity.Citizen;
import com.citizen_service.response.ResponseHandler;
import com.citizen_service.services.CitizenProducer;
import com.citizen_service.services.CitizenService;
import com.citizen_service.services.SequenceGeneratorService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenService CitizenService;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	CitizenProducer citizenProducer;

	@GetMapping("/vcid/{id}")
	public ResponseEntity<?> getAllByVaccinationCenterId(@PathVariable Long id) {
		List<Citizen> findAllByVaccinationCenterId = CitizenService.getAllByVaccinationCenterId(id);
		if(!findAllByVaccinationCenterId.isEmpty()) {
		return ResponseHandler.responseBuilderTrue(true, "success", findAllByVaccinationCenterId, HttpStatus.OK);
	}else {
		return ResponseHandler.responseBuilderFalse(false, "No data found", HttpStatus.OK);
	}}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Citizen findById = CitizenService.getById(id);
		if(findById!=null) {
		return ResponseHandler.responseBuilderTrue(true, "success", findById, HttpStatus.OK);
	}else {
		return ResponseHandler.responseBuilderFalse(false, "No data found", HttpStatus.OK);
	}}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCitizen(@RequestBody Citizen newCitizen) {
		newCitizen.setId(sequenceGeneratorService.generateSequence(Citizen.SEQUENCE_NAME));
		Citizen save = CitizenService.save(newCitizen);
		
		 CitizenDto citizenDto =
		 CitizenDto.builder().cid(save.getId()).citizenName(save.getCitizenName())
		 .vaccinationCenterId(save.getVaccinationCenterId()).build();
		 citizenProducer.save(citizenDto);
		 		
		return ResponseHandler.responseBuilderTrue(true, "success", save, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCitizens() {
		List<Citizen> findAll = CitizenService.getAll();
		return ResponseHandler.responseBuilderTrue(true, "success", findAll, HttpStatus.OK);
	}
	
	@GetMapping("/groupByGender")
	public ResponseEntity<?> groupByGender() {
		 Map<String, Long> groupByGender = CitizenService.groupByGender();
		return ResponseHandler.responseBuilderTrue(true, "success", groupByGender, HttpStatus.OK);
	}
}











