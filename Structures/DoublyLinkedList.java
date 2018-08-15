package Structures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DoublyLinkedList<V> extends LinkedListNode<V> {
	
	private LinkedListNode<V> head;
	private LinkedListNode<V> tail;
	private int size = 0;
	
	public DoublyLinkedList(V key) {
		super(key);
		head = new LinkedListNode<V>(key);
	}
	
	public DoublyLinkedList() {
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
	
	public LinkedListNode<V> addAtStart(V data) {
		LinkedListNode<V> node = new LinkedListNode<V>(data);
		if(size == 0) {
			node.next = node;
			node.prev = node;
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
	
	public LinkedListNode<V> addAtEnd(V data) {
		LinkedListNode<V> node =  new LinkedListNode<V>(data);
		if(size == 0) {
			node.next = node;
			node.prev = node;
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
	
	public V get(int index) {
		if(index > size) {
			return null;
		}
		LinkedListNode<V> node = head;
		//index-1
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
	
	public Iterator<V> iterator() {
		Set<V> dll = new HashSet<>();
		for(int i = 0; i < size; i++) {
			dll.add(head.data);
		}
		return dll.iterator();
	}
}
