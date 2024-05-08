package com.app.tester;

import static com.app.utility.CustomerUtility.*;
import static com.app.utility.CustomerUtility.populatedProductMap;
import static com.app.utility.CustomerValidation.removeAcct;
import static com.app.utility.CustomerValidation.reverseSortByCustomerID;
import static com.app.utility.CustomerValidation.reverseSortByDobAndName;
import static com.app.utility.CustomerValidation.searchByCustNo;
import static com.app.utility.CustomerValidation.sortByCustomerID;
import static com.app.utility.CustomerValidation.sortByDobAndName;
import static com.app.utility.CustomerValidation.validateInput;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.customer_hashmap.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {

			boolean exit = false;
			List<Customer> custlist = populatedCustomer();
			Map<Integer,Customer> customerlist =  populatedProductMap(custlist);
			while(!exit) {
				System.out.println();
				System.out.println("Options :\n"+"0.Exit\n"+"1.Accept the Customer\n"+"2.Display the Customers\n"
						+"3.Search on customer number\n"+"4.Remove account\n"
						+"5.Sort by customer id\n"+"6.Reversed Sort by customer id\n"+"7.Sort by dob and name\n"
						+"8.Reversed Sort by dob and name\n"+"9.Write Customer details in file\n"
						+"10.Read Customer details into the file\n");
				System.out.print("Enter Choice ");
				try {

					switch(sc.nextInt()) {
					case 0:
						System.out.println("MAIN OVER......");
						exit=true;
						break;

					case 1://Input
						System.out.println("Customerid "+"firstname "+"lastname "+"email "+"password "
								+"registrationammount "+"dateofbirth "+"plans ");
						Customer customer= validateInput(sc.nextInt(),sc.next(), sc.next(), sc.next(), sc.next()
								, sc.nextDouble(), sc.next(), 
								sc.next(), customerlist);
						customerlist.put(customer.getCustomerid(), customer);
						System.out.println("A/c created !");
						break;

					case 2://Display the customer (using Hash Map values method)
						System.out.println("All Customer details - ");
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
						sortByCustomerID(customerlist);
						break;
						
					case 6://sorting of Map in descending on customer id natural ordering (using Tree Map)
						reverseSortByCustomerID(customerlist);
						break;

					case 7://sort of map in ascending using dob and name (custom ordering)
						sortByDobAndName(customerlist);
						break;
						
					case 8://sort of map in descending using dob and name (custom ordering)
						reverseSortByDobAndName(customerlist);
						break;
						
					case 9://Write Customer details in file
						System.out.println("Enter the filename");
						writeDetails(customerlist,sc.next());
						break;
						
//					case 10:
//						System.out.println("Enter the filename");
//						Map<Integer,Customer> cust =readDetails(sc.next());
//						cust.forEach((k,v) -> System.out.println(v));
//						break;

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
