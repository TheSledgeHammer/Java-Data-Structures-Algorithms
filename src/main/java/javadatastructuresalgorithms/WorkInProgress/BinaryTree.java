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

/*
public class BinaryTree<V> extends BinaryTreeNode<V> {

    private BinaryTreeNode<V> root;
    private int size = 0;

    public BinaryTree(V value) {
        super(value);
        root = new BinaryTreeNode<>(value);
    }

    public BinaryTree() {
        super(null);
        root = null;
    }

    public int size(BinaryTreeNode<V> node) {
        if(node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public int depth(BinaryTreeNode<V> node) {
        int d = 0;
        while(node != root) {
            node = node.parent;
            d++;
        }
        return d;
    }

    public int height(BinaryTreeNode<V> node) {
        if(node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void traverse(BinaryTreeNode<V> node) {
        if(node == null) {
            return;
        }
        traverse(node.left);
        traverse(node.right);
    }

    public void BreadthFirstTraversal() {
        Queue<BinaryTreeNode<V>> q = new LinkedList<BinaryTreeNode<V>>();
        if(root != null) {
            q.add(root);
        }
        while(!q.isEmpty()) {
            BinaryTreeNode<V> node = q.remove();
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
    }
}
*/