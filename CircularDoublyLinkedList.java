package AlgorithmStructures;

public class CircularDoublyLinkedList<V> {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	CircularDoublyLinkedList(V data) {
		head = new Node(data);
	}
	
	public CircularDoublyLinkedList() {
		head = null;
	}
	
	public Node HeadNode() {
		return head;
	}
	
	public Node TailNode() {
		return tail;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public Node addAtStart(V data) {
		Node node =  new Node(data);
		if(size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
		return node;
	}
	
	public Node addAtEnd(V data) {
		Node node =  new Node(data);
		if(size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
		return node;
	}
	
	public Node addAfter(Node prevNode, V data) {
		if(prevNode == null) {
			return null;
		} else if(prevNode == tail) {
			return addAtEnd(data);
		} else {
			Node node = new Node(data);
			
			Node nextNode = prevNode.next;
			node.next = nextNode;
			prevNode.next = node;
			nextNode.prev = node;
			node.prev = prevNode;
			size++;
			return node;
		}
	}
	
	
	
	/*
	public Node addAtPos(V data, int index) {
		Node node =  new Node(data);
		if(index == 1) {
			addAtStart(data);
		}
		Node other = head;
		for(int i = 2; i <= size; i++) {
			if(i == index) {
				Node tmp = other.next;
				other.next = node;
				node.prev = other;
				node.next = tmp;
				tmp.prev = node;
			}
			other = other.next;
		}
		size++;
		return node;
	}*/
	
	public V get(int index) {
		if(index > size) {
			return null;
		}
		Node node = head;
		while(index != 0) {
			node = node.next;
			index--;
		}
		return node.data;
	}
	
	public int size() {
		return size;
	}
	
	public void deleteFromStart() {
		if(size == 0) {
			return;
		} else {
			System.out.println("\ndeleting node " + head.data + " from start");
			head = head.next;
			size--;
		}
	}
	
	public void deleteFromEnd() {
		if(size == 0) {
			return;
		} else if(size == 1) {
			deleteFromStart();
		} else {
			V x = tail.data;
			Node prevTail = tail.prev;
			tail = prevTail;
			tail.next = null;
			System.out.println("\ndeleting node " + x + " from end");
			size--;
		}
	}
	
	public void deleteNode(Node del) {
		if(head == null || del == null) {
			return;
		}
		
		if(head == del) {
			head = del.next;
		}
		
		if(del.next != null) {
			del.next.prev = del.prev;
		}
		
		if(del.prev != null) {
			del.prev.next = del.next;
		}
		return;
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void printInOrder(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public void printInReverse(Node node) {
		Node last = null;
		while(node != null) {
			last = node;
			node = node.next;
		}
		while(last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}
	
	public class Node {
		private V data;
		private Node next;
		private Node prev;
		
		public Node(V key) {
			data = key;
			next = null;
			prev = null;
		}
		
		public Node(V key, Node n, Node p) {
			data = key;
			next = n;
			prev = p;
		}
		
		public void setLinkNext(Node n) {
			next = n;
		}
		
		public void setLinkPrev(Node p) {
			prev = p;
		}
		
		public void setData(V key) {
			data = key;
		}
		
		public Node getLinkNext() {
			return next;
		}
		
		public Node getLinkPrev() {
			return prev;
		}
		
		public V getData() {
			return data;
		}
	}
}
