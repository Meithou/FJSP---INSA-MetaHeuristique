package Algorithm;

import GraphSolution.*;
import NeighbourGraphs.NeighbourGraph;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int sol;
		Graph g = new Graph();
		
		Node n1_1 = new Node(1,1,3,15);
		Node n1_2 = new Node(1,2,1,5);
		Node n2_1 = new Node(2,1,4,4);
		Node n2_2 = new Node(2,2,5,8);
		Node n2_3 = new Node(2,3,2,12);
		Node n3_1 = new Node(3,1,4,6);
		Node n3_2 = new Node(3,2,5,10);
		Node n3_3 = new Node(3,3,1,7);
		Node n4_1 = new Node(4,1,2,3);
		Node n4_2 = new Node(4,2,5,6);
		Node n4_3 = new Node(4,3,5,5);
		Node n4_4 = new Node(4,4,3,4);
		
		Node start = g.getStart();
		Node end = g.getEnd();
		
		start.addArc( n1_1,'T');
		start.addArc( n2_1,'T');
		start.addArc( n3_1,'T');
		start.addArc( n4_1,'T');
		
		n1_1.addArc( n1_2,'T');
		n1_1.addArc( n4_4,'M');
		
		n2_1.addArc( n2_2,'T');
		n2_1.addArc( n3_1,'M');
		
		n3_1.addArc( n3_2,'T');
		
		n4_1.addArc( n4_2,'T');
		n4_1.addArc( n2_3,'M');
		
		n1_2.addArc( end, 'T');
		
		n2_2.addArc( n2_3, 'T');
		n2_2.addArc( n3_2, 'M');
		
		n3_2.addArc( n3_3, 'T');
		n3_2.addArc( n4_2, 'M');
		
		n4_2.addArc( n4_3, 'T');
		
		n2_3.addArc( end, 'T');
		n3_3.addArc( end, 'T');
		
		n4_3.addArc( n4_4, 'T');
		n4_4.addArc( end, 'T');
		
		g.addNode(n1_1);
		g.addNode(n1_2);
		g.addNode(n2_1);
		g.addNode(n2_2);
		g.addNode(n2_3);
		g.addNode(n3_1);
		g.addNode(n3_2);
		g.addNode(n3_3);
		g.addNode(n4_1);
		g.addNode(n4_2);
		g.addNode(n4_3);
		g.addNode(n4_4);
		
		sol = g.evaluateCost();
		NeighbourGraph ng = new NeighbourGraph(g);
		System.out.printf("Cout de la solution:  %d \n",sol);
		sol = ng.evaluateCost();
		System.out.printf("Cout de la solution:  %d \n",sol);
        ArrayList<Integer> machines = new ArrayList<Integer>();
        machines.add(new Integer(1));
        machines.add(new Integer(2));
        machines.add(new Integer(3));
        machines.add(new Integer(4));
        NeighbourAlgorithms.neighbourf1(ng,machines);
        System.out.printf("job Done");
	}
}
