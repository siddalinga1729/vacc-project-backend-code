package com.citizen_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citizen_service.entity.Citizen;
@Repository
public interface CitizenRepository extends MongoRepository<Citizen, Long> {
public List<Citizen> findAllByVaccinationCenterId(Long id);
}
