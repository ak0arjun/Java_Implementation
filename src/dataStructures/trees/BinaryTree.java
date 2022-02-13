package dataStructures.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dataStructures.queues.Queue;
import dataStructures.stack.Stack;

/**
 *
 *Implementation of the binary tree structure providing functionalities:
 *Add values to tree
 *Delete
 *Print Tree
 *Find value
 *isBalanced
 *isBst
 *isSubTree
 * 
 * @author root
 *
 * @param <T> --> Defines class type for the value to be stored in each node
 */
public class BinaryTree<T extends Comparable<T>>  {

	protected BinaryTreeNode<T> root; 
	protected ArrayList<T> lastTravesal = new ArrayList<T>();
	int nodeCount = 0;


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
	 * Add nodes in BST manner
	 * @param values
	 */
	public void addNodesInBst(List<T> values) {
		if(  isTreeBST()) {
			BinaryTreeNode<T> parentNode = root;
			if(values != null) {
				for(Integer li=0;li<values.size();li++) {
					T currVal = values.get(li);
					nodeCount++;
					BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
					newNode.val = currVal;
					if(parentNode==null) {
						parentNode = newNode;
						root = parentNode;
					}else {
						parentNode = getBSTParent(currVal, root);
						if(parentNode.val.compareTo(currVal)>0) {
							parentNode.left = newNode;
							newNode.parent=parentNode;
						}else if(parentNode.val.compareTo(currVal)<0) {
							parentNode.right = newNode;
							newNode.parent=parentNode;
						}
					}
				}
			}
		}
	}

	/**
	 * Create BST from a sorted input list
	 * @param values
	 */
	public void createBSTFromSortedList(List<T> values) {
		Collections.sort(values);
		root = createBSTFromSortedList(null, values, 0, values.size()-1);
	}

	protected BinaryTreeNode<T> createBSTFromSortedList( BinaryTreeNode<T> parent,List<T> values, int startIndex, int endIndex) {
		if(endIndex<startIndex) {
			return null;
		}
		int midIndex = (startIndex + endIndex)/2;
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>();
		nodeCount++;
		newNode.val = values.get(midIndex);
		newNode.parent = parent;
		newNode.left=createBSTFromSortedList(newNode, values, startIndex, midIndex-1);
		newNode.right=createBSTFromSortedList(newNode, values, midIndex+1, endIndex);
		return newNode;
	}

	protected BinaryTreeNode<T> getBSTParent(T val, BinaryTreeNode<T> currNode)
	{
		if(currNode==null) {
			return null;
		}
		if(currNode.val.compareTo(val)>0) {
			if(currNode.left==null) {
				return currNode;
			}
			return getBSTParent(val, currNode.left);
		}else if(currNode.val.compareTo(val)<0){
			if(currNode.right==null) {
				return currNode;
			}
			return getBSTParent(val, currNode.right);
		}else {
			return null;
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
				nodeCount++;
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
						temp.parent = parentNode;
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
	protected void inOrderPrintRec(BinaryTreeNode<T> _root) {
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
	protected void preOrderPrint( ) {
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
	protected void inOrderPrint( ) {
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
	protected void postOrderPrint( ) {
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
	protected void preOrderPrintRec(BinaryTreeNode<T> _root) {
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
	protected void postOrderPrintRec(BinaryTreeNode<T> _root) {
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
	 * Get a random node from the tree
	 * @return
	 */
	public BinaryTreeNode<T> getRandomNode(){
		BinaryTreeNode<T> retNode = null;
		Random r  = new Random();
		int index = r.nextInt(nodeCount);
		retNode = getNodeAtIndex(index);
		return retNode;
	}
	

	/**
	 * Return Node at given index in BST traversal
	 * @param index
	 * @return
	 */
	public BinaryTreeNode<T> getNodeAtIndex(int index){
		BinaryTreeNode<T> retNode = null;
		if(index<nodeCount) {
			Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>(null);
			queue.push(root);
			while(!queue.isEmpty()) {
				BinaryTreeNode<T> temp = queue.pop();
				if(temp!=null) {
					index--;
					if(index ==0) {
						retNode=temp;
						break;
					}
					queue.push(temp.left);
					queue.push(temp.right);
				}
			}
		}
		return retNode;
	}

	/**
	 * Return node if given value exists in tree in BFS else return null
	 * @param value - Value to find
	 * @return
	 */
	public BinaryTreeNode<T> findNode(T value) {
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
		if(result) {
			nodeCount--;
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

	/**
	 * Return true if tree is balanced i.e each node left -right height is <= 1 and >= -1
	 * @return
	 */
	public boolean isBalanced() {
		boolean retVal = true;
		Integer height = checkBalance(root);
		if(height == -10000 ) {
			retVal = false;
		}
		return retVal;
	}

	protected Integer checkBalance(BinaryTreeNode<T> node) {
		if(node==null) {
			return 0;
		}
		Integer leftHeight = checkBalance(node.left);
		Integer rightHeight = checkBalance(node.right);
		if(leftHeight ==-10000 || rightHeight==10000) {
			return -10000;
		}
		if((leftHeight - rightHeight)<-1 || (leftHeight - rightHeight)>1 ) {
			return -10000;
		}
		if(leftHeight>rightHeight) {
			return (1 + leftHeight);
		}
		return (1 + rightHeight);
	}

	/**
	 * Return the next common ancestor of given nodes
	 * @param node1
	 * @param node2
	 * @return
	 */
	public BinaryTreeNode<T> findCommonAncestor(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2){
		BinaryTreeNode<T> ancestor = null;
		if(node1!=null && node2!=null) {
			int rootHeight1 = 0;
			BinaryTreeNode<T> temp = node1;
			while(temp!=root) {
				temp = temp.parent;
				rootHeight1++;
			}
			int rootHeight2 = 0;
			temp = node2;
			while(temp!=root) {
				temp = temp.parent;
				rootHeight2++;
			}
			while(rootHeight1!=rootHeight2) {
				if(rootHeight1>rootHeight2) {
					rootHeight1--;
					node1 = node1.parent;
				}else {
					rootHeight2--;
					node2 = node2.parent;
				}
			}

			while(node1!=null || node2!=null) {
				if(node1==node2) {
					ancestor= node1;
					break;
				}
				node1 = node1.parent;
				node2 = node2.parent;
			}


		}
		return ancestor;
	}

	/**
	 * Return true if tree is subtree in given tree
	 * @param tree2
	 * @return
	 */
	public boolean isSubTree(BinaryTree<T> tree2) {
		boolean result = false;
		result = checkSubTree(root, tree2);
		return result;
	}

	protected boolean checkSubTree(BinaryTreeNode<T> node1, BinaryTree<T> tree2) {
		if(node1==null) {
			return false;
		}
		if(tree2==null) {
			return true;
		}
		boolean isMatched = false;
		if(node1.val.equals(tree2.getRoot().val)) {
			isMatched = matchTrees(node1, tree2.getRoot());

		}
		if(isMatched) {
			return isMatched;
		}else {
			return checkSubTree(node1.left, tree2) || checkSubTree(node1.right, tree2);
		}
	}

	protected boolean matchTrees(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
		if(node1==null || node2==null) {
			return true;
		}
		if(node1.val.compareTo(node2.val)!=0) {
			return false;
		}else {
			return matchTrees(node1.left, node2.left) && matchTrees(node1.right, node2.right);
		}
	}

	/**
	 * Return root node
	 * @return
	 */
	public BinaryTreeNode<T> getRoot(){
		return root;
	}

}
