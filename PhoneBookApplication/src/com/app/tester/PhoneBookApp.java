package com.app.tester;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static  com.app.phonebookvalidation.PhoneBookValidation.validateInputs;

import com.app.phonebook.PhoneBook;

public class PhoneBookApp {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			Set<PhoneBook> phonebooklist=new HashSet<>();
			while(!exit) {
				System.out.println();
				System.out.println("-----Options-----\n"+"0.Exit\n"+"1.Accept details for phone book\n"
						+"2.Display phone book list\n");
				System.out.print("Enter choice ");
				try {
					switch (sc.nextInt()) {
					
					case 0:
						System.out.println("MAIN OVER......");
						exit=true;
						break;

					case 1:
						System.out.println("Enter your details\n"+"your phonenumber\t name\t your birthdate\t Email ");
						PhoneBook phonebook = validateInputs(sc.next(),sc.next(),sc.next(),sc.next()
								,phonebooklist);
						phonebooklist.add(phonebook);
						break;
						
					case 2:
						for (PhoneBook p : phonebooklist) {
							System.out.println(p);
						}
						break;
						
					}
					
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}

	}

}
