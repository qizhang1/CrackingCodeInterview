package com.leetcode;

import java.math.BigInteger;

public class MyUtility {


	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}
	
	public static BigInteger factoria(int n) {
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
	
	/*
	 * display matrix
	 */
	public static void displayMatrix(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		// print column index
		System.out.print("      ");
		for (int i = 0; i < c; i++) {
			System.out.format("[%2d]", i);
		}
		System.out.println();

		// print row index and value list
		for (int i = 0; i < r; i++) {
			System.out.format("[%3d] ", i);
			for (int j = 0; j < c; j++) {
				System.out.format("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/*
	 * display array
	 */
	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
}
