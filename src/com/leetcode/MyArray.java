package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyArray {
	
	// LC-283. Move Zeroes - Given an array nums, move all 0's to the end 
	// while maintaining the relative order of the non-zero elements.
	// Time O(n) Space O(1)
	// ** Two pointer **
    public static int[] moveZeroes1(int[] nums) {
        int dest = 0;
        for (int src = 0; src < nums.length; src++) {
            if ( nums[src] != 0) {
                nums[dest] = nums[src];
                dest++;
            } 
        }
        // fill in the rest with 0's.
        Arrays.fill(nums, dest, nums.length, 0);
        // while (dest < nums.length) {
        //     nums[dest]=0;
        //     dest++;
        // }
        return nums;
    }

	// Given an array of integers,
	// find two numbers such that they add up to a specific target number
	// Assume that each input would have exactly one solution? -- non repetitive number
	public static int[] twoSum1(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int remainder = target - numbers[i]; // use remainder as search key
			if (map.containsKey(remainder)) {
				result[0] = map.get(remainder);
				result[1] = i;
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
	// Elements in a triplet (a,b,c) must be in non-descending order.
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
		while (i + 1 < num.length && num[i + 1] == num[i]) {
			i++;
		}
		return ++i;
    }

    private  static int getNextLeftDiffNum(int[] num, int i) {
		while (i - 1 >= 0 && num[i - 1] == num[i]) {
			i--;
		}
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
	// Elements in a quadruplet (a,b,c,d) must be in non-descending order.
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
	// find maxim occurrence
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
	
	
	// LC-485. Max Consecutive Ones
	// Given a binary array, find the maximum number of consecutive 1's
	// Time O(n) Space O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int curMax = 0;
        int cur = 0;
        for (int n: nums) {
            if (n == 1) {
                cur++;
                curMax = Math.max(curMax, cur);
            } else {
                cur = 0;
            }    
        }
        return curMax;
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

	// LC-53. Maximum Subarray Find the sub array that yields the largest SUM;
	// {} return Integer.MIN_VALUE
	// Time O(n), Space O(1) *sliding window*
	public static int maxSubArray1(int[] A) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			cur = Math.max(cur + A[i], A[i]);
			max = Math.max(max, cur);
		}
		return max;
	}
	
	
    // Calculate the maximum sum of k consecutive elements in the array. K <= arr.length
    // Time O(n), Space O(1) *sliding window*
    public static int maxKSumSubarray(int[] arr, int k) {
    	// find first k window sum
    	int cur = 0;
    	for (int i = 0; i < k; i++) {
    		cur += arr[i];
    	}
    	
    	int max = cur;
    	for (int i = k; i < arr.length; i++) { 
    		cur = cur + arr[i] - arr[i - k];
    		max = Math.max(max, cur);
    	}
    	return max;
    }
    
    // LC-1456. Maximum Number of Vowels in a Substring of Given Length
    // Return the maximum number of vowel letters in any substring of s with length k.
    // Assume s consists of lowercase letters, 1 <= k <= s.length
    // Time O(n), Space O(1) *sliding window*
    public static int maxVowels(String s, int k) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int cur = 0;
        for (int i = 0; i < k;  i++) {
            if (vowels.contains(s.charAt(i))) {
                cur++;
            }
        }
        int max = cur;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                cur++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                cur--;
            }
            max = Math.max(max, cur);
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
        if (n == 0) {
			return matrix;
		}

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
    	if (numCopy[0].equals("0")) {
			return "0";
		}

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

    // Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    // Find all the elements of [1, n] inclusive that do not appear in this array.
    // Sorting - Time O(nlogn), Space O(1)
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        // 1 ≤ j ≤ nums[i]
        for (int i = 0, j = 1; j <= nums.length; ) {
            if (i == nums.length || j < nums[i]) {
                result.add(j);
                j++;
            } else if (j == nums[i]) {
                j++;
                i++;
            } else {
              i++;
            }
        }
        return result;
    }

    // Sorting [0...n] - Time O(nlogn), Space O(1)
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] numsToSearch = new int[len + 2];
        numsToSearch[0] = 0;
        numsToSearch[numsToSearch.length - 1] = len;
        for (int i = 1; i <= nums.length; i++) {
        	numsToSearch[i] = nums[i-1];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 1; j < numsToSearch.length; i++, j++ ) {
            if (numsToSearch[j] == numsToSearch[i] + 1) {
				continue;
			}
            for (int num = numsToSearch[i] + 1; num < numsToSearch[j]; num++) {
            	result.add(num);
            }
        }
        return result;
    }

    // Boolean Array - Time O(n), Space O(n)
    public static List<Integer> findDisappearedNumbers3(int[] nums) {

        List<Integer> result = new ArrayList<>();

        return result;
    }

    // Given a binary matrix A, flip the image horizontally, then invert it, and return the resulting image.
    // Time O(n), Space O(1)
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        // reverse each row [1,1,0] - > [0,1,1]
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][len-j];
                A[i][len-j] = tmp;
            }
        }

        //invert 0->1, 1->0
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = 1-A[i][j] ;
            }
        }
        return A;
    }

    // Given a string, find the first non-repeating character in it and return it's index.
    // If it doesn't exist, return -1.
    // Time O(n), Space O(N)
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
    	for (int i = 0; i < s.length(); i++) {
    		Character c = s.charAt(i);
    		if (map.containsKey(c)) {
    			map.put(c, map.get(c)+1);
    		} else {
    			map.put(c, 1);
    		}
    	}
    	for (int i = 0; i < s.length(); i++) {
    		Character c = s.charAt(i);
    		if (map.get(c) == 1) {
    			return i;
    		}
    	}
        return -1;
    }
    
    // LC-645. Set Mismatch
    // Given an array nums [1...n], one number got duplicated to another number
    // find the number occurs twice and the missing number.
    // Space O(n), Time O(n)
    public static int[] findErrorNums1(int[] nums) {
        int[] result = new int[2];
        int[] count = new int[nums.length]; // array used as hashmap
        for (int n: nums) {
            count[n - 1] += 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) { // missing number
                result[1] = i + 1; 
            } else if (count[i] == 2) { // duplicated number
                result[0] = i + 1;
            }
        }
        return result;
    }
    
    // Space O(1), Time O(n)
    public static int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] < 0) {
                // dup
                result[0] = n;
            } else {
            	// Inversion, mark nums[n-1] as negative number
                nums[n-1] = -nums[n-1]; 
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i+1;
            }
        }
        return result;
    }
    
    // LC-697. Degree of an Array
    // Find the smallest possible length of a subarray that has the same degree as nums.
    // The degree is defined as the maximum frequency of any one element.
    // Space O(n), Time O(n)
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
                firstIndex.put(n, i);
            }
            lastIndex.put(n, i);
        }
        
        int degree = Collections.max(count.values());
        int shortestSubArrayLen = nums.length;
        for (int n : nums) {
            if (count.get(n) == degree) {
                shortestSubArrayLen = Math.min(shortestSubArrayLen, lastIndex.get(n) - firstIndex.get(n) + 1);
            }
        }
        return shortestSubArrayLen;
    }
    
    // LC-667. Beautiful Arrangement II
    // Given two integers n and k (1 <= k < n), construct an array with number [1,n] and
    // [|a1 - a2|, |a2 - a3|, ... , |an-1 - an|] has exactly k distinct integers.
    // Time O(n), Space O(n)
    public static int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        // padding in natural order 1...n-k-1
        for (int i = 0; i < n - k - 1; i++) {
            arr[i] = i + 1;
        }
        // **Algorithm: remaining {[n-k, n-k+1, ...,n--, n]}
        boolean isSmall = true;
        int small = n - k;
        int large = n;
        for (int i = n - k - 1; i < n; i++) {
            arr[i] = isSmall ? small++ : large--;
            isSmall = !isSmall;
        }
        return arr;
    }
    
    // LC-769. Max Chunks To Make Sorted
    // Split the array into "chunks" (partitions), and individually sort each,
    // the concatenated result equals the sorted array
    // Time O(n), Space O(1)
    public static int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
    
    // LC-565. Array Nesting
    // A zero-indexed array A of length N contains all integers from 0 to N-1. 
    // Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }, 
    // stop adding before a duplicate element occurs
    // Brute Force Speed O(n^2), Space O(1)
    public static int arrayNesting1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i, count = 0;
            do {
                start = nums[start];
                count++;
            } while (start != i);
            res = Math.max(res, count);
        }
        return res;
    }
    
    // Space O(n), Space O(1) *visited array*
    public static int arrayNesting2(int[] nums) {
    	boolean[] isVisited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (!isVisited[i]) {
                int start = i, count = 0;
                do {
                    start = nums[start];
                    count++;
                    isVisited[start] = true;
                } while (start != i);
                res = Math.max(res, count);
            }
        }
        return res;
    }
    
    // LC-581. Shortest Unsorted Continuous Subarray
    // Find one continuous subarray that if you only sort this subarray in ascending order, 
    // then the whole array will be sorted.
    // Time O(nlogn), Space O(n)
    public static int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int left, right;
        for (left = 0; left < nums.length && nums[left] == sortedNums[left]; left++);       
        for (right = nums.length - 1; right >= 0 && nums[right] == sortedNums[right]; right--);
        return right - left + 1 < 0 ? 0 : right - left + 1;
    }
    

}
