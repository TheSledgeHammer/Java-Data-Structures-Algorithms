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

/**
 * A Binary Indexed Tree implementation that's backed by a CircularDoublyLinkedMap<Integer, TreeNode<V>>.
 * Adding to the left side of the tree, adds to the Head of the CircularDoublyLinkedMap<Integer, TreeNode<V>>.
 * Adding to the right side of the tree, adds to the Tail of the CircularDoublyLinkedMap<Integer, TreeNode<V>>.
 */
public class BinaryIndexedTree<V> {

    private CircularDoublyLinkedMap<Integer, TreeNode<V>> root;
    private int size = 0;

    BinaryIndexedTree(int index, V value) {
        root = new CircularDoublyLinkedMap<Integer, TreeNode<V>>(index, new TreeNode<>(value));
    }

    public BinaryIndexedTree() {
        root = new CircularDoublyLinkedMap<Integer, TreeNode<V>>();
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
        root.putToHead(index, node);
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
        root.putToTail(index, node);
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
