import java.util.Scanner;

public class PostFixEval{

	private char[] expression;

	public PostFixEval(char[] expression){
		this.expression = expression;
	}


	public boolean isDigit(char d){
		return false;
	}

	public boolean isOperator(char op){
		return false;
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