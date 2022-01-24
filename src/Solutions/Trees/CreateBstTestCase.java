package Solutions.Trees;

import java.util.ArrayList;
import java.util.Collections;

import DataStructures.Queues.Queue;
import DataStructures.Trees.BinaryTree;

public class CreateBstTestCase {

	ArrayList<Integer> inputs;
	BinaryTree<Integer> tree;

	public CreateBstTestCase( ) {
		
	}

	protected void initTree() {
		tree = new BinaryTree<Integer>(null);
		if(inputs!=null) {
			Collections.sort(inputs);
			int startIndex = 0;
			int endIndex = inputs.size()-1;
			Queue<Integer> startIndexQueue = new Queue<Integer>(startIndex);
			Queue<Integer> endIndexQueue = new Queue<Integer>(endIndex);
			while(!startIndexQueue.isEmpty()) {
				startIndex = startIndexQueue.pop();
				endIndex = endIndexQueue.pop();
				if( endIndex<startIndex) {
					continue;
				}
				int midIndex = (startIndex + endIndex)/2;
				tree.insertValue(inputs.get(midIndex));
				startIndexQueue.push(startIndex);
				endIndexQueue.push(midIndex-1);
				startIndexQueue.push(midIndex+1);
				endIndexQueue.push(endIndex);
			}
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
		System.out.println("Case 1:");
		tree.printTraverseTree(6);
		System.out.println("is Tree Bst:" + tree.isTreeBST());
	}
}
