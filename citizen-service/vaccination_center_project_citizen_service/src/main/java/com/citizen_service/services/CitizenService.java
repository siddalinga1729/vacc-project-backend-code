package com.citizen_service.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.citizen_service.entity.Citizen;
import com.citizen_service.repository.CitizenRepository;

@Service
public class CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;

	public Citizen save(Citizen citizen) {
		Citizen save = citizenRepository.save(citizen);
		return save;
	}
	@Cacheable(value = "citizen", key = "#id")
	public Citizen getById(Long id) {
		Optional<Citizen> findById = citizenRepository.findById(id);
		return findById.get();
	}	
	public List<Citizen> getAll() {
		List<Citizen> findAll = citizenRepository.findAll();
		return findAll;
	}
	public List<Citizen> getAllByVaccinationCenterId(Long id) {
		List<Citizen> findAll = citizenRepository.findAllByVaccinationCenterId(id);
		return findAll;
	}
	
	public Map<String, Long> groupByGender() {
		Map<String, Long> collect = citizenRepository.findAll().stream().collect(Collectors.groupingBy(citizen->
		citizen.getGender(),Collectors.counting()));
		return collect;
	}
	}		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

