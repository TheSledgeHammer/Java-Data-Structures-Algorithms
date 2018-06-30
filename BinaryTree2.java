package AlgorithmStructures;

public class BinaryTree2<V> {

	BTNode2<V> root;

	BinaryTree2(V name) {
		root = new BTNode2<V>(name);
	}

	BinaryTree2() {
		root = null;
	}

	private void printPostOrder(BTNode2<?> bTNode) {
		if (bTNode == null) {
			return;
		}
		printPostOrder(bTNode.left);
		printPostOrder(bTNode.right);
		System.out.print(bTNode.key + " ");
	}

	private void printInOrder(BTNode2<?> bTNode) {
		if (bTNode == null) {
			return;
		}

		printPostOrder(bTNode.left);
		System.out.print(bTNode.key + " ");
		printPostOrder(bTNode.right);
	}

	private void printPreOrder(BTNode2<?> bTNode) {
		if (bTNode == null) {
			return;
		}

		System.out.print(bTNode.key + " ");
		printPostOrder(bTNode.left);
		printPostOrder(bTNode.right);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	public void printInOrder() {
		printInOrder(root);
	}

	public void printPreOrder() {
		printPreOrder(root);
	}
}
