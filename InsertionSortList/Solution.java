/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode dummy = new ListNode(head.val);
        ListNode pointer = head.next;

        while (pointer != null) {
        	ListNode innerPointer = dummy;
        	ListNode next = pointer.next;
    		//head
    		if (pointer.val <= dummy.val) {
    			ListNode oldHead = dummy;
    			dummy = pointer;
    			dummy.next = oldHead;
    		}      	
        	while (innerPointer.next != null) {
        		//middle
        		if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
        			ListNode oldNext = innerPointer.next;
        			innerPointer.next = pointer;
        			pointer.next = oldNext;
        		}
        		innerPointer = innerPointer.next;
        	}
    		//tail
    		if (innerPointer.next == null && pointer.val > innerPointer.val) {
    			innerPointer.next = pointer;
    			pointer.next = null;
    		}
        	pointer = next;
        }

        return dummy;
    }

	public static void main(String[] args) {
		
		ListNode n2 = new ListNode(3);
		ListNode n1 = new ListNode(2);
		ListNode n3 = new ListNode(4);
 
		// ListNode n4 = new ListNode(3);
		// ListNode n5 = new ListNode(4);
		// ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;
 
		Solution sol = new Solution();
		ListNode res = sol.insertionSortList(n1);
 
		printList(res);
 
	}
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}