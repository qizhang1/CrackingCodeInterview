package com.leetcode;

import java.util.*;

// Backtracking (回溯法）– a method to try all possibilities using recursion 
public class Algorithm_RecBackTracing {
	// Permutation with Repetition
	// Recursive
	public static List<List<Integer>> permuteDup1(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Integer[] arr = new Integer[num.length];
		permuteDupDFS(num, arr, 0, result);
		return result;
	}

	private static void permuteDupDFS(int[] num, Integer[] arr, int arr_i,
			List<List<Integer>> result) {
		if (arr_i == num.length) {
			result.add(Arrays.asList(arr.clone()));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			arr[arr_i] = num[i];
			permuteDupDFS(num, arr, arr_i + 1, result);
		}
	}
	
	// Iterative
	// num is sorted integer array with no duplicate element
	public static List<List<Integer>> permuteDupIterative(int[] num) {
		// Initialize start array
		Integer[] arr = new Integer[num.length];
		Arrays.fill(arr, 0);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		int i;
		do {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				temp.add(num[arr[j]]);
			}
			result.add(temp);
		
			// next permutation
			for (i = num.length - 1; i >= 0; i--) {
				int next = (arr[i] + 1) % num.length;
				arr[i] = next;
				if (next != 0) break;
			}
		} while (i >= 0);
		return result;
	}
	

	// *****************************************************************************************
	// Permutation with no Repetition num!
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Integer[] arr = new Integer[num.length];
		boolean[] isVisited = new boolean[num.length];
		permuteDFS(num, isVisited, arr, 0, result);
		return result;
	}

	private static void permuteDFS(int[] num, boolean[] isVisited,
			Integer[] arr, int arr_i, List<List<Integer>> result) {
		if (arr_i == num.length) {
			result.add(Arrays.asList(arr.clone()));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (isVisited[i] == false) {
				arr[arr_i] = num[i];  
				isVisited[i] = true;
				permuteDFS(num, isVisited, arr, arr_i + 1, result);
				isVisited[i] = false; // backtracked to remove this num
			}
		}
	}
	
	// *****************************************************************************************
	// next permutation 
	// rearranges numbers into the lexicographically next greater permutation of numbers.
	// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	// Time O(n) Space O(1)
	public static void nextPermutation(int[] num) {
		// 1. identify the pivot num[vioIndex]
		// from right to left, pivot is the first element that violates the increasing order of longest suffix
		int vioIndex = num.length - 1;  
		while (vioIndex > 0 && num[vioIndex - 1] >= num[vioIndex]) {
			vioIndex--;
		}
		vioIndex--;
		
		// if vioIndex < 0, it is the last permutation already, sort and return
		if (vioIndex >= 0) {
			// 2. num[rightIndex] is rightmost successor to pivot in the suffix
			// assert rightIndex >= vioIndex
			int rightIndex = num.length - 1;   
			while(num[rightIndex] <= num[vioIndex]){   
				rightIndex--; 
			}  

			// 3. swap
			int temp = num[vioIndex];   
			num[vioIndex] = num[rightIndex];   
			num[rightIndex] = temp; 
		}	
		// 4. Reverse the suffix
		int left = vioIndex + 1;
		int right = num.length - 1; 
		while (left < right) {
			int temp = num[left];
			num[left] = num[right];
			num[right] = temp;
			left++;
			right--;
		}
		//MyUtility.displayArray(num);
	}

	// *****************************************************************************************
	// Given a collection of numbers that might contain duplicates
	// return all possible unique permutations.
	public static List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Integer[] arr = new Integer[num.length];
		boolean[] isVisited = new boolean[num.length];
		permuteUniqueDFS(num, isVisited, arr, 0, result);
		return result;
	}

	private static void permuteUniqueDFS(int[] num, boolean[] isVisited,
			Integer[] arr, int arr_i, List<List<Integer>> result) {
		if (arr_i == num.length) {
			result.add(Arrays.asList(arr.clone()));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			// skip the same number AND USED!
			if(i > 0 && num[i] == num[i-1] && isVisited[i-1] == true)  
			continue;  
			if (isVisited[i] == false) {
				arr[arr_i] = num[i];  
				isVisited[i] = true;
				permuteUniqueDFS(num, isVisited, arr, arr_i + 1, result);
				isVisited[i] = false; // backtracked to remove this num
			}
		}
	}

	// *****************************************************************************************
	// Given a 2D board and a word, find if the word exists in the grid.
	public static boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;
		boolean[][] isVisited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (existDFS(board, word, 0, i, j, isVisited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean existDFS(char[][] board, String word, int word_i,
			int i, int j, boolean[][] isVisited) {
		if (word_i == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (isVisited[i][j] == true) {
			return false;
		}
		if (word.charAt(word_i) != board[i][j]) {
			return false;
		}
		isVisited[i][j] = true;
		boolean next = existDFS(board, word, word_i + 1, i - 1, j, isVisited)
				|| existDFS(board, word, word_i + 1, i + 1, j, isVisited)
				|| existDFS(board, word, word_i + 1, i, j - 1, isVisited)
				|| existDFS(board, word, word_i + 1, i, j + 1, isVisited);
		isVisited[i][j] = false; // backtracked to remove this character
		return next;
	}

	// *****************************************************************************************
	// Given an integer n, return all distinct solutions to the n-queens puzzle.
    public static List<String[]> solveNQueens(int n) {
		int[] board = new int[n]; // i is row, board[i] is column
		List<String[]> result = new ArrayList<>();
		placeQueens(0, board, result);
		return result;
    }
    
    private static void placeQueens(int r, int[] board, List<String[]> result) {
		int n = board.length;
		if (r >= n) {
			printQueens(board, result);
			return;
		}
		for (int c = 0; c < n; c++) {
			if (isLegalPosition(r, c, board)) {
				board[r] = c; // place Queen
				placeQueens(r + 1, board, result);
				board[r] = 0; // backtracked to remove Queen (optional, value will be overwritten)
			}
		}
	}

	private static void printQueens(int[] board, List<String[]> result) {
		int n = board.length;
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
		    StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (board[i] == j) {
					sb.append("Q");
				} else {
					sb.append(".");
				}	
			}
			s[i] = sb.toString();
		}
		result.add(s);
	}

	private static boolean isLegalPosition(int r, int c, int[] board) {
		for (int i = 0; i < r; i++) {
			if (board[i] == c || // same column
					r - i == Math.abs((board[i] - c))) { // diagonal
				return false;
			}
		}
		return true;
	}
	
	// *****************************************************************************************
//	public static List<String> generateParenthesis(int n) {
//        
//    }
	
	
	// GameNim
	// the game begins with a pile of 13 coins in the center of a table.
	// On each turn, players take 1 - 3 coins from the pile and put them
	// aside. The player who takes the last coin loses.
	// returns true if the first player to pick can force a win with optimal play.
	// to be test
	public static boolean gameNim(int numCoin) {
		if (numCoin == 1){ //The player takes the last coin loses.
			return false;
		}
		for (int nTaken = 1; nTaken <= 3; nTaken++) {
			if (gameNim(numCoin - nTaken) == false) {
				return true;
			}
		}
		return false;
	}
	
	
	// *****************************************************************************************
	// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	// Combinations C(n, k)
	// Time O(n!) Space O(n!)  
	// Note if just print all combination, Space is O(k)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Integer[] arr = new Integer[k];
        combineHelper(1, n, arr, 0, result);
        return result;
     }

	private static void combineHelper(int start, int n, Integer[] arr, int cur, List<List<Integer>> result) {	    
		if (cur == arr.length) {
			result.add(Arrays.asList(arr.clone()));
			return;
		}
		for (int i = start; i <= n; i++) {
		    arr[cur] = i;
			combineHelper(i + 1, n, arr, cur + 1, result);
		}
	}
	
	// Given a set of candidate numbers (C) and a target number (T), 
	// find all unique combinations in C where the candidate numbers sums to T.
	// The same repeated number may be chosen from C unlimited number of times.
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, arr, result);
        return result;
	}

	private static void combinationSumHelper(int[] candidates, int target, int start, List<Integer> arr, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(arr));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target >= candidates[i]) {
			    arr.add(candidates[i]);
			    combinationSumHelper(candidates, target - candidates[i], i, arr, result);
			    arr.remove(arr.size() - 1);
			}
		}
	}
	
	// Each number in C may only be used once in the combination.
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
   		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<>();
        combinationSum2Helper(num, target, 0, arr, result);
        return result;
	}

	private static void combinationSum2Helper(int[] num, int target, int start, List<Integer> arr, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(arr));
			return;
		}
		for (int i = start; i < num.length; i++) {
			// avoid duplicate combinations
			if(i > start && num[i] == num[i-1]) continue;  
			
			if (target >= num[i]) {
			    arr.add(num[i]);
			    combinationSum2Helper(num, target - num[i], i + 1, arr, result);
			    arr.remove(arr.size() - 1);
			}
		}
	}
	
	// Given a set of distinct integers, S, return all possible subsets.
	// in non-descending order and no duplicates
	public static List<List<Integer>> subsets1(int[] S) {
		Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();
        subsets1Helper(S, 0, arr, result);
        return result;
    }

	private static void subsets1Helper(int[] num, int start, List<Integer> arr,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(arr));
		for (int i = start; i < num.length; i++) {
			arr.add(num[i]);
			subsets1Helper(num, i + 1, arr, result);
			arr.remove(arr.size() - 1);
		}
	}
	
	//2^n
	public static List<List<Integer>> subsets2(int[] S) {
		Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();
        subsets2Helper(S, 0, arr, result);
        return result;
    }
	
	private static void subsets2Helper(int[] num, int start, List<Integer> arr,
			List<List<Integer>> result) {
		if (start == num.length) {
			result.add(new ArrayList<>(arr));
			return;
		}
		// 不选num[start]
		subsets2Helper(num, start + 1, arr, result);
		// 选num[start]
		arr.add(num[start]);
		subsets2Helper(num, start + 1, arr, result);
		arr.remove(arr.size() - 1);
	}
	
	// Given a collection of integers that might contain duplicates S, 
	// return all possible subsets.
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();
        subsetsWithDupHelper(num, 0, arr, result);
        return result;
    }
	
	private static void subsetsWithDupHelper(int[] num, int start, List<Integer> arr,
			List<List<Integer>> result) {
	    result.add(new ArrayList<>(arr));
		for (int i = start; i < num.length; i++) {
		    if (i != start && num[i] == num[i-1]) continue;
			arr.add(num[i]);
			subsetsWithDupHelper(num, i + 1, arr, result);
			arr.remove(arr.size() - 1);
		}
	}
	
	// Letter Combinations of a Phone Number 
    public static List<String> letterCombinations(String digits) {
        String[] keyboard = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        char[] arr = new char[digits.length()];
        letterCombinationsHelper(digits, 0, keyboard, arr, 0, result);
        return result;
    }

	private static void letterCombinationsHelper(String digits, int start,
			String[] keyboard, char[] arr, int cur, List<String> result) {
		if (cur == digits.length()) {
			result.add(new String(arr));
			return;
		}
		int digit = (int)(digits.charAt(start) - '0');
		for (int i = 0; i < keyboard[digit].length(); i++) {
			arr[cur] = keyboard[digit].charAt(i);
			letterCombinationsHelper(digits, start + 1, keyboard, arr, cur + 1, result);
		}
	}
	
	// *****************************************************************************************
	// The gray code is a binary numeral system where two successive values differ in only one bit.
	// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
	// A gray code sequence must begin with 0.
	// 1. Math formula n XOR n/2
	//    Time O(2^n) Space O(1)
	public static List<Integer> grayCode1(int n) {
		List<Integer> result = new ArrayList<>();
		int size = 1 << n; // 2^n
		for (int i = 0; i < size; i++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
	
	// 2. Reflect and prefix (highest bit)
	// n = i时的Gray Code，相当于n = i-1时的Gray Code的逆序 加上 1 << i (highest bit stay same as binary code)
	// Time O(2^n) Space O(1)
	public static List<Integer> grayCode2(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for (int i = 0; i < n; i++) {
			int highestBit = 1 << i;
			int len = result.size();
			for(int j = len - 1; j >= 0; j--) {
				result.add(highestBit | result.get(j));
				// result.add(highestBit + result.get(j));
			}
		}
		return result;
	}
	// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	// Catalan number!!!
	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] arr = new char[n * 2];
        generateParentheseHelper(0, 0, n, arr, 0, result);
        return result;
    }
	
	private static void generateParentheseHelper(int l, int r, int n, char[] arr, int arr_i, List<String> result) {
		if (arr_i == arr.length) {
			result.add(new String(arr));	
			return;
		}
		if (l < n) {
			arr[arr_i] = '(';
			generateParentheseHelper(l + 1, r, n, arr, arr_i + 1, result);
		}
		if (r < l) {
			arr[arr_i] = ')';
			generateParentheseHelper(l, r + 1, n, arr, arr_i + 1, result);
		}
	}	
	
	// *****************************************************************************************
	// Palindrome Partitioning 1
	// Time O(2^n)
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		String[] arr = new String[s.length()];
		partitionHelper(s, 0, arr, 0, result );
        return result;
    }

	private static void partitionHelper(String s, int start, String[] arr, int arr_i, List<List<String>> result) {
		if (start == s.length()) {
			result.add(Arrays.asList(Arrays.copyOf(arr, arr_i)));
		}
		for (int len = 1; start + len <= s.length(); len++) {
			if (MyString.isPalindrome(s.substring(start, start + len))) {
				arr[arr_i] = s.substring(start, start + len);
				partitionHelper(s, start + len, arr, arr_i + 1, result );
			}
		}
	}
	
	// Palindrome Partitioning 2 
	// Return the minimum cuts needed for a palindrome partitioning of s.
	// Time O(2^n)
	// Exceed time limits, DP is the solution
    public static int minCut(String s) {
    	int[] min = new int[]{s.length() - 1};
        minCutHelper(s, 0, 0, min);
        return min[0];
    }
    
    private static void minCutHelper(String s, int start, int arr_i, int[] min) {
		if (start == s.length()) {
			if (arr_i - 1 < min[0]) {				
				min[0] = arr_i - 1;
			}
			return;
		}
		for (int len = 1; start + len <= s.length(); len++) {
		//for (int len = s.length() - start; len >= 1; len--) { // no need to go backwards
			if (MyString.isPalindrome(s.substring(start, start + len))) {
				minCutHelper(s, start + len, arr_i + 1, min);
				// first num of cut is not always the min cut
			}
		}
    }
    
    //Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    public List<String> restoreIpAddresses(String s) {
        return null;
    }
}
