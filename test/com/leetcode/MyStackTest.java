package com.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MyStackTest {

	@Test
	public void testIsValid1() {
		String s = "()[{}](";
		assertFalse(MyStack.isValid(s));
	}
	
	@Test
	public void testIsValid2() {
		String s = "()[{}]";
		assertTrue(MyStack.isValid(s));
	}
	
	@Test
	public void testDailyTemperatures1() {
		int[] T = {73,74,75,71,69,72,76,73};
		int[] expect = {1,1,4,2,1,1,0,0};
		assertTrue(Arrays.equals(MyStack.dailyTemperatures1(T), expect));
	}

	@Test
	public void testDailyTemperatures2() {
		int[] T = {89,62,70,58,47,47,46,76,100,70};
		int[] expect = {8,1,5,4,3,2,1,1,0,0};
		assertTrue(Arrays.equals(MyStack.dailyTemperatures1(T), expect));
	}
	
	@Test
	public void testNextGreaterElement11() {
		int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
		assertTrue(Arrays.equals(MyStack.nextGreaterElement1(nums1, nums2), new int[] {-1,3,-1}));
	}
	
	@Test
	public void testNextGreaterElement12() {
		int[] nums1 = {4,1,2}, nums2 = {1,2,3,4};
		assertTrue(Arrays.equals(MyStack.nextGreaterElement1(nums1, nums2), new int[] {-1, 2, 3}));
	}
	
	@Test
	public void testNextGreaterElement2() {
		int[] nums = {1,2,1};
		assertTrue(Arrays.equals(MyStack.nextGreaterElement2(nums), new int[] {2, -1, 2}));
	}
}
