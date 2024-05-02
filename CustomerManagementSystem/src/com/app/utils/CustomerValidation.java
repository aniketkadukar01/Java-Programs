package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.customer.Customer;
import com.app.customer.ServicePlans;
import com.app.customer_exception.CustomerException;
import com.app.tester.CustomerApp;

public class CustomerValidation {
	
	
	
	//check for duplicate customer by email
	public static void checkForDup(String email,List<Customer> customerlist) throws CustomerException {
		Customer cust =new Customer(email);
		if (customerlist.contains(cust)) //it will invoke internally the programmer override equals method 
			throw new CustomerException("Duplicate email");
	}
	
	
	//check for validate plan
	public static ServicePlans checkForPlans(String plans,double ammount ) throws CustomerException {
		 ServicePlans planType=ServicePlans.valueOf(plans.toUpperCase());
		 if (planType.getPlans()==ammount)
			 return planType;
		 
		 throw new CustomerException("Resgistration ammount does not match ");
	}
	
	
	//add a method to validate all inputs 
	public static Customer validateInput(String firstname, String lastname, String email,
			String password, double registrationammount, String dob, String plans, List<Customer> customerlist)
			throws CustomerException {
		checkForDup(email, customerlist);
		ServicePlans plan=checkForPlans(plans, registrationammount);
		LocalDate birthdate=LocalDate.parse(dob);
		return new Customer( firstname, lastname, email, password, registrationammount, birthdate, plan);
	}
	
	
	//method validate to email  
	public static Customer checkEmailAndPassword(String email,String password,List<Customer> customerlist) throws CustomerException {
		Customer customer=new Customer(email);
		int index=customerlist.indexOf(customer);
		if (index == -1) //Index not found 
			throw new CustomerException("Email not found");
		
		  Customer customer1=customerlist.get(index); 
		  
		  if (customer1.getPassword().equals(password)) 
		  		return customer1;
		 
		 throw new CustomerException("Invalid Password");
		 
		 
			/*//method validate for password
			public static boolean checkpassword(String password,Customer customer) throws CustomerException {
					if( customer.getPassword().equals(password))
						return true;
					
					throw new CustomerException("Invalid password");
			}*/
		
	}

	//Delete the customer 
	public static Customer unsuscriberUser(String email,List<Customer> customerList) throws CustomerException {
		
		int index=customerList.indexOf(new Customer(email));
		if (index==-1)
			throw new CustomerException("Email not found ");
		
		return customerList.remove(index);
	}
	

	
		
	
		
		
}
