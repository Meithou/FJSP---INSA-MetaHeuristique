package GraphSolution;
import java.util.ArrayList;

public class Graph {
	ArrayList<Node> nodeList;
	
	public Graph() {
		Node start = new Node(0,0,0);
		Node end = new Node(0,0,0);
		nodeList = new ArrayList<Node>();
		nodeList.add(start); // start is 0
		nodeList.add(end); // end is 1
	}
	
	public Node getStart() {
		return nodeList.get(0);
	}
	public Node getEnd() {
		return nodeList.get(1);
	}
	public void addNode(Node node) {
		nodeList.add(node);
	}
	
	private int evaluatePath(Node start,Node end) { // add marking array to handle loops
		int result = 0;
		int val;
		
		if(start.equals(end))
			return 0;
		for (Arc arc : start.getSucc()) {
			val = evaluatePath( arc.getNext(),end)+arc.getCost();
			result = (result > val) ? result : val;
		}
		return result;
	}
	
	public int evaluateCost() {
		int result;
		
		result = evaluatePath(nodeList.get(0),nodeList.get(1));
		return result;
	}
}
