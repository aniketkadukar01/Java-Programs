package com.devices;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number how many no of devices you want to store ");
		int number=in.nextInt();
		Device []device=new Device[number];
		while(true) {
			System.out.println("------Menu-------");
			System.out.println("1. for Accept Device ");
			System.out.println("2. Display Overriden method ");
			System.out.println("3. Display Special method of classes ");
			System.out.println("Any number other than 1 and 3 is for exit ");
			System.out.println("Enter your choice ");
			int choice=in.nextInt();
			switch(choice) {
				case 1:
					DeviceUtility.AcceptDevice(device);
					break;
				
				case 2:
					DeviceUtility.DisplayOverridenMethod(device);
					break;
				
				case 3:
					DeviceUtility.DisplaySpecialMethod(device);
					break;
					
				default :
					return;
			}
		}
		
	}

}
