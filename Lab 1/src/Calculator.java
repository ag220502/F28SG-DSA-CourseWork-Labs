// exception used for Q5
/**
 * Class to throw exception
 * @author Akshay Garg
 *
 */
class CalculateException extends RuntimeException {
	public CalculateException(String err) {
		super(err);
	}
}
/**
 * Class to Implement Polish notation calculator
 * @author Akshay Garg
 */
public class Calculator {
	
	//Time Complexity  : O(N)
	//Space Complexity : O(1) - Stack has constant size
	
	/** Calculates the result of polish notation
	 * @param cmds array of string in polish notation
	 * @return Returns the calculated result of polish notation 
	 */
	public static int calculate(String[] cmds) {
		Stack pstack = new Stack(100);
		Reverse.reverse(cmds);
		for (int i = 0; i < cmds.length; i++) {
			if (isNumber(cmds[i])) {
				pstack.push(cmds[i]);
			} else {
				pstack.push(applyOp(String.valueOf(pstack.pop()), cmds[i], String.valueOf(pstack.pop())));
			}
		}
		return (int) pstack.top();
	}

	//Time Complexity  : O(1)
	//Space Complexity : O(1)
	/**
	 * Converts String into Integer
	 * @param s Value in String is passed
	 * @return Returns the Integer of the String
	 * @throws NumberFormatException Exception is thrown if the passed string is not number
	 */
	
	public static int convert(String s) throws NumberFormatException {
		return Integer.parseInt(s);
	}

	/**
	 * Checks whether passed string is number or not
	 * @param s String to check whether it is number or not
	 * @return Returns true if the passed string is number else returns false
	 */
	//Time Complexity  : O(1)
	//Space Complexity : O(1)
	public static boolean isNumber(String s) {
		try {
			convert(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// apply the operator after converting the numbers
	/**
	 * This method applies operator on the operand which is passed as parameter
	 * @param fst This is the first operand for operation
	 * @param op This parameter contains operand as String
	 * @param snd This is the second operand for operation
	 * @return It returns the result of the operation
	 */
	//Time Complexity  : O(1)
	//Space Complexity : O(1)
	public static int applyOp(String fst, String op, String snd) {
		if (op == "+") {
			return convert(fst) + convert(snd);
		} else if (op == "-") {
			return convert(fst) - convert(snd);
		} else if (op == "*") {
			return convert(fst) * convert(snd);
		} else {
			return convert(fst) / convert(snd);
		}
	}
}
