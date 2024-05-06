package com.app.utility;

import java.time.LocalDate;
import java.util.Map;

import com.app.customer_hashmap.Customer;
import com.app.customer_hashmap.ServicePlans;
import com.app.customerexception_hashmap.CustomerException;




public class CustomerValidation {

	//validate all Inputs taken from the user
	public static Customer validateInput(int customerid,String firstname, String lastname, String email,
			String password, double registrationammount, String dob, String plans, 
			Map<Integer,Customer> customerlist) throws CustomerException {
		checkForDuplicate(customerid,customerlist);
		emailVerification(email);
		LocalDate birthDate = parseDate(dob);
		ServicePlans plans1= checkPlans(plans,registrationammount);
		return new Customer( customerid,firstname, lastname, email, password
				, registrationammount, birthDate, plans1);
		
	}
	
	// Check for Duplicate customer id (using Hash Map containsKey method)
	public static void checkForDuplicate(int customerid,Map<Integer,Customer> customerlist) throws CustomerException {
		if(customerlist.containsKey(customerid))
			throw new CustomerException("Duplicate CUstomer id !!!");
	}
	
	//validate email of customer (using regular expression)
		public static String emailVerification(String email) throws CustomerException {
			String regex="^(?=.*[a-z])(?=.*@gmail\\.com)[^A-Z]{2,32}$";
			if(!email.matches(regex))
				throw new CustomerException("Invalid Email");
			
			return email;
		}
		
		// add a static method for parsing string --> LocalDate
		public static LocalDate parseDate(String date) {
			return LocalDate.parse(date);
		}
		
		// compare plans with the registration amount
		public static ServicePlans checkPlans(String plans,double registrationammount) throws CustomerException {
			ServicePlans planType=ServicePlans.valueOf(plans.toUpperCase());
			if (planType.getPlans()==registrationammount)
				return planType;
			
			throw new CustomerException("Resgistration ammount does not match ");
		}
		
		//Search of customer on id (using Hash Map get method)
		public static Customer searchByCustNo(int customerid,Map<Integer,Customer>customerlist) throws CustomerException {
			Customer cust=customerlist.get(customerid);
			if(cust==null)
				throw new CustomerException("Customerid not found ");
			
			return cust;
		}
	
		//remove customer (using Hash Map remove method)
		public static String removeAcct(int customerid,Map<Integer,Customer> customerlist) throws CustomerException {
			Customer cust=customerlist.remove(customerid);
			if (cust==null)
				throw new CustomerException("Id number is Invalid");
			
			return "Account Closed "+cust;
		}
		
		
}
