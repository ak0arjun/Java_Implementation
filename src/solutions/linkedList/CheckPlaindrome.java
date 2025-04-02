package solutions.linkedList;

import dataStructures.linkedList.LinkedList;
import dataStructures.linkedList.Node;
import solutions.TestCaseAbstract;

public class CheckPlaindrome extends TestCaseAbstract {

	@Override
	public void run() {
		LinkedList<Character> madam = new LinkedList<Character>('m');
		madam.addValue('a', false);
		madam.addValue('d', false);
		madam.addValue('a', false);
		madam.addValue('m', false);

		System.out.println("Is Madam palindrome:" + isPalindrome(madam));

		LinkedList<Character> maam = new LinkedList<Character>('m');
		maam.addValue('a', false);
		maam.addValue('a', false);
		maam.addValue('m', false);

		System.out.println("Is maam palindrome:" + isPalindrome(maam));

		LinkedList<Character> m = new LinkedList<Character>('m');

		System.out.println("Is m palindrome:" + isPalindrome(m));

		LinkedList<Character> none = new LinkedList<Character>(null);

		System.out.println("Is null palindrome:" + isPalindrome(none));
	}

	private boolean isPalindrome(LinkedList<Character> ptr) {
		if (ptr.getHead() == null) {
			return false;
		}
		
		if (ptr.findLen() == 1) {
			return true;
		}

		Node<Character> middle =  ptr.findMiddle();
		return checkPalindrome(ptr.getHead(), middle) == null? false: true;
	}

	private Node<Character> checkPalindrome(Node<Character> ptr1, Node<Character> ptr2) {
		if(ptr2 == null) {
			return ptr1;
		}
		ptr1 = checkPalindrome(ptr1, ptr2.getNext());

		if(ptr1 == null) {
			return null;
		}
		if(ptr1.getVal() == ptr2.getVal()) {
			ptr1 = ptr1.getNext();
			return ptr1;
		}
		return null;
	}

}
