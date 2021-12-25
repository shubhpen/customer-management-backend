package com.tekvision.season.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekvision.season.model.EnquiryCustomer;
import com.tekvision.season.repository.EnquiryCustomerRepository;

@RestController
@RequestMapping("/api/v1/")
public class EnquiryCustomerController {

	@Autowired
	private EnquiryCustomerRepository enquiryCustomerRepository;
	
	//get all employees
	@GetMapping("/enquirycustomers")
	public List<EnquiryCustomer> getAllCustomers(){
		return enquiryCustomerRepository.findAll();
	}
}
