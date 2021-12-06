package Solutions;

import DataStructures.Trees.Heap;

public class ProjectRunner {

	public static void main(String[] args) {
		Heap<Integer> minHeap = new Heap<Integer>(null, 1);
		minHeap.addNodeToTree(10);
		minHeap.addNodeToTree(5);
		minHeap.addNodeToTree(15);
		minHeap.addNodeToTree(4);
		minHeap.addNodeToTree(8);
		minHeap.addNodeToTree(12);
		minHeap.addNodeToTree(20);
		
		minHeap.printHeap();
		System.out.println("Extract:"+minHeap.extractTop());
		minHeap.printHeap();
		System.out.println("Extract:"+minHeap.extractTop());
		minHeap.printHeap();
		System.out.println("Extract:"+minHeap.extractTop());
		minHeap.printHeap();
		System.out.println("Extract:"+minHeap.extractTop());
	}

}
