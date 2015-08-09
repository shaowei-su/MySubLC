package leetcode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
    	//edge cases
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null) {
    		return head;
    	}
    	int size = 0;
    	ListNode dum = head;
    	while (dum != null) {
    		size++;
    		dum = dum.next;
    	}
    	
    	k %= size;
    	for (int i = 0; i < k; i++) {
        	ListNode prev = head;
        	ListNode cur = head.next;
        	while (cur.next != null) {
        		prev = cur;
        		cur = cur.next;
        	}
        	prev.next = null;
        	cur.next = head;
        	head = cur;
    	}
    	return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList r = new RotateList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode l = r.rotateRight(head, 2);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

}
