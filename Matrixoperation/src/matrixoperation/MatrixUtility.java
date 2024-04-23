package matrixoperation;

import java.util.Scanner;

public class MatrixUtility {
	
	public static int[][] AcceptArray(int [][]arr) {
		Scanner in=new Scanner (System.in);
		System.out.println("Enter the array");
		for (int row=0;row<arr.length;row++) {
			for (int col=0;col<arr[row].length;col++) {
				arr[row][col]=in.nextInt();
			}
		}
		return arr;
	}
	
	public static void DisplayArray(int [][]arr) {
		for (int row=0;row<arr.length;row++) {
			for (int col=0;col<arr[row].length;col++) {
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] AdditionOFArray(int [][]arr,int [][]arr1,int rows,int coloumn) {
		int [][]array1=new int[rows][coloumn];
		for (int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[row].length;col++) {
				array1[row][col]=arr[row][col]+arr1[row][col];
			}
		}
		return array1;
	}
	
	public static int[][] SubtractionOFArray(int [][]arr,int [][]arr2,int rows,int coloumn) {
		int [][]array2=new int[rows][coloumn];
		for (int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[row].length;col++) {
				array2[row][col]=arr[row][col]-arr2[row][col];
			}
		}
		return array2;
	}
	
	public static int[][] MultiplicationOFArray(int [][]arr,int [][]arr3,int rows,int coloumn) {
		int [][]array3=new int[rows][coloumn];
		for (int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[row].length;col++) {
				array3[row][col]=arr[row][col]*arr3[row][col];
			}
		}
		return array3;
	}
	
	public static int[][] TransposeOfArray(int[][]arr,int rows,int coloumn){
		int [][]transpose=new int[rows][coloumn];
		for (int row=0;row<arr.length;row++) {
			for (int col=0;col<arr[row].length;col++) {
				transpose[col][row]=arr[row][col];
			}
		}
		return transpose;
	}

	public static void SymmetricOfArray(int [][]arr,int [][]transpose) {
		boolean flag=true;
		for (int row=0;row<arr.length;row++) {
			for (int col=0;col<arr[row].length;col++) {
				if(arr[row][col]!=transpose[row][col]) {
					flag=false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("Matrix is symmetric");
		}
		else {
			System.out.println("Matrix is not symmetric");
		}
	}
	
}