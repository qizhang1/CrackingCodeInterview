package com.leetcode;

import static org.junit.Assert.*;

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

}
