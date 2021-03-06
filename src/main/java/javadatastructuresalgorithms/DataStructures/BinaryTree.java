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
 * A Binary Tree implementation that's backed by a CircularDoublyLinkedList<V>.
 * Adding to the left side of the tree, adds to the Head of the CircularDoublyLinkedList<V>.
 * Adding to the right side of the tree, adds to the Tail of the CircularDoublyLinkedList<V>.
 */
public class BinaryTree<V> {

    private CircularDoublyLinkedList<TreeNode<V>> root;
    private int size = 0;

    BinaryTree(V value) {
        root = new CircularDoublyLinkedList<TreeNode<V>>(new TreeNode<>(value));
    }

    public BinaryTree() {
        root = new CircularDoublyLinkedList<TreeNode<V>>();
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

    public void addLeft(V value) {
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
        root.addToHead(node);
        size++;
    }

    public void addRight(V value) {
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
        root.addToTail(node);
        size++;
    }

    public V get(V value) {
        TreeNode<V> node = new TreeNode<>(value);
        for(int i = 0; i < size; i++) {
            if(root.get(i).getValue().equals(node.getValue())) {
                return node.getValue();
            }
        }
        return null;
    }

    public void delete(V value) {
        TreeNode<V> node = new TreeNode<>(value);
        for(int i = 0; i < size; i++) {
            if (root.get(i).getValue().equals(node.getValue())) {
                root.deleteAtPos(i);
            }
        }
        size--;
    }
}
