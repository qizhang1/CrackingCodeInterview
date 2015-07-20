package com.leetcode;

import java.util.*;

public class MyGraph_adjMatrix {

	public static List<Integer> DFS1(int[][] adjMatrix, int startVertex) {
		int numVertices = adjMatrix.length;
		boolean[] visited = new boolean[numVertices];
		// for (int i = 0; i < numVertices; i++) {
		// visited[i] = false;
		// }
		List<Integer> result = new ArrayList<>();
		DFS1Helper(adjMatrix, startVertex, result, visited);
		return result;
	}

	private static void DFS1Helper(int[][] adjMatrix, int startVertex,
			List<Integer> result, boolean[] visited) {
		visited[startVertex] = true;
		result.add(startVertex);
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[startVertex][i] == 1 && !visited[i]) {
				DFS1Helper(adjMatrix, i, result, visited);
			}
		}
	}

	public static List<Integer> DFS2(int[][] adjMatrix, int startVertex) {
		int numVertices = adjMatrix.length;
		boolean[] visited = new boolean[numVertices];
		// for (int i = 0; i < numVertices; i++) {
		// visited[i] = false;
		// }
		List<Integer> result = new ArrayList<>();
		Stack<Integer> parentStack = new Stack<>();
		parentStack.add(startVertex);
		while (!parentStack.isEmpty()) {
			int cur = parentStack.pop();
			if (visited[cur] == false) {
				visited[cur] = true;
				result.add(cur);
				for (int i = numVertices - 1; i > 0; i--) {
					if (adjMatrix[cur][i] == 1 && visited[i] == false) {
						parentStack.add(i);
					}
				}
			}
		}
		return result;
	}

	public static int[][] buildLevelGraph(int[][] adjMatrix) {
		int n = adjMatrix.length;

		int[][] levelGraph = new int[n][n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}

		HashSet<Integer> visiting = new HashSet<Integer>();
		visiting.add(0);
		while (!visiting.isEmpty()) {
			HashSet<Integer> next = new HashSet<Integer>();
			for (int i : visiting) {
				for (int j = 0; j < n; j++) {
					if (!visited[j] && !visiting.contains(j)
							&& adjMatrix[i][j] == 1) {
						levelGraph[i][j] = 1;
						next.add(j);
					}
				}
			}
			for (int i : visiting) {
				visited[i] = true;
			}
			visiting = next;
		}
		MyUtility.displayMatrix(levelGraph);
		return levelGraph;
	}

	// *****************************************************************************************
	// Given a 2D grid map of '1's (land) and '0's (water), count the number of
	// islands.
	// An island is surrounded by water and is formed by connecting adjacent
	// lands horizontally or vertically.
	// Assume all four edges of the grid are all surrounded by water.
	// Counting number of connected components in a undirected graph
	// Time Complexity O(m * n) Space O(m * n)
	public static int numIslands1(char[][] grid) {
		int count = 0;
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					// call DFS on the next un-visited component
					numIslandsDFS(grid, i, j, visited); 
					count++;
				}
			}
		}
		return count;
	}
	
	// In each DFS() call, a component or a sub-graph is visited.
	private static void numIslandsDFS(char[][] grid, int r, int c,
			boolean[][] visited) {
		if (!isValid(grid, r, c) || grid[r][c] == '0' || visited[r][c]) return;

		visited[r][c] = true;
		numIslandsDFS(grid, r, c - 1, visited); // 左
		numIslandsDFS(grid, r, c + 1, visited); // 右
		numIslandsDFS(grid, r - 1, c, visited); // 上
		numIslandsDFS(grid, r + 1, c, visited); // 下
	}
	
	private static boolean isValid(char[][] grid, int r, int c){
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}

	// *****************************************************************************************
	// BFS
	public static int numIslands2(char[][] grid) {
		int count = 0;
		int row = grid.length;
		if (row == 0) {
			return 0;
		}
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					numIslandsBFS(grid, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}
	public static class Pair {
		int row;
		int col;
		
		Pair(int r, int c) {
			row = r;
			col = c;
		}
	}

	private static void numIslandsBFS(char[][] grid, int i, int j,
			boolean[][] visited) {
		// 上，下，左，右
		int[] x = new int[]{-1, 1, 0, 0};
		int[] y = new int[]{0, 0, -1, 1};
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		visited[i][j] = true;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int k = 0; k < x.length; k++){
				int r = cur.row + x[k];
				int c = cur.col + y[k];
				if (isValid(grid, r, c) && grid[r][c] == '1' && !visited[r][c]){
					q.add(new Pair(r, c));
					visited[r][c] = true;
				}
			}
		}
	}

	// *****************************************************************************************

}
