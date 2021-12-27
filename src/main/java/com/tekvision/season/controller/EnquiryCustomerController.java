package com.tekvision.season.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekvision.season.exception.ResourceNotFoundException;
import com.tekvision.season.model.EnquiryCustomer;
import com.tekvision.season.repository.EnquiryCustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	//add customer
	@PostMapping("/enquirycustomers")
	public EnquiryCustomer addCustomer(@RequestBody EnquiryCustomer customer) {
		return enquiryCustomerRepository.save(customer);
	}
	
	//get customer by id
		@GetMapping("/enquirycustomers/{id}")
		public ResponseEntity<EnquiryCustomer> getCustomerById(@PathVariable long id) {
			EnquiryCustomer customer =  enquiryCustomerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
			
			return ResponseEntity.ok(customer);
		}
		
		//update customer
		@PutMapping("/enquirycustomers/{id}")
		public ResponseEntity<EnquiryCustomer> updateCustomer(@PathVariable long id,@RequestBody EnquiryCustomer customer_details){
			EnquiryCustomer customer =  enquiryCustomerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
			
			customer.setName(customer_details.getName());
			customer.setPhone_number(customer_details.getPhone_number());
			
			EnquiryCustomer updatedCustomer = enquiryCustomerRepository.save(customer);
			
			return ResponseEntity.ok(updatedCustomer);
		}
		
		//delete customer
		@DeleteMapping("/enquirycustomers/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable long id){
			EnquiryCustomer customer =  enquiryCustomerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
			
			enquiryCustomerRepository.delete(customer);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", Boolean.TRUE);
			
			return ResponseEntity.ok(response);
		}
}
