package com.devices;

import java.util.Scanner;

public class DeviceUtility {
	
	public static void AcceptDevice(Device []arr) {
		Scanner in=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("1.for Mobile\n2.for Refrigirator ");
			System.out.println("Enter the choice ");
			int choice=in.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter mobileid ");
					int mobileid=in.nextInt();
					System.out.println("Enter brandname ");
					String Brandname=in.next();
					System.out.println("Enter processor ");
					String processor=in.next();
					arr[i]=new Mobile(mobileid,Brandname,processor);
					break;
				
				case 2:
					System.out.println("Enter refrigiratorid ");
					int refrigiratorid=in.nextInt();
					System.out.println("Enter brandname ");
					String brandname=in.next();
					System.out.println("Enter capacity ");
					int capacity=in.nextInt();
					arr[i]=new Refrigirator(refrigiratorid,brandname,capacity);
					break;
				
				default:
					break;
			}
		}
	}

	public static void DisplayOverridenMethod(Device []arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i].on();
			arr[i].off();
			System.out.println(arr[i].toString());
		}
	}
	
	public static void DisplaySpecialMethod(Device []arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] instanceof Mobile) {
				((Mobile)arr[i]).log();
				((Mobile)arr[i]).runapp();
				((Mobile)arr[i]).monitor();
				((Mobile)arr[i]).print();
			}
			
			if(arr[i] instanceof Refrigirator) {
				((Refrigirator)arr[i]).freeze();
			}
		}
	}
}
