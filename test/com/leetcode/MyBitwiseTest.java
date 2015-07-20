package com.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBitwiseTest {
	

	@Test
	public void test() {
		int i = Integer.parseInt("10101010", 2);
		int n = MyBitwise.bitCount(i);
		assertEquals(4, n);
	}
	
	@Test
	public void testInverse() {
		int i = 0;
		int n = MyBitwise.inverse(i);
		assertEquals(0XFFFFFFFF, n);
		assertEquals(-1, n);
	}
	
	  /*0111 1111	127 	127 
		0111 1110	126 	126 
		0000 0010	  2 	2 
		0000 0001	  1 	1 
		0000 0000	  0 	0 
		1111 1111	255 	−1 
		1111 1110	254 	−2 
		1000 0010	130 	−126 
		1000 0001	129 	−127 
		1000 0000	128 	−128*/

	@Test
	public void testIsEven() {
		assertFalse(MyBitwise.isEven(3));
		assertTrue(MyBitwise.isEven(0));
		assertTrue(MyBitwise.isEven(-2));
	}
	
	@Test
	public void testSwap() {
		int[] a = {10};
		int[] b = {5};
		MyBitwise.swap(a, b);
		assertEquals(5, a[0]);
		assertEquals(10,b[0]);
	}
	
	@Test
	public void testCompare1() {
		int a = 10;
		int b = 9;
		assertEquals(1, MyBitwise.compare(a, b));
	}
	
	@Test
	public void testCompare2() {
		int a = -9;
		int b = 9;
		assertEquals(0, MyBitwise.compare(a, b));
	}
	
	@Test
	public void testCompare3() {
		int a = 9;
		int b = 9;
		assertEquals(0, MyBitwise.compare(a, b));
	}
	
	@Test
	public void testPower2() {
		assertEquals(1, MyBitwise.power2(0));
		assertEquals(4, MyBitwise.power2(2));
		assertEquals(8, MyBitwise.power2(3));
	}
	
	@Test
	public void testIsPower2() {
		assertTrue(MyBitwise.isPower2(0));
		assertTrue(MyBitwise.isPower2(8));
		assertTrue(MyBitwise.isPower2(16));
		assertFalse(MyBitwise.isPower2(3));
		assertFalse(MyBitwise.isPower2(12));
	}
	
	@Test
	public void testRangeBitwiseAnd1() {
		int result = MyBitwise.rangeBitwiseAnd1(5, 7);
		assertEquals(4, result);
	}
	
	@Test
	public void testRangeBitwiseAnd2() {
		int result = MyBitwise.rangeBitwiseAnd2(5, 7);
		assertEquals(4, result);
	}
}
