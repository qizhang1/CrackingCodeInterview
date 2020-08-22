package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import com.leetcode.MyLinkedList;
import com.leetcode.MyLinkedList.ListNode;

public class MyLinkedListTest extends TestCase {
	
	
	public void testIsLinkedListEqual1()
	{
		assertTrue(MyLinkedList.isLinkedListEqual(null, null));
	}
	
	public void testIsLinkedListEqual2()
	{
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{1});
		assertFalse(MyLinkedList.isLinkedListEqual(head1, null));
	}
	
	public void testIsLinkedListEqual3()
	{
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{1,2});
		assertFalse(MyLinkedList.isLinkedListEqual(null, head1));
	}
	
	public void testDeleteDuplicates1_1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{1,2,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray2(new int[]{1,1,2,3,3});
		MyLinkedList.deleteDuplicates(head2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testDeleteDuplicates1_2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{1,2});
		ListNode head2 = MyLinkedList.createLinkedListFromArray2(new int[]{1,1,2});
		MyLinkedList.deleteDuplicates(head2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testDeleteDuplicates2_1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{2,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray2(new int[]{1,1,2,3,4,4,5,5});
		head2 = MyLinkedList.deleteDuplicates2(head2);
		//MyLinkedList.PrintLinkedList(head2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testDeleteDuplicates2_2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray2(new int[]{2,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray2(new int[]{1,1,1,2,3});
		head2 = MyLinkedList.deleteDuplicates2(head2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testPreppend1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{2,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3});
		head1 = MyLinkedList.prepend(head1, 1);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testPreppend2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		ListNode head2 = MyLinkedList.prepend(null, 1);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testAppend1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3});
		head1 = MyLinkedList.append(head1, 3);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testAppend2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		ListNode head2 = MyLinkedList.append(null, 1);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertAfter1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{5,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5,2,3});
		head1 = MyLinkedList.insertAfter(head1, 5, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertAfter2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2});
		head1 = MyLinkedList.insertAfter(head1, 1, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertBefore1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{5,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5,2,3});
		head1 = MyLinkedList.insertBefore1(head1, 3, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertBefore2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{2});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2});
		head1 = MyLinkedList.insertBefore1(head1, 2, 1);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertBefore3(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{5,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5,2,3});
		head1 = MyLinkedList.insertBefore2(head1, 3, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	public void testInsertBefore4(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{2});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2});
		head1 = MyLinkedList.insertBefore2(head1, 2, 1);
		assertTrue(MyLinkedList.isLinkedListEqual(head1, head2));
	}
	
	
	public void testRemove1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{3,2,4,5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{3,4,5});
		ListNode head3 = MyLinkedList.remove1(head1, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head3, head2));
	}
	
	
	public void testRemove2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{3,2,4,5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{3,4,5});
		ListNode head3 = MyLinkedList.remove2(head1, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head2, head3));
	}
	
	
	public void testRemoveNthFromEnd1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3,4,5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3,5});
		ListNode head3 = MyLinkedList.removeNthFromEnd(head1, 2);
		assertTrue(MyLinkedList.isLinkedListEqual(head2, head3));
	}
	
	public void testRemoveNthFromEnd2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3,4,5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{2,3,4,5});
		ListNode head3 = MyLinkedList.removeNthFromEnd(head1, 5);
		assertTrue(MyLinkedList.isLinkedListEqual(head2, head3));
	}
	
	
	public void testMergeTwoLists1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{2,4,5});
		ListNode head3 = MyLinkedList.mergeTwoLists1(head1, head2);
		ListNode head4 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3,4,5});
		assertTrue(MyLinkedList.isLinkedListEqual(head3, head4));
	}
	
	public void testMergeTwoLists2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1,3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{2,4,5});
		ListNode head3 = MyLinkedList.mergeTwoLists2(head1, head2);
		ListNode head4 = MyLinkedList.createLinkedListFromArray1(new int[]{1,2,3,4,5});
		assertTrue(MyLinkedList.isLinkedListEqual(head3, head4));
	}
	
	
//	public void testMergeKLists1(){
//		List<ListNode> lists = new ArrayList<>();
//		lists.add(MyLinkedList.createLinkedListFromArray1(new int[]{1}));
//		lists.add(MyLinkedList.createLinkedListFromArray1(new int[]{0}));
//		ListNode list3 = MyLinkedList.createLinkedListFromArray1(new int[]{0,1});
//		MyLinkedList.printLinkedList(MyLinkedList.mergeKLists4(lists));
//		assertTrue(MyLinkedList.isLinkedListEqual(list3,MyLinkedList.mergeKLists4(lists)));
//	}
	
	public void testMergeKLists2(){
		List<ListNode> lists = new ArrayList<>();
		lists.add(MyLinkedList.createLinkedListFromArray1(new int[]{2, 5}));
		lists.add(MyLinkedList.createLinkedListFromArray1(new int[]{1, 3, 4 }));
		ListNode list3 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 2, 3, 4, 5});
		//MyLinkedList.printLinkedList(MyLinkedList.mergeKLists4(lists));
		assertTrue(MyLinkedList.isLinkedListEqual(list3,MyLinkedList.mergeKLists4(lists)));
	}
	
	public void testSwapPairs1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 2, 3, 4, 5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{2, 1, 4, 3, 5});
		ListNode head3 = MyLinkedList.swapPairs(head1);
		assertTrue(MyLinkedList.isLinkedListEqual(head2, head3));
	}
	
	public void testReverse1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 2, 3, 4, 5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5, 4, 3, 2, 1});
		assertTrue(MyLinkedList.isLinkedListEqual(head2, MyLinkedList.reverse(head1)));
	}
	
	public void testReverse2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		assertTrue(MyLinkedList.isLinkedListEqual(head1, MyLinkedList.reverse(head1)));
	}
	
	public void testReverseList1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 2, 3, 4, 5});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 4, 3, 2, 5});
		assertTrue(MyLinkedList.isLinkedListEqual(head2, MyLinkedList.reverseBetween(head1, 2, 4)));
	}
	
	public void testReverseList2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		assertTrue(MyLinkedList.isLinkedListEqual(head1, MyLinkedList.reverseBetween(head1, 1, 1)));
	}
	
	public void testAddTwoNumbers1(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{2, 4, 3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5, 6, 4});
		ListNode result = MyLinkedList.createLinkedListFromArray1(new int[]{7, 0, 8});
		assertTrue(MyLinkedList.isLinkedListEqual(result, MyLinkedList.addTwoNumbers(head1, head2)));
	}
	
	public void testAddTwoNumbers2(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{0, 1});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{0, 1, 2});
		ListNode result = MyLinkedList.createLinkedListFromArray1(new int[]{0, 2, 2});
		assertTrue(MyLinkedList.isLinkedListEqual(result, MyLinkedList.addTwoNumbers(head1, head2)));
	}
	
	public void testAddTwoNumbers3(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{9, 9});
		ListNode result = MyLinkedList.createLinkedListFromArray1(new int[]{0, 0, 1});
		assertTrue(MyLinkedList.isLinkedListEqual(result, MyLinkedList.addTwoNumbers(head1, head2)));
	}
	
	public void testAddTwoNumbers(){
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{7, 2, 4, 3});
		ListNode head2 = MyLinkedList.createLinkedListFromArray1(new int[]{5, 6, 4});
		ListNode result = MyLinkedList.createLinkedListFromArray1(new int[]{7, 8, 0, 7});
		assertTrue(MyLinkedList.isLinkedListEqual(result, MyLinkedList.addTwoNumbers2(head1, head2)));
	}
	
	
	
	public void testReorderList() {
		ListNode head1 = MyLinkedList.createLinkedListFromArray1(new int[]{1, 2, 3, 4});
		ListNode result = MyLinkedList.createLinkedListFromArray1(new int[]{1, 4, 2, 3});
		MyLinkedList.reorderList(head1);
		MyLinkedList.printLinkedList(head1);
		assertTrue(MyLinkedList.isLinkedListEqual(result, head1));
	}
	
}
