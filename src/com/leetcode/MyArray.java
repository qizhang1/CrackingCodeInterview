package com.leetcode;


import java.util.*;

public class MyArray {

	// Given an array of integers,
	// find two numbers such that they add up to a specific target number
	// Assume that each input would have exactly one solution? -- non repetitive number
	public static int[] twoSum1(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int remainder = target - numbers[i]; // use remainder as search key
			if (map.containsKey(remainder)) {
				result[0] = map.get(remainder) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i); // <number, index>
			}
		}
		return result;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		// preprocessing, store <value, index> pair in an arrayList
		ArrayList<Integer> index_value_list = new ArrayList<Integer>(
				numbers.length);
		for (int i = 0; i < numbers.length; i++) {
			index_value_list.add(i, numbers[i]);
		}
		// sort O(log N)
		Arrays.sort(numbers);

		int[] result = new int[2];
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int remainder = target - numbers[start];
			if (remainder == numbers[end]) {
				// found
				int index1 = index_value_list.indexOf(numbers[start]);
				int index2 = index_value_list.lastIndexOf(numbers[end]);
				result[0] = Math.min(index1, index2) + 1;
				result[1] = Math.max(index1, index2) + 1;
				break;
			} else if (remainder < numbers[end]) {
				end--;
			} else {
				start++;
			}
		}
		return result;
	}
	
	// *****************************************************************************************
	// 3Sum
	// Find all unique triplets (a,b,c)in the array which gives a + b + c = 0.
	// Elements in a triplet (a,b,c) must be in non-descending order. (a ¡Ü b ¡Ü c)
	// Time O(n2) Space O(1)
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int a = 0; a < num.length - 2 && num[a] <= 0; a = getNextRightDiffNum(num, a))
		{
			int b = a + 1;
		    int c = num.length - 1;
		    while (b < c) {
		    	if (num[a] + num[b] + num[c] == 0) {
					//found one triplet
					List<Integer> triplet = Arrays.asList(num[a], num[b], num[c]);
					result.add(triplet);
					b = getNextRightDiffNum(num, b);
					c = getNextLeftDiffNum(num, c);
				} else if (num[a] + num[b] + num[c] > 0) {
					c = getNextLeftDiffNum(num, c);
				} else {
					b = getNextRightDiffNum(num, b);
				}
		    }
		    
		}
		return new ArrayList<List<Integer>>(result);
    }

    private static int getNextRightDiffNum(int[] num, int i) {
		while (i + 1 < num.length && num[i + 1] == num[i]) i++;
		return ++i;
    }
    
    private  static int getNextLeftDiffNum(int[] num, int i) {
		while (i - 1 >= 0 && num[i - 1] == num[i]) i--;
		return --i;
    }

	// use HashSet
	// Time O(n2) Space O(n)
	public List<List<Integer>> threeSum2(int[] num) {
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		for (int a = 0; a < num.length - 2 && num[a] <= 0; a++) {
			int b = a + 1;
			int c = num.length - 1;
			while (b < c) {
				if (num[a] + num[b] + num[c] == 0) {
					// found one triplet
					List<Integer> triplet = Arrays.asList(num[a], num[b],
							num[c]);
					result.add(triplet);
					b++;
					c--;
				} else if (num[a] + num[b] + num[c] > 0) {
					c--;
				} else {
					b++;
				}
			}
		}
		return new ArrayList<List<Integer>>(result);
	}
	
	// *****************************************************************************************
	// Given an array S of n integers, find three integers in S such that the sum is closest to a given target. 
	// Return the sum of the three integers. 
	// Assume that each input would have exactly one solution.
	// Time O(n2) Space O(1)
	public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
		int result = 0;
        int diff = Integer.MAX_VALUE;
        for (int a = 0; a < num.length - 2; a++) {
        	int b = a + 1;
        	int c = num.length - 1;
        	while (b < c) {
        		int sum = num[a] + num[b] + num[c];
        		if (sum == target) {
        		    return sum;
        		}
                if (Math.abs(target - sum) < diff){
        		    diff = Math.abs(target - sum);
        			result = sum;
        		}
        		if (target - sum > 0) {
        		    b++;
        		} else {
        		    c--;
        		}
        	}        	
        }
		return result;
    }
	
	
	// *****************************************************************************************
	// Find all unique quadruplets in the array which gives the sum of target
	// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
	// Time O(n3) Space O(n)
    public static List<List<Integer>> fourSum1(int[] num, int target) {
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		for (int a = 0; a < num.length - 3; a++) {
			for (int b = a + 1; b < num.length - 2; b++) {
				int c = b + 1;
				int d = num.length - 1;
				while (c < d) {
					int sum = num[a] + num[b] + num[c] + num[d];
					if ( sum == target) {
						// found one quadruplet
						List<Integer> quadruplet = Arrays.asList(num[a], num[b], num[c], num[d]);
						result.add(quadruplet);
						c++;
						d--;
					} else if (sum > target) {
						d--;
					} else {
						c++;
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(result);
    }
	
	// Given an sorted positive integer array
	// find maxium occurrence
	public static int findMaxOccurance(int[] arr) {
		int max = 0;
		int count = 0; // count for each element
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] == arr[i - 1]) {
				count++; // update
				if (count > max) { // compare
					max = count;
				}
			} else {
				count = 1; // reset
			}
		}
		return max;
	}

	// Given a sorted array, remove the duplicates in place
	// return the new length.
	// Time O(n) Space O(1)
	public static int removeDuplicates1(int[] A) {

		if (A.length == 0) {
			return 0;
		}
		int dest = 1; // next available element
		for (int src = 1; src < A.length; src++) {
			if (A[src] != A[dest - 1]) { // this is not a duplicate
				A[dest] = A[src];
				dest++;
			}
		}
		return dest;
	}

	// Given a sorted array, remove the duplicates in place
	// return the new length.
	// duplicates are allowed at most twice
	// Time O(n) Space O(1)
	public static int removeDuplicates2(int[] A) {
		if (A.length < 3) {
			return A.length;
		}
		int dest = 2;
		for (int src = 2; src < A.length; src++) {
			if (A[src] != A[dest - 1]
					|| (A[src] == A[dest - 1] && A[dest - 1] != A[dest - 2])) {
				A[dest] = A[src];
				dest++;
			}
		}
		return dest;
	}

	// Given an array and a value, remove all instances of that value in place
	// return new length O(N)
	public static int removeElement(int[] A, int elem) {
		int dest = 0;
		for (int src = 0; src < A.length; src++) {
			if (A[src] != elem) {
				A[dest] = A[src];
				dest++;
			}
		}
		return dest;
	}

	// remove duplicates from an unsorted array

	// Given two sorted integer arrays A and B merge B into A as one sorted
	// array
	// assume that A has enough space (size is >= to m + n) to hold additional
	// elements from B.
	// The number of elements initialized in A and B are m and n respectively
	public static void mergeTwoSortedArrays(int A[], int m, int B[], int n) {
		// loop backwards
		int indexA = m - 1;
        int indexB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (indexA >= 0 && indexB >= 0){
                A[i] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
            } else if (indexB >= 0){
                A[i] = B[indexB--];
            }
        }
	}

	// Find the sub array that yields the largest SUM;
	// {} return Integer.MIN_VALUE
	// Time O(n), Space O(1)
	public static int maxSubArray1(int[] A) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			cur = Math.max(cur + A[i], A[i]);
			if (cur > max) {
				max = cur;
			}
		}
		return max;
	}

	// Find the largest subsequence of the given array that yields the largest
	// PRODUCT

	// *****************************************************************************************
	// Given a m * n matrix, if an element is 0,
	// set its entire row and column to 0 in place
	// Time O(m*n), Space O(1)
	public static void setZeroes1(int[][] matrix) {
		int col = matrix[0].length;
		boolean isFirstRowZero = false;
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0) {
				isFirstRowZero = true;
				break;
			}
		}

		int row = matrix.length;
		boolean isFirstColZero = false;
		for (int j = 0; j < row; j++) {
			if (matrix[j][0] == 0) {
				isFirstColZero = true;
				break;
			}
		}

		// Use 1st row and 1st col to track
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0; // row
					matrix[0][j] = 0; // col
				}
			}
		}
		// Ready to set zeros
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				// set row
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// set 1st row
		if (isFirstRowZero) {
			for (int j = 0; j < col; j++) {
				matrix[0][j] = 0;
			}
		}
		// set 1st col
		if (isFirstColZero) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// Time O(m*n), Space O(m+n)
	public static void setZeroes2(int[][] matrix) {
		int row = matrix.length;
		boolean[] isRowHasZero = new boolean[row];
		int col = matrix[0].length;
		boolean[] isColHasZero = new boolean[col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					isRowHasZero[i] = true;
					isColHasZero[j] = true;
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (isRowHasZero[i] || isColHasZero[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// *****************************************************************************************
	public static boolean isValidSudoku(char[][] board) {
		int row = 9;
		int col = 9;
		boolean[] used = new boolean[9];
		// check each row
		for (int i = 0; i < row; i++) {
			resetTest(used);
			for (int j = 0; j < col; j++) {
				if (!test(board[i][j], used)) {
					return false;
				}
			}
		}
		// check each col
		for (int j = 0; j < col; j++) {
			resetTest(used);
			for (int i = 0; i < col; i++) {
				if (!test(board[i][j], used)) {
					return false;
				}
			}
		}
		// check sub-box
		int numSubbox = 3;
		for (int n = 0; n < numSubbox; n++) {
			for (int m = 0; m < numSubbox; m++) {
				resetTest(used);
				for (int i = 3 * n; i < 3 * n + 3; i++) {
					for (int j = 3 * m; j < 3 * m + 3; j++) {
						if (!test(board[i][j], used)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private static void resetTest(boolean[] test) {
		for (int i = 0; i < test.length; i++) {
			test[i] = false;
		}
	}

	private static boolean test(char c, boolean[] test) {
		if (c == '.') {
			return true;
		}
		if (test[c - '1']) {
			return false;
		}
		test[c - '1'] = true;
		return true;
	}

	// *****************************************************************************************
	// given an n x n 2D matrix representing an image,
	// Rotate the image by 90 degrees (clockwise) in place
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		// Flip
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}

		// Transpose
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
				matrix[n - 1 - j][n - 1 - i] = temp;
			}
		}
	}

	// Given numRows, generate the first numRows of Pascal's triangle.
	public static List<List<Integer>> Pascal1(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			Integer[] row = new Integer[i + 1];
			row[0] = 1;
			for (int j = 1; j < i; j++) {
				int n = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
				row[j] = n;
			}
			row[i] = 1;
			result.add(Arrays.asList(row));
		}
		return result;
	}

	// return the kth row of the Pascal's triangle
	public static List<Integer> PascalGetRow(int rowIndex) {
		Integer[] row = new Integer[rowIndex + 1];
		row[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			row[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				row[j] = row[j] + row[j - 1];
			}
		}
		return Arrays.asList(row);
	}
	
	// Given an array of size n, find the majority element. 
	// The majority element is the element that appears more than |_ n/2 _| times.
	// Assume that the array is non-empty and the majority element always exist in the array.
	// Time O(n), Space O(n)
    public static int majorityElement1(int[] num) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (hm.containsKey(num[i])) {
                hm.put(num[i],hm.get(num[i])+1);
            } else {
                hm.put(num[i],1);
            }
            if (hm.get(num[i]) > num.length / 2) {
                return num[i];
            } 
        }
        return -1; // not found
    }
    // Moore Majority Voting algorithm
    // Assume that the array is non-empty and the majority element always exist in the array.
    // Time O(n), Space O(1)
    public static int majorityElement2(int[] num) {
    	int candidate = 0;
    	int counter = 0;
    	for (int n : num) {
    		if (counter == 0) { // no candidate
    			candidate = n;
    			counter = 1;
    		} else if (n == candidate) {
    			counter++;
    		} else {
    			counter--;
    		}
    	}
    	return candidate;
    }

	public static int getMinValue(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < min) {
				min = arr[j];
			}
		}
		return min;
	}
	
	// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	// Time O(n^2) Space O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<>();
    	if (matrix.length == 0) {
    		return result;
    	}
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        
        for (; startRow <= endRow && startCol <= endCol; startRow++, endRow--, startCol++, endCol--) {
        	for (int i = startCol; i <= endCol; i++) {
        		result.add(matrix[startRow][i]);
        	}
        	for (int j = startRow + 1; j < endRow; j++) {
        		result.add(matrix[j][endCol]);
        	}
        	for (int k = endCol; k >= startCol && startRow < endRow; k--) {
        		System.out.println(matrix[endRow][k]);
        		result.add(matrix[endRow][k]);
        	}
        	for (int h = endRow -1; h > startRow && startCol < endCol; h--) {
        		result.add(matrix[h][startCol]);
        	}
        }
        return result;
    }
    
    // Spiral Matrix II 
    // Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    // Time O(n^2) Space O(n^2)
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        
        int start = 0;
        int end = matrix.length - 1;
        
        // for (int num = 1; start <= end
        for (int num = 1; num <= n * n; start++, end--){
        	for (int i = start; i <= end; i++) {
        		matrix[start][i] = num;
        		num++;
        	}
        	
        	for (int j = start + 1; j < end; j++) {
        		matrix[j][end] = num;
        		num++;
        	}
        	
        	for (int k = end; k>= start && start< end; k--) {
        		matrix[end][k] = num;
        		num++;
        	}
        	
        	for (int h = end - 1; h > start && start < end; h--) {
        		matrix[h][start] = num;
        		num++;
        	}
        }
        return matrix;
    }
    
    // *****************************************************************************************
    // Rotate an array of n elements to the right by k steps.
    // Time O(n) Space O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // in case k is out of boundary
        reverseArr(nums, 0, n - 1); // reverse all
        reverseArr(nums, 0, k - 1); // reverse first k
        reverseArr(nums, k, n - 1); // reverse later n - k
    }
    
    private static void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
        	// swap
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    // *****************************************************************************************
    // Given a list of non negative integers, arrange them such that they form the largest number.
    public static String largestNumber(int[] num) {	
//    	if (num.length == 0) {
//    		return "";
//    	}
    	String[] numCopy = new String[num.length];
    	for (int i = 0; i < num.length; i++) {
    		numCopy[i] = Integer.toString(num[i]);
    	}
    	// sort in descending order
    	Comparator<String> comparator = Collections.reverseOrder(new IntegerComparator());
    	Arrays.sort(numCopy, comparator);

    	// special case [0, 0, ...]
    	if (numCopy[0].equals("0")) return "0";
    	
    	// concatenate biggest number
    	StringBuilder result = new StringBuilder();
    	for (int i = 0; i < num.length; i++) {
    		result.append(numCopy[i]);
    	}
    	return result.toString();
    }
    // return 1 if n1 + n2 is greater than n2 + n1
    static class IntegerComparator implements Comparator<String> {
		@Override
		public int compare(String n1, String n2) {	
			return (n1 + n2).compareTo(n2 + n1); 
		}
    }
    
    // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    // Time O(n) -- each num is add once and remove once
    public static int longestConsecutive(int[] num) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : num) {
        	hs.add(n);
        }
        int max = 0;
        for (int n : num){
        	hs.remove(n);
        	int count = 1;
        	int low = n - 1;
        	while (hs.contains(low)){
        		hs.remove(low);
        		count++;
        		low--;
        	}
        	int high = n + 1;
        	while (hs.contains(high)){
        		hs.remove(high);
        		count++;
        		high++;
        	}
        	max = Math.max(max, count);
        }
        return max;
    }
    

    
}
