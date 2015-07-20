package com.leetcode;

import java.util.*;

public class Algorithm_DP {

	public static int fib(int n) {
		if (n < 2) {
			return n;
		}
		int[] fib = new int[n + 1];
		// base cases
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	// *****************************************************************************************
	// Unique Paths
	// A robot is located at the top-left corner of a m x n grid
	// The robot is trying to reach the bottom-right corner of the grid
	// Time O(n^2) Space O(n^2)
	public static int uniquePaths1(int m, int n) {
		int[][] count = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					count[i][j] = 1;
				} else {
					count[i][j] = count[i][j - 1] + count[i - 1][j];
				}
			}
		}
		return count[m - 1][n - 1];
	}

	// Time O(n^2) Space O(n)
	public static int uniquePaths2(int m, int n) {
		int[] count = new int[n];
		// set first row and col
		Arrays.fill(count, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[j] = count[j - 1] + count[j];
			}
		}
		return count[n - 1];
	}

	// Time O(n^2) Space O(n)
	public static int uniquePaths3(int m, int n) {
		int[] count = new int[n];
		// set first column only, calculate first row in the loop
		count[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[j] = count[j - 1] + count[j];
			}
		}
		return count[n - 1];
	}

	// *****************************************************************************************
	// Time O(n^2) Space O(n^2)
	public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		int[][] count = new int[row][col];

		// set first row
		for (int j = 0; j < col; j++) {
			if (obstacleGrid[0][j] == 1 || (j > 0 && count[0][j - 1] == 0)) {
				count[0][j] = 0;
			} else {
				count[0][j] = 1;
			}
		}

		// set first column
		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 1 || (i > 0 && count[i - 1][0] == 0)) {
				count[i][0] = 0;
			} else {
				count[i][0] = 1;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (obstacleGrid[i][j] == 1) {
					count[i][j] = 0;
				} else {
					count[i][j] = count[i][j - 1] + count[i - 1][j];
				}
			}
		}
		return count[row - 1][col - 1];
	}

	// Time O(n^2) Space O(n)
	public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		int[] count = new int[col];

		// set first row only
		for (int j = 0; j < col; j++) {
			if (obstacleGrid[0][j] == 1 || (j > 0 && count[j - 1] == 0)) {
				count[j] = 0;
			} else {
				count[j] = 1;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (obstacleGrid[i][j] == 1) {
					count[j] = 0;
				} else {
					int left = j - 1 >= 0 ? count[j - 1] : 0;
					int upper = i - 1 >= 0 ? count[j] : 0;
					count[j] = left + upper;
				}
			}
		}
		return count[col - 1];
	}

	// Time O(n^2) Space O(n)
	public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		int[] count = new int[col];

		// only set first count
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		count[0] = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0)
					continue; // don't overwritten first count
				if (obstacleGrid[i][j] == 1) {
					count[j] = 0;
				} else { // 换成else if (j > 0 ) { 可以省略continue那行
					int left = j - 1 >= 0 ? count[j - 1] : 0;
					int upper = i - 1 >= 0 ? count[j] : 0;
					count[j] = left + upper;
				}
			}
		}
		return count[col - 1];
	}

	// *****************************************************************************************
	// Climbing Stairs with n steps
	// Each time you can either climb 1 or 2 steps. In how many distinct ways
	// can you climb to the top?
	public static int climbStairs(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	// *****************************************************************************************
	// find maximum Palindrome
	// time O(n^2) space O(n^2)
	public static String longestPalSubstr1(String s) {
//		if (s.length() < 2) {
//			return s;
//		}
		int n = s.length();
		boolean[][] mem = new boolean[n][n];
		// single character is palindrome
		for (int i = 0; i < n; i++) {
			mem[i][i] = true;
		}

		int start = 0;
		int end = 0;
		for (int sublen = 2; sublen <= n; sublen++) {
			for (int i = 0; i + sublen <= n; i++) {
				if ((sublen == 2 || mem[i + 1][i + sublen - 2])
						&& s.charAt(i) == s.charAt(i + sublen - 1)) {
					start = i;
					end = i + sublen - 1;
					mem[i][i + sublen - 1] = true;
				}
			}
		}
		return s.substring(start, end + 1);
	}

	// Optimal: time O(n^2) space O(1)
	public static String longestPalSubstr2(String s) {
		int start = 0;
		int end = 0;
		int maxLen = 0;
		
		for (int i = 0; i < s.length() - 1; i++) {
			// odd
			int oddLen = longestPalSubstr2Ext(s, i - 1, i + 1);
			if (oddLen * 2 + 1 > maxLen) {
				maxLen = oddLen * 2 + 1;
				start = i - oddLen;
				end = i + oddLen;
			}
			// even
			int evenLen = longestPalSubstr2Ext(s, i, i + 1);
			if (evenLen * 2 > maxLen) {
				maxLen = evenLen * 2;
				start = i - evenLen + 1;
				end = i + evenLen;
			}
		}
		return s.substring(start, end + 1);
	}

	public static int longestPalSubstr2Ext(String s, int left, int right) {
		int result = 0;
		while (left - result >= 0 && right + result < s.length()
				&& s.charAt(left - result) == s.charAt(right + result)) {
			result++;
		}
		return result;
	}

	// *****************************************************************************************
	// Palindrome Partitioning 2
	// Return the minimum cuts needed for a palindrome partitioning of s.
	// Time O(n^2)
	public static int minCut(String s) {
		// if (s.length() < 2) {
		// return 0;
		// }
		int n = s.length();
		int[] minCutMem = new int[n]; // minCutMem[i] is minimum cuts for S[i,
									  // n-1]
		boolean[][] mem = new boolean[n][n];
		// single character is palindrome
		for (int i = 0; i < n; i++) {
			minCutMem[i] = i; // init max cut for S[0, i]
		}

		for (int end = 0; end < n; end++) {
			for (int start = 0; start <= end; start++) {
				if (s.charAt(start) == s.charAt(end)
						&& (end - start < 2 || mem[start + 1][end - 1])) {
					mem[start][end] = true;
					if (start == 0) {
						minCutMem[end] = 0;
					} else {
						minCutMem[end] = Math.min(minCutMem[end], minCutMem[start - 1] + 1);
					}
				}
			}
		}
		return minCutMem[n - 1];
	}

	// *****************************************************************************************
	// delete minimum num to get longest ascending subarray

	// *****************************************************************************************
	// Given a string s and a dictionary of words dict,
	// determine if s can be segmented into a space-separated sequence of one or
	// more dictionary words.
	// Time O(n^3) Space O(n)
	public static boolean wordBreak(String s, Set<String> dict) {
		int n = s.length();
		boolean[] mem = new boolean[n + 1];
		// 空串 mem[0] = 0
		// 定义 mem[i] (0 < i <= n)为S字符串长度为i的子串是否可以被segmented by dict.
		mem[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (mem[j] && dict.contains(s.substring(j, i))) {
					mem[i] = true;
					break;
				}
			}
		}
		return mem[n];
	}

	// *****************************************************************************************
	// Given a triangle, find the minimum path sum from top to bottom.
	// Each step you may move to adjacent numbers on the row below.
	// Space O(n^2)? Time O(n)
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] mem = new int[n][n];
		mem[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			List<Integer> cur = triangle.get(i);
			mem[i][0] = mem[i - 1][0] + cur.get(0);
			for (int j = 1; j < i; j++) {
				mem[i][j] = Math.min(mem[i - 1][j - 1], mem[i - 1][j])
						+ cur.get(j);
			}
			mem[i][i] = mem[i - 1][i - 1] + cur.get(i);
		}
		return MyArray.getMinValue(mem[n - 1]);
	}

	// Space O(n) n is the total number of rows in the triangle.
	public static int minimumTotal2(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] mem = new int[n];
		mem[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) { // i current level
			List<Integer> cur = triangle.get(i);
			// backwards traverse
			mem[i] = mem[i - 1] + cur.get(i);
			for (int j = i - 1; j > 0; j--) {
				mem[j] = Math.min(mem[j - 1], mem[j]) + cur.get(j);
			}
			mem[0] = mem[0] + cur.get(0);
		}
		return MyArray.getMinValue(mem);
	}

	// Given a list of non-negative integers representing the amount of money of each house, 
	// Determine the maximum amount of money you can rob tonight without alerting the alarming system
	// It will automatically contact the police if two adjacent houses were broken into on the same night. 
	public int rob(int[] num) {
        int n = num.length;
        if (n == 0) return 0;
        int[] mem = new int[n];
        mem[0] = num[0];
        for (int i = 1; i < n; i++) {
            int pre = i - 2 >= 0 ? mem[i - 2] : 0;
            mem[i] = Math.max(pre + num[i], mem[i - 1]);
        }
        return mem[n - 1];
    }
	
}
