package data_structures;

public class Heap {

	public int[] heapArray;
	public int currentCount;
	public int capacity;
	public int heapType;

	/**
	 * Constructor to Initialize the heap
	 * 
	 * @param heapCapacity
	 * @param type
	 */
	public Heap(int heapCapacity, int type) {
		this.capacity = heapCapacity;
		this.heapType = type;
		this.currentCount = 0;
		this.heapArray = new int[heapCapacity];
	}

	/**
	 * Returns the parent of element at i th location in array. For an element
	 * at i, its parent is at (i-1)/2;
	 * 
	 * @param i
	 *            - the location of element whose parent is to be returned
	 * @return - the index of parent
	 */
	public int getParent(int i) {
		// if current element is the root or if the index is out of bound,
		// return -1
		if (i <= 1 || i >= this.currentCount) {
			return -1;
		}
		// if not, return its parent index which is (i-1)/2
		return (i - 1) / 2;
	}

	/**
	 * Returns the left child of an element at index i For an element at i, its
	 * left child is at (2*i)+1
	 * 
	 * @param i
	 *            - the location of element whose left child is to be returned
	 * @return - the index of left child
	 */
	public int getLeftChild(int i) {
		int left = (i * 2) + 1;

		// check if left child exists
		if (left >= currentCount) {
			return -1;
		}
		return left;
	}

	/**
	 * Returns the right child of an element at index i For an element at i, its
	 * right child is at (2*i)+2
	 * 
	 * @param i
	 *            - the location of element whose left child is to be returned
	 * @return - the index of left child
	 */
	public int getRightChild(int i) {
		int right = (i * 2) + 2;

		// check if right child exists
		if (right >= currentCount) {
			return -1;
		}
		return right;
	}

	/**
	 * -------ONLY for MAX HEAP ------------------
	 * Return the maximum element. The maximum element is always the root
	 * element at 0 th index of array
	 * 
	 * @return
	 */
	public int getMaximum() {
		// check if array is empty
		if (this.currentCount == 0 || this.heapType<=0) {
			return -1;
		}
		return this.heapArray[0];
	}
	
	/**
	 * --------------ONLY for MIN HEAP -------------------
	 * Return the maximum element. The minimum element is always the root
	 * element at 0th index of array
	 * 
	 * @return
	 */
	public int getMinimum() {
		// check if array is empty
		if (this.currentCount == 0 && this.heapType>0) {
			return -1;
		}
		return this.heapArray[0];
	}

	/**
	 * Inserts a new element correctly into the heap such that each element
	 * satisfies the heap property
	 * 
	 * @param i
	 *            - the new element to insert
	 */
	public void insert(int data) {
		if (this.currentCount == this.capacity) {
			return;
		}

		this.currentCount++;
		int newIndex = this.currentCount - 1;
		
		if(this.heapType<=0){
			// -------for MIN HEAP ------------------
			while (newIndex >0 && data < this.heapArray[(newIndex-1)/2]) {
				this.heapArray[newIndex] = this.heapArray[(newIndex-1)/2];
				newIndex = (newIndex-1)/2;
			}
		} else {
			//------- for MAX HEAP ------------------
			while (newIndex >0 && data > this.heapArray[(newIndex-1)/2]) {
				this.heapArray[newIndex] = this.heapArray[(newIndex-1)/2];
				newIndex = (newIndex-1)/2;
			}
		}
		this.heapArray[newIndex] = data;

	}
	
	/**
	 * -------ONLY for MAX HEAP ------------------
	 * Removes and return the max element.
	 * i.e. element at 0 th index
	 * @return - the max element from heap
	 */
	public int getAndRemoveMaxElement() {
		// if its a min heap, return -1
		if(this.heapType <=0 ) {
			return -1;
		}
		
		// make last element as first in the array and decrease count by 1
		int max = this.heapArray[0];
		/**
		 *  since we need to delete the first element,
		 *   we replace first element with last element and remove last.
		 *   Then heapify again
		 */
		this.heapArray[0] = this.heapArray[this.currentCount-1];
		this.currentCount--;
		heapifyMaxHeap(0);
		return max;
	}
	
	/**
	 * -------ONLY for MIN HEAP ------------------
	 * Removes and return the min element.
	 * i.e. element at 0 th index
	 * @return - the min element from heap
	 */
	public int getAndRemoveMinElement() {
		// if its a max heap, return -1
		if(this.heapType >0 ) {
			return -1;
		}
		// make last element as first in the array and decrease count by 1
		int min = this.heapArray[0];
		/**
		 *  since we need to delete the first element,
		 *   we replace first element with last element and remove last.
		 *   Then heapify again
		 */
		this.heapArray[0] = this.heapArray[this.currentCount-1];
		this.currentCount--;
		heapifyMinHeap(0);
		return min;
	}
	
	/**
	 * Re arranges array again so that each element satisfies heapify property
	 * @param i - the index o element to heapify
	 */
	public void heapifyMaxHeap(int i) {
		int leftChild, rightChild, max, temp;
		
		leftChild = this.getLeftChild(i);
		rightChild = this.getRightChild(i);
		
		// if leaf node, return
		if(leftChild ==-1 && rightChild==-1){
			return;
		}
		
		// if left child is bigger than node, assign left to max
		if(leftChild!=-1 && this.heapArray[leftChild] > this.heapArray[i]) {
			max = leftChild;
		} else {
			// else let current node be max
			max = i;
		}
		
		// if right child is greater than max, assign it to max
		if(rightChild!=-1 && this.heapArray[rightChild] > this.heapArray[max]) {
			max = rightChild;
		}
		
		/**
		 *  if max has changed, i.e either of the children has greater value,
		 *  swap them and recursively re arrange the heap
		 */
		
		if(max!=i) {
			temp = this.heapArray[i];
			this.heapArray[i] = this.heapArray[max];
			this.heapArray[max] = temp;
			heapifyMaxHeap(max);
		}
		
	}
	
	/**
	 * Re arranges array again so that each element satisfies heapify property
	 * @param i - the index o element to heapify
	 */
	public void heapifyMinHeap(int i) {
		int leftChild, rightChild, min, temp;
		
		leftChild = this.getLeftChild(i);
		rightChild = this.getRightChild(i);
		
		// if leaf node, return
		if(leftChild ==-1 && rightChild==-1){
			return;
		}
		
		// if left child is smaller than node, assign left to min
		if(leftChild!=-1 && this.heapArray[leftChild] < this.heapArray[i]) {
			min = leftChild;
		} else {
			// else let current node be min
			min = i;
		}
		
		// if right child is greater than max, assign it to max
		if(rightChild!=-1 && this.heapArray[rightChild] < this.heapArray[min]) {
			min = rightChild;
		}
		
		/**
		 *  if min has changed, i.e either of the children has smaller value,
		 *  swap them and recursively re arrange the heap
		 */
		
		if(min!=i) {
			temp = this.heapArray[i];
			this.heapArray[i] = this.heapArray[min];
			this.heapArray[min] = temp;
			heapifyMinHeap(min);
		}
		
	}
}
