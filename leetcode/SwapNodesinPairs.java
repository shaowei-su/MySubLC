package leetcode;

public class SwapNodesinPairs {

	
    public ListNode swapPairs(ListNode head) {
        //edge case
    	if (head == null) return null;
    	if (head.next == null) return head;
    	
    	ListNode res = head.next;
    	head.next = res.next;
    	res.next = head;
    	
    	ListNode prev = res.next;
    	ListNode l1;
    	ListNode l2;
    	while (prev.next != null && prev.next.next != null) {
    		l1 = prev.next;
    		l2 = l1.next;
    		
    		l1.next = l2.next;
    		prev.next = l2;
    		l2.next = l1;
    		
    		if (l1.next != null) {
    			prev = l1;
    		} else {
    			break;
    		}
    		
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesinPairs s = new SwapNodesinPairs();
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(3);
		h.next.next.next = new ListNode(4);
		ListNode res = s.swapPairs(h);
		
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}

}
