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

package javadatastructuresalgorithms.DataStructures;

import javadatastructuresalgorithms.DataStructures.NodeTypes.TableNode;

public class CircularDoublyLinkedTable<R,C,V> {

    private TableNode<R,C,V> head;
    private TableNode<R,C,V> tail;
    private int size = 0;

    public CircularDoublyLinkedTable(R row, C column, V value) {
        head = new TableNode<>(row, column, value);
    }

    public CircularDoublyLinkedTable() {
        head = null;
    }

    public TableNode<R,C,V> Head() {
        return head;
    }

    public TableNode<R,C,V> Tail() {
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

    public TableNode<R,C,V> putToHead(R row, C column, V value) {
        TableNode<R,C,V> node = new TableNode<R,C,V>(row, column, value);
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

    public TableNode<R,C,V> putToTail(R row, C column, V value) {
        TableNode<R,C,V> node = new TableNode<R,C,V>(row, column, value);
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

    public V get(R row, C column) {
        while(headHasNext()) {
            head.setRow(searchNextRow(row));
            head.setColumn(searchNextColumn(column));
            if (head.getRow() == row && head.getColumn() == column) {
                return head.getValue();
            }
        }
        return null;
    }

    public  TableNode<R,C,V> getNode(int i) {
        TableNode<R,C,V> p = null;
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
            TableNode<R,C,V> prevTail = tail.Prev();
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

        TableNode<R,C,V> other = head.Next();
        for(int i = 2; i <= size; i++) {
            if(i == index) {
                TableNode<R,C,V> p = other.Prev();
                TableNode<R,C,V> n = other.Next();
                p.setNext(n);
                n.setPrev(p);
                size--;
                return;
            }
            other = other.Next();
        }
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

    public R searchNextRow(R row) {
        while(headHasNext()) {
            head = head.Next();
            if(head.getRow().equals(row)) {
                return head.getRow();
            }
        }
        return null;
    }

    public C searchNextColumn(C column) {
        while(headHasNext()) {
            head = head.Next();
            if(head.getColumn().equals(column)) {
                return head.getColumn();
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

    public R searchPrevRow(R row) {
        while(tailHasPrev()) {
            tail = tail.Prev();
            if(tail.getRow().equals(row)) {
                return tail.getRow();
            }
        }
        return null;
    }

    public C searchPrevColumn(C column) {
        while(tailHasPrev()) {
            tail = tail.Prev();
            if(tail.getColumn().equals(column)) {
                return tail.getColumn();
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
}
