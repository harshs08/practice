import java.util.Stack;
import java.util.Scanner;

class BalancedParen{

	private char[] expression;

	public BalancedParen(char[] expression){
		this.expression = expression;
	}





	public boolean isPair(char opening, char closing){
		if (opening == '(' && closing == ')') return true;
		if (opening == '{' && closing == '}') return true;
		if (opening == '[' && closing == ']') return true;
		return false;
	}

	public boolean isParanthesesBalanced(){
		Stack<Character> S = new Stack<Character>();
		for (char a : expression ) {
			if(a == '(' || a == '{' || a == '['){
				S.push(a);
			}
			else if(a == ')' || a == '}' || a == ']'){
				if(S.empty() || isPair(S.peek(),a)) {
					return false;
				}
				else{
					S.pop();
				}
			}
		}
		return S.empty() ? true : false;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		char[] exp = in.nextLine().toCharArray();
		BalancedParen bp = new BalancedParen(exp);
		if (bp.isParanthesesBalanced()) {
			System.out.println("Balanced");
		}
		else{
			System.out.println("Not Balanced");
		}
	}
}