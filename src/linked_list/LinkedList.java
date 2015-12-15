package linked_list;

public class LinkedList {

	public static Node generateLinkedList() {
		Node head = new Node(1);
		addNodeAtEnd(head, new Node(2));
		addNodeAtEnd(head, new Node(3));
		addNodeAtEnd(head, new Node(4));
		addNodeAtEnd(head, new Node(5));
		addNodeAtEnd(head, new Node(6));
		addNodeAtEnd(head, new Node(7));
		addNodeAtEnd(head, new Node(8));
		addNodeAtEnd(head, new Node(9));
		addNodeAtEnd(head, new Node(10));

		return head;
	}

	public static Node generateCircularLinkedList() {
		Node head = new Node(1);
		addNodeAtEnd(head, new Node(2));
		addNodeAtEnd(head, new Node(3));
		addNodeAtEnd(head, new Node(4));
		Node n = new Node(5);
		addNodeAtEnd(head, n);

		addNodeAtEnd(head, new Node(6));
		addNodeAtEnd(head, new Node(7));
		addNodeAtEnd(head, new Node(8));
		addNodeAtEnd(head, new Node(9));
		Node last = new Node(10);
		addNodeAtEnd(head, last);
		last.next = n;
		return head;
	}

	public static void addNodeAtEnd(Node head, Node n) {
		while (head.next != null) {
			head = head.next;
		}
		head.next = n;
	}

	public static void printLinkedList(Node temp) {
		while (temp != null) {
			if (temp.next == null) {
				System.out.print(temp.val);
			} else {
				System.out.print(temp.val + " --> ");
			}

			temp = temp.next;
		}
	}

}
