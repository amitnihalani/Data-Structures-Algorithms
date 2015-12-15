package linked_list;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = LinkedList.generateCircularLinkedList();
		System.out.println("The cycle starts at: " + returnStartOfCycle(head).val);
		System.out.println("The length of cycle is: " + lengthOfLoop(returnStartOfCycle(head)));
	}
	
	private static Node returnStartOfCycle(Node head) {
		Node fast = head, slow = head;
		
		while(fast!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast) {
				break;
			}
		}
		
		System.out.println("the nodes meet at: " + slow.val);
		
		while(head != slow) {
			head = head.next;
			slow = slow.next;
		}
		
		return head;
	}
	
	private static int lengthOfLoop(Node start) {
		Node temp = start.next;
		int length =1;
		
		while(temp!=start) {
			temp = temp.next;
			length++;
		}
		return length;
	}

}
