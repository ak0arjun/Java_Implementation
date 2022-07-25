package solutions.sortAndSearch;

import java.util.ArrayList;

import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;

/**
 * Stores the data of Type in a fashion that it can be traced the number of items inserted smaller than any given value.
 */
public class RankFromStream<T extends Comparable<T>> {

	BinaryTree<T> bst = new BinaryTree<T>(null);

	/**
	 * Add a new value to data   
	 * @param val
	 */
	public void track(T val) {
		ArrayList<T> values = new ArrayList<T>();
		values.add(val);
		bst.addNodesInBst(values);
	}
	
	/**
	 * Calculate and return items less than equal to given value(not including the element in the count). Returns 0 if no such items
	 * @param val
	 * @return
	 */
	public int trace(T val) {
		int retVal = 0;
		BinaryTreeNode<T> node = null;
		retVal = bst.binarySearch(val, node);
		return retVal;
	}
		
}
