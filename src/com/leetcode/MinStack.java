package com.leetcode;

import java.util.Stack;

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    // Push element x onto stack
    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        } 
    }

    // Removes the element on top of the stack
    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }
    
    
	public static void main(String[] args) {
	    MinStack s = new MinStack();
	    s.push(10);
	    s.push(20);
	    s.push(30);
	    System.out.println(s.getMin());
	    s.push(5);
	    System.out.println(s.getMin());
	}
}
