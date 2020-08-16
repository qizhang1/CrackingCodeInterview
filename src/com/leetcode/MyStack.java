package com.leetcode;

import java.util.*;

public class MyStack {
	// LC-20. Valid Parentheses
	// Time O(n), Space O(n)
	public static boolean isValid(String s){
		Stack<Character> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);     
            if (c == '(' || c == '{' || c == '['){
                bracket.push(c); 
            }else {
                if (bracket.empty()){
                    return false;
                }else{
                    char top = bracket.pop();
                    if (c == ')' && top != '('||
                        c == '}' && top != '{' ||
                        c == ']' && top != '['){
                         return false;
                    }
                }
            }
        }
		return bracket.empty();
	}
	
	// Time O(n), Space O(n) 
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty() ) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (map.get(top) != s.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
	
	// *****************************************************************************************
	// LC-155. Min Stack
	// supports push, pop, top, and retrieving the minimum element in constant time
	// Time O(1), Space O(n) 
	class MinStack1 {
	    Stack<Integer> stack = new Stack<>();
	    Stack<Integer> minStack = new Stack<>();
	    
	    public void push(int x) {
	        stack.push(x);
	        if (minStack.empty() || x <= minStack.peek()) { 
	            minStack.push(x);
	        } 
	    }

	    public void pop() {
	        int x = stack.pop();
	        if (x == minStack.peek()) {
	            minStack.pop();
	        }
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return minStack.peek();
	    }
	}

	class MinStack2 {
	    Stack<Integer> stack = new Stack<>();
	    Stack<Integer> minStack = new Stack<>(); // push current min, keep same size as stack
	    
	    public void push(int x) {
	        stack.push(x);
	        if (minStack.empty() || x < getMin()) {
	            minStack.push(x);
	        } else {
	            minStack.push(getMin());
	        }
	    }

	    public void pop() {
	        stack.pop();
	        minStack.pop();

	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return minStack.peek();
	    }
	}

	// LC-225. Implement Stack using Queues
	class QStack {
	    Queue<Integer> q = new LinkedList<>();
	    Queue<Integer> tmp = new LinkedList<>();
	    // Time O(n)
	    public void push_2Q(int x) {
	        while (!q.isEmpty()) {
	            tmp.add(q.remove());
	        }
	        q.add(x);
	        while (!tmp.isEmpty()) {
	            q.add(tmp.remove());
	        }
	    }
	    
	    // Time O(n)
	    public void push_1Q(int x) {
	        q.add(x);
	        for (int i = q.size(); i > 1; i-- ) {
	            q.add(q.remove());
	        }
	    }

	    // Time O(1)
	    public void pop() {
	        q.remove();
	    }

	    // Time O(1)
	    public int top() {
	        return q.peek();   
	    }

	    // Time O(1)
	    public boolean empty() {
			return q.isEmpty();
	    }
	}
	
	// LC-739. Daily Temperatures
	// return how many days you would have to wait until a warmer temperature. T in range [30-100]
    // Time O(N) / O(NW), O(N+W), W is the size of the next array.
	public static int[] dailyTemperatures1(int[] T) {
        
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
        	while (!stack.empty() && T[i] > T[stack.peek()]) {
        		int index = stack.pop();
        		ans[index] = i - index;
        	}
        	stack.push(i);
        }
        return ans;
    }
	
	// LC-496. Next Greater Element I
	// The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
	// If it does not exist, output -1 for this number.
	// Assume no duplicates, nums1’s elements are subset of nums2
	// Time O(n), Space O(m) * optimal,  m is the size of nums1*
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <num, index> lookup
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>(); // nums1 element that we haven't found next grater number yet
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > nums1[stack.peek()]) {
                ans[stack.pop()] = nums2[i];
            }
            if (map.containsKey(nums2[i])) {
                stack.push(map.get(nums2[i]));
            }
        }
        return ans;
    }
}
