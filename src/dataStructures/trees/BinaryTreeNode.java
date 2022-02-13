package dataStructures.trees;

public class BinaryTreeNode<T> {
	T val;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode<T> parent;
	Integer priority = 0;

	public boolean isComplete() {
		if(left!=null && right!=null) {
			return true;
		}
		return false;
	}
	
	public BinaryTreeNode<T>  getLeft() {
		return left;
	}
	
	public BinaryTreeNode<T>  getRight() {
		return right;
	}
	
	public T getValue() {
		return val;
	}
}
