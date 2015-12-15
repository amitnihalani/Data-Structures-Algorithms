package linked_list;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.generateLinkedList();
		System.out.println("Original List: " );
		LinkedList.printLinkedList(head);
		System.out.println("\nReversed List (iterative): " );
		LinkedList.printLinkedList(reverseLinkedListIteratively(head));
		head = LinkedList.generateLinkedList();
		System.out.println("\nReversed List (recursive): " );
		LinkedList.printLinkedList(reverseLinkedListRecursively(head));
	}
	
	public static Node reverseLinkedListIteratively(Node head) {
		Node temp = null, next;
		
		while(head!=null) {
			next = head.next;
			head.next = temp;
			temp = head;
			head = next;
		}
		return temp;
	}
	
	public static Node reverseLinkedListRecursively(Node head) {
		Node newHead = reverseRecursively(head, null);
		return newHead;
	}
	
	public static Node reverseRecursively(Node head, Node temp) {
		if(head == null) {
			return temp;
		}
		
		Node next = head.next;
		head.next = temp;
	
		return reverseRecursively(next, head);
		
	}
	

}
