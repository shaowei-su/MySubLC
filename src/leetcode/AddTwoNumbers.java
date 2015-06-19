package leetcode;
/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = new ListNode(0);
		
		ListNode headNode = p3;
		
		int res = 0; //save the temporary value of each computation
		boolean flag = false; //indicate if there is carry 
		
		while (p1 != null || p2 != null) {
			if (p1 != null && p2 != null) {
				//check carry
				if (flag) {
					res = p1.val + p2.val + 1;
				} else {
					res = p1.val + p2.val;
				}
				//check result if larger than 10
				if (res >= 10) {
					flag = true;
				} else {
					flag = false;
				}
				//store result
				p3.next = new ListNode(res % 10);
				p1 = p1.next;
				p2 = p2.next;
			} else if (p1 != null) {
				//check carry
				if (flag) {
					res = p1.val + 1;
				} else {
					res = p1.val;
				}
				//check if result larger than 10
				if (res >= 10) {
					flag = true;
				} else {
					flag = false;
				}
				p3.next = new ListNode(res % 10);
				p1 = p1.next;
			} else if (p2 != null) {
				//check carry
				if (flag) {
					res = p2.val + 1;
				} else {
					res = p2.val;
				}
				//check if result larger than 10
				if (res >= 10) {
					flag = true;
				} else {
					flag = false;
				}
				p3.next = new ListNode(res % 10);
				p1 = p2.next;				
			}
			//no matter which case, p3 changes
			p3 = p3.next;
		}
		//special case, p1 and p2 have same length and flag is true
		if (p1 == null && p2 == null && flag) {
			p3.next = new ListNode(1);
		}
		
		return headNode.next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode test;
		test = a.addTwoNumbers(l1, l2);
		
		do {
			System.out.println(test.val);
			test = test.next;
		} while (test != null);
		
		
	}

}
