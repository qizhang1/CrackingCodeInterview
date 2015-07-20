package com.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.MyBinaryTree.TreeNode;

public class MyBinarySearchTreeTest {
	
	@Test
	public void testInsert1() {
		TreeNode root = null;
		root = MyBinarySearchTree.insert(root, 5);
		root = MyBinarySearchTree.insert(root, 3);
		root = MyBinarySearchTree.insert(root, 7);
		root = MyBinarySearchTree.insert(root, 6);
		root = MyBinarySearchTree.insert(root, 4);	
		root = MyBinarySearchTree.insert(root, 4);
		String[] strArray = new String[] { "5", "3", "#", "4", "#", "#",
				                           "7", "6", "#", "#", "#"};
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.isSameTree(root, expect));
	}
	
	@Test
	public void testLookup() {
		String[] strArray = new String[] { "5", "3", "#", "4", "#", "#",
                "7", "6", "#", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinarySearchTree.lookup(root, 4));
		assertTrue(MyBinarySearchTree.lookup(root, 7));
		assertFalse(MyBinarySearchTree.lookup(root, 8));
	}
	
	@Test
	public void testGetMinValue1() {
		// build a BST
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(1, MyBinarySearchTree.getMinValue1(root));
	}

	@Test
	public void testGetMinValue2() {
		// build a BST
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(1, MyBinarySearchTree.getMinValue2(root).val);
	}
	
	@Test
	public void testRemove1() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		root = MyBinarySearchTree.remove(root, 1); // remove node with right child only
		
		String[] strArray2 = new String[] { "5", "3", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		assertTrue(MyBinaryTree.isSameTree(expect, root));
	}
	
	@Test
	public void testRemove2() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		root = MyBinarySearchTree.remove(root, 7); // remove node with right child only
		
		String[] strArray2 = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "6", "#", "#", "9", "#", "#" };
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		assertTrue(MyBinaryTree.isSameTree(expect, root));
	}
	
	@Test
	public void testRemove3() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "9", "8", "6", "#", "7", "#", "#", "#", "10", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
	    root = MyBinarySearchTree.remove(root, 5); 

	    MyBinaryTree.printBrackets(root);
		String[] strArray2 = new String[] { "6", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "9", "8", "7", "#", "#", "#", "10", "#", "#" };
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		
		assertTrue(MyBinaryTree.isSameTree(expect, root));
	}
	

	@Test
	public void testDoubleTree1() {
		String[] strArray1 = new String[] { "2", "1", "#", "#", "3", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		TreeNode newTree = MyBinarySearchTree.doubleTree(root1);
		String[] strArray2 = new String[] { "2", "2", "1", "1", "#", "#", "#",
				"#", "3", "3", "#", "#", "#" };
		TreeNode root2 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		assertTrue(MyBinaryTree.isSameTree(newTree, root2));
	}
	


	@Test
	public void testCountTrees1() {
		assertEquals(2, MyBinarySearchTree.countTrees1(2));
		assertEquals(5, MyBinarySearchTree.countTrees1(3));
		assertEquals(14, MyBinarySearchTree.countTrees1(4));
		assertEquals(429, MyBinarySearchTree.countTrees1(7));
	}
	
	@Test
	public void testCountTrees2() {
		assertEquals(2, MyBinarySearchTree.countTrees2(2));
		assertEquals(5, MyBinarySearchTree.countTrees2(3));
		assertEquals(14, MyBinarySearchTree.countTrees2(4));
		assertEquals(429, MyBinarySearchTree.countTrees2(7));
	}

	@Test
	public void testIsBST1() {
		String[] strArray1 = new String[] { "5", "2", "1", "#", "#", "6", "#",
				"#", "7", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		assertFalse(MyBinarySearchTree.isBST1(root1));
		assertFalse(MyBinarySearchTree.isBST2(root1));
	}
	
	@Test
	public void testIsBST2() {
		String[] strArray1 = new String[] { "5", "2", "1", "#", "#", "#", "7", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		assertTrue(MyBinarySearchTree.isBST1(root1));
		assertTrue(MyBinarySearchTree.isBST2(root1));
	}
	
	@Test
	public void testIsBST3() {
		String[] strArray1 = new String[] { "5", "2", "1", "#", "#", "#", "7", "3", "#", "#", "#"};
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		assertFalse(MyBinarySearchTree.isBST1(root1));
		assertFalse(MyBinarySearchTree.isBST2(root1));
	}
	


}
