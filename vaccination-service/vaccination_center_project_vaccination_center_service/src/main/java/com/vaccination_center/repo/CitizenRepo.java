package com.vaccination_center.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination_center.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen,Long>{

 List<Citizen>	findAllByVaccinationCenterId(int id);
}
