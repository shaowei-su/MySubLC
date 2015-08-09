package leetcode;

import java.util.*;
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //edge
    	if (lists.length == 0) return null;
    	//priority queue
    	PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
        	public int compare(ListNode a, ListNode b) {
        		if (a.val > b.val) {
        			return 1;
        		} else if (a.val == b.val) {
        			return 0;
        		} else {
        			return -1;
        		}
        	}   		
    	});
    	//insert all the head
    	for (int i = 0; i < lists.length; i++) {
    		if (lists[i] != null) {
    			q.add(lists[i]);    			
    		}

    	}
    	
    	ListNode head = new ListNode(0); //fake head
    	ListNode p = head;
    	ListNode temp;
    	
    	while (q.size() != 0) {
    		temp = q.poll();
    		if (temp.next != null) {
    			q.add(temp.next);
    		}
    		p.next = temp;
    		p = p.next;
    		
    	}
    	
    	return head.next;
    }
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
}


