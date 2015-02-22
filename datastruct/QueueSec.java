import java.util.Scanner;
import java.util.NoSuchElementException;

public class QueueSec{

	private class Node{
		public Object data;
		public Node next;
		public Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	private Node head = null;
	private Node tail = null;

	public void enqueue(Object data){
		Node newNode = new Node(data, null);
		if (isEmpty()) { head = newNode; }
		else { tail.next = newNode; }
		tail = newNode;

	}

	public Object dequeue(){
		if(isEmpty()) { throw new NoSuchElementException(); }
		Object item = head.data;
		if(head == tail){
			tail = null;
		}
		head = head.next;
		return item;
	}

	public Object peek(){
		if(isEmpty()) { throw new NoSuchElementException(); }

		return head.data;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public int count(){
		int count = 0;
		for(Node node = head; node!= null; node = node.next){
			count++;
		}
		return count;
	}
}