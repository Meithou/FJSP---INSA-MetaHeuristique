package GraphSolution;

import java.util.ArrayList;

public class Path {
    private ArrayList<Node> path;
    private int cost;

    public Path(){
        this.cost=0;
        this.path = new ArrayList<>();
    }

    public void addNode(Node n){
        path.add(n);
        cost+=n.getCost();
    }

    public ArrayList<Node> getPath() {return path;}
    public int getCost(){return cost;}
}
