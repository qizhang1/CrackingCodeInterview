package com.leetcode;

import java.util.*;

public class MyLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}



	// *****************************************************************************************
	// basic approach
	public static ListNode createLinkedListFromArray1(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		// head
		int i = 0;
		ListNode head = new ListNode(arr[i]);
		// body
		ListNode cur = head;
		for (i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return head;
	}

	// dummy node approach
	public static ListNode createLinkedListFromArray2(int[] arr) {
		ListNode dummyHead = new ListNode(0); // dummy head
		ListNode cur = dummyHead;
		for (int i = 0; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return dummyHead.next; // head = dummyHead.next
	}

	// *****************************************************************************************
	public static boolean isLinkedListEqual(ListNode head1, ListNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.val != head2.val) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1 == null && head2 == null;
	}

	// *****************************************************************************************
	public static void printLinkedList(ListNode head) {
		ListNode cur = head; // not necessary
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// *****************************************************************************************
	// Given a sorted linked list, delete all duplicates
	// each element appear only once
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.next.val != cur.val){
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
	}

	// *****************************************************************************************
	// Given a sorted linked list, delete all nodes that have duplicate numbers
	// leaving only distinct numbers from the original list.
	public static ListNode deleteDuplicates2(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode cur = dummyHead;

		while (cur.next != null) {
			// test if duplicates are found
			if (cur.next.next != null && cur.next.val == cur.next.next.val) {
				int val = cur.next.val;
				while (cur.next != null && cur.next.val == val) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}

	public static ListNode deleteDuplicates2_2(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = head;

        while (cur != null){
        	// find all duplicate node
            if (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            } else {
                if (pre.next == cur) { // no duplicates --> inchworm
                    pre = cur;
                } else { // remove all duplicates --> leapfrog
                    pre.next = cur.next;
                }
                cur = cur.next;
            }   
        }
		return dummyHead.next;
	}

	// *****************************************************************************************
	// no need special case for head == null
	public static ListNode prepend(ListNode head, int toPrepend) {
		ListNode newNode = new ListNode(toPrepend);
		newNode.next = head;
		head = newNode;
		return head;
	}

	// *****************************************************************************************
	public static ListNode append(ListNode head, int toAppend) {
		ListNode newNode = new ListNode(toAppend);
		if (head == null) {
			return newNode;
		} else {
			ListNode cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = newNode;
			return head;
		}
	}

	// *****************************************************************************************
	public static ListNode insertAfter(ListNode head, int key, int toInsert) {
		if (head == null) {
			return null;
		}
		// search for key
		ListNode cur = head;
		while (cur != null && cur.val != key) {
			cur = cur.next;
		}
		// cur == null means key not found
		if (cur != null) {
			ListNode newNode = new ListNode(toInsert);
			newNode.next = cur.next;
			cur.next = newNode;
		}
		return head;
	}

	// *****************************************************************************************
	public static ListNode insertBefore1(ListNode head, int key, int toInsert) {
		if (head == null) {
			return null;
		}
		ListNode newNode = new ListNode(toInsert);
		if (head.val == key) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode pre = null;
			ListNode cur = head;

			while (cur != null && cur.val != key) {
				pre = cur;
				cur = cur.next;
			}
			if (cur != null) {
				newNode.next = cur;
				pre.next = newNode;
			}
		}
		return head;
	}

	public static ListNode insertBefore2(ListNode head, int key, int toInsert) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = head;

		// search for key
		while (cur != null && cur.val != key) {
			pre = cur;
			cur = cur.next;
		}
		if (cur != null) {
			ListNode newNode = new ListNode(toInsert);
			newNode.next = cur;
			pre.next = newNode;
		}
		return dummyHead.next;
	}

	// *****************************************************************************************
	// removeFirstOccurrence
	public static ListNode remove1(ListNode head, int key) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = head;

		while (cur != null && cur.val != key) {
			pre = cur;
			cur = cur.next;
		}
		if (cur != null) {
			pre.next = cur.next;
		}
		return dummyHead.next;
	}

	public static ListNode remove2(ListNode head, int key) {
		if (head == null) {
			return null;
		}
		if (head.val == key) {
			return head.next;
		}

		ListNode cur = head;
		ListNode pre = null;
		while (cur != null && cur.val != key) {
			pre = cur;
			cur = cur.next;
		}
		if (cur != null) {
			pre.next = cur.next;
		}
		return head;
	}
	
	// *****************************************************************************************
	// Remove all elements from a linked list of integers that have value val.
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        
        while (cur != null){
            if (cur.val == val){ 
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

	// *****************************************************************************************
	// Given a linked list, remove the nth node from the end of list and
	// return its head in one pass.
	// Given n will always be valid.
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode pre = dummyHead;
		ListNode cur = head;

		// cur move n first
		for (int i = 0; i < n; i++) {
			cur = cur.next;
		}

		// advance together
		while (cur != null) {
			pre = pre.next;
			cur = cur.next;
		}
		// remove the node
		pre.next = pre.next.next;
		return dummyHead.next;
	}

	// *****************************************************************************************
	// Merge two sorted linked lists and return it as a new list.
	// The new list should be made by splicing together the nodes of the first
	// two lists.
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur;
		for (cur = dummyHead; l1 != null && l2 != null; cur = cur.next) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
		}
		// the rest part
		cur.next = (l1 == null) ? l2 : l1;
		return dummyHead.next;
	}

	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		// head
		ListNode head;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		// body
		ListNode cur;
		for (cur = head; l1 != null && l2 != null; cur = cur.next) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;

			} else {
				cur.next = l2;
				l2 = l2.next;
			}
		}
		// tail
		cur.next = (l1 == null) ? l2 : l1;
		return head;

	}

	// *****************************************************************************************
	// �ܹ������Ľڵ���ĿΪn(2+3+��+k) = n*(k^2+k-2)/2, ʱ�临�Ӷ���O(nk^2)
	public static ListNode mergeKLists1(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		ListNode head = lists.get(0);
		// ListNode cur = head;
		for (int i = 1; i < lists.size(); i++) {
			head = mergeTwoLists1(head, lists.get(i));
		}
		return head;
	}

	public static ListNode mergeKLists2(List<ListNode> lists) {
		int n = lists.size();
		if (n == 0) {
			return null;
		}
		while (n > 1) {
			int mid = (n + 1) / 2;
			for (int i = 0; i < n / 2; i++) {
				lists.set(i, mergeTwoLists1(lists.get(i), lists.get(i + mid)));
			}
			n = mid;
		}
		return lists.get(0);
	}

	public static ListNode mergeKLists3(List<ListNode> lists) {
		int n = lists.size();
		if (n == 0) {
			return null;
		}
		for (int j = 1; j < n; j *= 2) {
			for (int i = 0; i + j < n; i = i + 2 * j) {
				lists.set(i, mergeTwoLists1(lists.get(i), lists.get(i + j)));
			}
		}
		return lists.get(0);
	}

	public static ListNode mergeKLists4(List<ListNode> lists) {
		int n = lists.size();
		if (n == 0) {
			return null;
		}
		if (n > 1) {
			int mid = n / 2;
			lists.set(
					0,
					mergeTwoLists1(mergeKLists4(lists.subList(0, mid)),
							mergeKLists4(lists.subList(mid, n))));
		}
		return lists.get(0);
	}

	// *****************************************************************************************
	// Swap every two adjacent nodes and return its head.
	// O(n)
	public static ListNode swapPairs(ListNode head) {
		// if (head == null || head.next == null){
		// return head;
		// }
		if (head == null)
			return null;

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode pre = dummyHead;
		ListNode cur = head;
		ListNode next = head.next;

		while (next != null) {
			pre.next = next;
			cur.next = next.next;
			next.next = cur;

			pre = cur;
			cur = cur.next;
			next = cur != null ? cur.next : null;
		}
		return dummyHead.next;
	}

	// *****************************************************************************************
	// Reverse a linked list.
	// Time O(n) Space O(1)
	public static ListNode reverse(ListNode head) {
		 ListNode cur = head;
	     ListNode newHead = null;

	     while (cur != null){
	    	 ListNode toPrepend = cur;
	         cur = cur.next;
	         toPrepend.next = newHead;
	         newHead = toPrepend;
	     }
	     return newHead;
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;

		int i;
		for (i = 1; i < m; i++) {
			pre = pre.next;
		}

		ListNode head2 = pre;
		pre = pre.next;
		ListNode cur = pre.next;

		for (; i < n; i++) {
			pre.next = cur.next;
			cur.next = head2.next;
			head2.next = cur;
			// next node
			cur = pre.next;
		}
		return dummyHead.next;
	}

	// *****************************************************************************************
	// O(n^2)
	public ListNode insertionSortList1(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = head;
		while (cur != null) {
			// find insert position
			ListNode pre = dummyHead;
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummyHead.next;
	}

	// Time O(nlogn), Space O(1)
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// find mid node
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null; // break the list

		ListNode l1 = sortList(head);
		ListNode l2 = sortList(mid);
		return mergeTwoLists1(l1, l2);
	}

	// Given a linked list, determine if it has a cycle in it
	public static boolean hasCycle(ListNode head) {
		ListNode n1 = head;
		ListNode n2 = head;
		while (n2 != null && n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				return true;
			}
		}
		return false;
	}

	// Add the two numbers and return it as a linked list.
	// Ex. (2 -> 4 -> 3) + (5 -> 6 -> 4) = 7 -> 0 -> 8  342 + 465 = 807
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		int carryover = 0;
		while (l1 != null || l2 != null) {
			int n1 = (l1 != null) ? l1.val : 0;
			int n2 = (l2 != null) ? l2.val : 0;
			int sum = n1 + n2 + carryover;
			cur.next = new ListNode(sum % 10);
			carryover = sum / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			cur = cur.next;
		}
		if (carryover != 0) {
			cur.next = new ListNode(carryover);
		}
		return dummyHead.next;
	}

	// Given a singly linked list L: L0��L1������Ln-1��Ln,
	// reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
	// Time O(n), Space O(1)
	public static void reorderList(ListNode head) {
		if (head == null)
			return;
		// break in the mid
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right = slow.next;
		slow.next = null; // cut at the middle

		// reverse the right list
		right = reverse(right);

		// merge left and right lists
		ListNode left = head;
		while (left.next != null) {
			ListNode nextL = left.next;
			ListNode nextR = right.next;
			right.next = nextL;
			left.next = right;
			left = nextL;
			right = nextR;
		}
		left.next = right;
	}
	
	// *****************************************************************************************
	// Definition for singly-linked list with a random pointer.
	public static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
		}
	}
	
	// Time O(n) Space O(n)
	public RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null) {
			return null;
		}
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        
        // copy the head
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode origin = head;
        RandomListNode copy = newHead;
        // copy the list
        while(origin.next != null){
        	copy.next = new RandomListNode(origin.next.label);
        	origin = origin.next;
        	copy = copy.next;
        	map.put(origin, copy);
        }
        
        // reset
        origin = head;
        copy = newHead;
        // copy the random pointer
        while (origin != null) {
        	//if (cur.random != null) {
        		copy.random = map.get(origin.random);
        	//} 
        	origin = origin.next;
        	copy = copy.next;
        }
        return newHead;
    }
	
	// *****************************************************************************************
	// Time O(n) Space O(1)
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// 1. double the list
		RandomListNode origin = head;
		while (origin != null) {
			RandomListNode next = origin.next;
			origin.next = new RandomListNode(origin.label);
			origin.next.next = next;
			origin = next;
		}
		// 2. copy the random pointer
		origin = head;
		while (origin != null) {
			if (origin.random != null) {
				origin.next.random = origin.random.next;
			}
			origin = origin.next.next;
		}
		
		// 3. restore both lists
		origin = head;
		RandomListNode newHead = origin.next;
		while (origin != null) {
		    RandomListNode copy = origin.next;
			origin.next = origin.next.next;
			if (copy.next != null) {
				copy.next = copy.next.next;
			}
			origin = origin.next;
		}
		return newHead;		
	}
}
