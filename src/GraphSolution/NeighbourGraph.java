package GraphSolution;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NeighbourGraph extends Graph {
    private ArrayList<NeighbourGraph> neighbour;
    public NeighbourGraph(){
        super();
        this.neighbour=new ArrayList<>();
    }
    public NeighbourGraph(Graph g)
    {
        for(Node n :g.nodeList) {
            Node tmp = new Node(n);
            for(Arc a:n.getSuccList()) {
                Node eq = findEquivalent(a.getNext());
                if( eq != null)
                tmp.addArc(eq, a.getType());
            }
        }
        this.neighbour=new ArrayList<>();
    }
    public Node findEquivalent(Node n){
        for(Node cn :this.nodeList)
            if(cn.getID()==n.getID())
                return cn;
        return null;
    }
    public NeighbourGraph deleteNode(Node n){
        NeighbourGraph new_g = new NeighbourGraph(this);
        // Set cost to 0, delete machine restrain
        Node new_n = new_g.findEquivalent(n);
        new_n.setCost(0);
        for(Arc a : new_n.getSuccList())
            if(a.getType()=='M')
                new_n.delArc(a.getNext()); // Deleting machine restrain after V / Should delete 1
        for(Arc a : new_n.getPredList())
            if(a.getType()=='M')
                a.getNext().delArc(new_n); // Deleting machine restrain before V
        return new_g;
    }

    public void findL(LR res,Node n){
        Node tmp;
        for(Arc a : n.getPredList()) {
            tmp = a.getNext();
            res.add_L(tmp);
            findL(res,n);
        }
    }
    public void findR(LR res,Node n){
        Node tmp;
        for(Arc a : n.getSuccList()) {
            tmp = a.getNext();
            res.add_R(tmp);
            findR(res,n);
        }}
    public LR getLR(Node n){
        LR result = new LR();
        findL(result,n);
        findR(result,n);
        return result;
    }
}
