package src.main.java.javadatastructuresalgorithms.DataStructures;

import src.main.java.javadatastructuresalgorithms.DataStructures.NodeTypes.TreeNode;

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
