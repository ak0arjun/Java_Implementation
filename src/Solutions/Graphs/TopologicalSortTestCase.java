package Solutions.Graphs;

import java.util.ArrayList;
import java.util.List;

import DataStructures.Graphs.Graph;

public class TopologicalSortTestCase {

	public TopologicalSortTestCase() {

	}


	protected void testCase1() {
		Graph<String> graph = new Graph<String>(true);

		List<String> aChildren = new ArrayList<String>();
		aChildren.add("d");
		graph.addNode("a", aChildren, null);

		graph.addNode("e", null, null);
		
		List<String> fChildren = new ArrayList<String>();
		fChildren.add("a");
		fChildren.add("b");
		graph.addNode("f", fChildren, null);
		
		List<String> bChildren = new ArrayList<String>();
		bChildren.add("d");
		graph.addNode("b", bChildren, null);

		List<String> dChildren = new ArrayList<String>();
		dChildren.add("c");
		graph.addNode("d", dChildren, null);

		graph.addNode("c", null, null);

		System.out.println("Top sort:"+ graph.topologicalSort());
	}

	public void run() {
		testCase1();
	}
}
