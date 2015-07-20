package com.leetcode;

import java.util.*;

public class MyGraph_adjList {

	// Definition for undirected graph.
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	// BFS
	public static UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, clone);

		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			UndirectedGraphNode cur = q.remove();
			List<UndirectedGraphNode> curNeighborsClone = map.get(cur).neighbors;

			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor)) { // not visited
					q.add(neighbor);
					UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(
							neighbor.label);
					curNeighborsClone.add(cloneNeighbor);
					map.put(neighbor, cloneNeighbor); // mark as visited
				} else {
					curNeighborsClone.add(map.get(neighbor));
				}
			}
		}
		return clone;
	}

	// DFS
	public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		cloneGraphhelper(node, map);
		return clone;
	}

	private static void cloneGraphhelper(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(
						neighbor.label);
				map.put(neighbor, copy);
				cloneGraphhelper(neighbor, map);
			}
			map.get(node).neighbors.add(map.get(neighbor));
		}
	}

	// {0,1,2#1,2#2,2}
	public static UndirectedGraphNode buildGraph(String[] s) {

		return null;
	}

	// Topological ordering problem
	// finding if a cycle exists in a directed graph
	// Given the total number of courses and a list of prerequisite pairs, is it
	// possible for you to finish all courses?
	public static boolean canFinish(int numCourses, int[][] prereq) {
		// construct graph matrix
		int[][] graph = new int[numCourses][numCourses];
		for (int i = 0; i < prereq.length; i++) {
			graph[prereq[i][1]][prereq[i][0]] = 1;
		}
		int[] visited = new int[numCourses]; // 0 / 1 / 2: not visited /
												// visiting / visited
		// detect cycle in each connected component
		for (int v = 0; v < numCourses; v++) {
			if (visited[v] == 0) {
				if (!canFinishDFS(graph, visited, v)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean canFinishDFS(int[][] graph, int[] visited, int cur) {
		visited[cur] = 1; // 1: visiting
		for (int otherNode = 0; otherNode < graph.length; otherNode++) {
			if (graph[cur][otherNode] == 1) { // edge exists
				if (visited[otherNode] == 1) {
					// cycle
					return false;
				}
				if (visited[otherNode] == 0
						&& !canFinishDFS(graph, visited, otherNode)) {
					return false;
				}
			}
		}
		visited[cur] = 2; // 2: visit done
		return true;
	}

}
