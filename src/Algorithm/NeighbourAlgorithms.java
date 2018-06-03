package Algorithm;

import NeighbourGraphs.NeighbourGraph;
import GraphSolution.Node;

import java.util.ArrayList;

public abstract class NeighbourAlgorithms {
    public static void neighbourf1(NeighbourGraph g, ArrayList<Integer> machines){
        NeighbourGraph tmp,toIns;
        for (Node n : g.getCriticalPath().getPath()){
                if(n.getCost()==0)
                    continue;
                tmp = g.deleteMArcs(n);
            for(Integer k : machines){
                if(k!=n.getMachine()){  // Same machine not handled
                    toIns=tmp.insertNodeBest(tmp.findEquivalent(n),k,n.getCost()); // need to update cost depending on machine
                    if(toIns!=null) {
                        toIns.evaluateCost();
                        g.addNeighbour(toIns); // Need to get the new cost from the new machine
                    }
                }
            }
        }
    }
}
