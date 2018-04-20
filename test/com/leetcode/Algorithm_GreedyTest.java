package com.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class Algorithm_GreedyTest {

	@Test
	public void testMaxProfit1() {
		int[] arr = new int[] { 2, 4, 3, 6, 7 };
		int result = Algorithm_Greedy.maxProfit2(arr);
		assertEquals(6, result);
	}
	
	@Test
	public void testMaxProfit2() {
		int[] arr = new int[] {7, 6, 4, 3, 1};
		int result = Algorithm_Greedy.maxProfit2(arr);
		assertEquals(0, result);
	}
	
	@Test
	public void testMaxSubArray () {
		int[] arr = new int[] {1, -3, 5, -2, 9, -8, -6, 4};
		assertEquals(12, Algorithm_Greedy.maxSubArray(arr));
	}
	
	@Test
	public void testCanJump1() {
		int[] arr = new int[] {2, 3, 1, 1, 4};
		assertTrue(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump2() {
		int[] arr = new int[] {3, 2, 1, 0, 4};
		assertFalse(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump3() {
		int[] arr = new int[] {1, 0, 1, 1};
		assertFalse(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump4() {
		int[] arr = new int[] {1, 2};
		assertTrue(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump5() {
		int[] arr = new int[] {2, 5, 0, 0};
		assertTrue(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump6() {
		int[] arr = new int[] {1, 1, 0, 1};
		assertFalse(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testCanJump7() {
		int[] arr = new int[] {1, 1, 2, 2, 0, 1, 1};
		assertTrue(Algorithm_Greedy.canJump(arr));
	}
	
	@Test
	public void testJump1 () {
		int[] arr = new int[] {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
		assertEquals(2, Algorithm_Greedy.jump(arr));
	}
	
	@Test
	public void testJump2 () {
		int[] arr = new int[] {2, 3, 1, 1, 4};
		assertEquals(2, Algorithm_Greedy.jump(arr));
	}
	

}
