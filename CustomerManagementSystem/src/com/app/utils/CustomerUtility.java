package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.customer.Customer;
import com.app.customer.ServicePlans;

public class CustomerUtility {

	public static List<Customer> populatedCustomer(){
		Customer a1=new Customer("virat", "kholi", "virat@gmail.com","virat", 1000, 
				LocalDate.parse("2000-12-12"), ServicePlans.SILVER);
		
		Customer a2=new Customer("scahin", "tendulkar", "scahin@gmail.com","scahin", 2000, 
				LocalDate.parse("2020-11-10"), ServicePlans.GOLD);
		
		Customer a3=new Customer("padypoo", "d", "padyoo@gmail.com","padyoo", 5000, 
				LocalDate.parse("2020-11-10"), ServicePlans.DIAMIOND);
		
		Customer a4=new Customer("ajaynagar", "dev", "ajaynagar@gmail.com","ajaynagar", 10000, 
				LocalDate.parse("2024-06-09"), ServicePlans.PLATINUM);
		
		Customer[] customer = {a1,a2,a3,a4};
		List<Customer> customerlist = new ArrayList<Customer>();
		
		for (Customer c : customer) {
			customerlist.add(c);
		}
		
		return customerlist;
			
	}
	
	
	public static void removeUser(String dob,String serviceplans,List<Customer> customerlist) {
		LocalDate date = LocalDate.parse(dob);
		ServicePlans enteredplan = ServicePlans.valueOf(serviceplans.toUpperCase());
		Iterator<Customer> itr = customerlist.iterator();
		while(itr.hasNext()) {
			Customer c= itr.next();
			if (c.getPlans()== enteredplan && c.getDob().isAfter(date))
				itr.remove();
		}
	}
	
	
	
	
}
