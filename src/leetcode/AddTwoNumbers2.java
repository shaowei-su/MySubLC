package leetcode;
/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers2 {
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
		
		int carry = 0; //save the temporary value of each computation

		
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry % 10);
			carry = carry / 10;
			p3 = p3.next;
		}
		//special case, p1 and p2 have same length and flag is true
		if (carry != 0) {
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
