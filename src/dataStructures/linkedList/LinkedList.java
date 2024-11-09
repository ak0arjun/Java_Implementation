package dataStructures.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of data structure linked list, with options to add new node, check length, pad list, delete node, print List
 * @author root
 *
 * @param <T>
 */
public class LinkedList<T> {

	/**
	 * head pointer of the list
	 */
	Node<T> head = null;

	public LinkedList(T headVal) {
		if(headVal!=null) {
			head = new Node<T>();
			head.val = headVal;
		}
	}

	/**
	 * Return current length of the list
	 * @return
	 */
	public int findLen(){
		int len=0;
		Node<T> temp = head;
		while(temp!=null){
			len++;
			temp=temp.next;
		}
		return len;
	}

	/**
	 * Add given pad value at head/bottom of the list
	 * @param head
	 * @param pad
	 * @param padVal
	 * @param start -- If true padding added at start of list else at bottom
	 * @return
	 */
	public  void padList( int pad, T padVal, boolean start){
		if (head == null && pad > 0) {
			head = new Node<T>();
			head.val = padVal;
			pad--;
		}
		if(pad>0 && head!=null){
			Node<T> tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			while(pad>0){
				Node<T> temp = new Node<T>();
				temp.val = padVal;
				if (start) {
					temp.next = head;
					head = temp;
				} else {
					tail.next = temp;
					temp.next = null;
					tail = temp;
				}
				pad--;
			}
		}
	}

	/**
	 * Create list for the given values
	 * @param vals
	 * @return
	 */
	public  void createList(List<T> vals){
		Node<T> head = null;
		if(vals!=null){
			Node<T> ptr = null;
			Node<T> prevPtr = null;
			for(int li=0;li<vals.size();li++){
				if(li==0){
					head = new Node<T>();
					head.val = vals.get(li);
					ptr = head;
					prevPtr = ptr;
				}else{
					ptr = new Node<T>();
					ptr.val = vals.get(li);
					prevPtr.setNext(ptr);
					prevPtr = ptr;
				}
			}
		}
	}

	public  void printList(){
		Node<T> temp = head;
		System.out.println("List start");
		while(temp!=null){
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
		System.out.println(" ");
		System.out.println("List end");
	}

	public ArrayList<T> getArrayList() {
		Node<T> temp = head;
		ArrayList<T> retArr = new ArrayList<T>();
		while(temp!=null){
			retArr.add(temp.val);
			temp = temp.next;
		}
		return retArr;
	}

	/**
	 * Delete the node with given value
	 * @param val
	 * @return
	 */
	public boolean deleteNode(T val) {
		boolean result = false;
		Node<T> ptr = head;
		Node<T> ptrPrev = head;
		while(ptr!=null) {
			if(ptr.val == val) {
				if(ptr == head) {
					head = head.next;
				}
				else {
					ptrPrev.next = ptr.next;
				}
				result = true;
				break;
			}
			ptrPrev = ptr;
			ptr = ptr.next;
		}
		return result;
	}

	/**
	 * Add given value at the end of the list
	 * @param start -- If true padding added at start of list else at bottom
	 * @param val
	 */
	public void addValue(T val, boolean start) {
		if(head == null) {
			head = new Node<T>();
			head.val = val;
		}else {
			Node<T> ptr = head;
			Node<T> temp = new Node<T>();
			temp.val = val;
			if (start ) {
				temp.next = head;
				head = temp;
			} else {
				Node<T> ptrLast = head;
				while(ptr!=null) {
					ptrLast = ptr;
					ptr = ptr.next;
				}
				ptrLast.next = temp;
			}
			
		}
	}
	
	public Node<T> getHead() {
		return head;
	}
}
