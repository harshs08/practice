public class IsEven{
	public static void main(String[] args) {
		int x = Integer.MAX_VALUE - 1;
		System.out.println("Number is: " + (((x & 1) == 0) ? "even" : "odd"));
	}
}