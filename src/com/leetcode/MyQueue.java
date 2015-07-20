package com.leetcode;

import java.util.Stack;

public class MyQueue {
	/* Java Queue Interface 
	*  offer -- return true or false  
	*  poll, peek -- return null if this queue is empty
	*  add -- returning true upon success and throws IllegalStateException if no space
	*  remove, element -- throws NoSuchElementException if this queue is empty */
	
	// ****************************************************************************************
	// Implement Queue using Stacks 
	class Queue {
	    Stack<Integer> in = new Stack<>();
	    Stack<Integer> out = new Stack<>();
	    
	    public void enqueue(int value) {
	    	in.push(value);
	    }
	    
	    public Integer dequeue() { 
//	        if (out.empty()){
//	            while (!in.empty()){
//	                out.push(in.pop());
//	            }
//	        }
	    	peek(); // use implementation in peek()
	        return out.pop();
	    } 
	    
	    public int peek() {
	    	if (out.empty()){
	    		while (!in.empty()){
	    			out.push(in.pop());
	    		}
	    	}
	        return out.peek();
	    }

	    public boolean empty() {
	        return in.isEmpty() && out.isEmpty();
	    }
	}
	
	
}
