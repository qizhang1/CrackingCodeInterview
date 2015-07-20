package com.leetcode;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class SortingTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void testBubbleSort1(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.bubbleSort(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testInsertSort1(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.insertSort1(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testInsertSort2(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.insertSort2(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testSelectionSort1(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.selectionSort1(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testSelectionSort2(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.selectionSort2(numbers, 4);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testMergeSort1(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.mergeSort1(numbers, 0, 4);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testMergeSort2(){
		int[] numbers = new int[]{6, 5, 4, 3, 2};
		Sorting.mergeSort1(numbers, 0, 3);
		assertArrayEquals(new int[]{3, 4, 5, 6, 2}, numbers);
	}
	
	
	@Test
	public void testMergeSort3(){
		int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		Sorting.mergeSort1(numbers, 0, 8);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, numbers);
	}
	
	@Test
	public void testMergeSort4(){
		int[] numbers = new int[]{6, 5, 4, 3, 2};
		Sorting.mergeSort1(numbers, 0, 3);
		assertArrayEquals(new int[]{3, 4, 5, 6, 2}, numbers);
	}
	
	@Test
	public void testMergeSort5(){
		int[] numbers = new int[]{6, 5, 4, 3, 2};
		Sorting.mergeSort1(numbers, 1, 3);
		assertArrayEquals(new int[]{6, 3, 4, 5, 2}, numbers);
	}
	
	@Test
	public void testMergeSort6(){
		int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		Sorting.mergeSort1(numbers, 0, 8);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, numbers);
	}
	
	@Test
	public void testMergeSort7(){
		int[] numbers = new int[]{5, 4, 3, 2, 1};
		Sorting.mergeSort2(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testMergeSort8(){
		int[] numbers = new int[]{6, 5, 4};
		Sorting.mergeSort2(numbers);
		assertArrayEquals(new int[]{4, 5, 6}, numbers);
	}
	
	@Test
	public void testMergeSort9(){
		int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		Sorting.mergeSort2(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, numbers);
	}
	
	@Test
	public void testMergeSort10(){
		int[] numbers = new int[]{6, 5, 5, 3, 2};
		Sorting.mergeSort2(numbers);
		assertArrayEquals(new int[]{2, 3, 5, 5, 6}, numbers);
	}
	
	@Test
	public void testQuickSort1() {
		int[] numbers = new int[]{6, 5, 4, 3, 2};
		Sorting.quickSort1(numbers, 0, 4);
		assertArrayEquals(new int[]{2, 3, 4, 5, 6}, numbers);
	}
	
	@Test
	public void testQuickSort2() {
		int[] numbers = new int[]{6, 5, 7, 9, 7, 4, 3, 2};
		Sorting.quickSort2(numbers, 0, 7);
		assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 7, 9}, numbers);
	}
	
	@Test
	public void testGetMedian1() {
		int[] numbers = new int[]{22, 5, 10, 11, 23};
		assertEquals(11.0, Sorting.getMedian(numbers),DELTA);
	}
	
	@Test
	public void testGetMedian2() {
		int[] numbers = new int[]{22, 5, 10, 11};
		assertEquals(10.5, Sorting.getMedian(numbers),DELTA);
	}
	
	
	@Test
	public void testCountingSort(){
		int[] numbers = new int[]{5, 4, 2, 1, 3};
		Sorting.simpleBucketSort(numbers);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray1() {
		int[] A = new int[]{1, 2, 3, 4};
		int[] B = new int[]{3, 4, 5, 6};
		assertEquals(3, Sorting.getMedianFrom2SortedArr1(A, 0, 3, B, 0, 3));
		assertEquals(3, Sorting.getMedianFrom2SortedArr2(A, B));
		assertEquals(3.5, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray2() {
		int[] A = new int[]{1, 2, 3};
		int[] B = new int[]{3, 4, 5};
		assertEquals(3, Sorting.getMedianFrom2SortedArr1(A, 0, 2, B, 0, 2));
		assertEquals(3, Sorting.getMedianFrom2SortedArr2(A, B));
		assertEquals(3, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray3() {
		int[] A = new int[]{1, 2};
		int[] B = new int[]{1, 2};
		assertEquals(1, Sorting.getMedianFrom2SortedArr1(A, 0, 1, B, 0, 1));
		assertEquals(1, Sorting.getMedianFrom2SortedArr2(A, B));
		assertEquals(1.5, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray4() {
		int[] A = new int[]{1};
		int[] B = new int[]{1};
		assertEquals(1, Sorting.getMedianFrom2SortedArr1(A, 0, 0, B, 0, 0));
		assertEquals(1, Sorting.getMedianFrom2SortedArr2(A, B));
		assertEquals(1, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray5() {
		int[] A = new int[]{1, 2, 3, 4, 5, 6};
		int[] B = new int[]{3, 4, 5, 6, 7, 8};
		assertEquals(4, Sorting.getMedianFrom2SortedArr1(A, 0, 5, B, 0, 5));
		assertEquals(4, Sorting.getMedianFrom2SortedArr2(A, B));
		assertEquals(4.5, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
	
	@Test
	public void testGetMedianFrom2SortedArray6() {
		int[] A = new int[]{};
		int[] B = new int[]{2, 3};
		assertEquals(2.5, Sorting.getMedianFrom2SortedArr3(A, B), DELTA);
	}
}
