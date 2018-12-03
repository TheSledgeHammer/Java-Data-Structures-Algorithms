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

package src.main.java.javadatastructuresalgorithms.DataStructures;

import src.main.java.javadatastructuresalgorithms.DataStructures.NodeTypes.ListNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DoublyLinkedList<V> {

    private ListNode<V> head;
    private ListNode<V> tail;
    private int size = 0;

    public DoublyLinkedList(V value) {
        head = new ListNode<V>(value);
    }

    public DoublyLinkedList() {
        head = null;
    }

    public ListNode<V> Head() {
        return head;
    }

    public ListNode<V> Tail() {
        return tail;
    }

    public boolean isEmpty() {
        if (head == null || tail == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public ListNode<V> addToHead(V value) {
        ListNode<V> node = new ListNode<V>(value);
        if (size == 0 || head == null) {
            head = node;
            tail = head;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        size++;
        return node;
    }

    public ListNode<V> addToTail(V value) {
        ListNode<V> node = new ListNode<V>(value);
        if (size == 0 || head == null) {
            head = node;
            tail = head;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
        return node;
    }

    public ListNode<V> addAtPos(int index, V value) {
        ListNode<V> node =  new ListNode<V>(value);
        if(index == 1) {
            node = addToHead(value);
        }
        ListNode<V> other = head;
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                ListNode<V> tmp = other.Next();
                other.setNext(node);
                node.setPrev(other);
                node.setNext(tmp);
                tmp.setPrev(node);
            }
            other = other.Next();
        }
        size++;
        return node;
    }

    public V get(int index) {
        return getNode(index).getValue();
    }

    public V set(int index, V value) {
        ListNode<V> node = getNode(index);
        V val = node.getValue();
        node.setValue(value);
        return val;
    }

    protected ListNode<V> getNode(int i) {
        ListNode<V> p = null;
        if (i < size / 2) {
            p = head.Next();
            for (int j = 0; j < i; j++) {
                p = p.Next();
            }
        } else {
            p = head;
            for (int j = size - 1; j > i; j--) {
                p = p.Prev();
            }
        }
        return p;
    }

    public int indexOf(V value) {
        int index = 0;
        while (headHasNext()) {
            index++;
            if (getNode(index).getValue().equals(value)) {
                break;
            }
        }
        if (index < 0) {
            return 0;
        }
        return index - 1;
    }

    public boolean headHasNext() {
        if (head.Next() != null) {
            return true;
        }
        return false;
    }

    public boolean headHasPrev() {
        if (head.Prev() != null) {
            return true;
        }
        return false;
    }

    public boolean tailHasNext() {
        if (tail.Next() != null) {
            return true;
        }
        return false;
    }

    public boolean tailHasPrev() {
        if (tail.Prev() != null) {
            return true;
        }
        return false;
    }

    public V searchNextValue(V value) {
        while (headHasNext()) {
            head = head.Next();
            if (head.getValue().equals(value)) {
                return head.getValue();
            }
        }
        return null;
    }

    public V searchPrevValue(V value) {
        while (tailHasPrev()) {
            tail = tail.Prev();
            if (tail.getValue().equals(value)) {
                return tail.getValue();
            }
        }
        return null;
    }

    public V quickSearch(V value) {
        ListNode<V> other = new ListNode<V>(value);
        if (other.getValue() == null) {
            return null;
        }
        if (countHead(value) <= countTail(value)) {
            other.setValue(searchNextValue(value));
        }
        if (countHead(value) > countTail(value)) {
            other.setValue(searchPrevValue(value));
        }
        other.setValue(value);
        return value;
    }

    private int countHead(V value) {
        int count = 0;
        while (headHasNext()) {
            head = head.Next();
            count++;
            if (head.getValue().equals(value)) {
                break;
            }
        }
        return count;
    }

    private int countTail(V value) {
        int count = 0;
        while (tailHasPrev()) {
            tail = tail.Prev();
            count++;
            if (tail.getValue().equals(value)) {
                break;
            }
        }
        return count;
    }

    public Iterator<V> iterator() {
        Set<V> dll = new HashSet<>();
        for (int i = 0; i < size; i++) {
            dll.add(head.getValue());
        }
        return dll.iterator();
    }

    public void deleteFromHead() {
        if (size == 0) {
            return;
        } else {
            System.out.println("\ndeleting node " + head.getValue() + " from start");
            head = head.Next();
            size--;
        }
    }

    public void deleteFromTail() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            deleteFromHead();
        } else {
            V x = tail.getValue();
            ListNode<V> prevTail = tail.Prev();
            tail = prevTail;
            tail.setNext(null);
            System.out.println("\ndeleting node " + x + " from end");
            size--;
        }
    }

    public void deleteAtPos(int index) {
        if(index == 1) {
            if(size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }

            head = head.Next();
            head.setPrev(tail);
            tail.setNext(head);
            size--;
            return;
        }

        if(index == size) {
            tail = tail.Prev();
            tail.setNext(head);
            head.setPrev(tail);
            size--;
        }

        ListNode<V> other = head.Next();
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                ListNode<V> p = other.Prev();
                ListNode<V> n = other.Next();
                p.setNext(n);
                n.setPrev(p);
                size--;
                return;
            }
            other = other.Next();
        }
    }
}
/*
    protected ListNode<V> getNode(int index) {
        ListNode<V> node = head;
        int count = 0;
       /* while(node != null) {
            if (count == index) {
                return node;
            }
            count++;
            node = node.Next();
        }
        node = tail;
        count = 0;
        while(node != null) {
            if (count == index) {
                return node;
            }
            count++;
            node = node.Prev();
        }
        return null;
    }

    public ListNode<V> addAfter(ListNode<V> prevNode, V value) {
        if(prevNode == null) {
            return null;
        } else if(prevNode == tail) {
            return addToHead(value);
        } else {
            ListNode<V> node = new ListNode<V>(value);
            ListNode<V> nextNode = prevNode.Next();
            node.setNext(nextNode);
            prevNode.setNext(node);
            nextNode.setPrev(node);
            node.setPrev(prevNode);
            size++;
            return node;
        }
    }

    public ListNode<V> addAtPos(int index, V value) {
        ListNode<V> node =  new ListNode<V>(value);
        if(index == 1) {
            node = addToHead(value);
        }
        ListNode<V> other = head;
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                ListNode<V> tmp = other.Next();
                other.setNext(node);
                node.setPrev(other);
                node.setNext(tmp);
                tmp.setPrev(node);
            }
            other = other.Next();
        }
        size++;
        return node;
    }

    //Doesnt Actually Delete anything???
    public void deleteNode(ListNode<V> del) {
        if(head == null || del == null) {
            return;
        }

        if(head == del) {
            head = del.Next();
        }

        if(del.Next() != null) {
            del.Next().setPrev(del.Prev());
        }

        if(del.Prev() != null) {
            del.Prev().setNext(del.Next());
        }
        return;
    }



}
*/