package com.vaccination_center.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizen_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {
	
	@Id	
	private Long cid;
		
	private String citizenName;

	private int vaccinationCenterId;
	
	private LocalDate date;
}
