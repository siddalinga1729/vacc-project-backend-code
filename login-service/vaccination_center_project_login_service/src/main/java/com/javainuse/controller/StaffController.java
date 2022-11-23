package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.DAOUser;
import com.javainuse.repo.UserRepo;
import com.javainuse.response.ResponseHandler;

@RestController
@RequestMapping("/admin")
public class StaffController {
	@Autowired
	private UserRepo userRepo;

	// we need to develop
	@PostMapping("/addStaff")
	public ResponseEntity<?> addStaff(@RequestBody DAOUser staff) {
		DAOUser save = userRepo.save(staff);
		return ResponseHandler.responseBuilderTrue(true, "success", save, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllStaff() {
		List<DAOUser> findAll = userRepo.findAll();
		return ResponseHandler.responseBuilderTrue(true, "success", findAll, HttpStatus.OK);	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteStaffById(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
