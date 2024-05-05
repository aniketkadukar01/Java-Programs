package com.app.utility;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.customer_hashmap.ServicePlans;
import com.app.customer_hashmap.Customer;

public class CustomerUtility {

	public static Map<Integer,Customer> populatedCustomer(){
		
		Customer a1=new Customer(18,"Virat", "kholi", "virat@gmail.com","virat", 1000, 
				LocalDate.parse("2002-12-12"), ServicePlans.SILVER);
		
		Customer a2=new Customer(64,"scahin", "Tendulkar", "scahin@gmail.com","scahin", 2000, 
				LocalDate.parse("2000-11-10"), ServicePlans.GOLD);
		
		Customer a3=new Customer(36,"Rohit", "Sharma", "rohit@gmail.com","rohit", 5000, 
				LocalDate.parse("2000-11-10"), ServicePlans.DIAMOND);
		
		Customer a4=new Customer(84,"Ravindra", "Jadeja", "Ravindra@gmail.com","Ravindra", 10000, 
				LocalDate.parse("2024-06-09"), ServicePlans.PLATINUM);
		
		Customer a5=new Customer(07,"Ms", "Dhoni", "Ms@gmail.com","MS", 10000, 
				LocalDate.parse("2024-06-09"), ServicePlans.PLATINUM);
		
		Customer a6=new Customer(10,"Shreyas", "Iyer", "Shreyas@gmail.com","Shreyas", 10000, 
				LocalDate.parse("2024-06-09"), ServicePlans.PLATINUM);
		
		Customer[] customer = {a1,a2,a3,a4,a5,a6};
		
		Map<Integer,Customer> customerlist = new HashMap<>();
		
		for(Customer c : customer) {
			System.out.println(customerlist.put(c.getCustomerid(), c));
		}
		
		return customerlist;
		
	}
	
}
