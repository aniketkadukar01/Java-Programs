package com.bankaccountmanagementsystem;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		System.out.println("how many Account you want to open in your bank");
		int accounts=in.nextInt();
		BankAccount []arr=new BankAccount[accounts];
		while(true) {
			System.out.println();
			System.out.println("-----MEUN-----");
			System.out.println("1.Create a new account ");
			System.out.println("2.Showing your account ");
			System.out.println("3.Deposite money in your account ");
			System.out.println("4.Withdraw money in your account ");
			System.out.println("5.Showing your account balance ");
			System.out.println("----------");
			System.out.println();
			System.out.print("Enter the number ");
			switch(in.nextInt()) {
			case 1:
				BankUtility.AcceptNewUser(arr);
				break;
			case 2:
				BankUtility.DisplayUser(arr);
				break;
			case 3:
				BankUtility.DipositeMoney(arr);
				break;
			case 4:
				BankUtility.withdrawMoney(arr);
				break;
			case 5:
				BankUtility.accountBalance(arr);
				break;
			default :
				return;
			}
		}

	}

}
