public class LSearch {
	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/*
	 * Part 3: complete
	 */	
	/**
	 * @param name User name for which we have to search in LinkedList
	 * @return Returns number if found else returns -1
	 */
	public int linearSearch(String name){
		//Checking if head node is null or not
		if(headNode==null)
		{
			//If head node is null it means no element in linked list
			//So returns -1
			return -1; 
		}
		//Taking one temporary node for the loop 
		Node tmp = headNode;
		//Running loop till the next node is not empty
		while(tmp!=null)
		{
			//If the name is equal to the name in linked list
			if(tmp.value.getName().equals(name))
			{
				//Then returning the number of the user
				return tmp.value.getNumber();
			}
			//Updating the temporary node with next node
			tmp = tmp.nextNode;
		}
		//If nothing is found then returning -1
		return -1; 
	}
}
