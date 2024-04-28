package Fruit;

import java.util.Scanner;

public class fruitUtility {
	
	private static int counter;
	
	static {
		counter=0;
	}

	public static void acceptFruits(fruit []arr) {
		Scanner in=new Scanner(System.in);
		if (counter!=arr.length) {
			for(;counter<arr.length;counter++) {
				System.out.println("Which fruits you want to add in your Basket ");
				System.out.println("1.For Apple\n2.For mango\n3.For orange\n4.For exit ");
				System.out.println();
				System.out.print("Enter the fruit number ");
				int choice=in.nextInt();
				System.out.println();
				fruitNames name;
				switch(choice) {
				case 1:
					name=fruitNames.APPLE;
					String fruitcolor="RED";
					System.out.println();
					boolean fresh=isFruitStale();
					if(fresh!=false)
						arr[counter]=new apple(name,fruitcolor,fresh);
					else
						counter--;
					break;
				
				case 2:
					name=fruitNames.MANGO;
					String fruitcolor1="GREEN";
					boolean fresh1=isFruitStale();
					if(fresh1!=false)
						arr[counter]=new mango(name,fruitcolor1,fresh1);
					else
						counter--;
					break;
				case 3:
					name=fruitNames.ORANGE;
					String fruitcolor2="YELLOW";
					boolean fresh2=isFruitStale();
					if(fresh2!=false)
						arr[counter]=new orange(name,fruitcolor2,fresh2);
					else
						counter--;
					break;
				default :
					return;
				}
			}
		}
		else
			System.out.println("Your basket is full ");
	}

	public static void callOverridenMethod(fruit []arr) {
		System.out.println("calling of overriden method ");
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=null)
				arr[i].taste();
			else
				return;
		}
	}

	public static void callSpecialMethod(fruit []arr) {
		System.out.println("calling of special method ");
		for (int i=0;i<arr.length;i++) {
			if (arr[i] instanceof apple) {
				((apple)arr[i]).jam();
			}
			if (arr[i] instanceof mango) {
				((mango)arr[i]).pulp();
			}
			if (arr[i] instanceof orange) {
				((orange)arr[i]).juice();
			}
		}
	}

	public static void displayFruit(fruit []arr) {
		for (int i=0;i<arr.length;i++) {
			if (arr[i]!=null) 
				System.out.println(arr[i].toString());
			else
				return;
		}
	}

	public static boolean isFruitStale() {
		Scanner in=new Scanner (System.in);
		boolean isfresh = true;
		System.out.print("1.Is fruit fresh\n2.Is fruit stale ");
		System.out.println();
		System.out.print("Enter the fruit number ");
		switch(in.nextInt()) {
		case 1:
			System.out.println();
			System.out.println("Fruit is added in your basket ");
			isfresh=true;
			break;
			
		case 2:
			System.out.println();
			System.out.println("Fruit is not added in your basket ");
			isfresh=false;
			break;
		}
		System.out.println();
		return isfresh;
		
	}
	
}
