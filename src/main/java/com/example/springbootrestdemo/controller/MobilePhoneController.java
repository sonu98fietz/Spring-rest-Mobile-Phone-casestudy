package com.example.springbootrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.example.springbootrestdemo.entites.MobilePhone;
import com.example.springbootrestdemo.exception.MobilePhoneNotFoundException;
import com.example.springbootrestdemo.service.MobilePhoneService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mobile")
public class MobilePhoneController {
	
	@Autowired
	private MobilePhoneService service;
	
	@GetMapping("/mobiles")
	@Operation(summary = "To find all MobilePhones")
	public List<MobilePhone> get() {
		return service.getAllMobiles();

	}

	@PostMapping("/add")
	@Operation(summary = "To Add MobilePhone")
	public ResponseEntity<?> post(@RequestBody MobilePhone mobilePhone) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<MobilePhone>(service.saveMobilePhone(mobilePhone), HttpStatus.OK);
		} catch (MobilePhoneNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/get/{id}")
	@Operation(summary = "To find MobilePhone by using id")
	public MobilePhone getById(@PathVariable (value = "id") long id) {
		return service.getMobilePhoneById(id);
	}

	@PutMapping("/edit")
	@Operation(summary = "To edit MobilePhone details")
	public void put(@RequestBody MobilePhone mobilePhone) {
		service.editMobilephone(mobilePhone);
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "To delete MobilePhone by using id")
	public void delete(@PathVariable (value = "id") long id) {
		service.deleteMobilePhone(id);
	}

	@GetMapping("/MobilePhones")
	@Operation(summary = "To find all MobilePhone Dto data")
	public List<MobilePhoneDto> getAll() {
		return service.getAllMobilePhones();
	}

}
