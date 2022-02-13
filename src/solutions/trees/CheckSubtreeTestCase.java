package solutions.trees;

import java.util.ArrayList;

import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

public class CheckSubtreeTestCase extends TestCaseAbstract {

	BinaryTree<Integer> tree1 ;
	BinaryTree<Integer> tree2 ;
	
	public CheckSubtreeTestCase() {
	}

	protected void createTrees() {
		tree1 = new BinaryTree<Integer>(null);
		tree2 = new BinaryTree<Integer>(null);
		
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		
		input1.add(5);
		input1.add(6);
		input1.add(10);
		input1.add(8);
		input1.add(9);
		input1.add(7);
		input1.add(12);
		input1.add(1);
		input1.add(15);
		
		tree1.addNodesToTree(input1);
		
		input2.add(6);
		input2.add(8);
		input2.add(9);
		
		tree2.addNodesToTree(input2);	
		
	}
	
	@Override
	public void run() {
		createTrees();
		System.out.println("sub tree exists:"+tree1.isSubTree(tree2));
	}
	
}
