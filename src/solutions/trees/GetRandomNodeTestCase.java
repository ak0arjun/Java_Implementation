package solutions.trees;

import java.util.ArrayList;

import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

public class GetRandomNodeTestCase extends TestCaseAbstract {

	BinaryTree<Integer> tree;
	ArrayList<Integer> input ;

	protected void initTree() {
		input = new ArrayList<Integer>();
		tree = new BinaryTree<Integer>(null);

		input.add(5);
		input.add(6);
		input.add(10);
		input.add(8);
		input.add(9);
		input.add(7);
		input.add(12);
		input.add(1);
		input.add(15);

		tree.addNodesToTree(input);
	}

	@Override
	public void run() {
		initTree();
		for(int li=0;li<20;li++) {
			BinaryTreeNode<Integer> node = tree.getRandomNode();
			if(node!=null) {
				System.out.println("Random node at "+li+":"+node.getValue());
			}
		}
	}

}
