package solutions.trees;

import java.util.ArrayList;

import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

public class FindCommonAncestorTestCase  extends TestCaseAbstract{

	ArrayList<Integer> inputs;
	BinaryTree<Integer> tree;

	public FindCommonAncestorTestCase() {
	}

	protected void initTree(){
		tree = new BinaryTree<Integer>(null);
		tree.addNodesToTree(inputs);
	}

	protected void testCase1() {
		BinaryTreeNode<Integer> node1 =  tree.findNode(8);
		BinaryTreeNode<Integer> node2 =  tree.findNode(6);
		BinaryTreeNode<Integer> ancBinaryTreeNode = tree.findCommonAncestor(node1, node2);
		if(ancBinaryTreeNode==null){
			System.out.println("No Ancestor");
		}else {
			System.out.println("Ancestor:"+ancBinaryTreeNode.getValue());
		}
	}

	
	protected void testCase2() {
		BinaryTreeNode<Integer> node1 =  tree.findNode(8);
		BinaryTreeNode<Integer> node2 =  tree.findNode(5);
		BinaryTreeNode<Integer> ancBinaryTreeNode = tree.findCommonAncestor(node1, node2);
		if(ancBinaryTreeNode==null){
			System.out.println("No Ancestor");
		}else {
			System.out.println("Ancestor:"+ancBinaryTreeNode.getValue());
		}
	}

	public void run() {
		inputs = new ArrayList<Integer>();
		inputs.add(1);
		inputs.add(2);
		inputs.add(3);
		inputs.add(4);
		inputs.add(5);
		inputs.add(6);
		inputs.add(7);
		inputs.add(8);
		inputs.add(9);
		inputs.add(10);
		initTree();
		testCase1();
		testCase2();
	}
}
