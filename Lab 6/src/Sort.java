
public class Sort {
	/**
	 * Method for sorting the array using Priority Queue
	 * @param arr The array which we have to sort
	 */
	public static void sort(int[] arr){
		//Creating object of priority queue with size of length of array 
		PriorityQueue pq = new PriorityQueue(arr.length);
		//Populating the priority queue by inserting the values
		for(int i=0;i<arr.length;i++)
		{
			//Calling the insert function to insert value
			pq.insert(arr[i]);
		}
		//Loop for changing elements in array by removing 
		//the minimum element from the priority queue
		for(int i=0;i<arr.length;i++)
		{
			//Changing the element 
			arr[i] = pq.removeMin();
		}
	}
	
	public static void main(String[] args){
		int[] arr = {53,3,5,2,4,67};
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);	
		System.out.println(arr[2]);
		System.out.println(arr[3]);	
		System.out.println(arr[4]);	
		System.out.println(arr[5]);	
	}
	
}
