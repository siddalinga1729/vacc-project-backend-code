package com.vaccination_center.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination_center.entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
