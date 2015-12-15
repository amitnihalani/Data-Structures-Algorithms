package amazon_questions;

import linked_list.LinkedList;
import linked_list.Node;

public class InsertInCircularSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = generateSortedLL();
		System.out.println("Origianl List: ");
		printCircularLL(head);
		System.out.println("\n\n After Insertion");
		Node h = insertInSortedCircularLL(head, 5);

		printCircularLL(h);
	}

	private static Node insertInSortedCircularLL(Node head, int val) {
		Node current = head;
		Node newNode = new Node(val);
		if (head == null) {
			return new Node(val);
		} else {
			// if the new node value is between head and the largest value, insert new node and return
			while (current.next != head && current.val < current.next.val) {
				if ((current.val <= val && current.next.val > val)) {
					newNode.next = current.next;
					current.next = newNode;
					return head;
				}
				current = current.next;
			}
			
			// if the new value is the largest/smallest value 
			// it is between the smallest and the current largest element
			if(val>=current.val || val<=current.next.val){
				newNode.next = current.next;
				current.next = newNode;
			} 
		}
		return head;
	}

	private static Node generateSortedLL() {
//		Node head = new Node(6);
//		head.next = new Node(8);
//		head.next.next = new Node(10);
//		head.next.next.next = new Node(2);
//		Node last = new Node(4);
//		head.next.next.next.next = last;
//		last.next = head;
		
		Node head = new Node(2);
		head.next = new Node(4);
		head.next.next = new Node(6);
		head.next.next.next = new Node(8);
		Node last = new Node(10);
		head.next.next.next.next = last;
		last.next = head;

		return head;
	}

	private static void printCircularLL(Node head) {
		Node current = head;

		while (true) {
			System.out.print(current.val + "->");
			if (current.next == head) {
				break;
			}
			current = current.next;
		}
	}
}
