package com.leetcode;

import java.util.*;

import com.leetcode.MyBinaryTree.TreeNode;

public class MyBinarySearchTree {

	public static boolean lookup(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		if (root.val == target) {
			return true;
		} else if (root.val > target) {
			return lookup(root.left, target);
		} else {
			return lookup(root.right, target);
		}
	}
	
	// *****************************************************************************************
	// Search Range in Binary Search Tree
	// Return all keys that k1<=key<=k2 in ascending order
	// Time O(n)
	public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<>();
        searchRangeHelper(root, k1, k2, result);
        return result;
    }
    
	// Inorder traversal because of ascending order
    private static void searchRangeHelper(TreeNode root, int k1, int k2, ArrayList<Integer> result){
        if (root == null) return;
        if (root.val > k1){
            searchRangeHelper(root.left, k1, k2, result);
        }
        if (root.val <= k2 && root.val >= k1){
            result.add(root.val);
        }
        if (root.val < k2) {
            searchRangeHelper(root.right, k1, k2, result);
        }
    }

	// *****************************************************************************************
	// Return the root of the new binary search tree.
	// Recursion - Time O(n)
	public static TreeNode insert(TreeNode root, int newVal) {
		if (root == null) {
			return new TreeNode(newVal);
		}
		if (newVal < root.val) {
			root.left = insert(root.left, newVal);
		} else if (newVal > root.val){
			root.right = insert(root.right, newVal);
		}
		return root; // if newVal is found, no need to update
	}
	
	// Non-Recursion approach
	public static TreeNode insertNode(TreeNode root, TreeNode node){
		if (root == null){
			return node;
		}

		TreeNode cur = root;
		while (cur != null){
			if (cur.val == node.val){
				break;
			} else if (cur.val > node.val){
				if (cur.left == null){
					cur.left = node;
					break;
				}
				cur = cur.left;
			} else {
				if (cur.right == null){
					cur.right = node;
					break;
				}
				cur = cur.right;
			}
		}
		return root;
	}
	
	// *****************************************************************************************
	// Find the min value in a non-empty BST
	public static int getMinValue1(TreeNode root) {
		if (root.left == null) {
			return root.val;
		}
		return getMinValue1(root.left);
	}

	// Non recursive is better
	public static TreeNode getMinValue2(TreeNode root) {
		if (root == null){
			return null;
		}
		TreeNode cur = root;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	// *****************************************************************************************
	public static TreeNode remove(TreeNode root, int toRemove) {
		if (root == null) {
			return null;
		}
		if (toRemove < root.val) {
			root.left = remove(root.left, toRemove);
		} else if (toRemove > root.val) {
			root.right = remove(root.right, toRemove);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				TreeNode temp = root;
				// get data from the leftmost node in the right subtree
				root = getMinValue2(root.right);
				// delete the leftmost node in the right subtree
				root.right = remove(temp.right, root.val); 
				root.left = temp.left;
			}
		}
		return root;
	}

	// *****************************************************************************************
	// createBalancedBST
	// Given an array where elements are sorted in ascending order,
	// convert it to a height balanced BST.
	// need to be test
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBSTHelper(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBSTHelper(num, start, mid - 1);
		root.right = sortedArrayToBSTHelper(num, mid + 1, end);
		return root;

	}

	// For each node in a BST, create a new duplicate node, and insert the
	// duplicate as the left child of the
	// original node. The resulting tree should still be a BST.
	public static TreeNode doubleTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode newTree = new TreeNode(root.val);
		newTree.left = new TreeNode(root.val);
		newTree.left.left = doubleTree(root.left);
		newTree.right = doubleTree(root.right);
		return newTree;
	}

	// *****************************************************************************************
	// Computes the number of structurally unique binary search trees that store
	// the values 1..N.
	// Strategy: consider that each value could be the root.
	// Recursively find the size of the left and right subtrees.
	public static int countTrees1(int numKeys) {
		if (numKeys <= 1) {
			return 1;
		}
		int sum = 0;
		for (int root = 1; root <= numKeys; root++) {
			int left = countTrees1(root - 1);
			int right = countTrees1(numKeys - root);
			sum += left * right;
		}
		return (sum);
	}

	// Catalan number Cn = (2n)!/n!*(n+1)! 1, 1, 2, 5, 14, 42, 132, 429 ...
	public static long countTrees2(int n) {
		long result = MyUtility
				.factoria(2 * n)
				.divide(MyUtility.factoria(n).multiply(
						MyUtility.factoria(n + 1))).longValue();
		return result;
	}

	public static long countTrees3(int n) {
		long result = factoria2(2 * n) / factoria2(n) * factoria2(n + 1);
		return result;
	}

	private static long factoria2(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// *****************************************************************************************
	public static boolean isBST1(TreeNode root) {
		return isBST1Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean isBST1Helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (min < root.val && root.val < max) {
			return isBST1Helper(root.left, min, root.val)
					&& isBST1Helper(root.right, root.val, max);
		}
		return false;
	}
	
	// *****************************************************************************************

	public static boolean isBST2(TreeNode root) {
		int[] current = new int[] { Integer.MIN_VALUE };
		return isBST2Helper2(root, current);
	}

	public static boolean isBST2Helper2(TreeNode root, int[] current) {
		if (root == null) {
			return true;
		}
		if (!isBST2Helper2(root.left, current)) {
			return false;
		}
		if (current[0] >= root.val) {
			return false;
		}
		current[0] = root.val;
		return isBST2Helper2(root.right, current);
	}
	
	// *****************************************************************************************
	// Find the lowest common ancestor (LCA) of two given nodes in the BST
	// Assume both node1 and node2 are in the tree 
	// Time O(log n) Space O(1)
	public static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return null;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (node1.val < cur.val && node2.val < cur.val) {
				cur = cur.left;
			} else if (node1.val > cur.val && node2.val > cur.val) {
				cur = cur.right;
			} else {
				return cur;
			}
		}
		return null;
	}
	
	
	// *****************************************************************************************
	// Implement an iterator over a binary search tree (BST)
	// next() and hasNext() should run in average O(1) time and uses O(h) memory
	// where h is the height of the tree.
	public class BSTIterator {
		private Stack<TreeNode> stack = new Stack<>();
	    private TreeNode cur;
	    
	    public BSTIterator(TreeNode root) {
	    	cur = root;
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return (cur != null || !stack.isEmpty());   
	    }

	    /** @return the next smallest number */
	    public TreeNode next() {
	        while (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        TreeNode node = cur;
	        cur = cur.right;
	        return node;   
	    }
	}
}
