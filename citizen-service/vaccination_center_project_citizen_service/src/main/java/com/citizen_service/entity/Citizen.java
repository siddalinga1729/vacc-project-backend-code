package com.citizen_service.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "citizens")
public class Citizen {
	@Transient
	public static final String SEQUENCE_NAME = "citizens_sequence";
	@Id
	private long id;
	private String citizenName;
	private int vaccinationCenterId;
	@Indexed(unique = true)
	private long adhaarNumber;
	@Indexed(unique = true)
	private long mobileNumber;
	private String gender;
	private LocalDate date=LocalDate.now();

//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	@CreatedDate
//	private Timestamp createdDate;
//	@LastModifiedDate
//	private Timestamp updatedTime;

}
