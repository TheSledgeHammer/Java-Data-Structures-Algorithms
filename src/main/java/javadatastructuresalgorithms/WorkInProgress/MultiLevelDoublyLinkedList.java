/**************************************************************************************************
 * Copyright [2018] [Martin Kelly]                                                                *
 *                                                                                                *
 * Licensed under the Apache License, Version 2.0 (the "License");                                *
 * you may not use this file except in compliance with the License.                               *
 * You may obtain a copy of the License at                                                        *
 *                                                                                                *
 * http://www.apache.org/licenses/LICENSE-2.0                                                     *
 *                                                                                                *
 * Unless required by applicable law or agreed to in writing, software                            *
 * distributed under the License is distributed on an "AS IS" BASIS,                              *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                       *
 * See the License for the specific language governing permissions and                            *
 * limitations under the License.                                                                 *
 **************************************************************************************************/

package main.java.datastructuresalgorithms.DataStructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
TODO:
Fix infinite runtime loop with multiple values
 */
public class MultiLevelDoublyLinkedList<V> {

	private LinkedListNode<V> head;
	private LinkedListNode<V> tail;
	private int size = 0;
	private int sizeChild = 0;

	public MultiLevelDoublyLinkedList(V key) {
		head = new LinkedListNode<V>(key);
	}

	public MultiLevelDoublyLinkedList() {
		head = null;
	}
	
	public LinkedListNode<V> HeadNode() {
		return head;
	}
	
	public LinkedListNode<V> TailNode() {
		return tail;
	}

	/*public ChildNode<V> HeadChildNode() {
		return head.childNode;
	}

	public ChildNode<V> TailChildNode() {
		return tail.childNode;
	}
	*/
	
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
		if(index >= 0 && index < size) {
			index++;
			return getNode(index).data;
		}
		return null;
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
//ChildNode
	public int sizeChild() {
		return sizeChild;
	}

	public ChildNode<V> addChild(V data) {
		int index = indexOf(data);
		ChildNode<V> node = new ChildNode<>(data);

		if(sizeChild == 0) {
			node.childNode.next = node.childNode;
			node.childNode.prev = node.childNode;
			head.childNode = node.childNode;
			tail.childNode = node.childNode;
		} else {
			node.childNode.next = head.childNode;
			head.childNode.prev = node.childNode;
			head.childNode = node.childNode;
		}
		size++;
		return node;
	}

	public class LinkedListNode<V> {

		private V data;
		private LinkedListNode<V> prev;
		private LinkedListNode<V> next;
		private ChildNode<LinkedListNode> childNode;

		public LinkedListNode(V key) {
			this.data = key;
			next = null;
			prev = null;
			childNode = null;
		}

		public void setData(V key) {
			this.data = key;
		}

		public V getData() {
			return data;
		}

		public void setLinkNext(LinkedListNode<V> n) {
			next = n;
		}

		public void setLinkPrev(LinkedListNode<V> p) {
			prev = p;
		}

		public void setChildNode(ChildNode<LinkedListNode> c) {
			childNode = c;
		}

		public LinkedListNode<V> getLinkNext() {
			return next;
		}

		public LinkedListNode<V> getLinkPrev() {
			return prev;
		}

		public ChildNode<LinkedListNode> getChildNode() {
			return childNode;
		}
	}

	public class ChildNode<V> extends LinkedListNode<V> {

		private ChildNode<LinkedListNode> childNode;
		private LinkedListNode<V> prev;
		private LinkedListNode<V> next;

		public ChildNode(V value) {
			super(value);
			next = null;
			prev = null;
			childNode = head.childNode;
		}
	}
/*
	public class ChildNode<V>  {
		private V childData;
		private int index;

		private ChildNode<V> prevChild;
		private ChildNode<V> nextChild;


		public ChildNode(int index, V key, V childKey) {
			super(key);
			this.childData = childKey;
			this.index = index;
			nextChild = null;
			prevChild = null;
			children.next.
		}

		void setChildNodeIndex(int index) {
			this.index = index;
		}

		public int getChildNodeIndex() {
			return index;
		}

		public void setChildNodeData(V childKey) {
			this.childData = childKey;
		}

		public V getChildNodeData() {
			return childData;
		}
	}*/
}
