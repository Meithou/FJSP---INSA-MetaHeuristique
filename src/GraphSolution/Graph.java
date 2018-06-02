package GraphSolution;
import java.util.ArrayList;

public class Graph {
	ArrayList<Node> nodeList;
	Path criticalPath;
	public Graph() {
		Node start = new Node(0,0,0,0);
		Node end = new Node(0,0,0,0);
		nodeList = new ArrayList<>();
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
	
	private Path evaluatePath(Node current,Node end) { // add marking array to handle loops
		Path currentPath;
		Path chosenPath=null;
		if(current.equals(end)) {
			chosenPath = new Path();
			chosenPath.addNode(current);
			return chosenPath;
		}
		for (Arc arc : current.getSucc()) {
			currentPath = evaluatePath( arc.getNext(),end);
			chosenPath = (chosenPath == null?currentPath : (chosenPath.getCost() > currentPath.getCost()) ? chosenPath : currentPath); // Choose between the different successors
		}
		return chosenPath;
	}
	
	public int evaluateCost() {
		criticalPath = evaluatePath(nodeList.get(0),nodeList.get(1));
		return criticalPath.getCost();
	}
}
