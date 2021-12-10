public class LQueue {
	
	private class Node{
		Object element;
		Node next;
		
		public Node(Object e, Node n){
			element = e;
			next = n;
		}
		
		public Node(Object e){
			element = e;
			next = null;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	
	public LQueue(){
		//Initializing pointers as null
		head = null;
		tail = null;
		//Initializing size as 0 when object is created
		size=0;
	}
	
	/*
	 * Part 3: complete the following methods
	 */

	// Part 3: complete	
	/**
	 * Method for checking whether queue is empty or not 
	 * @return returns true if queue is empty else returns false
	 */
	public boolean isEmpty(){
		//comparing size and returning boolean value 
		return (size==0);
	}
	
	// Part 3: complete
	/**
	 * Method for getting size of the Queue
	 * @return returns the size of the queue
	 */
	public int size(){
		return size; 
	}
	
	// Part 3: complete
	/**
	 * Method for Inserting elements at rear position in Queue
	 * @param o value which has to be inserted in node
	 */
	public void enqueue(Object o){
		//Creating new node and passing value
		Node newNode = new Node(o);
		//If the head is null then both pointers will to same 
		//node
		if(head==null)
		{
			//Referencing head and tail node to newly created node
			head = newNode;
			tail = newNode;
		}
		//If the queue is not null then inserting element at end
		else
		{
			//Referencing last node of the queue to the new one
			tail.next = newNode;
			//Setting new Node's next as null because
			//there is no other element is there after this Node
			newNode.next = null;
			//Pointing tail to newNode
			tail = newNode;
		}
		//Incrementing size After Inserting the Value
		size++;
	}
	
	// Part 3: complete	
	/**
	 * Method for removing elements from head from a Queue
	 * @return returns the element which is removed from the head
	 * @throws QueueException Throws Exception when Queue Is empty
	 */
	public Object dequeue() throws QueueException{
		//If head is null it means Queue is empty 
		//So, we will throw error that Queue Is Empty
		if(head==null)
		{
			//Throwing Error 
			throw new QueueException("Queue Is Empty");
		}
		//Creating temporary variable for storing current element 
		//at head position
		Object tmp = head.element;
		//If head is equal to tail it means that 
		//there is only one element in the Queue
		if(head == tail)
		{
			//Referencing head and tail as null because there is no
			//other element in the queue 
			head = null;
			tail = null;
		}
		else
		{
			//Referencing head as the next Node for
			//removing link from the queue with that element
			head = head.next;
		}
		//Decrementing size After Removing the Value
		size--;
		//Returning the 
		return tmp;
	}
	
	// Part 3: complete
	/**
	 * Method for returning the first element in the queue
	 * @return returns the element which is removed from the head
	 * @throws QueueException Throws Exception when Queue Is empty
	 */
	public Object front() throws QueueException{
		//If head is null then there is no element in the queue
		//It will throw an exception that the queue is empty
		if(head==null)
		{
			throw new QueueException("Queue Is Empty");
		}
		//If the head is empty then returning the element present at head 
		return head.element;
	}
	
}
