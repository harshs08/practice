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
		for (int i = 0;i< expression.length;i++) {
			if(expression[i] == ' ' || expression[i] == ',') { continue; }
			if (isOperator(expression[i])) {
				op2 = S.pop();
				op1 = S.pop();
				res = performOperation(expression[i], op1, op2);
				S.push(res);
			} else if(isDigit(expression[i])) {
				int operant = 0;
				while(isDigit(expression[i]) && i< expression.length){
					operant = operant*10 + Character.getNumericValue(expression[i]); 
					i++;
				}
				i--;
				S.push(operant);
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