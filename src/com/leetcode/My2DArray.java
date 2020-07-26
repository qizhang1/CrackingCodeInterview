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

}
