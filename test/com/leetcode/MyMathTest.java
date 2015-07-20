package com.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMathTest {

	@Test
	public void testFirstMissingPositive1() {
		int[] numbers = new int[]{1,2,0};
		assertEquals(3, MyMath.firstMissingPositive(numbers));
	}
	
	@Test
	public void testFirstMissingPositive2() {
		int[] numbers = new int[]{3,4,-1,1};
		assertEquals(2, MyMath.firstMissingPositive(numbers));
	}
	
	@Test
	public void testFirstMissingPositive3() {
		int[] numbers = new int[]{2,1};
		assertEquals(3, MyMath.firstMissingPositive(numbers));
	}
	
	@Test
	public void testIsNumber1() {
		assertTrue(MyMath.isNumber1("0"));
		assertTrue(MyMath.isNumber1(" 0.1 "));
		assertTrue(MyMath.isNumber1("2e10"));
		assertTrue(MyMath.isNumber1(".1"));
		assertTrue(MyMath.isNumber1("46.e3"));
		assertTrue(MyMath.isNumber1("3."));
		assertTrue(MyMath.isNumber1(".2e81"));
		assertTrue(MyMath.isNumber1("005047e+6"));
		assertFalse(MyMath.isNumber1("."));
		assertFalse(MyMath.isNumber1("abc"));
		assertFalse(MyMath.isNumber1("1 a"));
		assertFalse(MyMath.isNumber1("e"));
		assertFalse(MyMath.isNumber1("0e"));
		assertFalse(MyMath.isNumber1("4e+"));
		assertFalse(MyMath.isNumber2(" "));
		assertFalse(MyMath.isNumber2("e9"));
	}
	
	@Test
	public void testIsNumber2() {
		assertTrue(MyMath.isNumber2("0"));
		assertTrue(MyMath.isNumber2(" 0.1 "));
		assertTrue(MyMath.isNumber2("2e10"));
		assertTrue(MyMath.isNumber2(".1"));
		assertTrue(MyMath.isNumber2("46.e3"));
		assertTrue(MyMath.isNumber2("3."));
		assertTrue(MyMath.isNumber2(".2e81"));
		assertTrue(MyMath.isNumber2("005047e+6"));
		assertFalse(MyMath.isNumber2("."));
		assertFalse(MyMath.isNumber2("abc"));
		assertFalse(MyMath.isNumber2("1 a"));
		assertFalse(MyMath.isNumber2("e"));
		assertFalse(MyMath.isNumber2("0e"));
		assertFalse(MyMath.isNumber2("4e+"));
		assertFalse(MyMath.isNumber2(" "));
		assertFalse(MyMath.isNumber2("e9"));
	}
	
	@Test
	public void testTrailingZeroes1() {
		assertEquals(1, MyMath.trailingZeroes1(5));
		assertEquals(536870902, MyMath.trailingZeroes1(2147483647));
		assertEquals(24, MyMath.trailingZeroes1(100));
	}
	
	@Test
	public void testTrailingZeroes2() {
		assertEquals(1, MyMath.trailingZeroes2(5));
		assertEquals(536870902, MyMath.trailingZeroes2(2147483647));
		assertEquals(24, MyMath.trailingZeroes2(100));
	}
	
	@Test
	public void testMultiply1() {
		assertEquals(50, MyMath.multiply(5, 10));
		assertEquals(-40, MyMath.multiply(-5, 8));
		assertEquals(4611686014132420609L, MyMath.multiply(2147483647, 2147483647));
		assertEquals(4611686018427387904L, MyMath.multiply(-2147483648, -2147483648));
		assertEquals(0, MyMath.multiply(1000, 0));
	}
	
	@Test
	public void testDivide1() {
		assertEquals(5, MyMath.divide1(50, 10));
		assertEquals(-5, MyMath.divide1(-40, 8));
		assertEquals(2147483648L, MyMath.divide1(-2147483648, -1));
		assertEquals(-2147483648L, MyMath.divide1(-2147483648, 1));
	}
	
	@Test
	public void testComputeArea() {
		assertEquals(2, MyMath.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
		assertEquals(16, MyMath.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}

}
