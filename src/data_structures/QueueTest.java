package data_structures;

public class QueueTest {
	public static void main(String args[]){
		Queue q = new Queue(5);
		
		q.deQueue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
	}

}
