package com.vaccination_center.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vaccination_center.binding.GroupMonth;
import com.vaccination_center.entity.Citizen;
import com.vaccination_center.entity.VaccinationCenter;

@Service
public interface VaccinationCenterService {
	
public 	VaccinationCenter save(VaccinationCenter vaccinationCenter);
public List<VaccinationCenter> getAll();
public boolean deleteById(Integer id);
public List<Citizen> getCitizensByVcId(Integer id);
public Map<String,GroupMonth> groupingByMonth();
}
