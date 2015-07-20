package com.leetcode;

import org.junit.Test;

import com.leetcode.MyBinaryTree.TreeNode;

public class MyNnaryTreeTest {
	 @Test
	 public void testPrintLevelorder1() {
		 String[] strArray = new String[] { "30", "10", "50", "#", "#", "#",
				 "20", "45", "#", "#", "35", "#", "#"};
		 MyNnaryTree root = MyNnaryTree.createNnaryTreeFromStrArray(strArray);
	 }
}
