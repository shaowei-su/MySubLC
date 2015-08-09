package leetcode;

public class RemoveNthNodeFromEndofList2 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		
		if (fast == null) {
			head = head.next;
			return head;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		
		return head;
	}
}
