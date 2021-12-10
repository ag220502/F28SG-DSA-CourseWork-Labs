/**
 * Class to Reverse Array Using Stack Implementation
 * @author Akshay Garg
 * 
 */
public class Reverse {
	// Part 2
	//Time Complexity  : O(N) + O(N) = O(N)
	//Space Complexity : O(N) - Depends on length of Stack
	
	/** Reverses the passed array using stack
	 * @param arr Passing array which has to be reversed
	 */
	public static void reverse(String[] arr)
	{ 
		Stack st = new Stack(arr.length);
		for(int i=0;i<arr.length;i++)
		{
			st.push(arr[i]);	
		}
		for(int ele=0;ele<arr.length;ele++)
		{
			arr[ele] = (String) st.pop();
		}
	}
}