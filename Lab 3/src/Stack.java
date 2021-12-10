class StackException extends RuntimeException{    
		public StackException(String err) {
			super(err);
		}
}

public class Stack {
	
	/**
	 * Node Class for each node in the Stack
	 * @author akshay
	 *
	 */
	private class Node{
		//Element variable for storing the value of Node
		int element;
		//Next variable for storing address of next node
		Node next;
		
		/**
		 * @param e for setting value of element
		 * @param n for setting address of next node
		 */
		public Node(int e, Node n){
			element = e;
			next = n;
		}
		
		/**
		 * @return returns the value of that specific node
		 */
		public int getValue() {
			return element;
		}
		
		/**
		 * @return returns the address of next node
		 */
		public Node getNext() {
			return next;
		}
	}
	
	// this is a reference to the head node of the linked list
	private Node top;
	
	// keep track of the number of elements in the stack
	private int size;
	
	/**
	 * Constructor for initializing variables for Stack Class
	 */
	public Stack(){
		top = null;
		size = 0;
	}
	
	/**
	 * @return returns true if stack is empty else returns false 
	 */
	public boolean isEmpty(){
		return top == null;
	}
	
	/**
	 * @return returns the size of stack
	 */
	public int size(){
		return size; 
	}
	
	// part 3: complete
	/** Adds a new element to the stack
	 * 
	 * @param o the integer to add to the top of the stack
	 */
	public void push(int o)
	{
		//Creating new node for pushing into the stack
		Node newNode = new Node(o,null);
		//If the top is null then Stack is empty
		//So we will add new node
		if(top==null)
		{
			//We will reference it to top because there is no other element
			top = newNode;
		}
		//If stack is not empty then 
		else
		{
			//Adding reference of top node as next node of new node
			newNode.next = top;
			//Adding reference of new node into the the top node
			top=newNode;
		}
		//Incrementing the size after pushing one element into stack 
		size++;
	}
	
	// part 3: complete
	/** Removes an element from the top of the stack
	 * 
	 * @return the integer that was at the top of the stack
	 * @throws StackException if the stack is empty
	 */
	public int pop() throws StackException{
		//If top node is null it means stack is empty
		//So we will throw an exception
		if(top==null)
		{
			throw new StackException("Stack Is empty");
		}
		//Else we will take the top node in temporary node
		Node deleteNode= top;
		//We will set top as next node's address 
		top = top.getNext();
		//We will decrement the size as popping out one node
		size--;
		//Returning the value of node which is deleted/removed
		return deleteNode.getValue();
	}
	
	// part 3: complete
	/** Returns the integer at the top of the stack
	 * 
	 * @return the integer at the top of the stack
	 * @throws StackException is the stack is empty
	 */
	public int top() throws StackException{
		if(top==null)
		{
			throw new StackException("Stack Is empty");
		}
		return top.element; // dummy remove
	}
}
