package com.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

public class My2DArrayTest {
	
	@Test
	public void testMatrixReshape() {
		int[][] nums = {{1, 2}, {3, 4}};
		int[][] reshapedNums = My2DArray.matrixReshape(nums, 1, 4);
		int[][] expect = {{1, 2, 3, 4}};
		assertTrue(Arrays.deepEquals(reshapedNums, expect));
	}
	
	public void testSearchMatrixII() {
		int[][] matrix = {{1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}};
		assertTrue(My2DArray.searchMatrix(matrix, 5));
	}
}
