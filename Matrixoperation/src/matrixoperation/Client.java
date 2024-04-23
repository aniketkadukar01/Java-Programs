package matrixoperation;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the rows and coloumn");
		int rows=in.nextInt();
		int col=in.nextInt();
		int [][]arr=new int[rows][col];
		
		
		while(true) {
			System.out.println("-------Menu-------");
			System.out.println("1. for Accept the array ");
			System.out.println("2. for display the array ");
			System.out.println("3. for addition of array and Display ");
			System.out.println("4. for substraction of array and display ");
			System.out.println("5. for multiplacation of array ");
			System.out.println("6. for transpose of array ");
			System.out.println("7. for symmetric of array ");
			System.out.println("------Other than 1 and 7 is for exit------");
			System.out.println("Enter your choice ");
			int choice=in.nextInt();
			switch(choice) {
			
				case 1:
					MatrixUtility.AcceptArray(arr);
					break;
					
				case 2:
					MatrixUtility.DisplayArray(arr);
					break;
					
				case 3:
					System.out.println("Enter the another for add onto the first one ");
					int [][]arr1=new int[rows][col];
					int [][]array1=new int[rows][col];
					arr1=MatrixUtility.AcceptArray(arr1);
					array1=MatrixUtility.AdditionOFArray(arr, arr1, rows, col);
					MatrixUtility.DisplayArray(array1);
					break;
					
				case 4:
					System.out.println("Enter the another for substract onto the first one ");
					int [][]arr2=new int[rows][col];
					int [][]array2=new int[rows][col];
					arr2=MatrixUtility.AcceptArray(arr2);
					array2=MatrixUtility.SubtractionOFArray(arr, arr2, rows, col);
					MatrixUtility.DisplayArray(array2);
					break;
					
				case 5:
					System.out.println("Enter the another for multiplication onto the first one ");
					int [][]arr3=new int[rows][col];
					int [][]array3=new int[rows][col];
					arr3=MatrixUtility.AcceptArray(arr3);
					array3=MatrixUtility.MultiplicationOFArray(arr, arr3, rows, col);
					MatrixUtility.DisplayArray(array3);
					break;
					
				case 6:
					System.out.println("Enter the another for Transpose ");
					int [][]arr4=new int[rows][col];
					int [][]array4=new int[rows][col];
					arr4=MatrixUtility.AcceptArray(arr4);
					array4=MatrixUtility.TransposeOfArray(arr4, rows, col);
					MatrixUtility.DisplayArray(array4);
					break;
					
				case 7:
					System.out.println("Enter the another array for symmetric check ");
					int [][]arr5=new int[rows][col];
					int [][]array5=new int[rows][col];
					arr5=MatrixUtility.AcceptArray(arr5);
					array5=MatrixUtility.TransposeOfArray(arr5, rows, col);
					MatrixUtility.SymmetricOfArray(arr, array5);
					break;
					
				default :
					return;
			}
			
		}
		
	}

}
