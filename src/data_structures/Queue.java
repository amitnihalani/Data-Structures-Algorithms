package data_structures;

public class Queue {

	private int[] qArray;
	private int front;
	private int end;
	private boolean isEmpty;

	public Queue(int size) {
		qArray = new int[size];
		front = -1;
		end = -1;
		isEmpty = true;
	}

	public void enQueue(int val) {
		if(front == end && end== -1) {
			// q is empty
			qArray[0] = val;
			front=0;
			end=0;
			isEmpty = false;
			return;
		}
		
		if(((end + 1) % qArray.length)==front) {
				System.out.println("Queue is full! Remove some elements");
				return;
		}
		end = (end + 1) % qArray.length;
		qArray[end] = val;
		isEmpty = false;
	}
	
	public void deQueue() {
		if(isEmpty == true) {
			System.out.println("Queue is empty! Add some elements");
			return;
		}
		
		int val = qArray[front];
		front = (front + 1) % qArray.length;
		
		if(front == end) {
			isEmpty = true;
		}
	}
	
	public int peek() {
		if(isEmpty==true) {
			System.out.println("Queue is Empty");
			return -1;
		}
		
		return qArray[front];
	}
}
