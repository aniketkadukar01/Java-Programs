package com.employee;

import java.util.Scanner;

final class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size=in.nextInt();
		Employee []arr=new Employee[size];
		EmployeeUtility.AcceptEmployee(arr);
		EmployeeUtility.DisplayEmp(arr);
		Employee maxsalary=EmployeeUtility.MaxSalary(arr);
		System.out.println("the employee having maximum salary is");
		System.out.println(maxsalary);
		
	}

}
