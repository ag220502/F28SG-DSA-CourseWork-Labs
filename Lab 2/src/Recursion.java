public class Recursion {
	/**
	 * method finds the sum from 0 to n and returns the total using recursion
	 * @param n number for which we have to find sum
	 * @return returns the sum of the numbers 
	 */
	public static int sum(int n)
	{
		//Base Case : If the value of n is 0 then it returns 0 
		if(n==0)
		{
			return 0;
		}
		//Else it returns the sum of number and 
		//the function of one smaller value than that 
		return n+sum(n-1);
	}
	/**
	 * multiplies two number using recursion
	 * @param m this argument is the multiplier 
	 * @param n this argument is the multiplicand
	 * @return returns the value of multiplication of both numbers
	 */
	public static int multiply(int m, int n)
	{
		//If n is 0 then it returns 0
		if(n==0)
		{
			return 0;
		}
		//If n is less than 0 then we are adding -m and
		//we call the function with same multiplier and 
		//adding 1 to multiplicand
		if(n<0)
		{
			return (-m+multiply(m,n+1));
		}
		//If n is greater than 0 then we are adding m and
		//we call the function with same multiplier and 
		//subtracting 1 from multiplicand
		return m+multiply(m,n-1);
	}
	/**
	 * function for finding the nth Fibonacci Number
	 * @param n the number for which we have to find Fibonacci number
	 * @return returns the nth Fibonacci number
	 */
	public static int Fibonacci(int n)
	{
		//If n is 0 or 1 then returning n
		if(n==0 || n==1)
		{
			return n;
		}
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
}