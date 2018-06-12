package ProblemRepresentation;

import java.util.ArrayList;

public class Task {
    public int id;
    Job job;
    public ArrayList<Integer>  costs;
    public Task(int machineNumber){
        costs = new ArrayList<Integer>();
        for(int i=0;i<machineNumber;i++)
            costs.add(Integer.MAX_VALUE);
    }
    public void addCost(int machine, int cost){
        costs.set(machine,cost);
    }
    public int getCost(int machine){
        return costs.get(machine);
    }
}
