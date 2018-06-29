package AlgorithmStructures;

public class BTNode2<V> {
	V key;
	BTNode2<?> left, right;
	
	public BTNode2(V items) {
		key = items;
		left = right = null;
	}
}
