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
        ListNode iterB = headB;

        int lengthA = 0;
        int lengthB = 0;

        while (iterA != null) {
            lengthA++;
            iterA = iterA.next;
        }
        while (iterB != null) {
            lengthB++;
            iterB = iterB.next;
        }

        iterA = headA;
        iterB = headB;

        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                iterA = iterA.next;
            }
        } else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                iterB = iterB.next;
            }
        } 

        while (iterA != null) {
            if (iterA == iterB) {
                return iterA;
            }
            iterA = iterA.next;
            iterB = iterB.next;
        }

        return null;

    }
}