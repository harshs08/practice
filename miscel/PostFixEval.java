import java.util.Scanner;
import java.util.Stack;

public class PostFixEval {

	private char[] expression;

	public PostFixEval(char[] expression) {
		this.expression = expression;
	}

	public boolean isDigit(char d) {
		if (d >= '0' && d <= '9') {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOperator(char op) {
		if (op == '+' || op == '-' || op == '*' || op == '/')
			return true;
		
		return false;
	}

	public int performOperation(char operator, int op1, int op2) {
		if (operator == '+') {
			return op1 + op2;
		} else if (operator == '-') {
			return op1 - op2;
		} else if (operator == '*') {
			return op1 * op2;
		} else if (operator == '/') {
			return op1 / op2;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public int evaluatePostfix() {
		Stack<Integer> S = new Stack<Integer>();
		int res = 0;
		int op1;
		int op2;
		for (char element : expression) {
			if (isOperator(element)) {
				op2 = S.pop();
				op1 = S.pop();
				res = performOperation(element, op1, op2);
				S.push(res);
			} else if(isDigit(element)) {
				S.push(Character.getNumericValue(element));
			}
		}
		return S.peek();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] exp = in.nextLine().toCharArray();

		PostFixEval pf = new PostFixEval(exp);

		int result = pf.evaluatePostfix();
		System.out.println("Result: " + result);
		in.close();
	}
}