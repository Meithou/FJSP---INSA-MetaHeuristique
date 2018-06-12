package ProblemRepresentation;

import GraphSolution.Node;

public class Machine {
    public int id;
    public int currentCost;
    public Node lastNode;
    public Machine(int id){this.id=id;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
