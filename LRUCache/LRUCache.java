import java.util.*;

public class LRUCache {
	private int capacity;
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private DNode head = new DNode(0);
	private DNode tail = new DNode(0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

    	if (map.keySet().contains(key)) {
    		set(key, map.get(key));
    		return map.get(key);
    	} else {
    		return -1;
    	}
        
    }
    
    public void set(int key, int value) {
    	if (map.size() < capacity) {
    		map.put(key, value);
    	} else if (!map.keySet().contains(key)) {
    		map.remove(head.next.val);
    		map.put(key, value);
    		head.next = head.next.next;
    		head.next.prev = head;
    	} else {
    		map.put(key, value);
    		DNode iter = head.next;
    		while (iter.val != key) {
    			iter = iter.next;
    		}
    		iter.prev.next = iter.next;
    		iter.next.prev = iter.prev;
    	}

		DNode node = new DNode(key);
		tail.prev.next = node;
		node.next = tail;
		node.prev = tail.prev;
		tail.prev = node;
    }

    public class DNode {
    	int val;
    	DNode prev;
    	DNode next;

    	public DNode(int val) {
    		this.val = val;
    	} 
    }

    public static void main(String[] args) {
    	LRUCache lru = new LRUCache(2);
    	System.out.println(lru.get(2));
    	lru.set(2, 6);
    	System.out.println(lru.get(1));
    	lru.set(1, 5);
		lru.set(1, 2);
    	
    	System.out.println(lru.get(1));
    	System.out.println(lru.get(2));
    }
}