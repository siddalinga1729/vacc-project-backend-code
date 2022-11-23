package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username;
	@Column
	//@JsonIgnore
	private String password;
	@Column
	private String role;
	@CreationTimestamp
	private Timestamp createdTime;
	@UpdateTimestamp
	private Timestamp updatedTime;
	
}