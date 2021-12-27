package com.tekvision.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekvision.season.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
