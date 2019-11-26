package com.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.*;

import junit.framework.TestCase;

public class MyArrayTest extends TestCase {

	public void testTwoSum1() {
		int[] arr = new int[] { 3, 2, 4 };
		int index[] = MyArray.twoSum1(arr, 6);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, index));
	}

	public void testTwoSum2() {
		int[] arr = new int[] { 2, 0, 2, 11, 15 };
		int index[] = MyArray.twoSum1(arr, 4);
		assertTrue(Arrays.equals(new int[] { 0, 2 }, index));
	}

	public void testTwoSum3() {
		int[] arr = new int[] { 2, 3, 4 };
		int index[] = MyArray.twoSum2(arr, 7);
		assertTrue(Arrays.equals(new int[] { 1, 2 }, index));
	}

	public void testTwoSum4() {
		int[] arr = new int[] { 2, 7, 11, 15 };
		int index[] = MyArray.twoSum2(arr, 22);
		assertTrue(Arrays.equals(new int[] { 1, 3 }, index));
	}

	public void testThreeSum1() {
		int[] arr = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = MyArray.threeSum(arr);
		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		expect.add(Arrays.asList(-1, -1, 2));
		expect.add(Arrays.asList(-1, 0, 1));
		assertEquals(result, expect);
	}

	public void testThreeSum2() {
		int[] arr = new int[] { -2, 0, 1, 1, 2 };
		List<List<Integer>> result = MyArray.threeSum(arr);
		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		expect.add(Arrays.asList(-2, 0, 2));
		expect.add(Arrays.asList(-2, 1, 1));
		assertEquals(result, expect);
	}

	public void testThreeSum3() {
		int[] arr = new int[] { 0, 0, 0 };
		List<List<Integer>> result = MyArray.threeSum(arr);
		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		expect.add(Arrays.asList(0, 0, 0));
		assertEquals(result, expect);
	}

	public void testFindMaxOccurance1() {
		int[] arr = new int[] {};
		int max = MyArray.findMaxOccurance(arr);
		assertEquals(max, 0);
	}

	public void testFindMaxOccurance2() {
		int[] arr = new int[] { 1 };
		int max = MyArray.findMaxOccurance(arr);
		assertEquals(max, 1);
	}

	public void testFindMaxOccurance3() {
		int[] arr = new int[] { 1, 2, 2, 3, 4, 5, 5, 5 };
		int max = MyArray.findMaxOccurance(arr);
		assertEquals(max, 3);
	}

	public void testRemoveDuplicates2_1() {
		int[] arr = new int[] { 1, 1 };
		int max = MyArray.removeDuplicates2(arr);
		assertTrue(Arrays.equals(new int[] { 1, 1 }, arr));
		assertEquals(max, 2);
	}

	public void testRemoveDuplicates2_2() {
		int[] arr = new int[] {};
		int max = MyArray.removeDuplicates2(arr);
		assertTrue(Arrays.equals(new int[] {}, arr));
		assertEquals(max, 0);
	}

	public void testRemoveDuplicates2_3() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3 };
		int max = MyArray.removeDuplicates2(arr);
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 2, 3, 3 }, arr));
		assertEquals(max, 5);
	}

	public void testRemoveDuplicates1_1() {
		int[] arr = new int[] { 1 };
		int max = MyArray.removeDuplicates1(arr);
		assertTrue(Arrays.equals(new int[] { 1 }, arr));
		assertEquals(max, 1);
	}

	public void testRemoveDuplicates1_2() {
		int[] arr = new int[] {};
		int max = MyArray.removeDuplicates1(arr);
		assertTrue(Arrays.equals(new int[] {}, arr));
		assertEquals(max, 0);
	}

	public void testRemoveDuplicates1_3() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3 };
		int max = MyArray.removeDuplicates1(arr);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 2, 2, 3 }, arr));
		assertEquals(max, 3);
	}

	public void testRemoveElement1() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3 };
		int len = MyArray.removeElement(arr, 1);
		assertTrue(Arrays.equals(new int[] { 2, 2, 3, 2, 2, 3 }, arr));
		assertEquals(len, 3);
	}

	public void testRemoveElement2() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3, 3, 3 };
		int len = MyArray.removeElement(arr, 2);
		assertTrue(Arrays.equals(new int[] { 1, 1, 1, 3, 3, 3, 3, 3 }, arr));
		assertEquals(len, 6);
	}

	public void testMergeTwoArrays() {
		int[] arr1 = new int[] { 1, 3, 5, 0, 0, 0, 0, 0 };
		int[] arr2 = new int[] { 2, 4, 6, 7, 8 };
		MyArray.mergeTwoSortedArrays(arr1, 3, arr2, 5);
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, arr1));
	}



	public void testValidSudoku1() {
		char[][] board = new char[][] { ".87654321".toCharArray(),
				"2........".toCharArray(), "3........".toCharArray(),
				"4........".toCharArray(), "5........".toCharArray(),
				"6........".toCharArray(), "7........".toCharArray(),
				"8........".toCharArray(), "9........".toCharArray() };
		assertTrue(MyArray.isValidSudoku(board));
	}

	public void testValidSudoku2() {
		char[][] board = new char[][] { "....5..1.".toCharArray(),
				".4.3.....".toCharArray(), ".....3..1".toCharArray(),
				"8......2.".toCharArray(), "..2.7....".toCharArray(),
				".15......".toCharArray(), ".....2...".toCharArray(),
				".2.9.....".toCharArray(), "..4......".toCharArray() };
		assertFalse(MyArray.isValidSudoku(board));
	}

	public void testMaxSubarray1() {
		int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = MyArray.maxSubArray1(arr);
		assertEquals(6, result);
	}

	public void testMaxSubarray2() {
		int[] arr = new int[] { -1 };
		int result = MyArray.maxSubArray1(arr);
		assertEquals(-1, result);
	}
	
	public void testMaxSubarray3() {
		int[] arr = new int[] { -2, 1 };
		int result = MyArray.maxSubArray1(arr);
		assertEquals( 1, result);
	}
	
	public void testPascal1() {
		 List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		 triangle.add(Arrays.asList(1));
		 triangle.add(Arrays.asList(1, 1));
		 triangle.add(Arrays.asList(1, 2, 1));
		 triangle.add(Arrays.asList(1, 3, 3, 1));
		 assertEquals(triangle, MyArray.Pascal1(4));
	}
	
	public void testPascalGetRow() {
		 List<Integer> triangle = Arrays.asList(1, 3, 3, 1);
		 assertEquals(triangle, MyArray.PascalGetRow(3));
	}
	
	public void testSpiralOrder() {
		int[][] matrix = new int[][] {{1, 2, 3, 4, 5},
				                      {6, 7, 8, 9, 10},
				                      {11, 12, 13, 14, 15}};
		List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9));
		assertEquals(expect, MyArray.spiralOrder(matrix));	
	}
	
	public void testGenerateMatrix() {
		int[][] matrix = new int[][]{{1, 2, 3},
                                     {8, 9, 4},
                                     {7, 6, 5}};
		int[][] result = MyArray.generateMatrix(3);
		MyUtility.displayMatrix(result);
		for (int i = 0; i < 3; i++) {
			assertTrue(Arrays.equals(matrix[i], result[i]));
		}
	}
	
	public void testRotate1() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		MyArray.rotate(nums, 3);
		assertTrue(Arrays.equals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, nums));
	}

	public void testRotate2() {
		int[] nums = new int[] { 1, 2, 3};
		MyArray.rotate(nums, 4);
		assertTrue(Arrays.equals(new int[] { 3, 1, 2}, nums));
	}
	
	public void testLargestNumber1() {
		int[] num = new int[] {30, 3, 34, 5, 9, 9};
		String max = MyArray.largestNumber(num);
		assertEquals("99534330", max);
	}
	
	public void testLargestNumber2() {
		int[] num = new int[] {2, 2, 1};
		String max = MyArray.largestNumber(num);
		assertEquals("221", max);
	}
	
	public void testLargestNumber3() {
		int[] num = new int[] {0, 0};
		String max = MyArray.largestNumber(num);
		assertEquals("0", max);
	}
	
	public void testLargestNumber4() {
		int[] num = new int[] {824,8247};
		String max = MyArray.largestNumber(num);
		assertEquals("8248247", max);
	}
	
	public void testLongestConsecutive1() {
		int[] num = new int[] {100, 4, 200, 1, 3, 2};
		assertEquals(4, MyArray.longestConsecutive(num));
	}
	
    public void testFindDisappearedNumbers1() {
    	int[] num = new int[] {4,3,2,7,8,2,3,1};
        List<Integer> result = MyArray.findDisappearedNumbers(num);
        System.out.println(result);
        assertEquals(Arrays.asList(5, 6), MyArray.findDisappearedNumbers(num));
    }

    public void testFindDisappearedNumbers2() {
        int[] num = new int[] {2,2};
        List<Integer> result = MyArray.findDisappearedNumbers(num);
        System.out.println(result);
        assertEquals(Arrays.asList(1), MyArray.findDisappearedNumbers(num));
    }
    
	

	
}
