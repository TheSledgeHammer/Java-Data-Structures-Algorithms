public class LinkedListNode<V> {
	
	V data;
	LinkedListNode<V> prev;
	LinkedListNode<V> next;
	LinkedListNode<V> child;
	
	public LinkedListNode(V key) {
		data = key;
		next = null;
		prev = null;
		child = null;
	}
	/*
	public void setLinkNext(LinkedListNode<V> n) {
		next = n;
	}

	public void setLinkPrev(LinkedListNode<V> p) {
		prev = p;
	}

	public void setData(V key) {
		this.data = key;
	}

	public LinkedListNode<V> getLinkNext() {
		return next;
	}

	public LinkedListNode<V> getLinkPrev() {
		return prev;
	}

	public V getData() {
		return data;
	}
	*/
}
