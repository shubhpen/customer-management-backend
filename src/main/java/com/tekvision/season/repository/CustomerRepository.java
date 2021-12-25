package com.tekvision.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekvision.season.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
