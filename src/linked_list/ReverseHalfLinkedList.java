package linked_list;

public class ReverseHalfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.generateLinkedList();
		LinkedList.printLinkedList(head);
		head = reverseSecondHalfOfLL(head);
		System.out.println("\n\n Half reversed linked list: ");
		LinkedList.printLinkedList(head);
	}

	private static Node reverseSecondHalfOfLL(Node head) {
		Node slow = head, fast = head, prev = null;

		// move till half of linked List
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (slow == null || slow.next == null) {
			return head;
		} else {
			// check for middle node and send it to helper function
			prev.next = reverseLinkedList(slow);
		}
		return head;
	}

	private static Node reverseLinkedList(Node head) {
		Node prev = null, next = null;

		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
