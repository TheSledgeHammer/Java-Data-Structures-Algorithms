package AlgorithmStructures.Experiment;

public class LinkedListNode<V> implements ILinkedListNode<V> {
	
	protected V data;
	protected LinkedListNode<V> prev;
	protected LinkedListNode<V> next;
	
	public LinkedListNode(V key) {
		data = key;
		next = null;
		prev = null;
	}
	
	@Override
	public void setLinkNext(LinkedListNode<V> n) {
		this.next = n;
	}

	@Override
	public void setLinkPrev(LinkedListNode<V> p) {
		this.prev = p;
	}

	@Override
	public void setData(V key) {
		this.data = key;
	}

	@Override
	public LinkedListNode<V> getLinkNext() {
		return next;
	}

	@Override
	public LinkedListNode<V> getLinkPrev() {
		return prev;
	}

	@Override
	public V getData() {
		return data;
	}
}
