package com.leetcode;

import java.util.ArrayList;

public class Searching {
	// Given a sorted array and a target value, 
	// return the index if the target is found.
	// If not, return the index where it would be if it were inserted in order.
	public static int searchInsert(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			// three-way comparison
			if (target == A[mid]) {
				return mid;
			} else if (target < A[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	// return the first position of target
    public int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
	
    // *****************************************************************************************
    // Search for a Range 
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int index1 = binarySearchBound(A, target, true);
        int index2 = binarySearchBound(A, target, false);
        result.add(index1);
        result.add(index2);
        return result;
    }
    
    public int binarySearchBound(ArrayList<Integer> A, int target, boolean isLeft) {
        int left = 0;
        int right = A.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A.get(mid) == target) {
                result = mid;
                if (isLeft) {
                	right = mid - 1;
                } else {
                	left = mid + 1;
                }
            } else if (A.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // *****************************************************************************************
	// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	// Find the minimum element, assume no duplicate exists in the array.
	// Time O(logN) Space O(1)
    public static int findMin1(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (num[left] > num[right]) { // as long as it is rotated
            int mid = (left + right) / 2; 
            if (num[mid] > num[right])
              left = mid + 1;
            else
              right = mid;
        }
        return num[left] ;
    }
    
    public static int findMin2(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if ((mid == num.length - 1 || num[mid] < num[mid + 1]) && 
            	(mid == 0 || num[mid] < num[mid - 1])){
                return num[mid];
            } 
            if (num[mid] < num[right]){ //right subarray is sorted
                right = mid;
            } else { // left subarray is sorted
                left = mid + 1;
            }
        }
        return -1;
    }
    
    // *****************************************************************************************
 	// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 	// Find the minimum element, array may contain duplicates.
    // Time O(n) Space O(1)
    public static int findMin3(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (left < right){
            if (num[left] < num[right]) {
                return num[left];
            }
            int mid = (left + right) / 2;
            if ((mid == num.length - 1 || num[mid] < num[mid + 1]) && 
            	(mid == 0 || num[mid] < num[mid - 1])){
                return num[mid];
            } 
            if (num[mid] < num[right]){ //right subarray is sorted
                right = mid;
            } else if (num[mid] > num[right]) { //left subarray is sorted
                left = mid + 1;
            } else{
                left++;
            }
        }
        return num[left];
    }
    
    public int findMin(int[] num) {
        int min = Integer.MAX_VALUE;
        for (int n: num) {
            min = Math.min(n,min);
        }
        return min;
    }
    
    
    // *****************************************************************************************
    // Search in Rotated Sorted Array 
    // Assume no duplicate exists in the array.
    // Time O(logN) Space O(1)
    public static int search1(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (A[mid] == target) {
        		return mid;
        	} 
        	// right is sorted half and left is rotated half
            if (A[mid] < A[left]) { 
                if ( target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // left is sorted half and right is rotated half
                if (target < A[mid] && target >= A[left]) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
    	return -1;
    }
    
    // Search in Rotated Sorted Array 
    // Duplicate exists in the array.
    // Time O(n) Space O(1)
    public static boolean search2(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (A[mid] == target) {
        		return true;
        	} 
        	// right is sorted half and left is rotated half
            if (A[mid] < A[left]) { 
                if ( target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (A[mid] > A[left] ){ // left is sorted half and right is rotated half
                if (target < A[mid] && target >= A[left]) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
    	return false;
    }
    
    // Better choice for simplicity
    public static boolean search3(int[] A, int target) {
        for(int i = 0; i < A.length; i++) {
            if (A[i] == target){
                return true;
            }
        }
        return false;
     }
    
    // *****************************************************************************************
    // Search matrix 1
    // Integers in each row are sorted from left to right.
    // The first integer of each row is greater than the last integer of the previous row.
    // Time O (log(m*n)), Space O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int r = matrix.length;
    	if (r == 0) {
    		return false;
    	}
    	int c = matrix[0].length;
    	
    	int first = 0;
    	int last = r * c - 1;
    	
    	while (first <= last) {
    		int mid = (first + last) / 2;
    		int value = matrix[mid / c][mid % c];
    		if (value == target) {
    			return true;
    		} else if (value < target) {
    			first = mid + 1;
    		} else {
    			last = mid - 1;
    		}
    	}
        return false;
    }  
    
    // *****************************************************************************************
    // Search matrix 2
    // Return the occurrence of target
    // Integers in each row are sorted from left to right.
    // Integers in each column are sorted from up to bottom.
    // No duplicate integers in each row or column.
    // Time O(m + n), Space O(1)
    public static int searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length; // row
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length; // col
        
        int count = 0;
        int col = 0;
        int row = m - 1;
        while (col <= n - 1 && row >= 0) {
            int mid = matrix[row][col];
            if (mid == target){
                count++;
                col++;
                row--;
            } else if (mid < target) { // go right
                col++;
            } else { // go up
                row--;
            }
        }
        return count;
    }
    
    // *****************************************************************************************
    // The code base version is an integer and start from 1 to n.
    // Return an integer which is the first bad version.
    // Time O(logN) -- call isBadVersion less than O(logN)) times.
    public static class VersionControl {
         public static boolean isBadVersion(int k) {
			return false;
		}
    }

    public int findFirstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int mid = (left + right) / 2;
            if (VersionControl.isBadVersion(mid) == true){
            	if (mid == 1 || (mid >= 2 && !VersionControl.isBadVersion(mid - 1))){
                    return mid;
                } else {
                   right = mid - 1; 
                }
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
    
    // *****************************************************************************************    
    // A peak element is an element that is greater than its neighbors.
    // Given an input array where num[i] ≧ num[i+1], find a peak element and return its index.
    // Assume that num[-1] = num[n] = -﹢.
    // Time O(logn) Space O(1)
    public static int findPeakElement(int[] num) {
        int left = 0;
        int right = num.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0 || num[mid] > num[mid - 1]) {
                if (mid > num.length - 2 || num[mid] > num[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return 1; // seems unreachable
    }
    
    // *****************************************************************************************
    // Given a sorted array of integers, find the starting and ending position of a given target value.
    // If the target is not found in the array, return [-1, -1].
    // Time O(logn) Space O(1)
    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1, -1};
        // 砃酘標排  find most left target A[left1]
        int left1 = 0;
        int right1 = A.length - 1;
        while (left1 <= right1) {
        	int mid = (left1 + right1) / 2;
        	if (A[mid] >= target) {
        		right1 = mid - 1;	
        	} else {
        		left1 = mid + 1;
        	} 
        }
        
        // 砃衵標排 find right most target A[right2]
        int left2 = 0;
        int right2 = A.length - 1;
        while (left2 <= right2) {
        	int mid = (left2 + right2) / 2;
        	if (A[mid] <= target) {
        		left2 = mid + 1;
        	} else {
        		right2 = mid - 1;
        	} 
        }

        if (left1 <= right2) {
        	result[0] = left1;
        	result[1] = right2;
        }
        return result;
    }
    
    
    
    
}
