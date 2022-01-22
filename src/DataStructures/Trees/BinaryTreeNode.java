package DataStructures.Trees;

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
}
