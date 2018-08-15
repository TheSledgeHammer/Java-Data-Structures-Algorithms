package Structures;

public interface ILinkedListNode<V> {
	
	public void setLinkNext(LinkedListNode<V> n);
	
	public void setLinkPrev(LinkedListNode<V> p);
	
	public void setData(V key);
	
	public LinkedListNode<V> getLinkNext();
	
	public LinkedListNode<V> getLinkPrev();
	
	public V getData();
}

