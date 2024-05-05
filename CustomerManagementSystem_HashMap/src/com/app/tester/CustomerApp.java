package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.customer_hashmap.Customer;
import com.app.customordering_hashmap.CustomerDobAndNameComparator;

import static com.app.utility.CustomerValidation.*;

import static com.app.utility.CustomerUtility.populatedCustomer;

public class CustomerApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
		
			boolean exit = false;
			Map<Integer,Customer> customerlist = populatedCustomer();
			
			while(!exit) {
				System.out.println("Options :\n"+"0.Exit\n"+"1.Accept the Customer\n"+"2.Display the Customers\n"
						+"3.Search on customer number\n"+"4.Remove acoount\n"
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
						
						// cannot iterate Map (So For converting Map into Collection we are using values method)
						//it returns values in Map
						for(Customer c : customerlist.values())
							System.out.println(c);
						break;
						
					case 3://search by custno
						System.out.println("Enter customer no");
						Customer cust = searchByCustNo(sc.nextInt(),customerlist);
						System.out.println(cust);
						break;
						
					case 4://remove account on customer id
						System.out.println("Enter customer no");
						System.out.println(removeAcct(sc.nextInt(),customerlist));
						break;
						
						
					case 5://sorting of Map in ascending on customer id natural ordering (using Tree Map)
						TreeMap<Integer,Customer> sortedlist=new TreeMap<>(customerlist);
						//Map cannot iterable but Collection can so we use values method 
						//values method covert map into collection view
						for(Customer c : sortedlist.values())
							System.out.println(c);
						break;
						
					case 6://sort using dob and name (custom oredering)
						ArrayList<Customer> custlist=new ArrayList<>(customerlist.values());
						Collections.sort(custlist,new CustomerDobAndNameComparator());
						for(Customer c: custlist)
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
