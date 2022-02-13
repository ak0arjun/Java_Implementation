package dataStructures.trees;

import dataStructures.queues.Queue;

/**
 * Implementation of AVL tree DS.  Supporting add node, delete node  , print tree
 * @author root
 *
 * @param <T>
 */
public class AVL<T> {

	/**
	 * Root node
	 */
	AVLBinaryNode<T> root = null;

	/**
	 * AVL Binary node class extending generic Binary Tree node with balance addition
	 * @author root
	 *
	 * @param <T>
	 */
	protected class AVLBinaryNode<T>{
		int balance;
		T val;
		AVLBinaryNode<T> left;
		AVLBinaryNode<T> right;
		AVLBinaryNode<T> parent;
	}

	/**
	 * Constructor setting root node
	 */
	public AVL(T rootVal) {
		if(rootVal!=null) {
			root = new AVLBinaryNode<T>();
			root.balance = 0;
			root.val = rootVal;
		}
	}

	/**
	 * Add new node to the given value, if value is not found node is added at the end
	 * @param newVal
	 * @param findVal
	 * @param type : 0 means left of the given node, 1 means right of the given node
	 */
	public void addNodeAtGivenValue(T newVal,T findVal , int type) {
		AVLBinaryNode<T> parentNode = null;
		if(findVal!=null) {
			parentNode = findNode(findVal,0);
		}
		if(parentNode==null) {
			addNode(newVal);
		}else {
			if(type == 0) {
				while(parentNode.left != null) {
					parentNode = parentNode.left;
				}
			}else {
				while(parentNode.right != null) {
					parentNode = parentNode.right;
				}
			}
			addNodeToGivenParent(newVal, parentNode, type);
		}
	}

	/**
	 * Add a new node to tree
	 * @param nodeVal
	 */
	public void addNode(T nodeVal) {
		if(root == null) {
			root = new AVLBinaryNode<T>();
			root.balance = 0;
			root.val = nodeVal;
		}else {
			AVLBinaryNode<T> parentNode =findNode(null,1);
			int type = 1;
			if(parentNode.left == null) {
				type=0;
			}
			addNodeToGivenParent(nodeVal, parentNode, type);
		}
	}

	protected void addNodeToGivenParent(T nodeVal, AVLBinaryNode<T> parentNode, int type) {
		AVLBinaryNode<T> superParentNode = parentNode.parent;
		int superParentBal  =0;
		if(superParentNode!=null) {
			superParentBal = superParentNode.balance;
		}
		AVLBinaryNode<T> newNode = new AVLBinaryNode<T>();
		newNode.balance = 0;
		newNode.val = nodeVal;
		newNode.parent = parentNode;
		int parentBal = parentNode.balance;
		if(type==0) {
			parentNode.left = newNode;
			parentBal++;
		}
		else {
			parentNode.right = newNode;
			parentBal--;
		}
		boolean isTreeAdjusted = false;
		if(superParentNode!=null && parentBal!=0) {
			if(superParentNode.left == parentNode) {
				superParentBal++;
			}else {
				superParentBal--;
			}
			if(superParentBal <-1 || superParentBal>1) {
				isTreeAdjusted = true;
				adjustTreeBalance(superParentBal, newNode, parentNode, superParentNode);
			}
		}
		if(!isTreeAdjusted) {
			AVLBinaryNode<T> ptr =  newNode;
			AVLBinaryNode<T> parentPtr =  ptr.parent;
			while(parentPtr!=null) {
				if(parentPtr.left == ptr) {
					parentPtr.balance++;
				}else {
					parentPtr.balance--;
				}
				if(parentPtr.balance == 0) {
					break;
				}
				ptr = parentPtr;
				parentPtr = ptr.parent;
			}
		}
	}

	/**
	 * Adjust three nodes balances to 0 by shifting them as per position
	 * @param superParentBal
	 * @param currentNode
	 * @param parentNode
	 * @param superParentNode
	 */
	protected void adjustTreeBalance(int superParentBal, AVLBinaryNode<T> currentNode, AVLBinaryNode<T> parentNode, AVLBinaryNode<T> superParentNode) {
		if(superParentBal==2) {
			if(  parentNode.right == currentNode) {
				AVLBinaryNode<T> temp = currentNode.left;
				currentNode.left = parentNode;
				parentNode.parent = currentNode;
				parentNode.right = temp;
				temp.parent = parentNode;
				superParentNode.left = currentNode;
				currentNode.parent = superParentNode;
				temp = parentNode;
				parentNode = currentNode;
				currentNode = temp;
			}
			if(parentNode.left == currentNode) {
				AVLBinaryNode<T> temp = parentNode.right;
				parentNode.parent = superParentNode.parent;
				if(superParentNode.parent!=null) {
					if(superParentNode.parent.left == superParentNode) {
						superParentNode.parent.left = parentNode;
					}else {
						superParentNode.parent.right = parentNode;
					}
				}
				parentNode.right = superParentNode;
				superParentNode.left = temp;
				superParentNode.parent = parentNode;

			}
		}else {
			if(  parentNode.left == currentNode) {
				AVLBinaryNode<T> temp = currentNode.right;
				currentNode.right = parentNode;
				parentNode.left = temp;
				parentNode.parent = currentNode;
				temp.parent = parentNode;
				superParentNode.right = currentNode;
				currentNode.parent = superParentNode;
				temp = parentNode;
				parentNode = currentNode;
				currentNode = temp;
			}
			if(parentNode.right == currentNode) {
				AVLBinaryNode<T> temp = parentNode.left;
				parentNode.parent = superParentNode.parent;
				if(superParentNode.parent!=null) {
					if(superParentNode.parent.left == superParentNode) {
						superParentNode.parent.left = parentNode;
					}else {
						superParentNode.parent.right = parentNode;
					}
				}
				parentNode.left = superParentNode;
				superParentNode.right = temp;
				superParentNode.parent = parentNode;
			}
		}
		superParentNode.balance = 0;
		parentNode.balance = 0;
		currentNode.balance = 0;
		if(superParentNode == root) {
			root = parentNode;
		}
	}

	/**
	 * Find node for the given value.
	 * @param nodeVal
	 * @param type : If type == 0 find given value, if type == 1 find first node with empty child, type == 2 find last node in BFS
	 * @return
	 */
	protected AVLBinaryNode<T> findNode(T nodeVal, int type) {
		AVLBinaryNode<T> retNode = root;
		Queue<AVLBinaryNode<T>> queue = new Queue<AVLBinaryNode<T>>(null);
		queue.push(retNode);
		boolean isFound = false;
		while(!queue.isEmpty()) {
			retNode = queue.pop();
			if(type ==  1 && (retNode.left == null || retNode.right == null) ) {
				isFound=true;
				break;
			}else if( retNode.val == nodeVal && type == 0) {
				isFound=true;
				break;
			}
			else {
				if(retNode.left!=null) {
					queue.push(retNode.left);
				} 
				if(retNode.right!=null) {
					queue.push(retNode.right);
				}
			}
		}
		if(!isFound && (type==0)) {
			retNode = null;
		}
		return retNode;
	}

	/**
	 * Delete the node matching the given value
	 * @param nodeVal
	 */
	public boolean deleteNode(T nodeVal) {
		boolean result = false;
		AVLBinaryNode<T> currNode = findNode(nodeVal,0);
		if(currNode != null) {
			result = true;
			if(currNode == root && currNode.left == null && currNode.right==null) {
				root = null;
			}else {
				AVLBinaryNode<T> lastNode = findNode(nodeVal,2);
				currNode.val = lastNode.val;
				AVLBinaryNode<T> parentLastNode = lastNode.parent;
				if(parentLastNode.left == lastNode) {
					parentLastNode.left  = null;
					parentLastNode.balance--;
				}else {
					parentLastNode.right  = null;
					parentLastNode.balance++;
				}
				if(parentLastNode.balance == 0) {
					if(parentLastNode.parent!=null) {
						if(parentLastNode.left == lastNode) {
							parentLastNode.parent.balance--;
						}else {
							parentLastNode.parent.balance++;
						}
						
					}
				}
			}
		}
		return result;
	}

	/**
	 * Print the tree in BFS manner with its balance printed
	 */
	public void printTree() {
		System.out.println("AVL Tree print sart");
		Queue<AVLBinaryNode<T>> queue = new Queue<AVLBinaryNode<T>>(null);
		queue.push(root);
		while(!queue.isEmpty()) {
			AVLBinaryNode<T> ptr = queue.pop();
			if(ptr!=null) {
				System.out.print(ptr.val + "("+ ptr.balance+") " );
				queue.push(ptr.left);
				queue.push(ptr.right);
			}
		}
		System.out.println("");
		System.out.println("AVL Tree print stop");
	}
}
