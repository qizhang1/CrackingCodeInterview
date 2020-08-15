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
}
