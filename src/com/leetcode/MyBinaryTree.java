package com.leetcode;

import java.util.*;

public class MyBinaryTree {

	// *****************************************************************************************
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

	// *****************************************************************************************
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// *****************************************************************************************
	// Tree deserialization - preorder
	// *****************************************************************************************

	public static TreeNode createBinaryTreeFromStrArray1(String[] s) {
		int[] i = new int[1];
		return createBinaryTreeFromStrArray1Helper(s, i);
	}

	private static TreeNode createBinaryTreeFromStrArray1Helper(String[] s,
			int[] i) {
		if (s[i[0]].equalsIgnoreCase("#")) {
			i[0]++;
			return null;
		}
		TreeNode newTree = new TreeNode(Integer.parseInt(s[i[0]]));
		i[0]++;
		newTree.left = createBinaryTreeFromStrArray1Helper(s, i);
		newTree.right = createBinaryTreeFromStrArray1Helper(s, i);
		return newTree;
	}

	// level order traversal
	public static TreeNode buildSequentialTree(int max) {
		return buildSequentialTree(1, max);
	}

	private static TreeNode buildSequentialTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			TreeNode root = new TreeNode(n);
			root.left = buildSequentialTree(2 * n, max);
			root.right = buildSequentialTree(2 * n + 1, max);
			return root;
		}
	}

	// *****************************************************************************************
	// Tree Traversal
	// Three types of Depth-first traversal: Pre-order, In-order, Post-order.
	// *****************************************************************************************
	public static void printPreorder(TreeNode root) {
		System.out.print("Preorder: ");
		printPreorderHelper(root);
		System.out.println();
	}

	private static void printPreorderHelper(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			printPreorderHelper(root.left);
			printPreorderHelper(root.right);
		}
	}

	// Iterative Preorder Traversal 
	public static void printPreorder2(TreeNode root) {
		System.out.print("Preorder: ");
		if (root == null)
			return;
		Stack<TreeNode> parentStack = new Stack<>();
		parentStack.push(root);
		while (!parentStack.empty()) {
			TreeNode node = parentStack.pop();
			System.out.print(node.val + " "); // print a node��s value when pop
			if (node.right != null) {
				parentStack.push(node.right);
			}
			if (node.left != null) {
				parentStack.push(node.left);
			}
		}
		System.out.println();
	}

	// Iterative Preorder Traversal 
	public static void printPreorder3(TreeNode root) {
		System.out.print("Preorder: ");
		if (root == null)
			return;
		Stack<TreeNode> parentStack = new Stack<>();
		System.out.print(root.val + " ");
		parentStack.push(root);
		while (!parentStack.empty()) {
			TreeNode cur = parentStack.peek();
			if (cur.left != null) {
				System.out.print(cur.left.val + " "); // print a node��s value
														// when push
				parentStack.push(cur.left);
			} else {
				cur = parentStack.pop();
				while (cur.right == null) {
					if (parentStack.empty()) {
						return;
					}
					cur = parentStack.pop();
				}
				System.out.print(cur.right.val + " ");
				parentStack.push(cur.right);
			}
		}
	}

	// Divide and Conquer
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		// Divide
		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);

		// Conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}

	// *****************************************************************************************
	public static void printInorder(TreeNode root) {
		System.out.print("Inorder: ");
		printInorderHelper(root);
		System.out.println();
	}

	private static void printInorderHelper(TreeNode root) {
		if (root != null) {
			printInorderHelper(root.left);
			System.out.print(root.val + " ");
			printInorderHelper(root.right);
		}
	}

	public static void printInorder2(TreeNode root) {
		System.out.print("Inorder: ");
		if (root == null)
			return;
		Stack<TreeNode> parentStack = new Stack<>();
		TreeNode cur = root;
		pushLeftNodesToStack(parentStack, cur);
		while (!parentStack.empty()) {
			cur = parentStack.pop();
			System.out.print(cur.val + " ");
			cur = cur.right;
			pushLeftNodesToStack(parentStack, cur);
		}
		System.out.println();
	}

	// push that node and all its lefts to stack.
	private static void pushLeftNodesToStack(Stack<TreeNode> nodeStack,
			TreeNode n) {
		while (n != null) {
			nodeStack.push(n);
			n = n.left;
		}
	}

	// ����һ
	public static void printInorder3(TreeNode root) {
		System.out.print("Inorder: ");
		if (root == null)
			return;

		Stack<TreeNode> parentStack = new Stack<>();
		TreeNode cur = root;

		while (!parentStack.empty() || cur != null) {
			if (cur != null) {
				parentStack.push(cur);
				cur = cur.left;
			} else {
				cur = parentStack.pop();
				System.out.print(cur.val + " ");
				cur = cur.right;
			}
		}
		System.out.println();
	}

	// *****************************************************************************************
	public static void printPostorder(TreeNode root) {
		System.out.print("Postorder: ");
		printPostorderHelper(root);
		System.out.println();
	}

	private static void printPostorderHelper(TreeNode root) {
		if (root != null) {
			printPostorderHelper(root.left);
			printPostorderHelper(root.right);
			System.out.print(root.val + " ");
		}
	}

	// *****************************************************************************************
	// Breadth-first traversal
	// Time O(n) Space O(n)
	public static void printLevelorder1(TreeNode root) {
		System.out.print("Level order: ");
		if (root == null)
			return;
		Queue<TreeNode> parentQueue = new LinkedList<TreeNode>();
		parentQueue.add(root);
		while (!parentQueue.isEmpty()) {
			TreeNode cur = parentQueue.remove();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				parentQueue.add(cur.left);
			}
			if (cur.right != null) {
				parentQueue.add(cur.right);
			}
		}
		System.out.println();
	}

	// Breadth-first traversal, level by level
	public static List<List<Integer>> printLevelorder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> parentQueue = new LinkedList<TreeNode>();
		parentQueue.add(root);
		while (!parentQueue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();
			int size = parentQueue.size(); // can't not put in the for loop.
											// size changes
			for (int i = 0; i < size; i++) {
				TreeNode cur = parentQueue.poll();
				level.add(cur.val);
				if (cur.left != null) {
					parentQueue.add(cur.left);
				}
				if (cur.right != null) {
					parentQueue.add(cur.right);
				}
			}
			result.add(level);
		}
		return result;
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> parentQueue = new LinkedList<>();
		parentQueue.add(root);
		while (!parentQueue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();
			int size = parentQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = parentQueue.poll();
				level.add(cur.val);
				if (cur.left != null) {
					parentQueue.add(cur.left);
				}
				if (cur.right != null) {
					parentQueue.add(cur.right);
				}
			}
			result.add(level);
		}
		Collections.reverse(result);
		return result;
	}

	// *****************************************************************************************
	// Binary Tree Zigzag Level Order Traversal
	// Time O(n) Space O(n)
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> curLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		boolean L2R = true;
		curLevel.add(root);
		while (!curLevel.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();
			int size = curLevel.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = curLevel.pop();
				level.add(cur.val);
				if (L2R) {
					if (cur.left != null) {
						nextLevel.add(cur.left);
					}
					if (cur.right != null) {
						nextLevel.add(cur.right);
					}
				} else {
					if (cur.right != null) {
						nextLevel.add(cur.right);
					}
					if (cur.left != null) {
						nextLevel.add(cur.left);
					}
				}
			}
			result.add(level);
			// swap curLevel and nextlevel
			Stack<TreeNode> temp = curLevel;
			curLevel = nextLevel;
			nextLevel = temp;
			
			L2R = !L2R;
		}
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> Left2Right = new Stack<>();
		Stack<TreeNode> Right2Left = new Stack<>();
		Left2Right.add(root);
		while (!Left2Right.isEmpty() || !Right2Left.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();
			if (!Left2Right.isEmpty()){
				int size = Left2Right.size();
				for (int i = 0; i < size; i++) {
					TreeNode cur = Left2Right.pop();
					level.add(cur.val);
					if (cur.left != null) {
						Right2Left.add(cur.left);
					}	
					if (cur.right != null) {
						Right2Left.add(cur.right);
					}
				}
			} else {
				int size = Right2Left.size();
				for (int i = 0; i < size; i++) {
					TreeNode cur = Right2Left.pop();
					level.add(cur.val);
					if (cur.right != null) {
						Left2Right.add(cur.right);
					}
					if (cur.left != null) {
						Left2Right.add(cur.left);
					}
				}	
			}
			result.add(level);
		}
		return result;
	}
	
	// Easiest approach
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder3(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> parentQueue = new LinkedList<TreeNode>();
		parentQueue.add(root);
		boolean L2R = true;
		while (!parentQueue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();
			int size = parentQueue.size(); // can't not put in the for loop.
			for (int i = 0; i < size; i++) {
				TreeNode cur = parentQueue.poll();
				level.add(cur.val);
				if (cur.left != null) {
					parentQueue.add(cur.left);
				}
				if (cur.right != null) {
					parentQueue.add(cur.right);
				}
			}
			if (!L2R){
				Collections.reverse(level);
			}
			result.add(level);
			L2R = !L2R;
		}
		return result;
	}

	// *****************************************************************************************
	// Print Left View of a Binary Tree
	// BFS using two stacks
	public static void printLeftView1(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> cur = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		cur.add(root);
		System.out.print(root.val + " ");

		while (!cur.isEmpty()) {
			TreeNode nd = cur.poll();
			if (nd.left != null) {
				next.add(nd.left);
			}
			if (nd.right != null) {
				next.add(nd.right);
			}
			if (cur.isEmpty() && !next.isEmpty()) {
				System.out.print(next.peek().val + " ");
				cur = next;
				next = new LinkedList<>();
			}
		}
	}

	// *****************************************************************************************
	// Time O(n)
	public static void printLeftView2(TreeNode root) {
		int[] maxLevel = new int[] { 0 };
		printLeftView2Helper(root, 1, maxLevel);
	}

	private static void printLeftView2Helper(TreeNode root, int cur,
			int[] maxLevel) {
		if (root == null)
			return;
		if (cur > maxLevel[0]) {
			System.out.print(root.val + " ");
			maxLevel[0] = cur;
		}
		printLeftView2Helper(root.left, cur + 1, maxLevel);
		printLeftView2Helper(root.right, cur + 1, maxLevel);

	}

	// *****************************************************************************************
	// Print right view of Binary Tree
	public static List<Integer> printRightSideView1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> cur = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		cur.add(root);
		result.add(root.val);

		while (!cur.isEmpty()) {
			TreeNode nd = cur.poll();
			// visit right node first, then left
			if (nd.right != null) {
				next.add(nd.right);
			}
			if (nd.left != null) {
				next.add(nd.left);
			}
			if (cur.isEmpty() && !next.isEmpty()) {
				result.add(next.peek().val);
				cur = next;
				next = new LinkedList<>();
			}
		}
		return result;
	}

	// *****************************************************************************************
	// Time O(n)
	public static List<Integer> printRightSideView2(TreeNode root) {
		int[] maxLevel = new int[] { 0 };
		List<Integer> list = new ArrayList<>();
		rightViewUtil(root, 1, maxLevel, list);
		return list;
	}

	private static void rightViewUtil(TreeNode root, int level, int[] maxLevel,
			List<Integer> list) {
		if (root == null)
			return;
		if (maxLevel[0] < level) {
			list.add(root.val);
			maxLevel[0] = level;
		}
		rightViewUtil(root.right, level + 1, maxLevel, list);
		rightViewUtil(root.left, level + 1, maxLevel, list);
	}

	// *****************************************************************************************
	// Assume the given tree is a full binary tree, populate each next pointer
	// to point to its next right node.
	// If there is no next right node, the next pointer should be set to NULL.
	// Space O(1), Time O(N)
	public static void connect(TreeLinkNode root) {
		TreeLinkNode parentLevel = root;
		while (parentLevel != null) {
			TreeLinkNode cur = parentLevel;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
				}
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			parentLevel = parentLevel.left;
		}
	}

	// *****************************************************************************************
	public static void printSideways(TreeNode root) {
		printSideways(root, 0);
	}

	private static void printSpace(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("   ");
		}
	}

	private static void printSideways(TreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			printSpace(level);
			System.out.println(root.val);
			printSideways(root.left, level + 1);
		} else {
			printSpace(level);
			System.out.println(" *");
		}
	}

	// *****************************************************************************************
	public static void printBrackets(TreeNode root) {
		printBracketsHelper(root);
		System.out.println();
	}

	private static void printBracketsHelper(TreeNode root) {
		if (root == null) {
			System.out.print("N");
		} else {
			System.out.print(root.val);
			System.out.print("(");
			printBracketsHelper(root.left);
			System.out.print(",");
			printBracketsHelper(root.right);
			System.out.print(")");
		}
	}
	
	// LC-572. Subtree of Another Tree
	// Given two non-empty binary trees s and t, check whether tree t is a subtree of s
	// A subtree of s is a tree consists of a node in s and all of this node's descendants.
	// Time O(m * n), Space O(n)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t) || (s.left != null && isSubtree(s.left, t))
            || (s.right != null && isSubtree(s.right, t));
    }
    
	public static boolean isSameTree(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}
		if (n1 == null || n2 == null) {
			return false;
		}
		return n1.val == n2.val && isSameTree(n1.left, n2.left)
				&& isSameTree(n1.right, n2.right);
	}

	// *****************************************************************************************
	// total number of nodes
	public static int getSize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + getSize(root.left) + getSize(root.right);
	}

	// LC-104. Maximum Depth of Binary Tree, define depth of node is 1
	// Time O(n), Space O(1)
	public static int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
	}

	// LC-110. Balanced Binary Tree
	// A height-balanced binary tree is defined as a binary tree in which
	// the depth of the two subtrees of EVERY node never differ by more than 1.
	// Time O(n^2), Space O(1) * Top-down recursion *
	public static boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}
		int lDepth = getMaxDepth(root.left);
		int rDepth = getMaxDepth(root.right);
		return Math.abs(lDepth - rDepth) <= 1 && isBalanced1(root.left)
				&& isBalanced1(root.right);
	}

	// Time O(n), Space O(1) * DFS bottom up, optimal *
	public static boolean isBalanced2(TreeNode root) {
		return getBalancedMaxDepth(root) != -1;
	}

	// return the max depth of the current node
	// return -1 if tree is unbalanced
	private static int getBalancedMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lDepth = getBalancedMaxDepth(root.left);
		int rDepth = getBalancedMaxDepth(root.right);
		if (lDepth == -1 || rDepth == -1 || Math.abs(lDepth - rDepth) > 1) {
			return -1;
		}
		return 1 + Math.max(lDepth, rDepth);
	}

	// LC-111. Minimum depth
	// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	// Time O(n), Space O(n)
	public static int getMinDepth1(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left == null && root.right == null) {
        	return 1;
        }
        if (root.left == null) {
            return getMinDepth1(root.right) + 1;
        }
        if (root.right == null) {
            return getMinDepth1(root.left) + 1;
        }
        return Math.min(getMinDepth1(root.left), getMinDepth1(root.right)) + 1;
	}

	// BFS works well for highly unbalanced tree
	// because it does not need to traverse all nodes

	public static int getMinDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> parentQueue = new LinkedList<TreeNode>();
		parentQueue.add(root);
		parentQueue.add(null); // End of level
		int depth = 1;
		while (!parentQueue.isEmpty()) {
			TreeNode cur = parentQueue.poll();
			if (cur != null) {
				// stop at the first leaf node
				if (cur.left == null && cur.right == null) {
					break;
				}
				if (cur.left != null) {
					parentQueue.add(cur.left);
				}
				if (cur.right != null) {
					parentQueue.add(cur.right);
				}
			} else {
				// increment current depth when we reach the end of level
				depth++;
				if (parentQueue.isEmpty())
					break;
				parentQueue.add(null);
			}
		}
		return depth;
	}

	// *****************************************************************************************
	// expression tree

	// LC-112. "root-to-leaf" Path Sum
	// Return true if the tree has a root-to-leaf path such that adding up all
	// the values along the path equals the given sum. Otherwise, Return false.
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	// LC-113. Path Sum II
	// Given a binary tree and a sum, find all root-to-leaf path sum
	// Time O(nlogn), Space O(nlogn) ?
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<>();
		pathSumHelper(root, sum, path, result);
		return result;
	}

	private static void pathSumHelper(TreeNode node, int sum,
			List<Integer> path, List<List<Integer>> result) {
		if (node == null) {
			return;
		}
		path.add(node.val); // add current node
		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				List<Integer> found = new ArrayList<>(path); // COPY! this path to the result
				result.add(found);
			}
		} else {
			pathSumHelper(node.left, sum - node.val, path, result);
			pathSumHelper(node.right, sum - node.val, path, result);
		}
		path.remove(path.size() - 1); // remove current node
	}

	// LC-437. Path Sum 3
	// Find the number of paths that sum to a given value
    // The path does not need to start or end at the root or a leaf, but it must go downwards 
	// Space O(n), Time O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
    public int pathSum3(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //
        return pathSumFrom(root, sum) + pathSum3(root.left, sum) + pathSum3(root.right, sum);
    }
    
    // return number of paths from current node go downwards
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (node.val == sum) {
            result++;
        }
        result += pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        return result;
    }
	
	
	// *****************************************************************************************
	// Print all root to leaf paths
	// method 1: user int[] and index
	public static void printPaths1(TreeNode root) {
		int[] path = new int[1000];
		printPathsHelper1(root, path, 0);
	}

	private static void printPathsHelper1(TreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen] = root.val;
		pathLen++;
		if (root.left == null && root.right == null) {
			printArray(path, pathLen);
			return;
		}
		printPathsHelper1(root.left, path, pathLen);
		printPathsHelper1(root.right, path, pathLen);
	}

	private static void printArray(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// Method 2: use stack
	public static void printPaths2(TreeNode root) {
		Stack<Integer> path = new Stack<Integer>();
		printPathsHelper2(root, path);
	}

	private static void printPathsHelper2(TreeNode root, Stack<Integer> path) {
		if (root == null)
			return;
		path.push(root.val);
		if (root.left == null && root.right == null) {
			for (Integer i : path) {
				System.out.print(i.intValue() + " ");
			}
			System.out.println();
		}
		printPathsHelper2(root.left, path);
		printPathsHelper2(root.right, path);
		path.pop(); // remove parent
	}

	// *****************************************************************************************
	// Find maximum root to leaf path sum
	// Post-order traversal
	// Time O(n)
	public static int getMaxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getMaxPathSum(root.left);
		int right = getMaxPathSum(root.right);
		return Math.max(left, right) + root.val;
	}

	// *****************************************************************************************
	// Print maximum root to leaf path sum path
	public static class SumAndPath {
		public int maxSum;
		public ArrayList<TreeNode> nodePath;

		public SumAndPath() {
			this(0, new ArrayList<TreeNode>());
		}

		public SumAndPath(int maxSum, ArrayList<TreeNode> nodePath) {
			this.maxSum = maxSum;
			this.nodePath = nodePath;
		}
	}

	private static SumAndPath printMaxPathSumHelper(TreeNode root) {
		if (root == null) {
			return new SumAndPath();
		}
		SumAndPath left = printMaxPathSumHelper(root.left);
		SumAndPath right = printMaxPathSumHelper(root.right);
		SumAndPath choice = left.maxSum > right.maxSum ? left : right;
		choice.maxSum += root.val;
		choice.nodePath.add(root);
		return choice;
	}

	public static void printMaxPathSum(TreeNode root) {
		SumAndPath result = printMaxPathSumHelper(root);
		for (int i = result.nodePath.size() - 1; i >= 0; i--) {
			System.out.print(result.nodePath.get(i).val + " ");
		}
		System.out.println();
	}

	// *****************************************************************************************
	public static void printMaxPathSum2(TreeNode root) {
		Stack<TreeNode> cur = new Stack<>();
		Stack<TreeNode> path = new Stack<>();
		int[] max = new int[] { Integer.MIN_VALUE };
		printMaxPathSum2Helper(root, cur, path, 0, max);
		for (TreeNode node : path) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}

	private static void printMaxPathSum2Helper(TreeNode root,
			Stack<TreeNode> cur, Stack<TreeNode> path, int sum, int[] max) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (sum + root.val > max[0]) {
				max[0] = sum + root.val;
				path.clear();
				path.addAll(cur);
				path.push(root);
			}
			return;
		}
		cur.push(root);
		printMaxPathSum2Helper(root.left, cur, path, sum + root.val, max);
		printMaxPathSum2Helper(root.right, cur, path, sum + root.val, max);
		cur.pop();
	}

	// *****************************************************************************************
	public static void printPath(TreeNode root, TreeNode target) {
		Stack<TreeNode> path = new Stack<>();
		printPathHelper(root, target, path);
	}

	private static void printPathHelper(TreeNode root, TreeNode target,
			Stack<TreeNode> path) {
		if (root == null)
			return;
		if (root == target) {
			for (TreeNode node : path) {
				System.out.print(node.val + " ");
			}
			System.out.println(root.val);
			return;
		}
		path.push(root);
		printPathHelper(root.left, target, path);
		printPathHelper(root.right, target, path);
		path.pop();
	}

	// *****************************************************************************************
	// Find the maximum path sum between two leaves of a binary tree
	// Time O(n)
	public static int getMax2LeavesPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		getMax2LeavesPathSumHelper(root, max);
		return max[0];
	}

	// return maximum root to leaf path sum of a binary tree
	// max[0] stores maximum path sum between two leaves
	private static int getMax2LeavesPathSumHelper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = getMax2LeavesPathSumHelper(root.left, max);
		int right = getMax2LeavesPathSumHelper(root.right, max);
		if (left + right + root.val > max[0]) {
			max[0] = left + right + root.val;
		}
		return Math.max(left, right) + root.val;
	}

	// *****************************************************************************************
	// The path may start and end at any node in the tree.
	// 1. Node only
	// 2. L-sub + Node
	// 3. R-sub + Node
	// 4. L-sub + Node + R-sub
	public static int getMaxAnyPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		getMaxAnyPathSumHelper(root, max);
		return max[0];
	}

	// max[0] stores maximum path sum between any two nodes of a binary tree
	private static int getMaxAnyPathSumHelper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = getMaxAnyPathSumHelper(root.left, max);
		int right = getMaxAnyPathSumHelper(root.right, max);
		int curMax = getMax(root.val, root.val + left, root.val + right,
				root.val + left + right);
		max[0] = Math.max(curMax, max[0]);
		return Math.max(root.val, Math.max(left, right) + root.val);
	}

	private static int getMax(int n1, int n2, int n3, int n4) {
		return Math.max(Math.max(n1, n2), Math.max(n3, n4));
	}

	// *****************************************************************************************
	// Changes the tree into its mirror image
	public static void mirror(TreeNode root) {
		if (root != null) {
			// swap
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			mirror(root.left);
			mirror(root.right);
		}
	}
	
	
	// LC-226. Invert Binary Tree
	// Time O(n), Space O(n) 
	public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
	        TreeNode left = root.left; // save left treeNode
	        root.left = invertTree(root.right);
	        root.right = invertTree(left);
        }
        return root;
    }
	
	
    public static void invertTree2(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
	
	// TODO Iterative
	
	
	
	
	
	
	
	
	
	
	
	// *****************************************************************************************
	// Clone the tree into its mirror image
	public static TreeNode cloneMirror(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = cloneMirror(root.right);
		newRoot.right = cloneMirror(root.left);
		return newRoot;
	}

	// *****************************************************************************************
	public static TreeNode clone(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = clone(root.left);
		newRoot.right = clone(root.right);
		return newRoot;
	}

	// *****************************************************************************************
	// Sum Root to Leaf Numbers
	// Given a binary tree containing digits from 0-9 only,
	// each root-to-leaf path represents a number. The root-to-leaf path 1->2->3
	// represents the number 123
	// Find the total sum of all root-to-leaf numbers.
	public static int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}

	private static int sumNumbersHelper(TreeNode root, int parentVal) {
		if (root == null) {
			return 0;
		}
		int curVal = parentVal * 10 + root.val;
		if (root.left == null && root.right == null) {
			return curVal;
		}
		return sumNumbersHelper(root.left, curVal)
				+ sumNumbersHelper(root.right, curVal);
	}

	public static class LCANodeTag {
		public TreeNode node;
		public int tag;

		public LCANodeTag(TreeNode node, int tag) {
			this.node = node;
			this.tag = tag;
		}
	}

	// Given two nodes Find the lowest common ancestor (LCA)
	public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (n1 == null || n2 == null) {
			return null;
		} else {
			LCANodeTag struct = LCAHelper(root, n1, n2);
			return struct.tag == 2 ? struct.node : null;
		}
	}

	public static LCANodeTag LCAHelper(TreeNode subRoot, TreeNode n1,
			TreeNode n2) {

		if (subRoot == null) {
			return new LCANodeTag(null, 0);
		}

		LCANodeTag leftNodeTag = LCAHelper(subRoot.left, n1, n2);
		if (leftNodeTag.tag == 2) {
			return leftNodeTag;
		}

		LCANodeTag rightNodeTag = LCAHelper(subRoot.right, n1, n2);
		if (rightNodeTag.tag == 2) {
			return rightNodeTag;
		}

		LCANodeTag thisNodeTag = new LCANodeTag(null, 0);
		if (subRoot == n1) {
			thisNodeTag.node = subRoot;
			thisNodeTag.tag += 1;
		}
		if (subRoot == n2) {
			thisNodeTag.node = subRoot;
			thisNodeTag.tag += 1;
		}

		if (leftNodeTag.tag + rightNodeTag.tag + thisNodeTag.tag == 2) {
			return new LCANodeTag(subRoot, 2);
		}

		if (leftNodeTag.tag == 1) {
			return leftNodeTag;
		}

		if (rightNodeTag.tag == 1) {
			return rightNodeTag;
		}

		return thisNodeTag;
	}

	// The root of the binary search tree.
	// A and B are two nodes in a Binary.
	// Return the least common ancestor(LCA) of the two nodes.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return null;
		}
		if (root == A || root == B) {
			return root;
		}
		TreeNode l = lowestCommonAncestor(root.left, A, B);
		TreeNode r = lowestCommonAncestor(root.right, A, B);
		if (l != null && r != null) {
			return root;
		}
		return l == null ? r : l;
	}

	// LC-101. Symmetric Tree
	// Given a binary tree, check whether it is symmetric around its center
	// Time O(n), Space O(n)
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return left.val == right.val && isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}

	// Given a binary tree, flatten it to a linked list
	// Time O(n) Space ?
	public static void flatten1(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> parentStack = new Stack<>();
		parentStack.push(root);
		TreeNode pre = null;

		while (!parentStack.isEmpty()) {
			TreeNode cur = parentStack.pop();
			if (cur.right != null) {
				parentStack.push(cur.right);
			}
			if (cur.left != null) {
				parentStack.push(cur.left);
			}
			if (pre != null) {
				pre.left = null;
				pre.right = cur;
			}
			pre = cur;
		}
	}

	// Space O(1)
	public static void flatten2(TreeNode root) {

	}

	// Given preorder and inorder traversal of a tree, construct the binary
	// tree.
	// Assume that duplicates do not exist in the tree
	// O(n);
	public static TreeNode buildTree1(int[] preorder, int[] inorder) {
		// construct index map
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < preorder.length; i++) {
			indexMap.put(inorder[i], i);
		}
		return buildTree1Helper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, indexMap);
	}

	public static TreeNode buildTree1Helper(int[] preorder, int preStart,
			int preEnd, int[] inorder, int inStart, int inEnd,
			HashMap<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}
		// root = first element in preorder traversal
		int cur = preorder[preStart];
		TreeNode root = new TreeNode(cur);

		// search in inorder array
		int index = map.get(cur);
		int len = index - inStart;
		root.left = buildTree1Helper(preorder, preStart + 1, preStart + len,
				inorder, inStart, index - 1, map);
		root.right = buildTree1Helper(preorder, preStart + len + 1, preEnd,
				inorder, index + 1, inEnd, map);
		return root;
	}

	// Given inorder and postorder traversal of a tree, construct the binary
	// tree.
	public static TreeNode buildTree2(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i], i);
		}
		return buildTree2Helper(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1, indexMap);
	}

	public static TreeNode buildTree2Helper(int[] inorder, int inStart,
			int inEnd, int[] postorder, int postStart, int postEnd,
			HashMap<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}
		int cur = postorder[postEnd];
		TreeNode root = new TreeNode(cur);
		int index = map.get(cur);
		int len = index - inStart;

		root.right = buildTree2Helper(inorder, index + 1, inEnd, postorder,
				postStart + len, postEnd - 1, map);
		root.left = buildTree2Helper(inorder, inStart, index - 1, postorder,
				postStart, postStart + len - 1, map);
		return root;
	}

	// *****************************************************************************************
	public static int maxWidth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = getMaxDepth(root);
		int maxWidth = 0;
		for (int i = 1; i <= depth; i++) {
			int width = maxWidthHelper(root, depth);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}

	private static int maxWidthHelper(TreeNode root, int level) {
		if (root == null) {
			return 0;
		}
		if (level == 0) {
			return 1;
		}
		return maxWidthHelper(root.left, level - 1)
				+ maxWidthHelper(root.right, level - 1);

	}

	// LC-543. Diameter of Binary Tree
	// The length of the longest path between any two nodes in a tree, may or may not pass through the root.
    // Time O(n), Space O(n) DFS
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = getDepthAndPath(root);
        return result[1];
	}
    
	public int[] getDepthAndPath(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = getDepthAndPath(node.left);
        int[] right = getDepthAndPath(node.right);
        int currentPath = Math.max(Math.max(left[1], right[1]),
            left[0] + right[0]);
        int currentDepth = Math.max(left[0], right[0]) + 1;
        return new int[] { currentDepth, currentPath};
    }

    // problem: use of member variable
    int max = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        getMaxDepth2(root);
        return max;
    }
    
    public int getMaxDepth2(TreeNode node) {
		if (node == null) {
			return 0;
		}
                
        int L = getMaxDepth2(node.left);
        int R = getMaxDepth2(node.right);
        max = Math.max(max, L + R); // update longest path
		return Math.max(L, R) + 1;
	}
    
    // LC-687. Longest Univalue Path
    // find the length of the longest path where each node in the path has the same value. 
    // This path may or may not pass through the root.
    // Time O(n), Space O(n) DFS
    public int longestUnivaluePath(TreeNode root) {
        int[] result = dfs(root);
        return result[0];
    }
    
    public int[] dfs(TreeNode node) {
        if (node == null) {
        	return new int[]{0,0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int depthLeft = 0, depthRight = 0;
        if (node.left != null && node.val == node.left.val) {
            depthLeft = left[0] + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            depthRight = right[0] + 1;
        }
        int longestPath = Math.max(Math.max(left[1], right[1]), depthLeft+depthRight);
        return new int[]{Math.max(depthLeft, depthRight), longestPath};
    }
    
    // problem: use of member variable
    private int path = 0;
    public int longestUnivaluePath2(TreeNode root) {
        dfs(root);
        return path;
    }
    
    public int dfs2(TreeNode node) {
        if (node == null) return 0;
        int left = dfs2(node.left);
        int right = dfs2(node.right);
        int depthLeft = 0, depthRight = 0;
        if (node.left != null && node.val == node.left.val) {
            depthLeft = left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            depthRight = right + 1;
        }
        path = Math.max(path, depthLeft+depthRight);
        return Math.max(depthLeft, depthRight);
    }
    
    // LC-617. Merge Two Binary Trees
    // Time O(n), Space O(n)
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int n1 = t1 == null ? 0 : t1.val;
        int n2 = t2 == null ? 0 : t2.val;

        TreeNode node = new TreeNode(n1 + n2);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null? null: t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null? null : t2.right);
        return node;
    }
    
    // LC-404. Sum of Left Leaves
    // Time O(n), Space O(n)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // check isLeaf(root.left)
        if ( root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
     }
    
    // LC-337. House Robber III
    // overlapping of subproblems, not optimal
    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = rob(root.left);
        int right = rob(root.right);
        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
           val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(left + right,  val);
    }
    
    // Optimal DP
    // res[0] - the maximum amount of money that can be robbed if root is not robbed, 
    // res[1] the maximum amount of money robbed if it is robbed
    public static int rob2(TreeNode root) {
        int[] res = robSub(root); 
        return Math.max(res[0], res[1]);
    }

    private static int[] robSub(TreeNode root) {
        if (root == null) {
        	return new int[] { 0, 0 };
        }
        
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        return new int[] {
        		Math.max(left[0], left[1]) + Math.max(right[0], right[1]),
        		root.val + left[0] + right[0]
        };
    }
}
