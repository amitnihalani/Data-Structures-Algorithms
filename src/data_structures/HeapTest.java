package data_structures;

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap(10, 0);
		
		heap.insert(5);
		heap.insert(3);
		heap.insert(8);
//s		heap.insert(10);
		heap.insert(1);
		heap.insert(9);
		heap.insert(7);
		heap.insert(2);
		heap.insert(4);
		heap.insert(11);
		
		
		
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMinElement());
		System.out.println(heap.getAndRemoveMaxElement());
		System.out.println(heap.getAndRemoveMaxElement());
	}

}
