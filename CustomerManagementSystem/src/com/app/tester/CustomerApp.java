package com.app.tester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static com.app.utils.CustomerUtility.populatedCustomer;

import com.app.custom_ordering.CustomerDobAndNameComparator;
import com.app.customer.Customer;
import com.app.utils.CustomerUtility;
import com.app.utils.CustomerValidation;

import static com.app.utils.CustomerValidation.validateInput;

public class CustomerApp {

	public static void main(String[] args) {
			try(Scanner sc=new Scanner(System.in)){
				boolean exit =false;
				List<Customer> customerlist= populatedCustomer();
				int counter =0;
				while(!exit) {
					System.out.println("Options :\n"+"0.Exit\n"+"1.Accept the Customer\n"+"2.Display the Customers\n"
							+"3.SignIn\n"+"4.change password\n"+"5.Unsuscribed user\n"
							+"6.Sorting of Customer using email\n"+"7.Sorting of customer on dob and lastname\n"
							+"8.Delete customer after a specified date");
					System.out.println("Enter Choice");
					try {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("firstname "+"lastname "+"email "+"password "
									+"registrationammount "+"dateofbirth "+"plans ");
							Customer customer= CustomerValidation.validateInput(sc.next(), sc.next(), sc.next(), sc.next()
									    , sc.nextDouble(), sc.next(), 
										sc.next(), customerlist);
							customerlist.add(customer);
							break;
							
						case 2:
							for (Customer c: customerlist) {
								System.out.println(c);
							}
							break;
							
						case 3://Authenticate user
							System.out.println("Enter your email and password  ");
							customer = CustomerValidation.checkEmailAndPassword(sc.next(),sc.next(),customerlist);
							System.out.println(customer.toString());
							break;
							
						case 4://change password
							System.out.println("Enter your old email and old password  ");
							customer = CustomerValidation.checkEmailAndPassword(sc.next(),sc.next(),customerlist);
							System.out.println("Enter your New password  ");
							customer.setPassword(sc.next());
							System.out.println("Password change succesfully");
							break;
							
							
						case 5://unsuscribed delete customer
							System.out.println("Enter your email ");
							customer=CustomerValidation.unsuscriberUser(sc.next(),customerlist);
							System.out.println("this user is successfully deleted\n"+customer);
							break;
							
						case 6://sorting using natural ordering PK email
							Collections.sort(customerlist);
							break;
							
						case 7://sorting using custom ordering dob and last name
							Collections.sort(customerlist,new CustomerDobAndNameComparator());
							break;
													
						case 8://remove of customer after a specified date 
							System.out.println("Enter the date in yyyy-mm-dd and Service plan");
							CustomerUtility.removeUser(sc.next(),sc.next(),customerlist);
							break;
							
						case 0:
							System.out.println("MAIN OVER......");
							exit=true;
							break;
						}
						
					}catch (Exception e) {
						System.out.println(e.getMessage());
						sc.nextLine();//for token mismatch avoidence
					}
				}
			}
	}

}
