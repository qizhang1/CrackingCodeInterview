package com.leetcode;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.leetcode.MyBinaryTree.TreeNode;

public class MyBinaryTreeTest {

	@Test
	public void testBuildSequentialTree1() {
		TreeNode root1 = MyBinaryTree.buildSequentialTree(10);
		String[] strArray = new String[] { "1", "2", "4", "8", "#", "#", "9",
				"#", "#", "5", "10", "#", "#", "#", "3", "6", "#", "#", "7",
				"#", "#" };
		TreeNode root2 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.isSameTree(root1, root2));
	}

	@Test
	public void testPrintPreorder() {
		String[] strArray = new String[] { "1", "2", "4", "8", "#", "#", "9",
				"#", "#", "5", "10", "#", "#", "#", "3", "6", "#", "#", "7",
				"#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		MyBinaryTree.printPreorder(root);
		MyBinaryTree.printPreorder2(root);
		MyBinaryTree.printPreorder3(root);
	}

	@Test
	public void testPrintInorder() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		MyBinaryTree.printInorder(root);
		MyBinaryTree.printInorder2(root);
		MyBinaryTree.printInorder3(root);
	}

	@Test
	public void testPrintPostorder() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		MyBinaryTree.printPostorder(root);
	}

	@Test
	public void testPrintLevelorder1() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		MyBinaryTree.printLevelorder1(root);
	}

	@Test
	public void testPrintLevelorder2() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		List<List<Integer>> result = MyBinaryTree.printLevelorder2(root);

		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		expect.add(Arrays.asList(30));
		expect.add(Arrays.asList(10, 20));
		expect.add(Arrays.asList(50, 45, 35));
		assertEquals(expect, result);
	}

	@Test
	public void testLevelOrderBottom() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		List<List<Integer>> result = MyBinaryTree.levelOrderBottom(root);

		List<List<Integer>> expect = new ArrayList<List<Integer>>();
		expect.add(Arrays.asList(50, 45, 35));
		expect.add(Arrays.asList(10, 20));
		expect.add(Arrays.asList(30));
		assertEquals(expect, result);
	}
	
	
	@Test
	public void testZigzagLevelOrder() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		ArrayList<ArrayList<Integer>> result1 = MyBinaryTree.zigzagLevelOrder1(root);
		ArrayList<ArrayList<Integer>> result2 = MyBinaryTree.zigzagLevelOrder2(root);
		ArrayList<ArrayList<Integer>> result3 = MyBinaryTree.zigzagLevelOrder3(root);

		ArrayList<ArrayList<Integer>> expect = new ArrayList<>();
		ArrayList<Integer> level1 = new ArrayList<>();
		level1.add(30);
		expect.add(level1);
		
		ArrayList<Integer> level2 = new ArrayList<>();
		level2.add(20);
		level2.add(10);
		expect.add(level2);
		
		ArrayList<Integer> level3 = new ArrayList<>();
		level3.add(50);
		level3.add(45);
		level3.add(35);
		expect.add(level3);

		assertEquals(expect, result1);
		assertEquals(expect, result2);
		assertEquals(expect, result3);
	}
	
	@Test
	public void testPrintLeftView() {
		String[] strArray = new String[] { "12", "10", "#", "#", "30",
				"25", "#", "#", "40", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		//MyBinaryTree.printLeftView1(root); // 12, 10, 25
		MyBinaryTree.printLeftView2(root); // 12, 10, 25
	}
	
	@Test
	public void testPrintRightView1() {
		String[] strArray = new String[] { "1", "2", "#", "5", "#", "#", "3",
				"#", "4", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		List<Integer> result = MyBinaryTree.printRightSideView1(root); // 1, 3, 4
		Integer[] expect = new Integer[]{1, 3, 4};
		assertArrayEquals(expect, result.toArray());
	}
	
	@Test
	public void testPrintRightView2() {
		String[] strArray = new String[] { "1", "2", "#", "5", "#", "#", "3",
				"#", "4", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		List<Integer> result = MyBinaryTree.printRightSideView2(root); // 1, 3, 4
		Integer[] expect = new Integer[]{1, 3, 4};
		assertArrayEquals(expect, result.toArray());
	}
	
	
	

	@Test
	public void testGetSize() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		int size = MyBinaryTree.getSize(root);
		assertEquals(size, 6);
	}

	@Test
	public void testGetMaxDepth() {
		String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				"20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		int depth = MyBinaryTree.getMaxDepth(root);
		assertEquals(depth, 3);
	}

	@Test
	public void testGetMinDepth() {
		String[] strArray = new String[] { "1", "2", "#", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		int depth = MyBinaryTree.getMinDepth1(root);
		assertEquals(depth, 2);
	}

	@Test
	public void testIsBalanced1() {
		String[] strArray = new String[] { "30", "10", "50", "45", "#", "#",
				"#", "25", "#", "#", "20", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.isBalanced1(root));
	}

	@Test
	public void testIsBalanced2() {
		String[] strArray = new String[] { "30", "10", "50", "70", "#", "#",
				"#", "#", "20", "45", "#", "#", "35", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertFalse(MyBinaryTree.isBalanced2(root));
	}

	@Test
	public void testHasPathSum1() {
		// build a BST
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.hasPathSum(root, 11)); // 5->3->1->2
		assertTrue(MyBinaryTree.hasPathSum(root, 12)); // 5->3->4
		assertTrue(MyBinaryTree.hasPathSum(root, 22)); // 5->8->9
		assertTrue(MyBinaryTree.hasPathSum(root, 26)); // 5->8->7->6
		assertFalse(MyBinaryTree.hasPathSum(root, 25));
	}

	@Test
	public void testHasPathSum2() {
		TreeNode root = null;
		assertFalse(MyBinaryTree.hasPathSum(root, 0));
	}

	@Test
	public void testPrintPaths1() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		/*
		 * 5 3 1 2 
		 * 5 3 4 
		 * 5 8 7 6 
		 * 5 8 9
		 */
		MyBinaryTree.printPaths1(root);
		System.out.println("=========");
		MyBinaryTree.printPaths2(root);
	}
	
	@Test
	public void testPrintPaths2() {
		String[] strArray = new String[] { "1", "2", "#", "#", "3", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		/*
		 * 1 2 
		 * 1 3 
		 */
		MyBinaryTree.printPaths1(root);
		System.out.println("=========");
		MyBinaryTree.printPaths2(root);
	}
	
	@Test
	public void testGetMaxPathSum1() {
		String[] strArray = new String[] { "10", "-2", "8", "#", "#", "-4", "#", "#", "7", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(17, MyBinaryTree.getMaxPathSum(root));
	}
	
	@Test
	public void testGetMaxPathSum2() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(26, MyBinaryTree.getMaxPathSum(root));
	}
	
	@Test
	public void testGetMaxPathSum3() {
		String[] strArray = new String[] { "-1", "-2", "#", "#", "1", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(0, MyBinaryTree.getMaxPathSum(root));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testPrintMaxPathSum1() {
		String[] strArray = new String[] {"10", "-2", "8", "#", "#", "-4", "#", "#", "7", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		//MyBinaryTree.printMaxPathSum(root); // 10, 7
		MyBinaryTree.printMaxPathSum2(root);
	}
	
	@Test
	public void testPrintMaxPathSum2() {
		String[] strArray = new String[] { "5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		//MyBinaryTree.printMaxPathSum(root); // 5, 8, 7, 6
		MyBinaryTree.printMaxPathSum2(root);
	}
	
	@Test
	public void testGetMax2LeavesPathSum1() {
		String[] strArray = new String[] {"5", "3", "1", "#", "2", "#", "#",
				"4", "#", "#", "8", "7", "6", "#", "#", "#", "9", "#", "#" };
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(33, MyBinaryTree.getMax2LeavesPathSum(root));
	}
	
	@Test
	public void testGetMax2LeavesPathSum2() {
		String[] strArray = new String[] { "-15", "5", "-8", "2", "#", "#",
				"6", "#", "#", "1", "#", "#", "6", "3", "#", "#", "9","#", "0", "4", "#", "#",
				"-1", "10", "#", "#", "#"};
		TreeNode root = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertEquals(27, MyBinaryTree.getMax2LeavesPathSum(root));
	}
	
	
	

	
	
	
	

	@Test
	public void testMirror() {
		String[] strArray1 = new String[] { "4", "2", "1", "#", "#", "3", "#",
				"#", "5", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		MyBinaryTree.mirror(root1);
		String[] strArray2 = new String[] { "4", "5", "#", "#", "2", "3", "#",
				"#", "1", "#", "#" };
		TreeNode root2 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		MyBinaryTree.isSameTree(root1, root2);
	}

	@Test
	public void testCloneMirror() {
		String[] strArray1 = new String[] { "4", "2", "1", "#", "#", "3", "#",
				"#", "5", "6", "#", "#", "7", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		TreeNode root2 = MyBinaryTree.cloneMirror(root1);
		String[] strArray2 = new String[] { "4", "5", "7", "#", "#", "6", "#",
				"#", "2", "3", "#", "#", "1", "#", "#" };
		TreeNode root3 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		assertTrue(MyBinaryTree.isSameTree(root2, root3));
	}

	@Test
	public void testClone() {
		String[] strArray1 = new String[] { "4", "2", "1", "#", "#", "3", "#",
				"#", "5", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		TreeNode root2 = MyBinaryTree.clone(root1);
		assertTrue(MyBinaryTree.isSameTree(root1, root2));
	}

	@Test
	public void testSumNumbers() {
		String[] strArray1 = new String[] { "1", "2", "#", "#", "3", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		int sum = MyBinaryTree.sumNumbers(root1);
		assertEquals(25, sum);
	}

	@Test
	public void testIsSymmetric() {
		String[] strArray1 = new String[] { "1", "2", "3", "#", "#", "4", "#",
				"#", "2", "4", "#", "#", "3", "#", "#" };
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		assertTrue(MyBinaryTree.isSymmetric(root1));
	}

	@Test
	public void testBuildTree1() {
		int[] preorder = new int[] { 4, 2, 1, 3, 5, 6 };
		int[] inorder = new int[] { 1, 2, 3, 4, 5, 6 };
		TreeNode root = MyBinaryTree.buildTree1(preorder, inorder);
		String[] strArray = new String[] { "4", "2", "1", "#", "#", "3", "#",
				"#", "5", "#", "6", "#", "#" };
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.isSameTree(root, expect));
	}

	@Test
	public void testBuildTree2() {
		int[] postorder = new int[] { 1, 3, 2, 6, 5, 4 };
		int[] inorder = new int[] { 1, 2, 3, 4, 5, 6 };
		TreeNode root = MyBinaryTree.buildTree2(inorder, postorder);
		String[] strArray = new String[] { "4", "2", "1", "#", "#", "3", "#",
				"#", "5", "#", "6", "#", "#" };
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		assertTrue(MyBinaryTree.isSameTree(root, expect));
	}
	
	@Test
	public void testLCA1() {
		// build tree 
		TreeNode root = new TreeNode(30);
		TreeNode child1 = new TreeNode(10);
		TreeNode child2 = new TreeNode(20);
		TreeNode child3 = new TreeNode(50);
		TreeNode child4 = new TreeNode(25);
		TreeNode child5 = new TreeNode(35);
		TreeNode child6 = new TreeNode(45);
		TreeNode childOuter1 = new TreeNode(1000);
		TreeNode childOuter2 = new TreeNode(1100);
		root.left = child1;
		root.right = child2;
		child1.left = child3;
		child1.right = child4;
		child3.left = child6;
		child2.right = child5;
		//assertEquals(null, MyBinaryTree.LCA(root, null, null));
		assertEquals(child1, MyBinaryTree.LCA(root, child4, child6));
		assertEquals(root, MyBinaryTree.LCA(root, child5, child6));	
		assertEquals(child1, MyBinaryTree.LCA(root, child1, child6));	
		assertEquals(root, MyBinaryTree.LCA(root, child1, child5));	
		assertEquals(child3, MyBinaryTree.LCA(root, child3, child3));	
		assertEquals(null, MyBinaryTree.LCA(child1, child3, child2));	
		assertEquals(null, MyBinaryTree.LCA(root, child3, childOuter2));	
		assertEquals(null, MyBinaryTree.LCA(root, childOuter1, childOuter2));	
	}
	
	@Test
	public void testInvertTree1() {
		String[] strArray = new String[] { "4", "2", "1", "#", "#", "3", "#", "#", "7", "6", "#", "#", "9", "#", "#"};
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray);
		String[] expectStrArray = new String[] { "4", "7", "9", "#", "#", "6", "#", "#", "2", "3", "#", "#", "1", "#", "#"};
		TreeNode expect = MyBinaryTree.createBinaryTreeFromStrArray1(expectStrArray);
		assertTrue(MyBinaryTree.isSameTree(MyBinaryTree.invertTree(root1), expect));	
	}
	
	@Test
	public void testMergeTree() {
		String[] strArray1 = new String[] { "1", "3", "5", "#", "#", "#", "2", "#", "#"};
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		String[] strArray2 = new String[] { "2", "1", "#", "4", "#", "#", "3", "#", "7", "#", "#"};
		TreeNode root2 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray2);
		String[] expectStrArrays = new String[] { "3", "4", "5", "#", "#", "4", "#", "#", "5", "#", "7", "#", "#"};
		TreeNode expectRoot = MyBinaryTree.createBinaryTreeFromStrArray1(expectStrArrays);
		assertTrue(MyBinaryTree.isSameTree(MyBinaryTree.mergeTrees(root1, root2), expectRoot));	
	}
	
	@Test
	public void testRob() {
		String[] strArray1 = new String[] { "3", "4", "1", "#", "#", "3", "#", "#", "5", "#", "1", "#", "#"};
		TreeNode root1 = MyBinaryTree.createBinaryTreeFromStrArray1(strArray1);
		MyBinaryTree.printLevelorder1(root1);
		assertEquals(9, MyBinaryTree.rob(root1));
		assertEquals(9, MyBinaryTree.rob2(root1));
	}
}
