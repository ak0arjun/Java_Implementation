package dataStructures.trees;

import java.util.List;

import dataStructures.queues.Queue;

/**
 *
 *Implementation of the binary Heap structure providing functionalities:
 *Add values to tree, For the the given priority/value to compare values to each other
 *Extract Min/Max
 *Adjust Priority of Node
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
	public void addNodesToTree(List<T> values, List<Integer> priorities) {
		if(values != null && priorities!=null && values.size() == priorities.size()) {
			for(int li=0; li<values.size();li++) {
				addNodeToTree(values.get(li), priorities.get(li));
			}
		}
	}

	/**
	 * Add node to the heap
	 * @param value
	 */
	public void addNodeToTree(T value, Integer priority) {
		if(value!=null) {
			if(root == null) {
				root = new BinaryTreeNode<T>();
				root.val = value;
				root.priority = priority;
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
				newNode.priority = priority;
				newNode.parent = parentNode;
				if(parentNode.left == null) {
					parentNode.left = newNode;
				}else {
					parentNode.right = newNode;
				}
				adjustNodeUpwards(newNode);
			}
		}
	}

	/**
	 * Return node if given value exists in tree in BFS
	 * @param value - Value to find
	 * @return
	 */
	protected BinaryTreeNode<T> findNode(T value) {
		BinaryTreeNode<T> result=null;
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
		queue.push(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> temp = queue.pop();
			if(temp!=null) {
				if(temp.val == value) {
					result = temp;
					break;
				}
				queue.push(temp.left);
				queue.push(temp.right);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * If the Node exist in the heap for the given value, it will find the node and update its priority.
	 * Adjust node position according to the new priority
	 * 
	 * @param val
	 * @param priority
	 */
	public void adjustNodePriority(T val, Integer priority) {
		BinaryTreeNode<T> node = findNode(val);
		if(node!=null) {
			node.priority = priority;
			if(heapType==0) {
				if( node.parent!=null && node.priority  < node.parent.priority) {
					adjustNodeUpwards(node);
				}else if((node.left!=null && node.priority > node.left.priority) || (node.right != null && node.priority > node.right.priority)) {
					adjustNodeDownwards(node);
				}
			}else if(heapType==1) {
				if( node.parent!=null && node.priority  > node.parent.priority) {
					adjustNodeUpwards(node);
				}else if((node.left!=null &&  node.priority < node.left.priority) || (node.right != null && node.priority < node.right.priority) ) {
					adjustNodeDownwards(node);
				}
			}
			
		}
	}
	
	/**
	 * Adjust new added node correctly in heap by swapping new element with its parent until we find an appropriate spot
	 * @param node
	 */
	protected void adjustNodeUpwards(BinaryTreeNode<T> node) {
		if(node!=null) {
			while(node!=null) {
				if(node.parent!=null) {
					if(heapType ==0) {
						if((Integer)node.parent.priority > (Integer)node.priority) {
							T tempVal = node.parent.val;
							Integer tempPriority = node.parent.priority;
							node.parent.val = node.val;
							node.parent.priority = node.priority;
							node.val = tempVal;
							node.priority = tempPriority;
						}else {
							break;
						}
					}else {
						if((Integer)node.parent.priority < (Integer)node.priority) {
							T tempVal = node.parent.val;
							Integer tempPriority = node.parent.priority;
							node.parent.val = node.val;
							node.parent.priority = node.priority;
							node.val = tempVal;
							node.priority = tempPriority;
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
	 * Adjust new added node correctly in heap by swapping new element with its children until we find an appropriate spot
	 * @param node
	 */
	protected void adjustNodeDownwards(BinaryTreeNode<T> node) {
		if(node!=null) {
			while(node!=null) {
				BinaryTreeNode<T> childNode = node.left;
				if(childNode==null) {
					childNode = node.right;
				}
				if(childNode!=null) {
					if(heapType ==0) {
						if((Integer)childNode.priority < (Integer)node.priority) {
							T tempVal =childNode.val;
							Integer tempPriority = childNode.priority;
							childNode.val = node.val;
							childNode.priority = node.priority;
							node.val = tempVal;
							node.priority = tempPriority;
						}else {
							break;
						}
					}else {
						if((Integer)childNode.priority > (Integer)node.priority) {
							T tempVal = childNode.val;
							Integer tempPriority = childNode.priority;
							childNode.val = node.val;
							childNode.priority = node.priority;
							node.val = tempVal;
							node.priority = tempPriority;
						}else {
							break;
						}
					}
				}
				node = childNode;
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
				if(  childNode.left!=null && (Integer)childNode.priority > (Integer)childNode.left.priority ) {
					T tempVal = childNode.val;
					Integer tempPriority = childNode.priority;
					childNode.val = childNode.left.val;
					childNode.priority = childNode.left.priority;
					childNode.left.val = tempVal;
					childNode.left.priority = tempPriority;
					childNode = childNode.left;
				}else if(  childNode.right!=null && (Integer)childNode.priority > (Integer)childNode.right.priority ) {
					T tempVal = childNode.val;
					Integer tempPriority = childNode.priority;
					childNode.val = childNode.right.val;
					childNode.priority = childNode.right.priority;
					childNode.right.val = tempVal;
					childNode.right.priority = tempPriority;
					childNode = childNode.right;
				}else {
					break;
				}
			}else {
				if(  childNode.left!=null && (Integer)childNode.priority < (Integer)childNode.left.priority ) {
					T tempVal = childNode.val;
					Integer tempPriority = childNode.priority;
					childNode.val = childNode.left.val;
					childNode.priority = childNode.left.priority;
					childNode.left.val = tempVal;
					childNode.left.priority = tempPriority;
					childNode = childNode.left;
				}else if(  childNode.right!=null && (Integer)childNode.priority < (Integer)childNode.right.priority ) {
					T tempVal = childNode.val;
					Integer tempPriority = childNode.priority;
					childNode.val = childNode.right.val;
					childNode.priority = childNode.right.priority;
					childNode.right.val = tempVal;
					childNode.right.priority = tempPriority;
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
				System.out.print(temp.val + ":("+temp.priority+") ");
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
				root.priority = lastNode.priority;
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
