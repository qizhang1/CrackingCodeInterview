package com.leetcode;

public class Algorithm_Greedy {
	
	// Best Time to Buy and Sell Stock I
	// only permitted to complete at most one transaction (buy or sale) at the same day
    public static int maxProfit1(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // track the lowest stock price
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
                continue;
            }
            // current best profit
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; 
            }
        }
        return maxProfit;
    }

	// Best Time to Buy and Sell Stock II
	// allow multiple transactions at the same day
	public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1] ;
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return maxProfit;
	}
	
	// Gas Station
	// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length;
    	// Find start index of an subarray that maintain positive sum till the end
    	int cur = 0; // current
        int total = 0; 
        int index = 0;
        for (int i = 0; i < n; i++) {
        	int netCost = gas[i] - cost[i];
        	total += netCost;
        	if (cur + netCost < 0) {
        		cur = 0;
        		index = i + 1;
        	} else {
        		cur += netCost;
        	}
        }
        return total>= 0 ? index : -1;
    }
    
    public static int maxSubArray(int[] arr) {
    	int maxSum = 0;
    	int curSum = 0;
    	for (int i = 0; i < arr.length; i++) {
    		curSum += arr[i];
    		if (curSum < 0) {
    			curSum = 0;
    		}else if (curSum > maxSum) {
    			maxSum = curSum;
    		}
    	}
    	return maxSum;	
    }
  
	// *****************************************************************************************
    // Given an array of non-negative integers, you are initially positioned at the first index of the array.
    // Each element in the array represents your maximum jump length at that position.
    // Determine if you are able to reach the last index.  
    // Time O(n) Space O(1)
    public static boolean canJump(int[] A) {
    	int i = 0;
    	int lastLookedUp = 0;
    	while (i != A.length - 1) {
    		if (A[i] == 0) {
    			return false;
    		}
    		// select next Jump Index
        	int nextJumpIndex = 0;
    		if (i + A[i] >= A.length - 1) {
    			nextJumpIndex = A.length - 1;
    		} else {
				int max = 0;
				for (int j = lastLookedUp + 1; j <= A[i] + i; j++) {
					if (A[j] + j >= max ) {
					    max = A[j] + j;
						nextJumpIndex = j;
					}
				}
				lastLookedUp = A[i] + i;
    		}
    		// update i
			i = nextJumpIndex;
    	}
    	return true;
    }
    
    // *****************************************************************************************
    // return minimum number of jumps to reach the last index
    public static int jump(int[] A) {
    	int i = 0;
    	int lastLookedUp = 0;
    	int jump = 0;
    	while (i != A.length - 1) {
    		if (A[i] == 0) {
    			return -1;
    		}
    		// select next Jump Index
        	int nextJumpIndex = 0;
    		if (i + A[i] >= A.length - 1) {
    			nextJumpIndex = A.length - 1;
    		} else {
				int max = 0;
				for (int j = lastLookedUp + 1; j <= A[i] + i; j++) {
					if (A[j] + j >= max ) {
					    max = A[j] + j;
						nextJumpIndex = j;
					}
				}
				lastLookedUp = A[i] + i;
    		}
    		// update i
			i = nextJumpIndex;
			jump++;
    	}
    	return jump;  
    }
    
    // *****************************************************************************************
    // Container With Most Water 
    // Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
    // n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
    // Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    public static int maxArea(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if ( area > max) {
                max = area;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
