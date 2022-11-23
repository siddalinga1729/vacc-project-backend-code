package com.vaccination_center.services;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.citizen_service.dto.CitizenDto;
import com.vaccination_center.entity.Citizen;
import com.vaccination_center.repo.CitizenRepo;

@Service
public class CitizenKafkaConsumerService {
	@Autowired
	private CitizenRepo citizenRepo;
	
	@KafkaListener(topics = "vc", groupId = "group-id")
	public void consumeCitizens(CitizenDto citizenDto) throws IOException {
		System.out.println("-------------"+citizenDto.toString()+"----------------------");
		Citizen citizen = Citizen.builder().cid(citizenDto.getCid())
				.citizenName(citizenDto.getCitizenName())
				.vaccinationCenterId(citizenDto.getVaccinationCenterId()).date(LocalDate.now()).build();
		citizenRepo.save(citizen);
		//logger.info(citizen.toString());
		System.out.println("-------------"+citizen.toString()+"----------------------");
	}
}
