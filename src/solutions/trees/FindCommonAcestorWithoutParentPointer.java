package solutions.trees;

import java.util.ArrayList;

import dataStructures.trees.BinaryTree;
import dataStructures.trees.BinaryTreeNode;
import solutions.TestCaseAbstract;

/**
 *  Find the common ancestor node for the given values.
 *  Test cases tested for tree 1,2,3,4,5,6,7,8,9:
 *  1. Tree is null
 *  2. One value is not in tree
 *  3. Both value is not in tree
 *  4. Values 8,5
 *  5. Values 9,6
 *  6. Values 5,8
 *  7. Values 6,9
 *  8. Values 1,9
 *  9. Values 2,9
 *  10. Values 1,9
 */
public class FindCommonAcestorWithoutParentPointer extends TestCaseAbstract {

	@Override
	public void run() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(null);

		try {
			findCommonAncestor(tree, 4, 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Correct testcase null tree");
		}
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
		tree.addNodesToTree(inputs);

		try {
			findCommonAncestor(tree, 41, 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Correct testcase not found value in tree");
		}

		try {
			findCommonAncestor(tree, 491, 62);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Correct testcase not found value in tree");
		}
		
		try {
			BinaryTreeNode<Integer> case1  = findCommonAncestor(tree,8, 5);
			System.out.println("CAN for 8 & 5:" + case1.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			BinaryTreeNode<Integer> case2  = findCommonAncestor(tree,9, 6);
			System.out.println("CAN for 9 & 6:" + case2.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

		try {
			BinaryTreeNode<Integer> case1  = findCommonAncestor(tree,5, 8);
			System.out.println("CAN for 5 & 8:" + case1.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			BinaryTreeNode<Integer> case2  = findCommonAncestor(tree,6, 9);
			System.out.println("CAN for 6 & 9:" + case2.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			BinaryTreeNode<Integer> case2  = findCommonAncestor(tree,9, 9);
			System.out.println("CAN for 9 & 9:" + case2.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			BinaryTreeNode<Integer> case2  = findCommonAncestor(tree,1, 9);
			System.out.println("CAN for 1 & 9:" + case2.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			BinaryTreeNode<Integer> case2  = findCommonAncestor(tree,2, 9);
			System.out.println("CAN for 2 & 9:" + case2.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

	/**
	 * Find the common ancestor node for the given values.
	 * If root is null will throw bad input exception
	 * If val1/val2 do not exist in tree will throw bad input exception
	 * @param root Root of the tree for which common ancestor to be found
	 * @param val1 Value 1 of tree
	 * @param val2 Value 2 of tree
	 * @return Common ancestor node of the given values
	 * @throws Exception
	 */
	private BinaryTreeNode<Integer> findCommonAncestor(BinaryTree<Integer> tree, Integer val1, Integer val2) throws Exception {
		
		if(val1 == val2) {
			return tree.findNode(val2);
		}
		if (tree == null) {
			throw new Exception("Incorrect input root cannot be null");
		}

		if( tree.findNode(val1) == null || tree.findNode(val2) == null) {
			throw new Exception("Incorrect input values need to exists in tree");
		}
		BinaryTreeNode<Integer> ancestor = tree.getRoot();
		boolean val1OnLeft = tree.findNodeInSubTree(ancestor.getLeft(), val1) != null;
		boolean val2OnRight = tree.findNodeInSubTree(ancestor.getRight(), val2) != null;


		while(val1OnLeft != val2OnRight) {
			if (val1OnLeft == true) {
				ancestor = ancestor.getLeft();
			} else {
				ancestor = ancestor.getRight();
			}
			val1OnLeft = tree.findNodeInSubTree(ancestor.getLeft(), val1) == null;
			val2OnRight = tree.findNodeInSubTree(ancestor.getRight(), val2) == null;
		}
		

		return ancestor;

	}

}
