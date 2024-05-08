package com.app.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.customer_hashmap.ServicePlans;
import com.app.customer_hashmap.Customer;

public class CustomerUtility {

	public static List<Customer> populatedCustomer(){

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

		List<Customer> customerlist = new ArrayList<>();


		for(Customer c : customer) {
			System.out.println(customerlist.add(c));
		}

		return customerlist;

	}

	public static Map<Integer,Customer> populatedProductMap(List<Customer> customerlist){
		Map<Integer,Customer> cutomerMap =new HashMap<>();

		customerlist.forEach(c -> cutomerMap.put(c.getCustomerid(), c));
		return cutomerMap;

	}

	//add a static method for storing student details , in a bin file using ser.
	public static void writeDetails(Map<Integer,Customer> customer, String fileName) throws IOException {
		// Java App --> OOS --> FOS (bin file)
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(customer);// serialization
		} // JVM : out.close --fos.close --close the file handle
	}

	@SuppressWarnings("unchecked")
	public static Map<Integer, Customer> readDetails(String fileName) throws IOException, ClassNotFoundException {
		// Java App <--- OIS <--- FIS (bin file)
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<Integer, Customer>) in.readObject();
		}
	}

}
