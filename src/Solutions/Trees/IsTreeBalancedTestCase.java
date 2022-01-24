package Solutions.Trees;

import java.util.ArrayList;

import DataStructures.Trees.BinaryTree;

public class IsTreeBalancedTestCase {
	BinaryTree<Integer> tree;
	ArrayList<Integer> inputs;
	
	protected void initTree() {
		tree = new BinaryTree<Integer>(null);
		tree.addNodesToTree(inputs);
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
		System.out.println("Case 1:");
		System.out.println("is Tree Balanced:" + tree.isBalanced());
		
		tree.deleteNode(6);
		tree.deleteNode(7);
		System.out.println("Case 2:");
		System.out.println("is Tree Balanced:" + tree.isBalanced());
	}

}

