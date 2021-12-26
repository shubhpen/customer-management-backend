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
import com.tekvision.season.model.Customer;
import com.tekvision.season.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all employees
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	//add customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get customer by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		Customer customer =  customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
		
		return ResponseEntity.ok(customer);
	}
	
	//update customer
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customer_details){
		Customer customer =  customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
		
		customer.setName(customer_details.getName());
		customer.setPhone_number(customer_details.getPhone_number());
		customer.setAddress(customer_details.getAddress());
		customer.setBill_ammount(customer_details.getBill_ammount());
		customer.setBill_date(customer_details.getBill_date());
		
		Customer updatedCustomer = customerRepository.save(customer);
		
		return ResponseEntity.ok(updatedCustomer);
	}
	
	//delete customer
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable long id){
		Customer customer =  customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
		
		customerRepository.delete(customer);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}
