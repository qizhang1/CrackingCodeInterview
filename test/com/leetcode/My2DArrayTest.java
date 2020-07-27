package com.leetcode;

import java.util.Arrays;

import junit.framework.TestCase;

public class My2DArrayTest extends TestCase {
	
	public void testMatrixReshape() {
		int[][] nums = {{1, 2}, {3, 4}};
		int[][] reshapedNums = My2DArray.matrixReshape(nums, 1, 4);
		int[][] expect = {{1, 2, 3, 4}};
		assertTrue(Arrays.deepEquals(reshapedNums, expect));
	}
}
