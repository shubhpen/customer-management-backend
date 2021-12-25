package com.tekvision.season.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EnquiryCustomer")
public class EnquiryCustomer {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "phone_number")
	private long phone_number;
	
	public EnquiryCustomer() {
		
	}
	
	public EnquiryCustomer(String name, long phone_number) {
		this.name=name;
		this.phone_number=phone_number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone_number() {
		return phone_number;
	}
}
