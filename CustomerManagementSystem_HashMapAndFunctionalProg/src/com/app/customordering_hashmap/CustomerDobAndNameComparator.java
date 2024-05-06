package com.app.customordering_hashmap;

import java.util.Comparator;

import com.app.customer_hashmap.Customer;

public class CustomerDobAndNameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1,Customer c2) {
		int retval=c1.getDob().compareTo(c2.getDob());
		if(retval == 0)
			return c1.getLastname().compareTo(c2.getLastname());
		
		return retval;
	}
	
}
