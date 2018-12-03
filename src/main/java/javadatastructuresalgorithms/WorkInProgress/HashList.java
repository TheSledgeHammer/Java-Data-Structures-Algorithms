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

package src.main.java.javadatastructuresalgorithms.WorkInProgress;

import src.main.java.javadatastructuresalgorithms.DataStructures.CircularDoublyLinkedMap;
import src.main.java.javadatastructuresalgorithms.DataStructures.NodeTypes.ListNode;

public class HashList<V> {

    private CircularDoublyLinkedMap<Integer, ListNode<V>> entries;
    private int hashConstant;
    private int size = 0;

    public HashList(V value) {
        entries = new CircularDoublyLinkedMap<Integer, ListNode<V>>();
        setHashConstant(10);
    }

    public HashList(V value, int hashConstant) {
        entries = new CircularDoublyLinkedMap<Integer, ListNode<V>>();
        setHashConstant(hashConstant);
    }

    public HashList() {
        entries = new CircularDoublyLinkedMap<Integer, ListNode<V>>();
        setHashConstant(10);
    }

    public int size() {
        return size;
    }

    public int getHashConstant() {
        return hashConstant;
    }

    public void add(V value) {
        ListNode<V> node = new ListNode<V>(value);
        int idx = Hash(value);
        if (size == 0 || entries == null) {
            node.setValue(value);
        } else {
            while (idx == Hash(value)) {
                idx++;
                if (idx != Hash(value)) {
                    break;
                }
            }
            node.setValue(value);
        }
        entries.put(idx, node);
        size++;
    }

    public V get(V value) {
        ListNode<V> node = new ListNode<V>(value);
        int idx = Hash(value);
        if(entries.get(idx).getValue().equals(node.getValue())) {
            return node.getValue();
        }
        return null;
    }

    //Not Working
    public void delete(V value) {
        ListNode<V> node = new ListNode<V>(value);
        int idx = Hash(value);
        entries.deleteAtPos(idx);
        size--;
    }

    public void setHashConstant(int hashConstant) {
        this.hashConstant = hashConstant;
    }

    private int Hash(V value) {
        return value.hashCode() % hashConstant;
    }
}
