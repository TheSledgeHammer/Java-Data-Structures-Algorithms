package AlgorithmStructures.Experiment;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<V> extends TreeNode<V> {
	
	public TreeNode<V> root;

	public BinaryTree(V key) {
		super(key);
		root = new TreeNode<V>(key);
	}
	
	public BinaryTree() {
		super(null);
		root = null;
	}
	
	public int depth(TreeNode<V> node) {
		int d = 0;
		while(node != root) {
			node = node.parent;
			d++;
		}
		return d;
	}
	
	public int size(TreeNode<V> node) {
		if(node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}
	
	public int height(TreeNode<V> node) {
		if(node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public void traverse(TreeNode<V> node) {
		if(node == null) {
			return;
		}
		traverse(node.left);
		traverse(node.right);
	}
	
	public void BreadthFirstTraversal() {
		Queue<TreeNode<V>> q = new LinkedList<TreeNode<V>>();
		if(root != null) {
			q.add(root);
		}
		while(!q.isEmpty()) {
			TreeNode<V> node = q.remove();
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}
}
