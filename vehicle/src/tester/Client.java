package tester;

import java.util.Scanner;

import custom_exception.SpeedOutOfBounds;

import static utils.VehicleValidationRules.validateSpeed;

import utils.VehicleValidationRules;

public class Client {

	public static void main(String[] args) {
			Scanner in=new Scanner (System.in);
			try {
				System.out.println("Enter the speed ");
				validateSpeed(in.nextInt());
				System.out.println("End of try----");
			} 
			catch (Exception e) {
	
				System.out.println(e.getMessage());
			}
			
			System.out.println("End of main---- ");
			in.close();
	}

}
