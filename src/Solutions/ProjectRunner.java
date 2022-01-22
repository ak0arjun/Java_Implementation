package Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructures.Graphs.Graph;

public class ProjectRunner {

	public static void main(String[] args) {
		Graph<String> graph = new Graph<String>(true);
		
		List<String> aChildren = new ArrayList<String>();
		aChildren.add("b");
		aChildren.add("c");
		aChildren.add("e");
		List<Integer> aChildrenWeights = new ArrayList<Integer>();
		aChildrenWeights.add(5);
		aChildrenWeights.add(3);
		aChildrenWeights.add(2);
		graph.addNode("a",aChildren , aChildrenWeights);
		
		List<String> bChildren = new ArrayList<String>();
		List<Integer> bChildrenWeights = new ArrayList<Integer>();
		bChildren.add("d");
		bChildrenWeights.add(2);
		graph.addNode("b",bChildren , bChildrenWeights);
		
		List<String> cChildren = new ArrayList<String>();
		List<Integer> cChildrenWeights = new ArrayList<Integer>();
		cChildren.add("b");
		cChildrenWeights.add(1);
		cChildren.add("d");
		cChildrenWeights.add(1);
		graph.addNode("c",cChildren , cChildrenWeights);
		
		List<String> dChildren = new ArrayList<String>();
		List<Integer> dChildrenWeights = new ArrayList<Integer>();
		dChildren.add("a");
		dChildrenWeights.add(1);
		dChildren.add("h");
		dChildrenWeights.add(1);
		dChildren.add("g");
		dChildrenWeights.add(2);
		graph.addNode("d",dChildren , dChildrenWeights);
		
		List<String> eChildren = new ArrayList<String>();
		List<Integer> eChildrenWeights = new ArrayList<Integer>();
		eChildren.add("a");
		eChildrenWeights.add(1);
		eChildren.add("h");
		eChildrenWeights.add(4);
		eChildren.add("i");
		eChildrenWeights.add(7);
		graph.addNode("e",eChildren , eChildrenWeights);
		
		List<String> fChildren = new ArrayList<String>();
		List<Integer> fChildrenWeights = new ArrayList<Integer>();
		fChildren.add("b");
		fChildrenWeights.add(3);
		fChildren.add("g");
		fChildrenWeights.add(1);
		graph.addNode("f",fChildren , fChildrenWeights);
		
		List<String> gChildren = new ArrayList<String>();
		List<Integer> gChildrenWeights = new ArrayList<Integer>();
		gChildren.add("c");
		gChildrenWeights.add(3);
		gChildren.add("i");
		gChildrenWeights.add(2);
		graph.addNode("g",gChildren , gChildrenWeights);
		
		List<String> hChildren = new ArrayList<String>();
		List<Integer> hChildrenWeights = new ArrayList<Integer>();
		hChildren.add("c");
		hChildrenWeights.add(2);
		hChildren.add("g");
		hChildrenWeights.add(2);
		hChildren.add("f");
		hChildrenWeights.add(2);
		graph.addNode("h",hChildren , hChildrenWeights);
		
		graph.addNode("i",null , null);
		
		graph.traverseGraph(0);
		
		 ArrayList<String> topSort = graph.topologicalSort();
		 System.out.println("TopSort:"+topSort);
		 
		 ArrayList<String> path = new ArrayList<String>();
		Integer pathCost = graph.findShortestPath("a", "i", path);
		
		 System.out.println("pathCost:"+pathCost);
		 System.out.println("path:"+path);
	}

}
