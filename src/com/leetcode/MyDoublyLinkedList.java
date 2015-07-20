package com.leetcode;

public class MyDoublyLinkedList {
	public static class DBListNode {
		int val;
		DBListNode next;
		DBListNode prev;

		DBListNode(int x) {
			val = x;
			next = null;
			prev = null;
		}
	}
	
	void remove(DBListNode head, int val) {
		DBListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
			if (cur.prev != null)
				cur.prev.next = cur.next;
			if (cur.next != null)
				cur.next.prev = cur.prev;
				break;
			}
			cur = cur.next;
		}
	}
}
