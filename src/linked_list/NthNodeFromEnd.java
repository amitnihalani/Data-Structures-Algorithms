package linked_list;

import java.util.Scanner;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.generateLinkedList();
		LinkedList.printLinkedList(head);
		System.out.println("\n\nEnter n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Nth Node from last is: " + findNthNodeFromEnd(head, n).val);
	}
	
	

	public static Node findNthNodeFromEnd(Node head, int n) {
		Node temp = head;
		for(int i=0; i<n; i++) {
			temp = temp.next;
			
			if(temp == null) {
				System.out.println("There aren't N elements n the list");
			}
		}
		
		while(temp!=null) {
			head = head.next;
			temp=temp.next;
		}
		
	return head;
	}
	
}
