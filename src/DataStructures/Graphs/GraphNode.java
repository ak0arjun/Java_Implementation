package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Node used for graph creation
 * @author root
 *
 * @param <T>
 */
public class GraphNode<T> {

	T value;
	boolean isVisited;
	
	/**
	 * weight for each children path
	 */
	List<Integer> weights;

	/**
	 * Adjacency children list
	 */
	List<GraphNode<T>> childrens;

	public GraphNode() {
		isVisited = false;
		value = null;
		weights =new ArrayList<Integer>();
		childrens = new ArrayList<GraphNode<T>>();
	}

	/**
	 * Add the given nodes to connected node list
	 * @param newNode
	 */
	public void addChildren(GraphNode<T> newNode, Integer weight) {
		if(newNode!=null) {
			childrens.add(newNode);
			weights.add(weight);
		}
	}
}
