package AlgorithmStructures.Experiment;

public class TreeNode<V> {
	
	public V data;
	public TreeNode<V> right;
	public TreeNode<V> left;
	public TreeNode<V> parent;
	
	public TreeNode(V key) {
		data = key;
		right = left = parent = null;
	}
}
