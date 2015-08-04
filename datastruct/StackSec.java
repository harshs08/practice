import java.util.Scanner;
import java.util.NoSuchElementException;

public class StackSec {
		
	private class Node {
		public Object data;
		public Node next;
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top = null;
	private int count = 0;

	public void push(Object item) {
		top = new Node(item, top);
		count++;
	}

	public Object pop() {
		Object item = top.data;
		top = top.next;
		count--;
		return item;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Object peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	public int size() {
		// int count = 0;
		// for (Node node = top; node != null; node = node.next) {
		// 		count++;
		// }
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		StackSec s = new StackSec();
		for (int i = 0; i<T ; i++) {
			s.push(in.nextInt());
		}

		System.out.println("Poped Item: " + s.pop() + " ");

		System.out.println("Stack Size: " + s.size());
	}
}