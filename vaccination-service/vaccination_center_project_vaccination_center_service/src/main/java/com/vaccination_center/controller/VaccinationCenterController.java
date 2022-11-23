package com.vaccination_center.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination_center.binding.GroupMonth;
import com.vaccination_center.entity.Citizen;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.response.ResponseHandler;
import com.vaccination_center.services.VaccinationCenterService;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {	
	@Autowired
	private VaccinationCenterService vaccinationCenterService ;
	
	@PostMapping("/add")
	public ResponseEntity<?> addVaccinationCenter(@Valid @RequestBody VaccinationCenter vaccinationCenter) {
		VaccinationCenter saveVaccinationCenter = vaccinationCenterService.save(vaccinationCenter);
		return ResponseHandler.responseBuilderTrue(true, "success", saveVaccinationCenter, HttpStatus.CREATED);
	}
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<?> getCitizenByVcId(@PathVariable Integer id) {
		List<Citizen> listOfCitizens = vaccinationCenterService.getCitizensByVcId(id);
		return ResponseHandler.responseBuilderTrue(true, "success", listOfCitizens, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVaccinationCentreById(@PathVariable Integer id) {
		vaccinationCenterService.deleteById(id);
		String str="deleted successfully";
		return ResponseHandler.responseBuilderTrue(true, "success", str, HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllVaccinationCentres() {
		List<VaccinationCenter> findAll = vaccinationCenterService.getAll();
		return ResponseHandler.responseBuilderTrue(true, "success", findAll, HttpStatus.OK);
	}
	@GetMapping("/groupByMonth")
	public ResponseEntity<?> groupByMonth(){
		Map<String, GroupMonth> groupingByMonth = vaccinationCenterService.groupingByMonth();
		return ResponseHandler.responseBuilderTrue(true, "success", groupingByMonth, HttpStatus.OK);
	}
	
}
