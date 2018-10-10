import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CircularDoublyLinkedList<V> extends LinkedListNode<V> {
	
	private LinkedListNode<V> head;
	private LinkedListNode<V> tail;
	private int size = 0;
	
	public CircularDoublyLinkedList(V data) {
		super(data);
		head = new LinkedListNode<V>(data);
	}
	
	public CircularDoublyLinkedList() {
		super(null);
		head = null;
	}
	
	public LinkedListNode<V> HeadNode() {
		return head;
	}
	
	public LinkedListNode<V> TailNode() {
		return tail;
	}
	
	public boolean isEmpty() {
		if(head == null || tail == null) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}
	
	public LinkedListNode<V> addAtStart(V data) {
		LinkedListNode<V> node =  new LinkedListNode<V>(data);
		if(size == 0 || head == null) {
			node.next = node;
			node.prev = node;
			head = node;
			tail = head;
		} else {
			node.prev = tail;
			tail.next = node;
			head.prev = node;
			node.next = head;
			head = node;
		}
		size++;
		return node;
	}
	
	public LinkedListNode<V> addAtEnd(V data) {
		LinkedListNode<V> node =  new LinkedListNode<V>(data);
		if(size == 0 || head == null) {
			node.next = node;
			node.prev = node;
			head = node;
			tail = head;
		} else {
			node.prev = tail;
			tail.next = node;
			head.prev = node;
			node.next = head;
			tail = node;
		}
		size++;
		return node;
	}
	
	public LinkedListNode<V> addAfter(LinkedListNode<V> prevNode, V data) {
		if(prevNode == null) {
			return null;
		} else if(prevNode == tail) {
			return addAtEnd(data);
		} else {
			LinkedListNode<V> node = new LinkedListNode<V>(data);
			LinkedListNode<V> nextNode = prevNode.next;
			node.next = nextNode;
			prevNode.next = node;
			nextNode.prev = node;
			node.prev = prevNode;
			size++;
			return node;
		}
	}
	
	public LinkedListNode<V> addAtPos(int index, V data) {
		LinkedListNode<V> node =  new LinkedListNode<V>(data);
		if(index == 1) {
			node = addAtStart(data);
		}
		LinkedListNode<V> other = head;
		for(int i = 2; i <= size; i++) {
			if(i == index) {
				LinkedListNode<V> tmp = other.next;
				other.next = node;
				node.prev = other;
				node.next = tmp;
				tmp.prev = node;
			}
			other = other.next;
		}
		size++;
		return node;
	}
	
	public boolean headHasNext() {
		if(head.next != null) {
			return true;
		}
		return false;
	}
	
	public boolean headHasPrev() {
		if(head.prev != null) {
			return true;
		}
		return false;
	}
	
	public boolean tailHasNext() {
		if(tail.next != null) {
			return true;
		}
		return false;
	}
	
	public boolean tailHasPrev() {
		if(tail.prev != null) {
			return true;
		}
		return false;
	}
	
	public V searchNext(V data) {
		while(headHasNext()) {
			head = head.next;
			if(head.data.equals(data)) {
				return head.data;
			}
		}
		return null;
	}
	
	public V searchPrev(V data) {
		while(tailHasPrev()) {
			tail = tail.prev;
			if(tail.data.equals(data)) {
				return tail.data;
			}
		}
		return null;
	}
	
	public V quickSearch(V data) {
		LinkedListNode<V> other = new LinkedListNode<V>(data);
		if(other.data == null) {
			return null;
		}
		if(countHead(data) <= countTail(data)) {
			 other.data = searchNext(data);
		}
		if(countHead(data) > countTail(data)) {
			other.data = searchPrev(data);
		}
		other.data = data;
		return data;
	}
	
	private int countHead(V data) {
		int count = 0;
		while(headHasNext()) {
			head = head.next;
			count++;
			if(head.data.equals(data)) {
				break;
			}
		}
		return count;
	}
	
	private int countTail(V data) {
		int count = 0;
		while(tailHasPrev()) {
			tail = tail.prev;
			count++;
			if(tail.data.equals(data)) {
				break;
			}
		}
		return count;
	}
	
	public int indexOf(V data) {
		int index = 0;
		while(headHasNext()) {
			head = head.next;
			index++;
			if(head.data.equals(data)) {
				break;
			}
		}
		return index;
	}
	
	public LinkedListNode<V> getNode(int i) {
		LinkedListNode<V> p = null;
		if(i < size / 2) {
			p = head.next;
			for(int j = 0; j < i; j++) {
				p = p.next;
			}
		} else {
			p = head;
			for(int j = size; j > i; j--) {
				p = p.prev;
			}
		}
		return p;
	}
	
	public V get(int index) {
		if(index > size) {
			return null;
		}
		LinkedListNode<V> node = head;
		while(index != 0) {
			node = node.next;
			index--;
		}
		return node.data;
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
			LinkedListNode<V> prevTail = tail.prev;
			tail = prevTail;
			tail.next = null;
			System.out.println("\ndeleting node " + x + " from end");
			size--;
		}
	}
	
	public void deleteNode(LinkedListNode<V> del) {
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
	
	public void deleteAtPos(int index) {
		if(index == 1) {
			if(size == 1) {
				head = null;
				tail = null;
				size = 0;
				return;
			}
		
			head = head.next;
			head.prev = tail;
			tail.next = head;
			size--;
			return;
		}
		
		if(index == size) {
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
			size--;
		}
		
		LinkedListNode<V> other = head.next;
		for(int i = 2; i <= size; i++) {
			if(i == index) {
				LinkedListNode<V> p = other.prev;
				LinkedListNode<V> n = other.next;
				p.next = n;
				n.prev = p;
				size--;
				return;
			}
			other = other.next;
		}
	}
	
	public Iterator<V> iterator() {
		Set<V> cdll = new HashSet<>();
		for(int i = 0; i < size; i++) {
			cdll.add(head.data);
		}
		return cdll.iterator();
	}
}
