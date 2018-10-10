import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LinkedList<V> extends LinkedListNode<V> {

    private LinkedListNode<V> head;
    private int size = 0;

    public LinkedList(V key) {
        super(key);
        head = new LinkedListNode<V>(key);
    }

    public LinkedList() {
        super(null);
        head = null;
    }

    public LinkedListNode<V> HeadNode() {
        return head;
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
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return node;
    }

    public void remove() {
        if(size == 0) {
            return;
        } else {
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            size--;
        }
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

    public V searchNext(V data) {
        while(headHasNext()) {
            head = head.next;
            if(head.data.equals(data)) {
                return head.data;
            }
        }
        return null;
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

    public Iterator<V> iterator() {
        Set<V> dll = new HashSet<>();
        for(int i = 0; i < size; i++) {
            dll.add(head.data);
        }
        return dll.iterator();
    }
}
