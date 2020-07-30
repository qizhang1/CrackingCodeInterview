package com.leetcode;

public class My2DArray {
	
	// LC-566. Reshape the Matrix
	// Reshape a matrix into a new one filled with all the elements of the original matrix 
	// in the same row-traversing order as they were.
	// Time O(m*n) Space O(m*n)
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int numsR = nums.length;
        int numsC = nums[0].length;
        // 'reshape' operation with given parameters is impossible,
        // return the original matrix.
        if (numsR * numsC != r*c) { 
            return nums;
        }
        
        int[][] reshapedNums = new int[r][c];
        int m = 0, n = 0;
        for (int i = 0; i < numsR; i++)  { // traverse origin matrix's row 
            for ( int j = 0; j < numsC; j++) {
                reshapedNums[m][n] = nums [i][j];
                n++; 
                // set m, n to the start of next row if n reaches end of the row
                if (n == c) {
                    m++;
                    n = 0; 
                }
            }
        }
        return reshapedNums;
	}
	
	// LC-240. Search a 2D Matrix II
	//Searches for a value in an m x n matrix.
    // Integers in each row and column are sorted in ascending from left to right.
	// Time O(m+n) Space O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // start with top, right corner number
        int r = 0;
        int c = matrix[0].length - 1;
        
        while (r < matrix.length && c >= 0) {
            int num = matrix[r][c];
            if (num == target) {
                return true;
            } else if (num > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
    
    // LC-766. Toeplitz Matrix
    // A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
    // Given an M x N matrix, return True if and only if the matrix is Toeplitz.
    // Time O(m*n), Space O(1)
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j <matrix[0].length; j++ ) {
                
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
