package com.tekvision.season.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekvision.season.model.EnquiryCustomer;

@Repository
public interface EnquiryCustomerRepository extends JpaRepository<EnquiryCustomer, Long>{

}
