package NeighbourGraphs;

import GraphSolution.Arc;
import GraphSolution.Graph;
import GraphSolution.Node;

import java.util.ArrayList;

public class NeighbourGraph extends Graph {
    private ArrayList<NeighbourGraph> neighbours;
    public NeighbourGraph(){
        super();
        this.neighbours=new ArrayList<>();
    }
    public NeighbourGraph(Graph g)
    {
        for(Node n :g.getNodeList()) {
            Node tmp = new Node(n);
            for(Arc a:n.getSuccList()) {
                Node eq = findEquivalent(a.getNext());
                if( eq != null)
                tmp.addArc(eq, a.getType());
            }
        }
        this.neighbours=new ArrayList<>();
    }
    public Node findEquivalent(Node n){
        for(Node cn :this.getNodeList())
            if(cn.getID()==n.getID())
                return cn;
        return null;
    }
    public void addNeighbour (NeighbourGraph ng){
        neighbours.add(ng);
    }
    public NeighbourGraph deleteMArcs(Node n){
        NeighbourGraph new_g = new NeighbourGraph(this);
        // Set cost to 0, delete machine restrain
        Node new_n = new_g.findEquivalent(n);
        for(Arc a : new_n.getSuccList())
            if(a.getType()=='M')
                new_n.delArc(a.getNext()); // Deleting machine constrain after V
        for(Arc a : new_n.getPredList())
            if(a.getType()=='M')
                a.getNext().delArc(new_n); // Deleting machine constrain before V
        return new_g;
    }

    private void findL(LR res, Node n){
        Node tmp;
        for(Arc a : n.getPredList()) {
            tmp = a.getNext();
            res.add_L(tmp);
            findL(res,n);
        }
    }
    private void findR(LR res,Node n){
        Node tmp;
        for(Arc a : n.getSuccList()) {
            tmp = a.getNext();
            res.add_R(tmp);
            findR(res,n);
        }}
    private LR getLR(Node n){
        LR result = new LR();
        findL(result,n);
        findR(result,n);
        return result;
    }

    public ArrayList<NeighbourGraph> getNeighbour() {
        return neighbours;
    }
    public NeighbourGraph insertNodeBest(Node n, int machine, int newCost){
        return getBest(insertNode(n,getLR(n),machine,newCost));
    }
    private ArrayList<NeighbourGraph> insertNode(Node n, LR lr,int machine,int newCost){
        ArrayList<NeighbourGraph> neighbourList = new ArrayList<>();
        NeighbourGraph new_g = new NeighbourGraph(this);
        Arc todel = null;
        Node current = new_g.getStart();
        for(Arc a:current.getSuccList())
            if(a.getNext().getMachine()==machine)
                current=a.getNext();
        while(current!=null){
            if(!lr.getL().contains(current)) { // Move after L
                break;
            }
            for(Arc a:current.getSuccList()) { // Need to add case at the end of the list
                if (a.getType()=='M') {
                    current = a.getNext();
                    break;
                }
                else
                    current=null;
            }
        }
        while(current!=null){
            if (!lr.getR().contains(current)) { //
                for(Arc a:current.getSuccList()) {
                    if (a.getType() == 'M') {
                        Node nEq = new_g.findEquivalent(n);
                        for ( Arc aM: current.getSuccList()) {
                            if(aM.getType()=='M')
                                todel = aM;
                        }
                        if(todel!=null) {
                            nEq.addArc(todel.getNext(),'M');
                            nEq.setCost(newCost);
                            nEq.setMachine(machine);
                            current.addArc(nEq, 'M');// inserting the node after the current
                            current.delArc(todel.getNext()); // Updating machine constrain
                        }
                        current = a.getNext(); // Moving to next node
                        neighbourList.add(new_g); // Store the current insertion in the solution list
                        new_g = new NeighbourGraph(this); // Create another graph without the insertion
                        current = new_g.findEquivalent(current); // Moving back to the same place in the new graph
                        break;
                    }
                }
            }
            else break; // R reached
        }
        return neighbourList;
    }
    private NeighbourGraph getBest(ArrayList<NeighbourGraph> list){
        NeighbourGraph sol = null;
        int score= Integer.MAX_VALUE;
        int scoreC;

        for(NeighbourGraph ng : list) {
            scoreC = ng.evaluateCost(); // Possible update on evaluation score
            if (scoreC < score)
                sol = ng;
        }
        return sol;
    }
}
