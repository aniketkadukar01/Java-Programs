package com.app.utility;

import java.time.LocalDate;
import java.util.Comparator;
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

	//Search of customer on id (using Hash Map )
	public static Customer searchByCustNo(int customerid,Map<Integer,Customer> customerlist) throws CustomerException {

		Customer customer = customerlist.values()
				.stream()
				.filter(entry -> entry.getCustomerid() == customerid)
				.findFirst()
				.orElseThrow(() -> new CustomerException("Customer not found "));

		return customer;

	}

	//remove customer (using Hash Map remove method)
	public static String removeAcct(int customerid,Map<Integer,Customer> customerlist) throws CustomerException {

		Customer customer = customerlist.values()
				.stream()
				.filter(entry -> entry.getCustomerid()==customerid)
				.findFirst()
				.map(entry -> {customerlist.remove(entry.getCustomerid()); return entry;})
				.orElseThrow(() -> new CustomerException("Customer not found"));

		return "Account Closed "+customer;
	}

	// Method for sorting the map in ascending order (customerId) natural ordering
	public static void sortByCustomerID(Map<Integer,Customer> customerlist) throws CustomerException {

		if(customerlist.isEmpty())
			throw new CustomerException("Map is empty");
		
		Comparator<Customer> customeridComparator = Comparator.comparing(Customer::getCustomerid);

		customerlist.values()
		.stream()
		.sorted(customeridComparator)
		.forEach(entry -> System.out.println(entry));

	}

	
	// Method for sorting the map in descending order (customerId) natural ordering
	public static void reverseSortByCustomerID(Map<Integer,Customer> customerlist) throws CustomerException {

		if(customerlist.isEmpty())
			throw new CustomerException("Map is empty");
		
		Comparator<Customer> customeridComparator = Comparator.comparing(Customer::getCustomerid);

		customerlist.values()
		.stream()
		.sorted(customeridComparator.reversed())
		.forEach(entry -> System.out.println(entry));

	}
	
	
	
	// Method for sorting the map in ascending order (Dob and name) custom ordering
	public static void sortByDobAndName(Map<Integer,Customer> customerlist) throws CustomerException {

		if(customerlist.isEmpty())
			throw new CustomerException("Map is empty");

		Comparator<Customer> dobAndNameComparator =Comparator
				.comparing(Customer::getDob)
				.thenComparing(Customer::getLastname);

		customerlist.values()
		.stream()
		.sorted(dobAndNameComparator)
		.forEach(entry -> System.out.println(entry));


	}
	
	// Method for sorting the map in descending order (Dob and name) custom ordering
	public static void reverseSortByDobAndName(Map<Integer,Customer> customerlist) throws CustomerException {

		if(customerlist.isEmpty())
			throw new CustomerException("Map is empty");

		Comparator<Customer> dobAndNameComparator =Comparator
				.comparing(Customer::getDob)
				.thenComparing(Customer::getLastname);

		customerlist.values()
		.stream()
		.sorted(dobAndNameComparator.reversed())
		.forEach(entry -> System.out.println(entry));


	}


}
