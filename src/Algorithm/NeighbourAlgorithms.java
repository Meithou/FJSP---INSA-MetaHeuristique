package Algorithm;

import NeighbourGraphs.NeighbourGraph;
import GraphSolution.Node;

import java.util.ArrayList;

public abstract class NeighbourAlgorithms {
    public static void neighbourf1(NeighbourGraph g, ArrayList<Integer> machines){
        NeighbourGraph tmp;
        for (Node n : g.getCriticalPath().getPath()){
                tmp = g.deleteMArcs(n);
            for(Integer k : machines){
                if(k!=n.getMachine())  // Same machine not handled
                    g.addNeighbour(tmp.insertNodeBest(n,k,10)); // Need to get the new cost from the new machine
            }
        }
    }
}
