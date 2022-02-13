package dataStructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataStructures.queues.Queue;
import dataStructures.stack.Stack;
import dataStructures.trees.Heap;

/**
 * Implementation of graph data structure using adjacency list approach. It provides functionality to add, delete, search a node, search path between 2 nodes, BFS, DFS print 
 * @author root
 *
 * @param <T>
 */
public class Graph<T> {

	/**
	 * List of all the nodes
	 */
	List<GraphNode<T>> nodes;
	/**
	 * Denotes if graph is directional or un-directional
	 */
	boolean isDirected;

	/**
	 * Stores last traversal result
	 */
	protected ArrayList<T> lastTravesal = new ArrayList<T>();

	/**
	 * Construct a graph 	
	 * @param isDirected
	 */
	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
		nodes = new ArrayList<GraphNode<T>>();
	}

	/**
	 * Add a new node in graph with the given value
	 * @param val : New node value
	 * @param connectedNodes: List of values to which graph is connected
	 */
	public void addNode(T val, List<T> connectedNodes, List<Integer> weights) {
		if(val != null) {
			HashMap<T,  GraphNode<T>> nodeValueMap = new HashMap<T, GraphNode<T>>();
			for(int li=0;li<nodes.size();li++) {
				nodeValueMap.put(nodes.get(li).value, nodes.get(li));
			}
			GraphNode<T> newNode = null;
			if(!nodeValueMap.containsKey(val)) {
				newNode = new GraphNode<T>();
				newNode.value = val;
				nodes.add(newNode);
			}else {
				newNode = nodeValueMap.get(val);
			}
			if(connectedNodes!=null && connectedNodes.size()>0) {
				for(int li=0;li<connectedNodes.size();li++) {
					if(!nodeValueMap.containsKey(connectedNodes.get(li))){
						GraphNode<T> tempNode = new GraphNode<T>();
						tempNode.value = connectedNodes.get(li);
						nodes.add(tempNode);
						nodeValueMap.put(connectedNodes.get(li), tempNode);
					}
					GraphNode<T> existingNode = nodeValueMap.get(connectedNodes.get(li));
					Integer weight = 1;
					if(isDirected && weights!=null && li < weights.size()) {
						weight = weights.get(li);
					}
					newNode.addChildren(existingNode, weight);
					if(!isDirected) {
						existingNode.addChildren(newNode, 1);
					}
				}
			}
		}
	}

	/**
	 * Traverse and print the graph in the given type
	 * @param type : 0 - BFS, 1: DFS, 2: DFS recursive
	 */
	public void traverseGraph(int type) {
		System.out.println("Graph print start");
		lastTravesal.clear();
		for(int li=0;li<nodes.size();li++) {
			nodes.get(li).isVisited = false;
		}
		switch (type) {
		case 1:
			traverseDFS();
			break;
		case 2:
			for (int li = 0; li < nodes.size(); li++) {
				GraphNode<T> node = nodes.get(li);
				if(node != null && node.isVisited == false) {
					traverseDFSRecursive(node);
				}
			}
			break;
		default:
			traverseBFS();
			break;
		}
		System.out.println("");
		System.out.println("Graph print end");
	}

	protected void traverseDFS() {
		Stack<GraphNode<T>> stack = new Stack<GraphNode<T>>(null);
		for (int li = 0; li < nodes.size(); li++) {
			GraphNode<T> node = nodes.get(li);
			if(node != null && node.isVisited == false) {
				stack.push(node);
				while(!stack.isEmpty()) {
					node = stack.pop();
					if(node.isVisited==false) {
						node.isVisited = true;
						System.out.print(node.value + " ");
						lastTravesal.add(node.value);
						for(int cli=node.childrens.size()-1;cli>=0;cli--) {
							GraphNode<T> childNode = node.childrens.get(cli);
							if(childNode!=null && !childNode.isVisited) {
								stack.push(childNode);
							}
						}
					}
				}
			}
		}
	}

	protected void traverseDFSRecursive(GraphNode<T> node) {
		System.out.print(node.value + " ");
		lastTravesal.add(node.value);
		node.isVisited=  true;
		for(int cli=0;cli<node.childrens.size();cli++) {
			GraphNode<T> childNode = node.childrens.get(cli);
			if(childNode!=null && !childNode.isVisited) {
				traverseDFSRecursive(childNode);
			}
		}
	}

	protected void traverseBFS() {
		Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>(null);
		for (int li = 0; li < nodes.size(); li++) {
			GraphNode<T> node = nodes.get(li);
			if(node != null && node.isVisited == false) {
				queue.push(node);
				while(!queue.isEmpty()) {
					node = queue.pop();
					if(node.isVisited==false) {
						node.isVisited = true;
						System.out.print(node.value + " ");
						lastTravesal.add(node.value);
						for(int cli=0;cli<node.childrens.size();cli++) {
							GraphNode<T> childNode = node.childrens.get(cli);
							if(childNode!=null && !childNode.isVisited) {
								queue.push(childNode);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Delete the given node 
	 * @param val
	 */
	public void deleteNode(T val) {
		if(val != null) {
			int posDel = -1;
			for (int li = 0; li < nodes.size(); li++) {
				GraphNode<T> node = nodes.get(li);
				if(node.value == val) {
					posDel = li;
				}
				int childPosDel = -1;
				for(int cli=0;cli<node.childrens.size();cli++) {
					GraphNode<T> childNode = node.childrens.get(cli);
					if(childNode.value == val) {
						childPosDel = cli;
					}
				}
				if(childPosDel>-1) {
					node.childrens.remove(childPosDel);
				}
			}
			if(posDel>-1) {
				nodes.remove(posDel);
			}
		}
	}

	/**
	 * Return true if node exists 
	 * @param val
	 * @return
	 */
	public boolean findNode(T val) {
		for(int li=0;li<nodes.size();li++) {
			nodes.get(li).isVisited = false;
		}
		Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>(null);
		for (int li = 0; li < nodes.size(); li++) {
			GraphNode<T> node = nodes.get(li);
			if(node != null && node.isVisited == false) {
				queue.push(node);
				while(!queue.isEmpty()) {
					node = queue.pop();
					if(node.isVisited==false) {
						node.isVisited = true;
						if(node.value == val) {
							return true;
						}
						for(int cli=0;cli<node.childrens.size();cli++) {
							GraphNode<T> childNode = node.childrens.get(cli);
							if(childNode!=null && !childNode.isVisited) {
								queue.push(childNode);
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Return list of nodes if a path exists between 2 given nodes 
	 * @param val
	 */
	public void findPathNode(T val, T val2, ArrayList<T> pathTraversal, ArrayList<Integer> weights) {
		for(int li=0;li<nodes.size();li++) {
			nodes.get(li).isVisited = false;
		}
		Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>(null);
		Queue<ArrayList<Integer>> queueWeight = new Queue<ArrayList<Integer>>(null);
		Queue<ArrayList<T>> queueTraversal = new Queue<ArrayList<T>>(null);
		GraphNode<T> node = null;
		for (int li = 0; li < nodes.size(); li++) {
			if(nodes.get(li).value== val) {
				node = nodes.get(li);	
				break;
			}
		}
		if(node != null && node.isVisited == false) {
			queue.push(node);
			ArrayList<Integer> initWeight = new ArrayList<Integer>();
			initWeight.add(0);
			queueWeight.push(initWeight);
			ArrayList<T> initTraversal = new ArrayList<T>();
			initTraversal.add(node.value);
			queueTraversal.push(initTraversal);
			while(!queue.isEmpty()) {
				node = queue.pop();
				ArrayList<Integer> weightsUsed = queueWeight.pop();
				ArrayList<T> pathTraversed = queueTraversal.pop();
				if(node.isVisited==false) {
					node.isVisited = true;
					if(node.value == val2) {
						pathTraversal.addAll(pathTraversed);
						weights.addAll(weightsUsed);
						return;
					}
					for(int cli=0;cli<node.childrens.size();cli++) {
						GraphNode<T> childNode = node.childrens.get(cli);
						if(childNode!=null && !childNode.isVisited) {
							ArrayList<Integer> newWeightsUsed = new ArrayList<Integer>();
							ArrayList<T> newPathTraversed = new ArrayList<T>();
							newWeightsUsed.addAll(weightsUsed);
							newWeightsUsed.add(node.weights.get(cli));
							queue.push(childNode);
							newPathTraversed.addAll(pathTraversed);
							newPathTraversed.add(childNode.value);
							queueWeight.push(newWeightsUsed);
							queueTraversal.push(newPathTraversed);
						}
					}
				}
			}
		}
		pathTraversal = null;
		weights = null;
	}

	/**
	 * Return a Topological sort of the given graph
	 * @return
	 */
	public ArrayList<T> topologicalSort(){
		ArrayList<T> retArr = new ArrayList<T>();
		if(isDirected) {
			Queue<GraphNode<T>> queueNext = new Queue<GraphNode<T>>(null);
			HashMap<GraphNode<T>, Integer> nodeIncomingCount = new HashMap<GraphNode<T>, Integer>();
			for(int li=0;li<nodes.size();li++) {
				nodeIncomingCount.put(nodes.get(li), 0);
			}
			for(int li=0;li<nodes.size();li++) {
				GraphNode<T> node = nodes.get(li);
				for(int cli=0;cli<node.childrens.size();cli++) {
					nodeIncomingCount.put(node.childrens.get(cli), nodeIncomingCount.get(node.childrens.get(cli))+1);
				}
			}
			do {
				while(!queueNext.isEmpty()) {
					GraphNode<T> node = queueNext.pop();
					retArr.add(node.value);
					nodeIncomingCount.remove(node);
					for(int cli=0;cli<node.childrens.size();cli++) {
						nodeIncomingCount.put(node.childrens.get(cli), nodeIncomingCount.get(node.childrens.get(cli))-1);
					}
				}
				for (HashMap.Entry<GraphNode<T>, Integer> entry : nodeIncomingCount.entrySet()) {
					GraphNode<T> key = entry.getKey();
					Integer val = entry.getValue();
					if(val == 0) {
						queueNext.push(key);
					}
				}
			}while(!queueNext.isEmpty());

		}
		return retArr;
	}

	/**
	 * Find the shortest possible path between 2 nodes using dijikstra's algorithm and return the path value.
	 * @param val
	 * @param val2
	 * @param pathTraversal
	 * @return
	 */
	public Integer findShortestPath(T val, T val2, ArrayList<T> pathTraversal) {
		Integer pathTotalWeight = -1;
		if(val!=null && val2!=null) {
			HashMap<T, Integer> pathWeight = new HashMap<T, Integer>();
			pathWeight.put(val, 0);
			HashMap<T, T> previousNode = new HashMap<T, T>();
			Heap<GraphNode<T>> remaining = new Heap<GraphNode<T>>(null, 0);
			for(int li=0;li<nodes.size();li++) {
				GraphNode<T> node = nodes.get(li);
				if(node.value == val) {
					remaining.addNodeToTree(node, 0);
				}else {
					remaining.addNodeToTree(node, 1000000);
				}
			}

			remaining.printHeap();
			GraphNode<T> node = remaining.extractTop();
			while(node != null) {
				List<GraphNode<T>> nodeChildrens = node.childrens;
				List<Integer> nodeChildrenWeights = node.weights;
				for(int li=0;li<nodeChildrens.size();li++) {
					GraphNode<T> nodeChildren = nodeChildrens.get(li);
					Integer nodeChildrenWeight = nodeChildrenWeights.get(li);
					Integer newWeight  = pathWeight.get(node.value)+nodeChildrenWeight;
					if(!pathWeight.containsKey(nodeChildren.value)) {
						pathWeight.put(nodeChildren.value, newWeight);
						previousNode.put(nodeChildren.value, node.value);
						remaining.adjustNodePriority(nodeChildren, newWeight);
					}else if(pathWeight.get(nodeChildren.value) > newWeight) {
						pathWeight.put(nodeChildren.value, newWeight);
						previousNode.put(nodeChildren.value, node.value);
						remaining.adjustNodePriority(nodeChildren, newWeight);
					}
				}
				node = remaining.extractTop();
			}
			if(pathWeight.containsKey(val2)) {
				pathTotalWeight=pathWeight.get(val2);
				T tempVal = val2;
				pathTraversal.add(tempVal);
				while(previousNode.containsKey(tempVal)) {
					tempVal = previousNode.get(tempVal);
					pathTraversal.add(tempVal);
				}
			}
		}
		return pathTotalWeight;
	}
}


