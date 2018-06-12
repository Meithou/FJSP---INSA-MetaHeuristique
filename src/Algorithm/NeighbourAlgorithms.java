package Algorithm;

import NeighbourGraphs.NeighbourGraph;
import GraphSolution.Node;
import ProblemRepresentation.Machine;
import ProblemRepresentation.Problem;

public abstract class NeighbourAlgorithms {
    public static void neighbourf1(NeighbourGraph g, Problem prob){
        NeighbourGraph tmp,toIns;
        for (Node n : g.getCriticalPath().getPath()){
                if(n.getCost()==0)
                    continue;
                tmp = g.deleteMArcs(n);
            for(Machine m : prob.machines){
                int k = m.getId();
                if(k!=n.getMachine()){  // Same machine not wanted ?
                    toIns=tmp.insertNodeBest(tmp.findEquivalent(n),k,prob.jobs.get(n.job).tasks.get(n.task).getCost(k));
                    if(toIns!=null) {
                        toIns.evaluateCost();
                        g.addNeighbour(toIns); // Need to get the new cost from the new machine
                    }
                }
            }
        }
    }
}