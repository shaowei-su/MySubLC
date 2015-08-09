package leetcode;



public class ReverseNodesK {

	
	public ListNode reverse(ListNode pre, ListNode next) {
		
		ListNode last = pre.next; // the first one is guaranteed to be the last
		ListNode cur = last.next;
		
		while (cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		
		return last;
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	//the point is find how to reverse between two arbitrary nodes
        //edge cases
    	if (head == null) return null;
    	if (k == 0 || k == 1) return head;
    	
    	//dummy node
    	ListNode dummy = new ListNode(0);
    	ListNode pre = dummy;
    	dummy.next = head;
    	int i = 0;
    	while (head != null) {
    		i++;
    		if (i % k == 0) {
    			pre = reverse(pre, head.next);
    			head = pre.next;
    		} else {
    			head = head.next;
    		}
    	}
    	
    	return dummy.next;
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
