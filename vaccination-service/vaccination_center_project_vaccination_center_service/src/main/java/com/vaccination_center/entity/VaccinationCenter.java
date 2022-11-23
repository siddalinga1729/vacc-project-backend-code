package com.vaccination_center.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "The vaccinationCenterName is required.")
	private String vaccinationCenterName;
	@NotEmpty(message = "The centerAddress is required.")
	private String centerAddress;
	@Column(unique = true)
	private long pincode;
	private LocalDate date = LocalDate.now();
	@CreationTimestamp
	private Timestamp createdTime;
	@UpdateTimestamp
	private Timestamp updatedTime;
	@Column(unique = true)
	private double latitude;
	@Column(unique = true)
	private double longitude;
	
	
}
