package dataStructures.trees;

import java.util.ArrayList;
import java.util.List;

import dataStructures.queues.Queue;
import dataStructures.stack.Stack;

/**
 * Implementation of trie tree data structure holding english words and helping for quick prefix lookup. Supporting add string, check ifPrefixisValid, print tree
 * @author root
 *
 * @param <T>
 */
public class Tries {

	/**
	 * root Node
	 */
	private TreeNode<Character> root = null;

	/**
	 * Constructor initializing the root node
	 */
	public Tries(){
		root = new TreeNode<Character>();
		root.val = null;
		root.childrens = new ArrayList<TreeNode<Character>>();
	}

	/**
	 * Add a new path in tree representing the given String.
	 * @param newString
	 */
	public void addStringToTree(String newString) {

		TreeNode<Character> ptr = root;
		if(newString!=null) {
			for(int li=0;li<newString.length();li++) {
				Character c = newString.charAt(li);
				TreeNode<Character> ptr2 = checkIfCharExists(ptr, c);
				if(ptr2 == null) {
					TreeNode<Character> newNode = new TreeNode<Character>();
					newNode.val = c;
					newNode.childrens = new ArrayList<TreeNode<Character>>();
					ptr.childrens.add(newNode);
					ptr = newNode;
				}else {
					ptr = ptr2;
				}
			}
			boolean starFound = false;
			for(int chLi=0;chLi<root.childrens.size();chLi++) {
				if(root.childrens.get(chLi).val == '*') {
					starFound = true;
					break;
				}
			}
			if(!starFound) {
				TreeNode<Character> newNode = new TreeNode<Character>();
				newNode.val = '*';
				newNode.childrens = null;
				ptr.childrens.add(newNode);
			}
		}
	}

	private TreeNode<Character> checkIfCharExists(TreeNode<Character> ptr, Character c) {
		TreeNode<Character> charNode = null;
		for(int chLi=0;chLi<ptr.childrens.size();chLi++) {
			if(ptr.childrens.get(chLi).val == '*') {
				continue;
			}
			if(c == ptr.childrens.get(chLi).val) {
				ptr = ptr.childrens.get(chLi);
				charNode = ptr;
				break;
			}
		}
		return charNode;
	}


	/**
	 * Check if the given prefix exists in tree if yes return all possible strings from the prefix
	 * @param prefix
	 * @return
	 */
	public List<String> checkIfValid(String prefix){
		List<String> retList = new ArrayList<String>();
		TreeNode<Character> ptr = root;
		if(prefix!=null) {
			for(int li=0;li<prefix.length();li++) {
				Character c = prefix.charAt(li);
				TreeNode<Character> ptr2 = checkIfCharExists(ptr, c);
				if(ptr2 == null) {
					ptr = null;
					break;
				}else {
					ptr = ptr2;
				}
			}
			if(ptr!=null) {
				retList = getAllWordsForNode(ptr);
				for(int li=0;li<retList.size();li++) {
					retList.set(li, prefix.substring(0, prefix.length() -1) + retList.get(li));
				}
			}
		}
		return retList;
	}

	/**
	 * For the given pointer it collects all the words in DFS
	 * @param startPtr
	 * @return
	 */
	private List<String> getAllWordsForNode(TreeNode<Character> startPtr) {
		List<String> retList = new ArrayList<String>();
		Stack<TreeNode<Character>> stack = new Stack<TreeNode<Character>>(null);
		Stack<String> prefixString = new Stack<String>(null);
		stack.push(startPtr);
		prefixString.push("");
		while(!stack.isEmpty()) {
			String prefix = prefixString.pop();
			TreeNode<Character> ptr =  stack.pop();
			if(ptr.val != null) {
				if(ptr.val == '*') {
					retList.add(prefix);
					continue;
				}
				if(ptr.val!=null) {
					prefix = prefix + ptr.val;
				}
			}
			if(ptr.childrens.size()>0) {
				for(int li=0;li<ptr.childrens.size();li++) {
					stack.push(ptr.childrens.get(li));
					prefixString.push(prefix);
				}
			}
		}
		return retList;
	}

	/**
	 * Print all existing words using DFS
	 */
	public void printTree() {
		System.out.println("Tree print starts");
		List<String> strings = getAllWordsForNode(root);
		for(int li=0;li<strings.size();li++) {
			System.out.println(strings.get(li));
		}
		System.out.println("Tree print ends");

	}
}
