package com.app.customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	
	private int customerid;
	private String firstname,lastname,email,password;
	private double registrationammount;
	private LocalDate dob;
	private ServicePlans plans;
	private static int counter;
	
	static {
		counter=0;
	}
	
	public  Customer (String firstname,String lastname,String email,String password
			,double registrationammount,LocalDate dob,ServicePlans plans) {
		super();
		this.customerid=++counter;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		this.registrationammount=registrationammount;
		this.dob=dob;
		this.plans=plans;
	}
	
	//add overload constructor , to wrap PK(email)
	public Customer (String email) {
		this.email=email;
	}
	
	
	
	
	public ServicePlans getPlans() {
		return plans;
	}

	public void setPlans(ServicePlans plans) {
		this.plans = plans;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", registrationammount=" + registrationammount + ", dob=" + dob
				+ ", plans=" + plans + "]";
	}
	
	
	@Override
	public boolean equals (Object obj) {
		
			if(obj instanceof Customer) {
				Customer c=(Customer)obj;
				return this.email.equals(c.email) ;		
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Customer anothercustomer) {
		System.out.println("Inside compareTO");
		 return this.email.compareTo(anothercustomer.email);
	}
	
	
}
