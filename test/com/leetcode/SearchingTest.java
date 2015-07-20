package com.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SearchingTest {

	@Test
	public void testSearchInsert() {
		int[] arr1 = new int[] { 1, 3, 5, 7 };
		int index = Searching.searchInsert(arr1, 4);
		assertEquals( 2, index);
	}
	
	@Test
	public void testFindMin1() {
		int[] arr1 = new int[] { 3, 2, 1 };
		assertEquals(1, Searching.findMin1(arr1));
	}
	
	@Test
	public void testFindMin2() {
		int[] arr1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		assertEquals(0, Searching.findMin1(arr1));
	}
	
	@Test
	public void testFindMin3() {
		int[] arr1 = new int[] { 1, 2, 3};
		assertEquals(1, Searching.findMin1(arr1));
	}
	
	@Test
	public void testFindMin4() {
		int[] arr1 = new int[] { 1 };
		assertEquals(1, Searching.findMin1(arr1));
	}
	
	@Test
	public void testFindMin5() {
		int[] arr1 = new int[] { 3, 2, 1 };
		assertEquals(1, Searching.findMin2(arr1));
	}
	
	@Test
	public void testFindMin6() {
		int[] arr1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		assertEquals(0, Searching.findMin2(arr1));
	}
	
	@Test
	public void testFindMin7() {
		int[] arr1 = new int[] { 1, 2, 3};
		assertEquals(1, Searching.findMin2(arr1));
	}
	
	@Test
	public void testFindMin8() {
		int[] arr1 = new int[] { 1 };
		assertEquals(1, Searching.findMin2(arr1));
	}
	
	@Test
	public void testSearch1_1() {
		int[] arr1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		assertEquals(5, Searching.search1(arr1, 1));
	}
	
	@Test
	public void testSearch1_2() {
		int[] arr1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		assertEquals(-1, Searching.search1(arr1, 3));
	}
	
	@Test
	public void testSearch2_1() {
		int[] arr1 = new int[] { 1, 3, 1, 1, 1};
		assertTrue(Searching.search2(arr1, 3));
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void testSearchMatrix1() {
		int[][] matrix = new int[][] {{1, 3, 5,7},
				                      {10, 11, 16, 20},
				                      {23, 30, 34, 50}};
		assertTrue(Searching.searchMatrix(matrix, 3));
	}
	
	@Test
	public void testSearchMatrix2() {
		int[][] matrix = new int[][] {{1}};
		assertFalse(Searching.searchMatrix(matrix, 0));
	}
	
	@Test
	public void testSearchMatrix3() {
		int[][] matrix = new int[][] {{1}, {3}, {5}};
		assertFalse(Searching.searchMatrix(matrix, 0));
	}
	
	@Test
	public void testSearchMatrix4() {
		int[][] matrix = new int[][] {{1, 1}};
		assertFalse(Searching.searchMatrix(matrix, 0));
	}
	
	@Test
	public void testSearchRange1() {
		int[] arr = {5, 7, 7, 8, 8, 10};
		int[] result = Searching.searchRange(arr, 8);
		assertTrue(Arrays.equals(result, new int[]{3, 4}));
	}
	
	@Test
	public void testSearchRange2() {
		int[] arr = {5, 7, 7, 8, 8, 10};
		int[] result = Searching.searchRange(arr, 9);
		assertTrue(Arrays.equals(result, new int[]{-1, -1}));
	}
	
	@Test
	public void testSearchMatrix5() {
		int[][] matrix = new int[][]{{1, 3, 5, 7},
                                     {2, 4, 7, 8},
                                     {3, 5, 9, 10}};
		
		assertEquals(2, Searching.searchMatrix2(matrix, 3));
	}
	

}
