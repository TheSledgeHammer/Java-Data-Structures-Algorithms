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

import src.main.java.javadatastructuresalgorithms.DataStructures.NodeTypes.LinkedMapNode;

public class CircularDoublyLinkedMap<K,V> {

    private LinkedMapNode<K,V> head;
    private LinkedMapNode<K,V> tail;
    private int size = 0;

    public CircularDoublyLinkedMap(K key, V value) {
        head = new LinkedMapNode<>(key, value);
    }

    public CircularDoublyLinkedMap() {
        head = null;
    }

    public LinkedMapNode<K,V> Head() {
        return head;
    }

    public LinkedMapNode<K,V> Tail() {
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

    //Adds key-value pair to head or tail node depending on if size is even or odd numbered
    public LinkedMapNode<K,V> put(K key, V value) {
        LinkedMapNode<K,V> node;// = new LinkedMapNode<K,V>(key, value);
        if(isEven(size)) {
            node = putToHead(key, value);
           // System.out.println("Stored at Head Node: " + key + ':' + value);
            return node;
        }
        if(!isEven(size)) {
            node = putToTail(key, value);
         //   System.out.println("Stored at Tail Node: " + key + ':' + value);
            return node;
        }
        return null;
    }

    public LinkedMapNode<K,V> put(int index, K key, V value) {
        LinkedMapNode<K,V> node = new LinkedMapNode<K,V>(key, value);
        if(index == 1) {
            node = putToHead(key, value);
        }
        LinkedMapNode<K,V> other = head;
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                LinkedMapNode<K,V> tmp = other.Next();
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

    public LinkedMapNode<K,V> putToHead(K key, V value) {
        LinkedMapNode<K,V> node = new LinkedMapNode<K,V>(key, value);
        if(size == 0 || head == null) {
            node.setNext(node);
            node.setPrev(node);
            head = node;
            tail = head;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        size++;
        return node;
    }

    public LinkedMapNode<K,V> putToTail(K key, V value) {
        LinkedMapNode<K,V> node = new LinkedMapNode<K,V>(key, value);
        if(size == 0 || head == null) {
            node.setNext(node);
            node.setPrev(node);
            head = node;
            tail = head;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            head.setPrev(node);
            node.setNext(head);
            tail = node;
        }
        size++;
        return node;
    }

    public boolean headHasNext() {
        if(head.Next() != null) {
            return true;
        }
        return false;
    }

    public boolean headHasPrev() {
        if(head.Prev() != null) {
            return true;
        }
        return false;
    }

    public boolean tailHasNext() {
        if(tail.Next() != null) {
            return true;
        }
        return false;
    }

    public boolean tailHasPrev() {
        if(tail.Prev() != null) {
            return true;
        }
        return false;
    }

    public K searchNextKey(K key) {
        while(headHasNext()) {
            head = head.Next();
            if(head.getKey().equals(key)) {
                return head.getKey();
            }
        }
        return null;
    }

    public V searchNextValue(V value) {
        while(headHasNext()) {
            head = head.Next();
            if(head.getValue().equals(value)) {
                return head.getValue();
            }
        }
        return null;
    }

    public K searchPrevKey(K key) {
        while(tailHasPrev()) {
            tail = tail.Prev();
            if(tail.getKey().equals(key)) {
                return tail.getKey();
            }
        }
        return null;
    }

    public V searchPrevValue(V value) {
        while(tailHasPrev()) {
            tail = tail.Prev();
            if(tail.getValue().equals(value)) {
                return tail.getValue();
            }
        }
        return null;
    }

    public V quickSearch(K key, V value) {
        LinkedMapNode<K,V> other = new LinkedMapNode<K,V>(key,value);
        if(other.getValue() == null) {
            return null;
        }
        if(countHead(value) <= countTail(value)) {
            other.setValue(searchNextValue(value));
        }
        if(countHead(value) > countTail(value)) {
            other.setValue(searchPrevValue(value));
        }
        other.setValue(value);
        return value;
    }

    private int countHead(V value) {
        int count = 0;
        while(headHasNext()) {
            head = head.Next();
            count++;
            if(head.getValue().equals(value)) {
                break;
            }
        }
        return count;
    }

    private int countTail(V value) {
        int count = 0;
        while(tailHasPrev()) {
            tail = tail.Prev();
            count++;
            if(tail.getValue().equals(value)) {
                break;
            }
        }
        return count;
    }

    private boolean isEven(int value) {
        if(value % 2 == 0) {
            return true;
        }
        return false;
    }

    public int indexOfKey(K key) {
        int index = 0;
        while(headHasNext()) {
            index++;
            if(getNode(index).getKey().equals(key)) {
                break;
            }
        }
        if(index < 0) {
            return 0;
        }
        return index - 1;
    }

    public int indexOfValue(V value) {
        int index = 0;
        while(headHasNext()) {
            index++;
            if(getNode(index).getValue().equals(value) ) {
                break;
            }
        }
        if(index < 0) {
            return 0;
        }
        return index - 1;
    }

    public int indexOf(K key, V value) {
        int index;// = 0;
        if(indexOfKey(key) == indexOfValue(value)) {
            index = (indexOfKey(key) + indexOfValue(value)) / 2;
            return index;
        }
        return -1;
    }

    public LinkedMapNode<K,V> getNode(int i) {
        LinkedMapNode<K,V> p = null;
        if(i < size / 2) {
            p = head.Next();
            for(int j = 0; j < i; j++) {
                p = p.Next();
            }
        } else {
            p = head;
            for(int j = size - 1; j > i; j--) {
                p = p.Prev();
            }
        }
        return p;
    }

    public V get(K key) {
        while(headHasNext()) {
            head.setKey(searchNextKey(key));
            if (head.getKey() == key) {
                return head.getValue();
            }
        }
        return null;
    }

    public void deleteFromHead() {
        if(size == 0) {
            return;
        } else {
            System.out.println("\ndeleting node " + head.getValue() + " from start");
            head = head.Next();
            size--;
        }
    }

    public void deleteFromTail() {
        if(size == 0) {
            return;
        } else if(size == 1) {
            deleteFromHead();
        } else {
            V x = tail.getValue();
            LinkedMapNode<K,V> prevTail = tail.Prev();
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

        LinkedMapNode<K,V> other = head.Next();
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                LinkedMapNode<K,V> p = other.Prev();
                LinkedMapNode<K,V> n = other.Next();
                p.setNext(n);
                n.setPrev(p);
                size--;
                return;
            }
            other = other.Next();
        }
    }

    public boolean contains(K key) {
        if(key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /*
          public LinkedMapNode<K,V> putAfter(LinkedMapNode<K,V> prevNode, K key, V value) {
        if(prevNode == null) {
            return null;
        } else if(prevNode == tail) {
            return putToTail(key, value);
        } else {
            LinkedMapNode<K,V> node = new LinkedMapNode<K,V>(key, value);
            LinkedMapNode<K,V> nextNode = prevNode.Next();
            node.setNext(nextNode);
            prevNode.setNext(node);
            nextNode.setPrev(node);
            node.setPrev(prevNode);
            size++;
            return node;
        }
    }
      //Doesnt Actually Delete anything???
    public void deleteNode(LinkedMapNode<K,V> del) {
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
    }*/
}
