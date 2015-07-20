package com.leetcode;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class MyGraph_adjMatrixTest {

	@Test
	public void testDFS1() {
		int[][] adjMatrix = {{1, 1, 0, 1, 1, 0},
				             {0, 0, 1, 0, 1, 0},
			                 {0, 0, 0, 0, 1, 1},
			                 {0, 0, 0, 0, 1, 0},
			                 {0, 0, 0, 0, 0, 1},
			                 {0, 0, 0, 1, 0, 0}};
		List<Integer> DFS = Arrays.asList(0, 1, 2, 4, 5, 3);
		assertEquals(DFS, MyGraph_adjMatrix.DFS1(adjMatrix, 0));
	}
	
	@Test
	public void testDFS2() {
		int[][] adjMatrix = {{0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
							 {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
				             {1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
				             {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				             {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				             {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};
		List<Integer> DFS = Arrays.asList(0, 1, 3, 4, 6, 5, 2, 7, 8);
		assertEquals(DFS, MyGraph_adjMatrix.DFS1(adjMatrix, 0));
	}
	
	@Test
	public void testDFS3() {
		int[][] adjMatrix = {{1, 1, 0, 1, 1, 0},
				             {0, 0, 1, 0, 1, 0},
			                 {0, 0, 0, 0, 1, 1},
			                 {0, 0, 0, 0, 1, 0},
			                 {0, 0, 0, 0, 0, 1},
			                 {0, 0, 0, 1, 0, 0}};
		List<Integer> DFS = Arrays.asList(0, 1, 2, 4, 5, 3);
		assertEquals(DFS, MyGraph_adjMatrix.DFS2(adjMatrix, 0));
	}
	
	@Test
	public void testDFS4() {
		int[][] adjMatrix = {{0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
							 {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
				             {1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
				             {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				             {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				             {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				             {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};
		List<Integer> DFS = Arrays.asList(0, 1, 3, 4, 6, 5, 2, 7, 8);
		assertEquals(DFS, MyGraph_adjMatrix.DFS2(adjMatrix, 0));
	}
	
	
	@Test
	public void testBuildLevelGraph() {
		int[][] adjMatrix = {{0, 1, 1, 0, 0},
				             {0, 0, 0, 1, 1},
				             {0, 0, 0, 1, 0},
			                 {0, 0, 1, 0, 1},
			                 {0, 0, 0, 0, 0}};
		int[][] levelGraph = {{0, 1, 1, 0, 0},
	             			 {0, 0, 0, 1, 1},
	             			 {0, 0, 0, 1, 0},
                             {0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0}};
		assertArrayEquals(levelGraph, MyGraph_adjMatrix.buildLevelGraph(adjMatrix));
	}
	
	@Test
	public void testNumIslands1() {
		char[][] map = new char[][]{{'1', '1', '0', '0', '0'},
				                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '1', '0', '0'},
                                     {'0', '0', '0', '1', '1'}};
		assertEquals(3, MyGraph_adjMatrix.numIslands1(map));
		assertEquals(3, MyGraph_adjMatrix.numIslands2(map));
	}
	
	@Test
	public void testNumIslands2() {
		char[][] map = new char[][]{{'1', '1', '1', '1', '0'},
				                     {'1', '1', '0', '1', '0'},
                                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '0', '0', '0'}};	
		assertEquals(1, MyGraph_adjMatrix.numIslands1(map));
		assertEquals(1, MyGraph_adjMatrix.numIslands2(map));
	}
	
	@Test
	public void testNumIslands3() {
		char[][] map = new char[][]{ {'1', '1', '1'},
				                     {'0', '1', '0'},
                                     {'1', '1', '1'}};	
		assertEquals(1, MyGraph_adjMatrix.numIslands1(map));
		assertEquals(1, MyGraph_adjMatrix.numIslands2(map));
	}

}
