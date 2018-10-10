public class MultiLevelLinkedList<V> extends LinkedListNode<V> {

    LinkedListNode<V> head;
    LinkedListNode<V> child;
    private int size = 0;

    public MultiLevelLinkedList(V key) {
        super(key);
        head = new LinkedListNode<V>(key);
    }

    public MultiLevelLinkedList() {
        super(null);
        head = null;
    }

    public LinkedListNode<V> HeadNode() {
        return head;
    }

    public LinkedListNode<V> ChildNode() {
        return head.child;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public LinkedListNode<V> add(V data) {
        LinkedListNode<V> node = new LinkedListNode<V>(data);
        if(size == 0) {
            node.next = node;
            node.prev = node;
            head = node;
            head.child = node;
        } else {
            node.next = head;
            head.prev = node;
            head.child = node;
        }
        size++;
        return node;
    }

    public LinkedListNode<V> addChild(V data) {
        LinkedListNode<V> node = new LinkedListNode<V>(data);
        if(head.child != null) {
            node.child.next = node.child;
            node.child.prev = node.child;
            head.child = node.child;
        } else {
            node.child.next = head.child;
            head.child.prev = node.child;
            head.child = node.child;
        }
        size++;
        return node;
    }
}
