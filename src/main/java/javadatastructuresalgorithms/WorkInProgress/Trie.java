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

package javadatastructuresalgorithms.WorkInProgress;

import javadatastructuresalgorithms.DataStructures.NodeTypes.ListNode;

public class Trie<V> {

    private ListNode<V> root;
    private int size = 0;

    public Trie(V ch) {
        root = new ListNode<V>(ch);
    }

    public Trie() {
        root = null;
    }

    public ListNode<V> Head() {
        return root;
    }

    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public ListNode<V> add(V ch) {
        ListNode<V> node = new ListNode<V>(ch);
        if(size == 0 || root == null) {
            node.setNext(node);
            node.setPrev(node);
            root = node;
        } else {
            root.setPrev(node);
            node.setNext(root);
            root = node;
        }
        size++;
        return node;
    }

    public ListNode<V> getNode(int i) {
        ListNode<V> p = null;
        if(i < size / 2) {
            p = root.Next();
            for(int j = 0; j < i; j++) {
                p = p.Next();
            }
        } else {
            p = root;
            for(int j = size; j > i; j--) {
                p = p.Prev();
            }
        }
        return p;
    }

    public V get(int index) {
        while(index >= 0 && index < size) {
            index++;
            return getNode(index).getValue();
        }
        return null;
    }
}
