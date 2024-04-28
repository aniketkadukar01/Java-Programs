package Fruit;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("How many Fruits you want add in your Basket ");
		int number=in.nextInt();
		fruit []arr=new fruit[number];
		System.out.println();
		
		fruitUtility.acceptFruits(arr);
		while(true) {
			System.out.println();
			System.out.println("-------MENU-------");
			System.out.println();
			System.out.println("1.for add the fruits ");
			System.out.println("2.for display the fruits ");
			System.out.println("3.for display overriden method of fruits ");
			System.out.println("4.for display special method of fruits ");
			System.out.println("5.exit ");
			System.out.println();
			System.out.println("-------------------");
			System.out.print("Enter your choice ");
			int choice = in.nextInt();
			System.out.println();
			switch(choice) {
			
			case 1:		
				fruitUtility.acceptFruits(arr);
				break;
				
			case 2:
				fruitUtility.displayFruit(arr);
				break;
				
			case 3:
				fruitUtility.callOverridenMethod(arr);
				break;
				
			case 4:
				fruitUtility.callSpecialMethod(arr);
				break;
				
			default:
				return;
			
			}

		}
	}
	

}
