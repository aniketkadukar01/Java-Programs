package com.bankaccountmanagementsystem;

import java.util.Scanner;

public class BankUtility {
	
	private static int counter;
	
	static {
		counter=0;
	}
	
	public static void AcceptNewUser(BankAccount []arr) {
		Scanner in=new Scanner(System.in);
		for (;counter<arr.length;counter++) {
			if (counter>=1) {
				System.out.println("You want to add account ");
				System.out.println("1.YES\t2.NO ");
				if(in.nextInt()==2) 
					return;
			}
			System.out.println();
			System.out.print("Enter Account Number ");
			int accountNumber=in.nextInt();
			System.out.print("Enter Account Holder Name ");
			String accountHolderName=in.next();
			System.out.print("Enter Account Holder Balance ");
			double balance=in.nextDouble();
			arr[counter]=new BankAccount(accountNumber,accountHolderName,balance);
		}
	}
	
	public static void DisplayUser(BankAccount []arr) {
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=null)
				System.out.println(arr[i].toString());
			else
				return;
		}
	}

	public static void DipositeMoney(BankAccount []arr) {
		System.out.println("Enter Account Number");
		Scanner in=new Scanner(System.in);
		int accountNumber=in.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				if (arr[i].getAccountNumber()==accountNumber) {
					System.out.println("Enter the amount");
					double depositeAmmount=in.nextDouble();
					arr[i].setBalance(arr[i].getBalance()+depositeAmmount);
					break;
				}
			}
			else {
				System.out.println("Invalid account number ");
				return;
			}
		}
	}

	public static void withdrawMoney(BankAccount []arr) {
		System.out.println("Enter Account Number");
		Scanner in=new Scanner(System.in);
		int accountnumber=in.nextInt();
		for(int i=0;i<arr.length;i++) {
			if (arr[i]!=null) {
				if(arr[i].getAccountNumber()==accountnumber) {
					System.out.println("Enter withdraw ammount ");
					double withdrawAmmount=in.nextDouble();
					if (arr[i].getBalance()<withdrawAmmount) {
						System.out.println("Withdraw Ammount is greater than "
								+ "Account Balance ");
						break;
					}
					else {
						arr[i].setBalance(arr[i].getBalance()-withdrawAmmount);
						System.out.println("Ammount has been Withdrawn ");	
					}
				}
				else
					System.out.println("Invalid account number ");
			}
			else
				return;
		}
	}

	public static void accountBalance(BankAccount []arr) {
		System.out.println("Enter Account Number");
		Scanner in=new Scanner(System.in);
		int accountNumber=in.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				if (arr[i].getAccountNumber()==accountNumber) {
					System.out.println("Balance of your account is "+arr[i].getBalance());
				}
			}
			else
				return;
		}
	}

}
