package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveNthNodeFromEndofList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) return null;
    	ListNode iter = head;
    	for (int i = 1; i < n; i++) {
    		iter = iter.next;
    	}
    	ListNode rem = new ListNode(0);
    	rem.next = head;
    	if (iter.next == null) {
    		rem.next = rem.next.next;
    		return rem.next;
    	}
    	while (iter.next != null) {
    		rem = rem.next;
    		iter = iter.next;
    	}
    	rem.next = rem.next.next;
    	return head;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
