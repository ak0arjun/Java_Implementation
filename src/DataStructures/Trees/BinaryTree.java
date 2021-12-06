package DataStructures.Trees;

import java.util.ArrayList;
import java.util.List;

import DataStructures.Queues.Queue;
import DataStructures.Stack.Stack;

/**
 *
 *Implementation of the binary tree structure providing functionalities:
 *Add values to tree
 *Delete
 *Print Tree
 *Find value
 *isBst
 * 
 * @author root
 *
 * @param <T> --> Defines class type for the value to be stored in each node
 */
public class BinaryTree<T> {

	protected BinaryTreeNode<T> root; 
	protected ArrayList<T> lastTravesal = new ArrayList<T>();


	/**
	 * Construct root of the tree
	 * @param rootVal
	 */
	public BinaryTree(T rootVal){
		if(rootVal!=null) {
			root = new BinaryTreeNode<T>();
			root.val = rootVal;
		}
	}

	/**
	 * Add nodes to the tree from from left to right
	 * @param values
	 */
	public void addNodesToTree(List<T> values) {
		Queue<BinaryTreeNode<T>> queue= new Queue<BinaryTreeNode<T>>(null);
		BinaryTreeNode<T> parentNode = root;
		if(parentNode !=null) {
			queue.push(parentNode);
		}
		if(values != null) {
			for(Integer li=0;li<values.size();li++) {
				if(parentNode == null) {
					parentNode = new BinaryTreeNode<T>();
					parentNode.val = values.get(li);
					root = parentNode;
					queue.push(parentNode);
				}else {
					boolean isProcessed = false;
					while(!queue.isEmpty() && !isProcessed) {
						parentNode = queue.peek();
						BinaryTreeNode<T> temp = new BinaryTreeNode<T>();
						temp.val = values.get(li);
						if(parentNode.left==null) {
							parentNode.left = temp;
							queue.push(temp);
							isProcessed = true;
						}else if(parentNode.right == null) {
							parentNode.right = temp;
							queue.push(temp);
							isProcessed = true;
						}
						if(parentNode.isComplete()) {
							queue.pop();
							if(parentNode.left !=null) {
								queue.push(parentNode.left);
							}
							if(parentNode.right !=null) {
								queue.push(parentNode.right);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Print the tree values in Inorder/Postorder/PreOrder
	 * @param type 0 - InorderRec, 1 - PreOrderRec, 2 - PostOrderRec, 3 - Inorder, 4 - PreOrder, 5 - PostOrder
	 */
	public void printTraverseTree(int type){
		lastTravesal.clear();
		System.out.println("Tree print start");
		switch(type) {
		case 0:{
			inOrderPrintRec(root);
			break;
		}
		case 1:{
			preOrderPrintRec(root);
			break;
		}
		case 2:{
			postOrderPrintRec(root);
			break;
		}
		case 3:{
			inOrderPrint();
			break;
		}
		case 4:{
			preOrderPrint();
			break;
		}
		case 5:{
			postOrderPrint();
			break;
		}
		case 6:{
			breathFirstSearchPrint();
			break;
		}
		default:{
			inOrderPrintRec(root);
			break;	
		}
		}	
		System.out.println("");
		System.out.println("Tree print stop");
	}

	/**
	 * In order traversal/print of tree using recursion
	 * @param _root
	 */
	public void inOrderPrintRec(BinaryTreeNode<T> _root) {
		if(_root==null)
		{		
			return;
		}
		inOrderPrintRec(_root.left);
		System.out.print(_root.val + " ");
		lastTravesal.add(_root.val);
		inOrderPrintRec(_root.right);
	}

	/**
	 * Pre order traversal and print without recursion
	 */
	public void preOrderPrint( ) {
		if(root==null)
		{		
			return;
		}

		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>(null);
		BinaryTreeNode<T> temp = root;
		stack.push(temp);
		while(stack.isEmpty()==false) {
			temp = stack.pop();
			if(temp == null) {
				continue;
			}
			System.out.print(temp.val + " ");
			lastTravesal.add(temp.val);
			stack.push(temp.right);
			stack.push(temp.left);
		}
	}

	/**
	 * In order traversal and print without recursion
	 */
	public void inOrderPrint( ) {
		if(root==null)
		{		
			return;
		}
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>(null);
		BinaryTreeNode<T> temp = root;
		while(temp!=null || stack.isEmpty()==false) {
			while(temp!=null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			System.out.print(temp.val + " ");
			lastTravesal.add(temp.val);
			temp=temp.right;
		}
	}

	/**
	 * Post order traversal and print without recursion
	 */
	public void postOrderPrint( ) {
		if(root==null)
		{		
			return;
		}

		Stack<BinaryTreeNode<T>> stack1 = new Stack<BinaryTreeNode<T>>(null);
		Stack<BinaryTreeNode<T>> stack2 = new Stack<BinaryTreeNode<T>>(null);
		BinaryTreeNode<T> temp = root;
		stack1.push(temp);
		while(stack1.isEmpty()==false) {
			temp = stack1.pop();
			stack2.push(temp);
			if(temp.left!=null) {
				stack1.push(temp.left);
			}
			if(temp.right!=null) {
				stack1.push(temp.right);
			}
		}

		while(!stack2.isEmpty()) {
			temp=stack2.pop();
			System.out.print(temp.val + " ");
			lastTravesal.add(temp.val);
		}
	}

	/**
	 * Pre order traversal/print of tree using recursion
	 * @param _root
	 */
	public void preOrderPrintRec(BinaryTreeNode<T> _root) {
		if(_root==null)
		{		
			return;
		}
		System.out.print(_root.val + " ");
		lastTravesal.add(_root.val);
		preOrderPrintRec(_root.left);
		preOrderPrintRec(_root.right);
	}

	/**
	 * Post order traversal/print of tree using recursion
	 * @param _root
	 */
	public void postOrderPrintRec(BinaryTreeNode<T> _root) {
		if(_root==null)
		{		
			return;
		}
		postOrderPrintRec(_root.left);
		postOrderPrintRec(_root.right);
		System.out.print(_root.val + " ");
		lastTravesal.add(_root.val);
	}

	/**
	 * BFS search traversal/print
	 */
	public void breathFirstSearchPrint() {
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
		queue.push(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> temp = queue.pop();
			if(temp!=null) {
				System.out.print(temp.val + " ");
				lastTravesal.add(temp.val);
				queue.push(temp.left);
				queue.push(temp.right);
			}
		}
	}

	/**
	 * Return true/false if given value exists in tree in BFS
	 * @param value - Value to find
	 * @return
	 */
	public boolean findNode(T value) {
		boolean result=false;
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
		queue.push(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> temp = queue.pop();
			if(temp!=null) {
				if(temp.val == value) {
					result = true;
					break;
				}
				queue.push(temp.left);
				queue.push(temp.right);
			}
		}
		return result;
	}

	/**
	 * Delete tree node with the given value in BFS traversal
	 * @param value
	 */
	public boolean deleteNode(T value) {
		boolean result=false;
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
		Queue<BinaryTreeNode<T>> parentQueue = new Queue<BinaryTreeNode<T>>(null);
		queue.push(root);
		parentQueue.push(root); 
		while(!queue.isEmpty()) {
			BinaryTreeNode<T> temp = queue.pop();
			BinaryTreeNode<T> parentTemp = parentQueue.pop();
			if(temp!=null) {
				if(temp.val == value) {
					result = true;
					if(temp == root) {
						if(temp.left!=null) {
							root.val = temp.left.val;
							temp = temp.left;
						}else if(temp.right!=null) {
							root.val = temp.right.val;
							temp = temp.right;
						}else {
							root = null;
							break;
						}
					}
					T retVal = findAndReplaceLargestValue(temp, parentTemp);
					if(retVal != null) {
						temp.val = retVal;
					}
					break;
				}
				queue.push(temp.left);
				parentQueue.push(temp);
				queue.push(temp.right);
				parentQueue.push(temp);
			}
		}
		return result;
	}

	protected T findAndReplaceLargestValue(BinaryTreeNode<T> temp, BinaryTreeNode<T> parentTemp) {
		T retVal = null;
		while(temp.right !=null) {
			parentTemp = temp;
			temp = temp.right;
			retVal = temp.val;
		}
		parentTemp.right = temp.left;
		return retVal;
	}

	/**
	 * Insert value at a empty node
	 * @param value 
	 * @param type
	 */
	public void insertValue(T value ) {
		ArrayList<T> values = new ArrayList<T>();
		values.add(value);
		addNodesToTree(values);
	}
	
	/**
	 * Return true if tree is BST
	 * @return
	 */
	public boolean isTreeBST() {
		boolean retVal = true;
		printTraverseTree(3);
		if(lastTravesal.size()>0) {
			T lastVal = lastTravesal.get(0);
			for(int li=0;li<lastTravesal.size();li++) {
				if((Integer)lastVal > (Integer)lastTravesal.get(li)) {
					retVal = false;
					break;
				}
				lastVal = lastTravesal.get(li);
			}
		}
	
		return retVal;
	}
}
