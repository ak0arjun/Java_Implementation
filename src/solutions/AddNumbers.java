package solutions;


import dataStructures.linkedList.LinkedList;
import dataStructures.linkedList.Node;

public class AddNumbers extends TestCaseAbstract {

	@Override
	public void run() {
		LinkedList<Integer> ptr1 = new LinkedList<Integer>(7);
		ptr1.addValue(1, false);
		ptr1.addValue(6, false);
		
		LinkedList<Integer> ptr2 = new LinkedList<Integer>(5);
		ptr2.addValue(9, false);
		ptr2.addValue(2, false);
		
		LinkedList<Integer> ptr3 = new LinkedList<Integer>(null);
		
		addNumber(ptr1, ptr2, ptr3);
		ptr1.printList();
		ptr2.printList();
		ptr3.printList();
		
		LinkedList<Integer> ptr4 = new LinkedList<Integer>(3);
		ptr4.addValue(9, false);
		ptr4.addValue(4, false);
		
		LinkedList<Integer> ptr5 = new LinkedList<Integer>(2);
		ptr5.addValue(9, false);
		ptr5.addValue(1, false);
		ptr5.addValue(8, false);
		
		LinkedList<Integer> ptr6 = new LinkedList<Integer>(null);
		
		addNumber(ptr4, ptr5, ptr6);
		ptr4.printList();
		ptr5.printList();
		ptr6.printList();
		
		LinkedList<Integer> ptr7 = new LinkedList<Integer>(3);
		ptr7.addValue(9, false);
		ptr7.addValue(4, false);
		
		LinkedList<Integer> ptr8 = new LinkedList<Integer>(null);
		
		LinkedList<Integer> ptr9 = new LinkedList<Integer>(null);
		
		addNumber(ptr7, ptr8, ptr9);
		ptr7.printList();
		ptr8.printList();
		ptr9.printList();
		
		LinkedList<Integer> ptr10 = new LinkedList<Integer>(null);
		
		LinkedList<Integer> ptr11 = new LinkedList<Integer>(null);
		
		LinkedList<Integer> ptr12 = new LinkedList<Integer>(null);
		
		addNumber(ptr10, ptr11, ptr12);
		ptr10.printList();
		ptr11.printList();
		ptr12.printList();
	}
	
	private void addNumber(LinkedList<Integer> ptr1, LinkedList<Integer> ptr2, LinkedList<Integer> ptr) {
		int len1 = ptr1.findLen();
		int len2 = ptr2.findLen();
		
		if(len1 < len2) {
			ptr1.padList(len2 - len1, 0, true);
		} else if (len2 < len1) {
			ptr2.padList(len1 - len2, 0, true);
		}
		Integer remainder = addNumberRecursion(ptr1.getHead(), ptr2.getHead(), ptr);
		if( remainder > 0) {
			ptr.addValue(remainder, true);
		}
	}
	
	private Integer addNumberRecursion(Node<Integer> node1, Node<Integer> node2, LinkedList<Integer> ptr) {
		if (node1 == null && node2 == null) {
			return 0;
		}
		Integer remainder = addNumberRecursion(node1.getNext(), node2.getNext(), ptr);
		Integer add = node1.getVal() + node2.getVal() + remainder;
		
		Integer remainderNew = add/10;
		Integer value = add%10;
		
		System.out.println("Add:" + add + "Rem:" + remainderNew + "value:" + value);
		
		ptr.addValue(value, true);
		
		return remainderNew;
	}

}
