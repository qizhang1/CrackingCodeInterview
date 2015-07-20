package com.leetcode;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class Algorithm_RecBackTracingTest {
    @Test
	 public void testPermuteDup1() {
		 int[] num = {1, 2, 3};
		 List<List<Integer>> result = Algorithm_RecBackTracing.permuteDup1(num); 
		 List<List<Integer>> expect = new ArrayList<List<Integer>>();
		 expect.add(Arrays.asList(1, 1, 1));
		 expect.add(Arrays.asList(1, 1, 2));
		 expect.add(Arrays.asList(1, 1, 3));
		 expect.add(Arrays.asList(1, 2, 1));
		 expect.add(Arrays.asList(1, 2, 2));
		 expect.add(Arrays.asList(1, 2, 3));
		 expect.add(Arrays.asList(1, 3, 1));
		 expect.add(Arrays.asList(1, 3, 2));
		 expect.add(Arrays.asList(1, 3, 3));
		 
		 expect.add(Arrays.asList(2, 1, 1));
		 expect.add(Arrays.asList(2, 1, 2));
		 expect.add(Arrays.asList(2, 1, 3));
		 expect.add(Arrays.asList(2, 2, 1));
		 expect.add(Arrays.asList(2, 2, 2));
		 expect.add(Arrays.asList(2, 2, 3));
		 expect.add(Arrays.asList(2, 3, 1));
		 expect.add(Arrays.asList(2, 3, 2));
		 expect.add(Arrays.asList(2, 3, 3));
		 
		 expect.add(Arrays.asList(3, 1, 1));
		 expect.add(Arrays.asList(3, 1, 2));
		 expect.add(Arrays.asList(3, 1, 3));
		 expect.add(Arrays.asList(3, 2, 1));
		 expect.add(Arrays.asList(3, 2, 2));
		 expect.add(Arrays.asList(3, 2, 3));
		 expect.add(Arrays.asList(3, 3, 1));
		 expect.add(Arrays.asList(3, 3, 2));
		 expect.add(Arrays.asList(3, 3, 3));
		 assertEquals(expect, result);
	 }
    
    @Test
    public void permuteDupIterative1() {
		 int[] num = {1, 2, 3};
		 List<List<Integer>> result = Algorithm_RecBackTracing.permuteDupIterative(num);
		 List<List<Integer>> expect = new ArrayList<List<Integer>>();
		 expect.add(Arrays.asList(1, 1, 1));
		 expect.add(Arrays.asList(1, 1, 2));
		 expect.add(Arrays.asList(1, 1, 3));
		 expect.add(Arrays.asList(1, 2, 1));
		 expect.add(Arrays.asList(1, 2, 2));
		 expect.add(Arrays.asList(1, 2, 3));
		 expect.add(Arrays.asList(1, 3, 1));
		 expect.add(Arrays.asList(1, 3, 2));
		 expect.add(Arrays.asList(1, 3, 3));
		 
		 expect.add(Arrays.asList(2, 1, 1));
		 expect.add(Arrays.asList(2, 1, 2));
		 expect.add(Arrays.asList(2, 1, 3));
		 expect.add(Arrays.asList(2, 2, 1));
		 expect.add(Arrays.asList(2, 2, 2));
		 expect.add(Arrays.asList(2, 2, 3));
		 expect.add(Arrays.asList(2, 3, 1));
		 expect.add(Arrays.asList(2, 3, 2));
		 expect.add(Arrays.asList(2, 3, 3));
		 
		 expect.add(Arrays.asList(3, 1, 1));
		 expect.add(Arrays.asList(3, 1, 2));
		 expect.add(Arrays.asList(3, 1, 3));
		 expect.add(Arrays.asList(3, 2, 1));
		 expect.add(Arrays.asList(3, 2, 2));
		 expect.add(Arrays.asList(3, 2, 3));
		 expect.add(Arrays.asList(3, 3, 1));
		 expect.add(Arrays.asList(3, 3, 2));
		 expect.add(Arrays.asList(3, 3, 3));
		 assertEquals(expect, result);
    }
	
     @Test
	 public void testPermute1() {
		 int[] num = {1, 2, 3};
		 List<List<Integer>> result = Algorithm_RecBackTracing.permute(num); 
		 List<List<Integer>> expect = new ArrayList<List<Integer>>();
		 expect.add(Arrays.asList(1, 2, 3));
		 expect.add(Arrays.asList(1, 3, 2));
		 expect.add(Arrays.asList(2, 1, 3));
		 expect.add(Arrays.asList(2, 3, 1));
		 expect.add(Arrays.asList(3, 1, 2));
		 expect.add(Arrays.asList(3, 2, 1));
		 assertEquals(expect, result);
	 }
     
     @Test
	 public void testPermuteUnique() {
		 int[] num = {1, 1, 2};
		 List<List<Integer>> result = Algorithm_RecBackTracing.permuteUnique(num); 
		 List<List<Integer>> expect = new ArrayList<List<Integer>>();
		 expect.add(Arrays.asList(1, 1, 2));
		 expect.add(Arrays.asList(1, 2, 1));
		 expect.add(Arrays.asList(2, 1, 1));
		 assertEquals(expect, result);
	 }
     
     
     @Test
     public void testNextPermutation1() {
    	 int[] n1 = {1, 2, 3};
    	 Algorithm_RecBackTracing.nextPermutation(n1);
    	 assertTrue(Arrays.equals(n1, new int[] {1, 3, 2}));
     }
     
     @Test
     public void testNextPermutation2() {
    	 int[] n1 = {3, 2, 1};
    	 Algorithm_RecBackTracing.nextPermutation(n1);
    	 assertTrue(Arrays.equals(n1, new int[] {1, 2, 3}));
     }
     
     @Test
     public void testNextPermutation3() {
    	 int[] n1 = {1, 1, 5};
    	 Algorithm_RecBackTracing.nextPermutation(n1);
    	 assertTrue(Arrays.equals(n1, new int[] {1, 5, 1}));
     }
     

     
     
     
     
     
     
     
     
     
     @Test
     public void testExist1() {
 		char[][] board = new char[][] { "ABCE".toCharArray(),
				                        "SFCS".toCharArray(), 
				                        "ADEE".toCharArray()};
 		assertTrue(Algorithm_RecBackTracing.exist(board, "ABCCED"));
 		assertTrue(Algorithm_RecBackTracing.exist(board, "SEE"));
 		assertFalse(Algorithm_RecBackTracing.exist(board, "ABCB"));
     }
     
     
     @Test
     public void testSolveNQueens1() {
    	 List<String[]> expect = new ArrayList<>();
    	 String[] s1 = new String[]{".Q..",  
    			                   "...Q",
    			                   "Q...",
    			                   "..Q."};

    	 expect.add(s1);
    	 String[] s2 = new String[]{"..Q.",  
    			                    "Q...",
    			                    "...Q",
    			                    ".Q.."};
    	 expect.add(s2); 
    	 List<String[]> result = Algorithm_RecBackTracing.solveNQueens(4);
    	 assertEquals(expect.size(), result.size());
    	 for (int i = 0; i < expect.size(); i++) {
    		 assertArrayEquals(expect.get(i), result.get(i));
    	 }
     }
     
     @Test
     public void testSolveNQueens2() {
    	 List<String[]> expect = new ArrayList<>();
    	 List<String[]> result = Algorithm_RecBackTracing.solveNQueens(3);
    	 assertEquals(expect.size(), result.size());
    	 for (int i = 0; i < expect.size(); i++) {
    		 assertArrayEquals(expect.get(i), result.get(i));
    	 }
     }
     
     @Test
     public void testGameNim1() {
    	 assertFalse(Algorithm_RecBackTracing.gameNim(5)); // you are doomed to lose
     }
     
     @Test
     public void testGameNim2() {
    	 assertTrue(Algorithm_RecBackTracing.gameNim(2)); 
    	 assertTrue(Algorithm_RecBackTracing.gameNim(3)); 
    	 assertTrue(Algorithm_RecBackTracing.gameNim(4)); // you are doomed to win
     }
     
     @Test
     public void testSubsets1() {
    	 int[] arr = new int[]{1, 2, 3};
    	 List<List<Integer>> result = Algorithm_RecBackTracing.subsets1(arr);
    	 List<List<Integer>> expect = new ArrayList<List<Integer>>();
    	 expect.add(new ArrayList<Integer>());
		 expect.add(Arrays.asList(1));
		 expect.add(Arrays.asList(1, 2));
		 expect.add(Arrays.asList(1, 2, 3));
		 expect.add(Arrays.asList(1, 3));
		 expect.add(Arrays.asList(2));
		 expect.add(Arrays.asList(2, 3));
		 expect.add(Arrays.asList(3));
		 assertEquals(expect, result);
     }
     
     @Test
     public void testSubsets2() {
    	 int[] arr = new int[]{1, 2, 3};
    	 List<List<Integer>> result = Algorithm_RecBackTracing.subsets2(arr);
    	 List<List<Integer>> expect = new ArrayList<List<Integer>>();
    	 expect.add(new ArrayList<Integer>());
    	 expect.add(Arrays.asList(3));
		 expect.add(Arrays.asList(2));
		 expect.add(Arrays.asList(2, 3));
		 expect.add(Arrays.asList(1));
		 expect.add(Arrays.asList(1, 3));
		 expect.add(Arrays.asList(1, 2));
		 expect.add(Arrays.asList(1, 2, 3));
		 assertEquals(expect, result);
     }
     
     @Test
     public void subsetsWithDup1() {
    	 int[] arr = new int[]{1, 2, 2};
    	 List<List<Integer>> result = Algorithm_RecBackTracing.subsetsWithDup(arr);
    	 List<List<Integer>> expect = new ArrayList<List<Integer>>();
    	 expect.add(new ArrayList<Integer>());
		 expect.add(Arrays.asList(1));
		 expect.add(Arrays.asList(1, 2));
		 expect.add(Arrays.asList(1, 2, 2));
		 expect.add(Arrays.asList(2));
		 expect.add(Arrays.asList(2, 2));
		 assertEquals(expect, result);
     }
     
     @Test
     public void letterCombinations1() {
    	 List<String> result = Algorithm_RecBackTracing.letterCombinations("23");
    	 List<String> expect = new ArrayList<String>
    	 (Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    	 assertEquals(expect, result);
     }
     
     @Test
     public void grayCode1() {
    	 List<Integer> result = Algorithm_RecBackTracing.grayCode2(2);
    	 List<Integer> expect = new ArrayList<>();
    	 expect.add(0);
    	 expect.add(1);
    	 expect.add(3);
    	 expect.add(2);
    	 assertEquals(expect, result);
     }
     
     @Test
     public void grayCode2() {
    	 List<Integer> result = Algorithm_RecBackTracing.grayCode2(1);
    	 List<Integer> expect = new ArrayList<>();
    	 expect.add(0);
    	 expect.add(1);
    	 assertEquals(expect, result);
     }
     
     @Test
     public void generateParenthesis1 () {
    	 List<String> result = Algorithm_RecBackTracing.generateParenthesis(3);
    	 List<String> expect = new ArrayList<String>();
    	 expect.add("((()))");
    	 expect.add("(()())");
    	 expect.add("(())()");
    	 expect.add("()(())");
    	 expect.add("()()()");
    	 assertEquals(expect, result);
     }
     
     @Test
     public void partition1() {
    	 List<List<String>> result = Algorithm_RecBackTracing.partition("aab");
    	 List<List<String>> expect = new ArrayList<List<String>>();
    	 expect.add(Arrays.asList("a","a","b"));
    	 expect.add(Arrays.asList("aa","b"));
    	 assertEquals(expect, result);
     }
     
     @Test
     public void minCut1() {
    	 assertEquals(1, Algorithm_RecBackTracing.minCut("aab"));
     }
     
     
     @Test
     public void minCut2() {
    	 // a|babbbab|bab|a
    	 // aba|bbb|abba|b|a  not right
    	 assertEquals(3, Algorithm_RecBackTracing.minCut("ababbbabbaba"));
     }
     
     @Test
     public void minCut3() {
    	 // a|babbab
    	 // aba|bb|a|b  not right
    	 assertEquals(1, Algorithm_RecBackTracing.minCut("ababbab"));
     }
     
     
     
}
