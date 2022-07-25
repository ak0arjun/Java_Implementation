package dataStructures.stack;

 

/**
 * A generic stack class implementing stack data structure with all stack functions such as peek, push, pop, print etc
 * @author root
 *
 * @param <T>
 */
public class Stack<T> {
	private Node head;
	public String label;

	
	
	private class Node{
		T val;
		Node next;
	}
	
	/**
	 * Create a Stack with head pointing to val passed in constructor 
	 * @param val
	 */
	public Stack(T val){
		if(val!=null) {
			head = new Node();
			head.val = val;
		}
	}
	
	/**
	 * Return top value of the Stack
	 * @return
	 */
	public T peek(){
		T returnVal = null;
		if(head!=null) {
			returnVal = head.val;
		}
		return returnVal;
	}

	/**
	 * Return true/false if Stack is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		boolean returnVal = true;
		if(head !=null) {
			returnVal = false;
		}
		return returnVal;
	}
	
	/**
	 * add given value to back of the Stack
	 * @param val
	 */
	public void push(T val) {
		
		if(head ==null) {
			head = new Node();
			head.val = val;
		}else {
			Node temp = new Node();
			temp.val = val;
			temp.next = head;
			head = temp;
		}
	}
	
	/**
	 * Return all the head value of the Stack
	 * @return
	 */
	public T pop() {
		T returnVal = null;
		if(head !=null) {
			Node temp = head;
			head = head.next;
			returnVal = temp.val;
		}
		return returnVal;
	}
	
	/**
	 * Print all elements of the Stack
	 */
	public void printStack() {
		Node temp = head;
		System.out.println("Stack print start");
		while(temp!=null) {
			System.out.print(temp.val);
			System.out.print(", ");	
			temp = temp.next;
		}
		System.out.println("");
		System.out.println("Stack print end");
	}	
}
