import java.util.Scanner;

public class PostFixEval{

	private char[] expression;

	public PostFixEval(char[] expression){
		this.expression = expression;
	}

	public boolean isDigit(char d){
		if(d >= 0 && d<=9 ){ return true; }
		else { false; }
	}

	public boolean isOperator(char op){
		if(op == "+" || op == "-" || op == "*" || op == "/")
			return true;
		return false;
	}

	public int performOperation(char operator, int op1, int op2){
		if(operator == "+"){
			return op1 + op2;
		}
		else if (operator == "-") {
			return op1 - op2;
		}
		else if (operator == "*") {
			return op1 * op2;
		}
		else if (operator == "/") {
			return op1 / op2;
		}
		else{
			return Integer.MAX_VALUE;
		}
	}

	public int evaluatePostfix(){
		int result = 0;
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] exp = in.nextLine().toCharArray();
		PostFixEval pf = new PostFixEval(exp);

		int result = pf.evaluatePostfix();
		System.out.println("The result of PostFix Evaluation: "+result);
	}
}