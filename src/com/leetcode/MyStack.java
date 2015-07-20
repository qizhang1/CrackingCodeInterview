package com.leetcode;

import java.util.*;

public class MyStack {
	// Valid Parentheses
	public static boolean isValid(String s){
		Stack<Character> bracket = new Stack<>();
		
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);     
            if (c == '(' || c == '{' || c == '['){
                bracket.push(c); // push left brackets
            }else if (bracket.empty()){
                return false;
            }else{
                char d = bracket.pop().charValue();
                if (c == ')' && d != '('||
                    c == '}' && d != '{' ||
                    c == ']' && d != '['){
                     return false;
                }
            }
        }
		return bracket.empty();
	}
	
	// *****************************************************************************************
	class MinStack {
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
	
	// *****************************************************************************************
	// Implement Stack using Queues
	class QStack {
	    Queue<Integer> q = new LinkedList<>();
	    Queue<Integer> tmp = new LinkedList<>();
	    public void push(int x) {
	        while (!q.isEmpty()) {
	            tmp.add(q.remove());
	        }
	        q.add(x);
	        while (!tmp.isEmpty()) {
	            q.add(tmp.remove());
	        }
	    }

	    public void pop() {
	        q.remove();
	    }

	    // Get the top element.
	    public int top() {
	        return q.element();   
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
			return q.isEmpty();
	    }
	}
}
