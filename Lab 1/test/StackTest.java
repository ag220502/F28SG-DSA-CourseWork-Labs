import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class to test implementation of Stack Class Using Arrays
 * @author Akshay Garg
 */
public class StackTest {

	Stack st;
	/**
	 * Method to initialize stack with size 2
	 * This method executes every time before any other test method
	 */
	@Before
	public void setup()
	{
		st = new Stack(2);
	}
	/**
	 * Test method to test the size method of stack class when stack is empty
	 * If the method returns 0 test passes else it fails
	 */
	@Test
	public void testPushEmptySize() {
		assertEquals(0,st.size());
	}
	/**
	 * Test method to test the size method of stack class when stack is not empty
	 * If the method returns the number of elements pushed test passes else it fails
	 */
	@Test
	public void testPushNonEmptySize() {
		st.push("A");
		st.push("B");
		assertEquals(2,st.size());
	}
	/**
	 * Test method to test the pop method of stack class to pop the elements
	 * If the method returns the top element of stack and decreases the size of stack test passes else it fails
	 */
	@Test
	public void testPopTwo() {
		st.push("A");
		st.push("B");
		assertEquals("B",st.pop());
		assertEquals("A",st.pop());
	}
	/**
	 * Test method to test the top method of stack class when stack is not empty
	 * If the method returns the top element of stack test passes else it fails
	 */
	@Test
	public void testTopTwo() {
		st.push("A");
		assertEquals("A",st.top());
		assertEquals("A",st.top());
	}
	
	/**
	 * Test method to pop elements when stack is empty 
	 * Here, method throws the exception from StackException Class
	 */
	@Test(expected = StackException.class)
	public void testEmptyPop() {
		st.pop();
	}
	/**
	 * Test method to push elements when stack is full
	 * Here, method throws the exception from StackException Class
	 */
	@Test(expected = StackException.class)
	public void testFullPush() 
	{
		st.push("A");
		st.push("B");
		st.push("C");
		st.push("D");
	}
}
