package dataStructures.queues;

import dataStructures.trees.Heap;

/**
 * 
 *Implementation of the binary Heap structure providing functionalities:
 *Add values to tree, For the the given priority/value to compare values to each other
 *Extract Min/Max
 *Adjust Priority of Node
 *Print Tree
 *
 * @author root
 *
 * @param <T>
 */
public class PriorityQueue<T> extends Heap<T>{
	
	public PriorityQueue(T rootVal, Integer type) {
		super(rootVal, type);
	}
	

}
