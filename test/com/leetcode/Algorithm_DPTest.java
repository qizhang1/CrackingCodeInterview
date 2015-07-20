package com.leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class Algorithm_DPTest {

	@Test
	public void testFib() {
		assertEquals(0, Algorithm_DP.fib(0));
		assertEquals(1, Algorithm_DP.fib(1));
		assertEquals(1, Algorithm_DP.fib(2));
		assertEquals(2, Algorithm_DP.fib(3));
		assertEquals(3, Algorithm_DP.fib(4));
		assertEquals(144, Algorithm_DP.fib(12));
		assertEquals(2584, Algorithm_DP.fib(18));
	}
	
	
	@Test
	public void testUniquePaths1() {
		int result = Algorithm_DP.uniquePaths1(3, 3);
		assertEquals(6, result);
	}
	
	@Test
	public void testUniquePaths2() {
		int result = Algorithm_DP.uniquePaths2(3, 3);
		assertEquals(6, result);
	}
	
	@Test
	public void testUniquePathsWithObstacles1() {
		int [][] obstacles = {
		                      {0,0,0},
		                      {0,1,0},
		                      {0,0,0}};
		assertEquals(2, Algorithm_DP.uniquePathsWithObstacles1(obstacles));
	}
	
	@Test
	public void testUniquePathsWithObstacles2() {
		int [][] obstacles = {
		                      {0,0,0},
		                      {0,1,0},
		                      {0,0,0}};
		assertEquals(2, Algorithm_DP.uniquePathsWithObstacles2(obstacles));
	}
	
	@Test
	public void testWordBreak1() {
		HashSet<String> set = new HashSet<>();
		set.add("a");
		assertTrue(Algorithm_DP.wordBreak("a", set));
	}
	
	@Test
	public void testWordBreak2() {
		HashSet<String> set = new HashSet<>();
		set.add("a");
		set.add("abc");
		set.add("b");
		set.add("cd");
		assertTrue(Algorithm_DP.wordBreak("abcd", set));
	}
	
	
	@Test
	public void testTriangle1() {
		 List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		 triangle.add(Arrays.asList(2));
		 triangle.add(Arrays.asList(3, 4));
		 triangle.add(Arrays.asList(6, 5, 7));
		 triangle.add(Arrays.asList(4, 1, 8, 3));
		 assertEquals(11, Algorithm_DP.minimumTotal1(triangle));
	}
	
	@Test
	public void testTriangle2() {
		 List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		 triangle.add(Arrays.asList(2));
		 triangle.add(Arrays.asList(3, 4));
		 triangle.add(Arrays.asList(6, 5, 7));
		 triangle.add(Arrays.asList(4, 1, 8, 3));
		 assertEquals(11, Algorithm_DP.minimumTotal2(triangle));
	}
	
	@Test
	public void testLongestPalSubstr1() {
		String s = "abbaca";
		assertEquals("abba", Algorithm_DP.longestPalSubstr1(s));
	}
	
	@Test
	public void testLongestPalSubstr2() {
		String s = "abbaca";
		assertEquals("abba", Algorithm_DP.longestPalSubstr2(s));
	}
	
	@Test
	public void testLongestPalSubstr3() {
		String s = "bb";
		assertEquals("bb", Algorithm_DP.longestPalSubstr2(s));
	}
	
	@Test
	public void testLongestPalSubstr4() {
		String s = "abc";
		assertEquals("a", Algorithm_DP.longestPalSubstr2(s));
	}
	
    @Test
    public void minCut1() {
   	 // a|babbbab|bab|a
   	 // aba|bbb|abba|b|a  not right
   		assertEquals(3, Algorithm_DP.minCut("ababbbabbaba"));
    }
    
    @Test
    public void minCut2() {
   	 // a|babbab
   	 // aba|bb|a|b  not right
   		assertEquals(1, Algorithm_DP.minCut("ababbab"));
    }
    
    @Test
    public void minCut3() {
   	 assertEquals(1, Algorithm_DP.minCut("aab"));
    }

}
