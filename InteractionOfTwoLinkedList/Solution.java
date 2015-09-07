/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }

        ListNode iterA = headA;

        while (iterA != null) {
        	ListNode iterB = headB;
	        while (iterB != null) {
	        	if (iterB == iterA) {
	        		return iterA;
	        	}
	        	iterB = iterB.next;
	        }
        	iterA = iterA.next;
        }

        return null;

    }
}