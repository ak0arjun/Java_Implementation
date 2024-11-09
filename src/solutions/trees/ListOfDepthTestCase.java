package solutions.trees;

import java.util.ArrayList;

import dataStructures.linkedList.LinkedList;
import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

public class ListOfDepthTestCase extends TestCaseAbstract{
	
	BinaryTree<Integer> tree;
	ArrayList<LinkedList<BinaryTreeNode<Integer>>> lists;
	
	public  ListOfDepthTestCase() {
		ArrayList<Integer> inputs = new ArrayList<Integer>();
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
		tree = new BinaryTree<Integer>(null);
		tree.addNodesToTree(inputs);
		lists = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
		createTreeList();
	}
	
	protected void createTreeList() {
		LinkedList<BinaryTreeNode<Integer>> currentList = new LinkedList<BinaryTreeNode<Integer>> (null);
		currentList.addValue(tree.getRoot(), false);
		while(currentList.findLen() != 0) {
			lists.add(currentList);
			LinkedList<BinaryTreeNode<Integer>> parents = currentList;
			currentList =  new LinkedList<BinaryTreeNode<Integer>> (null);
			ArrayList<BinaryTreeNode<Integer>> parentsArr = parents.getArrayList();
			for(int li=0;li<parents.getArrayList().size();li++) {
				BinaryTreeNode<Integer> parent = parentsArr.get(li);
				if(parent.getLeft()!=null ) {
					currentList.addValue(parent.getLeft(), false);
				}
				if(parent.getRight()!=null ) {
					currentList.addValue(parent.getRight(), false);
				}
			}
		}
	}
	
	public void run() {
		for(int li=0;li<lists.size();li++) {
			LinkedList<BinaryTreeNode<Integer>> list = lists.get(li);
			System.out.print("Level "+(li+1)+":"+" ");
			ArrayList<BinaryTreeNode<Integer>> listArr = list.getArrayList();
			for(int li2=0;li2<listArr.size();li2++) {
				System.out.print(listArr.get(li2).getValue() +" ");
			}
			System.out.println("");
		}
	}
}
