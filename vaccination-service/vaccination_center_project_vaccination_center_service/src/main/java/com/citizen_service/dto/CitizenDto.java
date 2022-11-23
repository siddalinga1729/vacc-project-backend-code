package com.citizen_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitizenDto {
	
	private Long cid;

	private String citizenName;

	private int vaccinationCenterId;
}

