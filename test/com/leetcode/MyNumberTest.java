package com.leetcode;

import java.util.Arrays;

import junit.framework.TestCase;

public class MyNumberTest extends TestCase {
	public void testReverse1(){
		int x = 123;
		assertEquals(321, MyNumber.reverse(x));
	}
	
	public void testReverse2(){
		int x = -123;
		assertEquals(-321, MyNumber.reverse(x));
	}
	
	public void testReverse3(){
		int x = 10100;
		assertEquals(101, MyNumber.reverse(x));
	}
	
	public void testAtoi1(){
		String s = "  -1";
		assertEquals(-1, MyNumber.atoi(s));
	}
	
	public void testAtoi2(){
		String s = "2147483648";
		assertEquals(2147483647, MyNumber.atoi(s));
	}
	
	public void testAtoi3(){
		String s = "-2147483649";
		assertEquals(-2147483648, MyNumber.atoi(s));
	}
	public void testAtoi4(){
		String s = "0  ";
		assertEquals(0, MyNumber.atoi(s));
	}
	
	public void testAtoi5(){
		String s = "++5";
		assertEquals(0, MyNumber.atoi(s));
	}
	
	public void testAtoi6(){
		String s = "";
		assertEquals(0, MyNumber.atoi(s));
	}
	
	public void testPalindromeNum1(){
		int x = 121;
		assertTrue(MyNumber.isPalindrome2(x));
	}
	
	public void testPalindromeNum2(){
		int x = 0;
		assertTrue(MyNumber.isPalindrome2(x));
	}
	
	public void testPalindromeNum3(){
		int x = 12321;
		assertTrue(MyNumber.isPalindrome2(x));
	}
	
	public void testPalindromeNum4(){
		int x = 100021;
		assertFalse(MyNumber.isPalindrome2(x));
	}
	
	public void testPalindromeNum5(){
		int x = -12321;
		assertFalse(MyNumber.isPalindrome2(x));
	}
	
	public void testPlusOne1(){
		int[] x = new int[]{0};
		int[] result = MyNumber.plusOne(x, 1);
		assertTrue(Arrays.equals(new int[]{1}, result));
	}
	
	public void testPlusOne2(){
		int[] x = new int[]{9,9};
		int[] result = MyNumber.plusOne(x, 1);
		assertTrue(Arrays.equals(new int[]{1, 0, 0}, result));
	}
	
	public void testPlusOne3(){
		int[] x = new int[]{9,1};
		int[] result = MyNumber.plusOne(x, 9);
		assertTrue(Arrays.equals(new int[]{1, 0, 0}, result));
	}
	
	public void testAddBinary1(){
		String a = "11";
		String b = "1";
		String result = MyNumber.addBinary(a, b);
		System.out.println("addBinary:" + result);
		assertTrue(result.equalsIgnoreCase("100"));
	}
	
	public void testCountandSay() {
		assertEquals("1", MyNumber.countAndSay(1));
		assertEquals("11", MyNumber.countAndSay(2));
		assertEquals("21", MyNumber.countAndSay(3));
		assertEquals("1211", MyNumber.countAndSay(4));
		assertEquals("111221", MyNumber.countAndSay(5));
	}
	
	public void testCompress1() {
		assertEquals("a3b2c4", MyNumber.compress("aaabbcccc"));
		assertEquals("", MyNumber.compress(""));
	}
	
	public void testRomanToInt() {
		assertEquals(18, MyNumber.romanToInt("XVIII"));
		assertEquals(4, MyNumber.romanToInt("IV"));
	}
}
