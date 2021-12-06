package DataStructures.Trees;

import java.util.List;

import DataStructures.Queues.Queue;

/**
 *
 *Implementation of the binary Heap structure providing functionalities:
 *Add values to tree
 *Extract Min/Max
 *Print Tree
 * 
 * @author root
 *
 * @param <T> --> Defines class type for the value to be stored in each node
 */
public class Heap<T>{

	private BinaryTreeNode<T> root;

	/**
	 * Type of the heap:
	 * 0 --> Min Heap
	 * 1 --> Max Heap
	 */
	Integer heapType = 0;

	public Heap(T rootVal, Integer type) {
		if(rootVal!=null) {
			root = new BinaryTreeNode<T>();
			root.val = rootVal;
		}
		heapType = type;
	}

	/**
	 * Add nodes to the heap
	 * @param values
	 */
	public void addNodesToTree(List<T> values) {
		if(values != null) {
			for(int li=0; li<values.size();li++) {
				addNodeToTree(values.get(li));
			}
		}
	}

	/**
	 * Add node to the heap
	 * @param value
	 */
	public void addNodeToTree(T value) {
		if(value!=null) {
			if(root == null) {
				root = new BinaryTreeNode<T>();
				root.val = value;
			}else {
				Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
				queue.push(root);
				BinaryTreeNode<T> parentNode = null;
				while(!queue.isEmpty()) {
					parentNode = queue.pop();
					if(parentNode.left == null || parentNode.right == null) {
						break;
					}
					if(parentNode.left!=null) {
						queue.push(parentNode.left);
					}
					if(parentNode.right!=null) {
						queue.push(parentNode.right);
					}
				}
				BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
				newNode.val = value;
				newNode.parent = parentNode;
				if(parentNode.left == null) {
					parentNode.left = newNode;
				}else {
					parentNode.right = newNode;
				}
				adjustNode(newNode);
			}
		}
	}

	/**
	 * Adjust new added node correctly in heap by swapping new element with its parent until we find an appropriate spot
	 * @param node
	 */
	protected void adjustNode(BinaryTreeNode<T> node) {
		if(node!=null) {
			while(node!=null) {
				if(node.parent!=null) {
					if(heapType ==0) {
						if((Integer)node.parent.val > (Integer)node.val) {
							T temp = node.parent.val;
							node.parent.val = node.val;
							node.val = temp;
						}else {
							break;
						}
					}else {
						if((Integer)node.parent.val < (Integer)node.val) {
							T temp = node.parent.val;
							node.parent.val = node.val;
							node.val = temp;
						}else {
							break;
						}
					}
				}
				node = node.parent;
			}
		}
	}

	/**
	 * Adjust root by swapping elements with its children until we find an appropriate spot
	 */
	protected void adjustRootNode() {
		BinaryTreeNode<T> childNode = root;

		while(childNode!=null) {
			if(heapType ==0) {
				if(  childNode.left!=null && (Integer)childNode.val > (Integer)childNode.left.val ) {
					T temp = childNode.val;
					childNode.val = childNode.left.val;
					childNode.left.val = temp;
					childNode = childNode.left;
				}else if(  childNode.right!=null && (Integer)childNode.val > (Integer)childNode.right.val ) {
					T temp = childNode.val;
					childNode.val = childNode.right.val;
					childNode.right.val = temp;
					childNode = childNode.right;
				}else {
					break;
				}
			}else {
				if(  childNode.left!=null && (Integer)childNode.val < (Integer)childNode.left.val ) {
					T temp = childNode.val;
					childNode.val = childNode.left.val;
					childNode.left.val = temp;
					childNode = childNode.left;
				}else if(  childNode.right!=null && (Integer)childNode.val < (Integer)childNode.right.val ) {
					T temp = childNode.val;
					childNode.val = childNode.right.val;
					childNode.right.val = temp;
					childNode = childNode.right;
				}else {
					break;
				}
			}
		}
	}

	/**
	 * BFS search print
	 */
	public void printHeap() {
		System.out.println("Tree print start");
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
		queue.push(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> temp = queue.pop();
			if(temp!=null) {
				System.out.print(temp.val + " ");
				queue.push(temp.left);
				queue.push(temp.right);
			}
		}
		System.out.println("");
		System.out.println("Tree print stop");
	}

	/**
	 * Extract root of the heap i.e min/max element
	 */
	public T extractTop() {
		T retVal = null;
		if(root!=null) {
			retVal = root.val;
			if(root.left==null && root.right==null) {
				root = null;
			}else {
				Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
				queue.push(root);
				BinaryTreeNode<T> lastNode = null;
				while(!queue.isEmpty()) {
					lastNode = queue.pop();
					if(lastNode.left!=null) {
						queue.push(lastNode.left);
					}
					if(lastNode.right!=null) {
						queue.push(lastNode.right);
					}
				}
				root.val = lastNode.val;
				if(lastNode.parent.left == lastNode) {
					lastNode.parent.left = null;
				}else {
					lastNode.parent.right = null;
				}
			}
			adjustRootNode();

		}
		return retVal;
	}
}
