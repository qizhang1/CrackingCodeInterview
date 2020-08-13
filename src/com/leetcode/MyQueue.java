package com.leetcode;

import java.util.Stack;

public class MyQueue {

	// LC-232. Implement Queue using Stacks 
	class Queue {
		private Stack<Integer> s1 = new Stack<>();
		private Stack<Integer> s2 = new Stack<>(); 
	    private int front;
	    
	    // Time O(1)
	    public void push(int x) {
	        if (s1.empty()) {
	            front = x;
	        }
	        s1.push(x);
	    }
	    
	    // Time Amortized O(1), Worst-case O(n)
	    public int pop() {
	    	// push all elements of s1 to stack s2, which helps to store the elements in reversed order
	        if (s2.isEmpty()) {
	            while (!s1.isEmpty()) {
	                s2.push(s1.pop());
	            }
	        }
	        return s2.pop(); 
	    }
	    
	    // Time O(1)
	    public int peek() {
	        if (!s2.isEmpty()) {
	           return s2.peek();
	        }
	        return front;
	    }
	    
	    // Time O(1)
	    public boolean empty() {
	        return s1.isEmpty() && s2.isEmpty();
	    }
	}
}
