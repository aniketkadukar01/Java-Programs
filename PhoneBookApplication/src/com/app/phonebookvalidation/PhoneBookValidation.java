package com.app.phonebookvalidation;

import java.time.LocalDate;
import java.util.Set;

import com.app.phonebook.PhoneBook;
import com.app.phonebookexception.PhoneBookException;

public class PhoneBookValidation {

	// validate inputs
	public static PhoneBook validateInputs(String phonenumber,String name,String dob,String email
			,Set<PhoneBook> phonebooklist) throws PhoneBookException {
		LocalDate birthdate=LocalDate.parse(dob);
		checkForDuplicateNameAndDob(name,birthdate,phonebooklist);
		return new PhoneBook(checkPhoneNumber(phonenumber), name, birthdate, emailVerification(email));
	}
	
	//validate email of Phonebook
	public static String emailVerification(String email) throws PhoneBookException {
		String regex="^(?=.*[a-z])(?=.*@gmail\\.com)[^A-Z]{2,32}$";
		if(!email.matches(regex))
			throw new PhoneBookException("Invalid Email");
		
		return email;
	}
	
	
	//validate name and date of birth
	public static void checkForDuplicateNameAndDob(String name,LocalDate birthdatedate
			,Set<PhoneBook> phoneboklist) throws PhoneBookException {
		PhoneBook phonebook=new PhoneBook(name, birthdatedate);
		if(phoneboklist.contains(phonebook))
			throw new PhoneBookException("Duplicate name or date of birthdate ");
	}
	
	
	//validate phone number
	public static String checkPhoneNumber(String phonenumber) throws PhoneBookException {
		String regex="^\\d{10}$";
		if(!phonenumber.matches(regex))
			throw new PhoneBookException("Phone number is not valid ");
		
		return phonenumber;
	}
	
}
