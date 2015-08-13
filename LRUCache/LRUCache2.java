import java.util.*;

public class LRUCache2 {
    public class DNode {
        int value;
        int key;
        DNode prev;
        DNode next;

        public DNode(int key, int value) {
            this.value = value;
            this.key = key;
            this.prev = null;
            this.next = null;
        } 
    }

	private int capacity;
	private HashMap<Integer, DNode> map = new HashMap<Integer, DNode>();
	private DNode head = new DNode(-1, -1);
	private DNode tail = new DNode(-1, -1);
    
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //remove current node
        DNode crt = map.get(key);
        crt.prev.next = crt.next;
        crt.next.prev = crt.prev;

        //move to the tail
        move2Tail(crt);
        return map.get(key).value;
    }
    
    public void set(int key, int value) {
        //最先考虑是不是包含这个key， 而不是考虑满不满
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        DNode node = new DNode(key, value);
        map.put(key, node);
        move2Tail(node);
    }

    public void move2Tail(DNode crt) {
        // tail.prev.next = crt;
        // crt.prev = tail.prev;
        // crt.next = tail;
        // tail.prev = crt;
        crt.prev = tail.prev;
        tail.prev = crt;
        crt.prev.next = crt;
        crt.next = tail;
    }


    public static void main(String[] args) {
    	LRUCache2 lru = new LRUCache2(2);
    	System.out.println(lru.get(2));
    	lru.set(2, 6);
    	System.out.println(lru.get(1));
    	lru.set(1, 5);
		lru.set(1, 2);
    	
    	System.out.println(lru.get(1));
    	System.out.println(lru.get(2));
    }
}