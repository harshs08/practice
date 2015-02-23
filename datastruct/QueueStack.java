import java.util.Scanner;
import java.util.NoSuchElementException;

public class QueueStack{

	private class Node{
		public Object data;
		public Node next;
		
		public Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	private Node top = null;

	public Node getTop(){
		return top;
	}

	public void push(Object data){
		top = new Node(data, top);
	}

	public Object pop(){
		if(top == null){ throw new NoSuchElementException(); }
		Object item = top.data;
		top = top.next;
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
		int count = 0;
		for (Node node = top; node != null; node = node.next) {
				count++;
		}
		return count;
	}

	public static void enqueue(Object item, QueueStack sq1){
		sq1.push(item);
	}

	public static Object dequque(QueueStack sq2, QueueStack sq1){
		Object item = null;
		if(sq2.isEmpty()){
			for (Node node = sq1.getTop(); node != null; node = node.next) {
				sq2.push(sq1.pop());
			}
			item = sq2.pop();
		}
		else{
			item = sq2.pop();
		}
		return item;
	}

	public static void main(String[] args) {
		QueueStack sq1 = new QueueStack();
		QueueStack sq2 = new QueueStack();
		enqueue("1", sq1);
		enqueue("2", sq1);
		enqueue("3", sq1);
		System.out.println("Size: "+ sq1.size());
		System.out.println("Size: "+ sq2.size());
		System.out.println("Poped: "+ dequque(sq2, sq1));
		enqueue("4", sq1);
		System.out.println("Size: "+ sq1.size());
		System.out.println("Size: "+ sq2.size());
		System.out.println("Poped: "+ dequque(sq2, sq1));
	}

}