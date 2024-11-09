package dataStructures.linkedList;

public class Node<T>{

	T val;
	Node<T> next;
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getVal() {
		return val;
	}
	
	public Node<T>  getNext() {
		return next;
	}
}
