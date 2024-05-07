package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.customer_hashmap.Customer;
import com.app.customordering_hashmap.CustomerDobAndNameComparator;

import static com.app.utility.CustomerValidation.*;

import static com.app.utility.CustomerUtility.*;

public class CustomerApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
		
			boolean exit = false;
			List<Customer> custlist = populatedCustomer();
			Map<Integer,Customer> customerlist =  populatedProductMap(custlist);
			while(!exit) {
				System.out.println("Options :\n"+"0.Exit\n"+"1.Accept the Customer\n"+"2.Display the Customers\n"
						+"3.Search on customer number\n"+"4.Remove account\n"
						+"5.Display Customer Sort by customer id\n"+"6.Sort by dob and name\n");
				System.out.println("Enter Choice");
				try {
					
					switch(sc.nextInt()) {
					case 0:
						System.out.println("MAIN OVER......");
						exit=true;
						break;
						
					case 1://Input
						System.out.println("Customerid"+"firstname "+"lastname "+"email "+"password "
								+"registrationammount "+"dateofbirth "+"plans ");
						Customer customer= validateInput(sc.nextInt(),sc.next(), sc.next(), sc.next(), sc.next()
							    , sc.nextDouble(), sc.next(), 
								sc.next(), customerlist);
						customerlist.put(customer.getCustomerid(), customer);
						System.out.println("A/c created !");
						break;
						
					case 2://Display the customer (using Hash Map values method)
						System.out.println("All Customer details -");
						customerlist.forEach((k,v) -> System.out.println(v));
						break;
						
					case 3://search by customer no
						System.out.println("Enter customer no");
						customer = searchByCustNo(sc.nextInt(),customerlist);
						System.out.println(customer);
						break;
						
					case 4://remove account on customer id
						System.out.println("Enter customer no");
						System.out.println(removeAcct(sc.nextInt(),customerlist));
						break;
						
						
					case 5://sorting of Map in ascending on customer id natural ordering (using Tree Map)
//						TreeMap<Integer,Customer> sortedlist=new TreeMap<>(customerlist);
						sortByCustomerID(customerlist);
//						for(Customer c : sortedlist.values())
//							System.out.println(c);
						break;
						
					case 6://sort using dob and name (custom oredering)
						ArrayList<Customer> custlist1=new ArrayList<>(customerlist.values());
						Collections.sort(custlist1,new CustomerDobAndNameComparator());
						for(Customer c: custlist1)
							System.out.println(c);
						break;
						
					}
					
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println(e.getMessage());
				}
				
			}
			
		}

	}

}
