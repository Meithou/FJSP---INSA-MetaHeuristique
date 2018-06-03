package GraphSolution;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    protected ArrayList<Node> nodeList;
    private Path criticalPath;

    public Graph() {
        Node start = new Node(0, 0, -1, 0);
        Node end = new Node(-1, -1, -2, 0);
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
    public Path getCriticalPath(){return this.criticalPath;}
    public void addNode(Node node) {
        nodeList.add(node);
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    protected Path evaluatePath(Node current, Node end) { // add marking array to handle loops
        Path currentPath;
        Path chosenPath = null;
        if (current.equals(end)) {
            chosenPath = new Path();
            chosenPath.addNode(current);
            return chosenPath;
        }
            for (Arc arc : current.getSuccList()) {
            currentPath = evaluatePath(arc.getNext(), end);
            if(currentPath==null)
                continue; // Path not found
            chosenPath = (chosenPath == null ? currentPath : (chosenPath.getCost() > currentPath.getCost()) ? chosenPath : currentPath); // Choose between the different successors
        }
        if(chosenPath!=null)
            chosenPath.addNode(current);
        return chosenPath;
    }

    public int evaluateCost() {
        Path tmp = evaluatePath(nodeList.get(0), nodeList.get(1));
        Collections.reverse(tmp.getPath());
        criticalPath = tmp;
        System.out.println(criticalPath.getPath());
        return criticalPath.getCost();
    }
}
