package amazon_questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }
    
    int size, currentSize;
    Map<Integer, Node> map;
    Node head, tail;
    
    public LRUCache(int capacity) {
        size = capacity;
        currentSize = 0;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
      Node n = map.get(key);
      if(n != null) {
          int value = n.value;
          deleteNode(n);
          set(key, value);
          return value;
      }
      return -1;
    }
    
    public void set(int key, int value) {
            Node newNode = new Node(key, value);
            Node exists = map.get(key);
            if(head == null) {
                head = newNode;
                tail = head;
                currentSize++;
            } else if(currentSize < size) {
                // if new Node is to added and the cache is not full, make the new node as tail
            	  if(exists == null) {
                  	addToTail(newNode);
                  } else {
                  	deleteNode(exists);
                  	addToTail(newNode);
                  }

            } else {
            	if(exists == null){
            		addToTail(newNode);
                    Node temp = head;
                    head = head.next;
                    deleteNode(temp);
            	} else {
            		deleteNode(exists);
                  	addToTail(newNode);
            	}
                
            }
            
            map.put(key, newNode);
    }
    
    private void deleteNode(Node n) {
        if(n == tail) {
            tail = n.prev;
        }
        
        if(n == head) {
            head = head.next;
        }
        
        if(n.prev != null) {
            n.prev.next = n.next;
        }
        
        if(n.next != null) {
            n.next.prev = n.prev;
        }
        
        map.remove(n.key);
        n = null;
        currentSize--;
    }
    
    private void addToTail(Node n) {
    	if(tail == null) {
    		head = tail = n;
    	}
        tail.next = n;
        n.prev = tail;
        tail= tail.next;
        currentSize++;
    }
    
    public static void main(String[] args) {
    	LRUCache lru = new LRUCache(2);
    	lru.set(2,1);
    	lru.set(1, 1);
    	System.out.println(lru.get(2));
    	//lru.set(1, 1);
    	lru.set(4, 1);
    	System.out.println(lru.get(1));
    	System.out.println(lru.get(2));
    	
    }
}