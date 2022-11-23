package com.vaccination_center.services;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccination_center.binding.GroupMonth;
import com.vaccination_center.entity.Citizen;
import com.vaccination_center.entity.VaccinationCenter;
import com.vaccination_center.repo.CenterRepo;
import com.vaccination_center.repo.CitizenRepo;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {
	@Autowired
	private CenterRepo centerRepo;
	@Autowired
	private CitizenRepo citizenRepo;


	@Override
	public List<VaccinationCenter> getAll() {
		List<VaccinationCenter> findAll = centerRepo.findAll();
		return findAll;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean b=true;
		try {
		centerRepo.deleteById(id);	
		}
		catch(Exception e) {
			b=false;
		}
		return b;
	}

	@Override
	public VaccinationCenter save(VaccinationCenter vaccinationCenter) {
		VaccinationCenter save = centerRepo.save(vaccinationCenter);
		return save;
	}

	@Override
	public List<Citizen> getCitizensByVcId(Integer id) {
		List<Citizen> listOfCitizens = citizenRepo.findAllByVaccinationCenterId(id);
		return listOfCitizens;
	}

	@Override
	public Map<String, GroupMonth> groupingByMonth() {
		Map<Month, Long> collect = citizenRepo.findAll().stream().collect(Collectors.groupingBy(citizen->
		citizen.getDate().getMonth(),Collectors.counting()));
		Map<Month, Long> collect2 = centerRepo.findAll().stream().collect(Collectors.groupingBy(vc->
		vc.getDate().getMonth(),Collectors.counting()));
		Map<String, GroupMonth> map=new HashMap<>();
		collect.forEach((Month,Long)->{
			GroupMonth groupMonth=new GroupMonth();
			groupMonth.setCitizens(Long);
			map.put(Month+"", groupMonth);
		});
		collect2.forEach((Month,Long)->{
			if(map.get(Month+"")!=null) {
				GroupMonth groupMonth = map.get(Month+"");
				groupMonth.setVCenters(Long);
				map.put(Month+"", groupMonth);
			}
			else {
				GroupMonth groupMonth=new GroupMonth();
				groupMonth.setVCenters(Long);
				map.put(Month+"", groupMonth);
			}
		});
		return map;
	}
}
