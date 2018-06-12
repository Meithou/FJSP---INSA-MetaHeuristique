package Heuristic;

import GraphSolution.Arc;
import GraphSolution.Node;
import NeighbourGraphs.NeighbourGraph;
import ProblemRepresentation.Job;
import ProblemRepresentation.Machine;
import ProblemRepresentation.Problem;
import ProblemRepresentation.Task;

import java.util.ArrayList;

public abstract class HeuristicAlgorithms {
    public static NeighbourGraph getLowestIncreaseeAlgo(Problem pb){ // We insert the node that increase the least the makespan of the machine with the lowest makespan
        NeighbourGraph new_g = new NeighbourGraph();
        ArrayList<Node> toPlace = new ArrayList<>();
        Node last = new_g.getStart();
        for(Machine m : pb.machines)
            m.lastNode=new_g.getStart();
        for(Job j : pb.jobs ){
           for(Task t : j.tasks){
               Node new_n = new Node(j.id,t.id,0,0);
               last.addArc(new_n,'T'); // Adding all the task related arcs;
               new_g.addNode(new_n);
               last = new_n;
           }
           last.addArc(new_g.getEnd(),'T'); // adding link to the end
           last = new_g.getStart();
        }
        for(Arc a: last.getSuccList()) { // it should be the starting node
            toPlace.add(a.getNext());
        }
        while(!toPlace.isEmpty())
        {
            int nodeCost=0;
            int lowestCost=Integer.MAX_VALUE;
            Node currentW=null;
            Machine m = pb.getLowestCost();
            for(Node n :toPlace){
                nodeCost = pb.jobs.get(n.job).tasks.get(n.task).getCost(m.id);
                int taskCost = nodeCost+new_g.evaluatePath(new_g.getStart(),n).getCost();
                int machineCost = nodeCost+m.currentCost;
                int cost = taskCost>machineCost?taskCost:machineCost;
                if(cost<lowestCost)
                    currentW=n;
            }
            if(currentW==null) // Should never happen
                break;
            for(Arc a : currentW.getSuccList())
                if(!a.getNext().equals(new_g.getEnd()))
                    toPlace.add(a.getNext());// Adding the next task from the job
            currentW.setCost(nodeCost);
            currentW.setMachine(m.id);
            m.lastNode.addArc(currentW,'M'); // Adding the arc from the previous task in the machine m to the new inserted node.
            m.currentCost+=nodeCost;
        }
        return new_g;
    }
}
