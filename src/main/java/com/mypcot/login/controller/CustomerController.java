package com.mypcot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypcot.login.dto.CustomerLoginDto;
import com.mypcot.login.dto.LoginMesage;
import com.mypcot.login.entity.Customer;
import com.mypcot.login.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer customer){
		cs.register(customer);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody CustomerLoginDto dao){
		LoginMesage msg = cs.loginEmployee(dao);
		return ResponseEntity.ok(msg);
	}
}
