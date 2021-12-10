public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
	 */
	/**
	 * @param name User name for which we have to search in Array
	 * @return Returns number if found else returns -1
	 */
	public int linearSearch(String name){
		//Running for loop will the size of the array
		for(int i=0;i<current;i++)
		{
			//Checking id the name exists
			if(catalogue[i].getName().equals(name))
			{
				//If the name exists then returning the number of user 
				return catalogue[i].getNumber();
			}
		}
		//If it is not found then returning -1 
		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	/**
	 * @param first Argument for starting of the array
	 * @param last Argument for ending of the array
	 * @param name User name for which we have to search in Array
	 * @return Returns number if found else returns -1
	 */ 
	private int binarySearch(int first,int last,String name){
		//Declaring mid value as 0
		int mid=0;
		//Checking if first is less then last value 
		if(first<=last)
		{
			//Taking mid value so that we can check
			mid = (first+last)/2;
			//If the name in the array is equal to the name to search 
			if(name.equals(catalogue[mid].getName()))
			{
				//Then returning the number of the user
				return catalogue[mid].getNumber();
			}
			//Else checking if mid name is greater than the name to search
			else if(name.compareTo(catalogue[mid].getName())>0)
			{
				//If yes then calling same function with 
				//first value as value next to mid value
				return binarySearch(mid+1,last,name);
			}
			//Else checking if mid name is less than the name to search
			else if(name.compareTo(catalogue[mid].getName())<=0)
			{
				//If yes then calling same function with 
				//last value as value previous to mid value
				return binarySearch(first,mid-1,name);
			}
		}
		//If not found then returning -1
		return -1;				
	}
	// helper method exposed to the programmer
	public int binarySearch(String name){
		return binarySearch(0,current-1,name);
	}
}