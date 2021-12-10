import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Test class to test implementation of Calculator Class
 * @author Akshay Garg
 */
public class CalculatorTest {

	/**
	 * Method to test calculate method which returns the calculated result 
	 */
	@Test
	public void testCalculate() {
		String [] cmds1 = {"+","-","3","5","2"};
		String [] cmds2 = {"-","3","+","5","2"};
		assertEquals(0,Calculator.calculate(cmds1));
		assertEquals(-4,Calculator.calculate(cmds2));	
	}
	/**
	 * Method to test convert method which returns the Integer for the string passed 
	 */
	@Test
	public void testConvert() {
		assertEquals(1,Calculator.convert("1"));
		assertEquals(0,Calculator.convert("0"));
		assertEquals(-5,Calculator.convert("-5"));
	} 
	/**
	 * Method to test isNumber method which returns true if the string passed has Number 
	 */
	@Test
	public void testIsNumber() {
		assertTrue(Calculator.isNumber("-1"));
		assertFalse(Calculator.isNumber("A"));
	}
	/**
	 * Method to test ApplyOp method which returns calculated result of the operator and two operand 
	 */
	@Test
	public void testApplyOp() {
		assertEquals(3,Calculator.applyOp("1","+","2"));
		assertEquals(-5,Calculator.applyOp("2","-","7"));
		assertEquals(6,Calculator.applyOp("3","+","3"));
		assertEquals(3,Calculator.applyOp("5","-","2"));
	}
	
	// optional part
	
	/* Uncomment this test if you wish to complete and test
	 * the optional part of lab 2.
	@Test
	public void testCalculatePolish() {
		String [] cmds1 = {"+","-","3","5","2"};
		String [] cmds2 = {"-","3","+","5","2"};
		
		assertEquals(0,Calculator.calculatePolish(cmds1));
		assertEquals(-4,Calculator.calculatePolish(cmds2));	
	}
	*/
	

}
