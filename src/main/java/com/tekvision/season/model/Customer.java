package com.tekvision.season.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Customer")
public class Customer{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "phone_number")
	private long phone_number;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "bill_ammount")
	private long bill_ammount;
	
	@Column (name = "bill_date")
	private Date bill_date;
	
	public Customer() {
		
	}

	public Customer(String name, long phone_number, String address, long bill_ammount, Date bill_date) {
		this.name=name;
		this.phone_number=phone_number;
		this.address = address;
		this.bill_ammount = bill_ammount;
		this.bill_date = bill_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getBill_ammount() {
		return bill_ammount;
	}

	public void setBill_ammount(long bill_ammount) {
		this.bill_ammount = bill_ammount;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	
	
}
