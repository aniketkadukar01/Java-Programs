package com.app.phonebook;

import java.time.LocalDate;

public class PhoneBook {

	private String phonenumber,name,email;
	private LocalDate date;

	//Parameterized constructor 
	public PhoneBook(String phonenumber,String name,LocalDate date,String email) {
		this.phonenumber=phonenumber;
		this.name=name;
		this.date=date;
		this.email=email;
	}
	
	//Composite primary key constructor 
	public PhoneBook(String name,LocalDate date) {
		this.name=name;
		this.date=date;
	}

	//Override toString method of Object class
	@Override
	public String toString() {
		return "PhoneBook [phonenumber=" + phonenumber + ", name=" + name + ", email=" 
				+ email + ", date=" + date + "]";
	}

	//Override equals method of Object class
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PhoneBook) {
			PhoneBook p=((PhoneBook)obj);
			return (this.name.equals(p.name) && this.date.equals(p.date));
		}
		return false;
	}
	
	//Override hashCode method of Object class
	@Override
	public int hashCode() {
		return 31* (name.hashCode() * date.hashCode());
	}
	
	
}
