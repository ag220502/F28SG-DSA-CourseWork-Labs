import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** Bubble sort of an array
	 * 
	 * This is Question 3
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
		//Declaring the variable for running while loop and value as true
		boolean swaps =true;
		//While it is true
		while(swaps)
		{
			//We will turn variable to false  
			swaps = false;
			//Running for loop till the length - 1 through the array
			for(int i=0;i<arr.length-1;i++)
			{
				//If the value of the array is more than the value corresponding to it we will swap the values 
				if(arr[i]>arr[i+1])
				{
					//Taking temporary variable and storing the value to be swapped
					int tmp = arr[i];
					//Changing the value of element with the next element
					arr[i] = arr[i+1];
					//Changing the next element's value with temporary value
					arr[i+1] = tmp;
					//Changing swaps to true
					swaps = true;
				}
			}
		}
	}

	// Part 5 : complete implementation
	/**
	 * Method to sort ArrayList using quick sort
	 * @param S ArrayList to be sorted
	 * @return returns the sorted ArrayList
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		//If the size of the arrayList is less than or equal to 1
		if(S.size()<=1)
		{
			//We are returning the ArrayList
			return S;
		}
		//Else we are taking the first element as the pivot so that we can compare it 
		int pivot = S.get(0);
		//Declaring 3 new ArrayLists for storing values which are greater than or equal or less than
		ArrayList<Integer> L = new ArrayList<Integer>();
		ArrayList<Integer> E = new ArrayList<Integer>();
		ArrayList<Integer> G = new ArrayList<Integer>();
		int size = S.size();
		//Running for loop till the size of the ArrayList to populate 3 new ArrayLists
		for(int i=0;i<size;i++)
		{
			//Removing and Storing the first value from ArrayList in variable  
			int val = S.remove(0);
			//checking if the value is less than the value of pivot then we will add it in L ArrayList 
			if(val<pivot)
			{
				L.add(val);
			}
			//Else If the value is equal to the value of pivot then we will add it in E ArrayList
			else if(val == pivot)
			{
				E.add(val);
			}
			//Else If the value is greater than the value of pivot then we will add it in G ArrayList
			else
			{
				G.add(val);
			}
		}
		//Creating 2 new ArrayLists for sorted lists L and G
		ArrayList<Integer> sortedL = quickSort(L);
		ArrayList<Integer> sortedG = quickSort(G);
		//Creating one more new ArrayList for storing all the result 
		ArrayList<Integer> all = new ArrayList<Integer>();
		//First, adding the elements of sorted list with values less than the pivot value
		all.addAll(sortedL);
		//Second, adding the elements of the sorted list with values equal to the pivot value
		all.addAll(E);
		//At Last, adding the elements of the sorted list with values greater than the pivot value
		all.addAll(sortedG);
		//Returning the ArrayList with sorted elements
		return all;
	}
	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		arr2.add(2);
		arr2.add(9);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};
	}

}
