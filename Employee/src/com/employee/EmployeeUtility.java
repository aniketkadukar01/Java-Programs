package com.employee;

import java.util.Scanner;

public class EmployeeUtility {
	
	public static void AcceptEmployee(Employee []arr) {
		Scanner in=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter the empolyee id ");
			int empid=in.nextInt();
			System.out.println("Enter the empolyee name ");
			String name=in.next();
			System.out.println("Enter the empolyee salary ");
			double salary=in.nextDouble();
			System.out.println("1. for SoftwareEngg 2. for Consultant 3. for SenoirConsultant");
			int Codes=in.nextInt();
			DesignationCodes dcode=null;
			switch(Codes) {
				case 1:
					dcode=DesignationCodes.SOFTWAREENGG;
					break;
				case 2:
					dcode=DesignationCodes.CONSULTANT;
					break;
				case 3:
					dcode=DesignationCodes.SENIORCONSULTANT;
					break;
					
			}
			arr[i]=new Employee(empid,name,salary,dcode);
		}
	}
	
	public static void DisplayEmp(Employee []arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static Employee MaxSalary(Employee []arr) {
		Employee maxsalary=arr[0];
		for (int i=1;i<arr.length;i++) {
			if(arr[i].getSalary()>maxsalary.getSalary()) {
				maxsalary=arr[i];
			}
		}
		return maxsalary;
	}
	
}
