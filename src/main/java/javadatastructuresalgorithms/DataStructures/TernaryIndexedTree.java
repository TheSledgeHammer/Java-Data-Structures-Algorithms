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

import javadatastructuresalgorithms.DataStructures.NodeTypes.TreeNode;

public class TernaryIndexedTree<V> {

    private CircularDoublyLinkedMap<Integer, TreeNode<V>> root;
    private int size = 0;

    TernaryIndexedTree(int index, V value) {
        root = new CircularDoublyLinkedMap<Integer, TreeNode<V>>(index, new TreeNode<>(value));
    }

    public TernaryIndexedTree() {
        root = new CircularDoublyLinkedMap<Integer, TreeNode<V>>();
    }

    public int size() {
        return size;
    }

    public void addMiddle(int index, V value) {
        TreeNode<V> node = new TreeNode<V>(value);
        if(size == 0 || root == null) {
            node.setMiddle(node);
        } else {
            while(node.Middle() != null) {
                node.Middle().setMiddle(node);
                if(node.Middle() == null) {
                    node.Middle().setMiddle(node);
                }
            }
        }
        root.put(index, node);
        size++;
    }

    public void addLeft(int index, V value) {
        TreeNode<V> node = new TreeNode<>(value);
        if(size == 0 || root == null) {
            node.setLeft(node);
        } else {
            while(node.Left() != null) {
                node.Left().setLeft(node);
                if(node.Left() == null) {
                    node.Left().setLeft(node);
                }
            }
        }
        root.put(index, node);
        size++;
    }

    public void addRight(int index, V value) {
        TreeNode<V> node = new TreeNode<>(value);
        if(size == 0 || root == null) {
            node.setRight(node);
        } else {
            while(node.Right() != null) {
                node.Right().setRight(node);
                if(node.Right() == null) {
                    node.Right().setRight(node);
                }
            }
        }
        root.put(index, node);
        size++;
    }

    public V get(int index) {
        return root.get(index).getValue();
    }

    public void delete(int index) {
        root.deleteAtPos(index);
        size--;
    }
}
