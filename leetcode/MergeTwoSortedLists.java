package leetcode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	if (l1 == null && l2 == null) {
    		return null;
    	} else if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	}
        
    	ListNode cur1 = l1;
    	ListNode cur2 = l2;
    	ListNode res = new ListNode(0);
    	ListNode temp = res;
    	
    	while (cur1 != null && cur2 != null) {
    		if (cur1.val > cur2.val) {
    			res.next = cur2;
    			res = res.next;
    			cur2 = cur2.next;
    		} else {
    			res.next = cur1;
    			res = res.next;
    			cur1 = cur1.next;
    		}
    	}
    	
    	if (cur1 == null) {
    		res.next = cur2;
    	} else if (cur2 == null) {
    		res.next = cur1;
    	}
    	
    	return temp.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
