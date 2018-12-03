package datastructures;

public class GQueue<T> {
	
	public class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	Node tail;
	Node head;
	int counter = 0;

	public void add(T data) {
		Node node = new Node(data);

		if (tail != null) {
			tail.next = node;
		}
		tail = node;

		if (head == null)
			head = node;
		counter++;
	}

	public T remove() {
		if (head == null)
			throw new RuntimeException();
		T data = head.data;
		head = head.next;
		counter--;
		return data;
	}

	public T peek() {
		if (head != null) {
			return head.data;
		} else {
			throw new RuntimeException();
		}
	}
	
	public int size(){
		return counter;
	}

}
