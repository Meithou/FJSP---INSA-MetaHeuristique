package NeighbourGraphs;

import GraphSolution.Node;

import java.util.ArrayList;

public class LR {
    private ArrayList<Node> L;
    private ArrayList<Node> R;

    public ArrayList<Node> getL() {
        return L;
    }

    public ArrayList<Node> getR() {
        return R;
    }

    public LR (){
        L = new ArrayList<>();
        R = new ArrayList<>();
    }
    public void add_L(Node n){
        if(!L.contains(n))
            this.L.add(n);
    }

    public void add_R(Node n){
        if(!R.contains(n))
            this.R.add(n);
    }
}
