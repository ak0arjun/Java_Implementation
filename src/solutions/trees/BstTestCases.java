package solutions.trees;

import java.util.ArrayList;
import java.util.Collections;

import dataStructures.queues.Queue;
import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

public class BstTestCases  extends TestCaseAbstract{

	ArrayList<Integer> inputs;
	BinaryTree<Integer> tree;

	public BstTestCases( ) {

	}

	protected void createBstSortedList() {
		tree = new BinaryTree<Integer>(null);
		tree.createBSTFromSortedList(inputs);
	}

	protected void createBst() {
		tree = new BinaryTree<Integer>(null);
		tree.addNodesInBst(inputs);
	}

	protected ArrayList<ArrayList<Integer>> printAllPossibleArrayFromBST(){
		ArrayList<ArrayList<Integer>> retArr = new ArrayList<ArrayList<Integer>>();
		if(tree!=null) {
			retArr= generateAllSequences(tree.getRoot());
			System.out.println("Seq size="+retArr.size());
			System.out.println("Seq="+retArr);
		}
		return retArr;
	}

	protected ArrayList<ArrayList<Integer>> generateAllSequences(BinaryTreeNode<Integer> node ) {
		ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
		if(node==null) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		prefix.add(node.getValue());
		ArrayList<ArrayList<Integer>> leftSeqs = generateAllSequences(node.getLeft());
		ArrayList<ArrayList<Integer>> rightSeqs = generateAllSequences(node.getRight());
		for(Integer li1=0;li1<leftSeqs.size();li1++) {
			for(Integer li2=0;li2<rightSeqs.size();li2++) {
				ArrayList<ArrayList<Integer>> weaved = new ArrayList<ArrayList<Integer>>();
				weaveLists(leftSeqs.get(li1), rightSeqs.get(li2), weaved, prefix);
				results.addAll(weaved);
			}
		}
		return results;
	}

	protected void weaveLists(ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> prefix) {

		if(first.size()==0 || second.size()==0) {
			ArrayList<Integer> res = (ArrayList<Integer>) prefix.clone();
			res.addAll(first);
			res.addAll(second);
			results.add(res);
			return;
		}

		Integer head = first.remove(0);
		prefix.add(head);
		weaveLists(first, second, results, prefix);
		first.add(head);
		prefix.remove(prefix.size()-1);
		head = second.remove(0);
		prefix.add(head);
		weaveLists(first, second, results, prefix);
		second.add(head);
		prefix.remove(prefix.size()-1);
	}

	public void run() {
		inputs = new ArrayList<Integer>();
		inputs.add(5);
		inputs.add(6);
		inputs.add(1);
		inputs.add(2);
		inputs.add(7);
//		inputs.add(6);
//		inputs.add(8);
		createBst();
		System.out.println("Case 1:");
		tree.printTraverseTree(6);
		System.out.println("is Tree Bst:" + tree.isTreeBST());

		printAllPossibleArrayFromBST();
		
		createBstSortedList();
		System.out.println("Case 2:");
		tree.printTraverseTree(6);
		System.out.println("is Tree Bst:" + tree.isTreeBST());
	}
}
