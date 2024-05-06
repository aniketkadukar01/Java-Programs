package com.app.customer_hashmap;

import java.time.LocalDate;


public class Customer {
	
	private int customerid;
	private String firstname,lastname,email,password;
	private double registrationammount;
	private LocalDate dob;
	private ServicePlans plans;
	
	
	public Customer(int customerid, String firstname, String lastname, String email, String password,
			double registrationammount, LocalDate dob, ServicePlans plans) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.registrationammount = registrationammount;
		this.dob = dob;
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", registrationammount=" + registrationammount + ", dob=" + dob
				+ ", plans=" + plans + "]";
	}

	public int getCustomerid() {
		return customerid;
	}

	public String getLastname() {
		return lastname;
	}

	public LocalDate getDob() {
		return dob;
	}
	
	
	
}
