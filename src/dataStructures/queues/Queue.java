package dataStructures.queues;

/**
 * It implements Queue Data structure with all queue functions such as peek, push, pop, print etc
 * @author root
 *
 * @param <T>
 */
public class Queue<T> {

	private Node head;
	private Node back;
	
	private class Node{
		T val;
		Node next;
	}
	
	/**
	 * Create a queue with head pointing to val passed in constructor 
	 * @param val
	 */
	public Queue(T val){
		if(val!=null) {
			head = new Node();
			head.val = val;
			back = head;
		}
	}
	
	/**
	 * Return top value of the queue
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
	 * Return true/false if queue is empty or not
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
	 * add given value to back of the queue
	 * @param val
	 */
	public void push(T val) {
		
		if(back ==null) {
			head = new Node();
			head.val = val;
			back = head;
		}else {
			Node temp = new Node();
			temp.val = val;
			back.next = temp;
			back = temp;
		}
	}
	
	/**
	 * Return all the head value of the queue
	 * @return
	 */
	public T pop() {
		T returnVal = null;
		if(head !=null) {
			Node temp = head;
			returnVal = temp.val;
			head = head.next;
			if(head == null) {
				back = null;
			}
		}
		return returnVal;
	}
	
	/**
	 * Print all elements of the queue
	 */
	public void printQueue() {
		Node temp = head;
		System.out.println("Queue print start");
		while(temp!=null) {
			System.out.print(temp.val);
			System.out.print(", ");	
			temp = temp.next;
		}
		System.out.println("");
		System.out.println("Queue print end");
	}
}
