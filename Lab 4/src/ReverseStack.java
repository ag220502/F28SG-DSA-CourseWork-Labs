public class ReverseStack {
	/*
	 * 1: complete implementation
	 */
	/**
	 * @param st passing the stack which we have to reversed
	 */
	public static void reverseStack(Stack st){
		//Creating the object of Queue Class
		Queue q = new Queue(st.size()+1);
		//Taking the temporary variable to run loops
		//We cannot take Stack size as it will increase
		//and decrease when popping elements and pushing them back
		int qSize = st.size();
		//Running for loop for Popping elements from stack and
		//Inserting it at rear in a Queue
		for(int i=0;i<qSize;i++) 
		{
			q.enqueue(st.pop());
		}
		//Running for loop for removing elements from queue and
		//Pushing it into a stack 
		for(int i=0;i<qSize;i++) 
		{
			st.push(q.dequeue());
		}
	}
}
