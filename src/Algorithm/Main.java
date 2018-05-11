package Algorithm;

import GraphSolution.*;

public class Main {
	public static void main(String[] args) {
		int sol;
		Graph g = new Graph();
		
		Node n1_1 = new Node(1,1,3);
		Node n1_2 = new Node(1,2,1);
		Node n2_1 = new Node(2,1,4);
		Node n2_2 = new Node(2,2,5);
		Node n2_3 = new Node(2,3,2);
		Node n3_1 = new Node(3,1,4);
		Node n3_2 = new Node(3,2,5);
		Node n3_3 = new Node(3,3,1);
		Node n4_1 = new Node(4,1,2);
		Node n4_2 = new Node(4,2,5);
		Node n4_3 = new Node(4,3,5);
		Node n4_4 = new Node(4,4,3);
		
		Node start = g.getStart();
		Node end = g.getEnd();
		
		start.addArc(0, n1_1,'T');
		start.addArc(0, n2_1,'T');
		start.addArc(4, n3_1,'T');
		start.addArc(0, n4_1,'T');
		
		n1_1.addArc(15, n1_2,'T');
		n1_1.addArc(15, n4_4,'M');
		
		n2_1.addArc(4, n2_2,'T');
		n2_1.addArc(4, n3_1,'M');
		
		n3_1.addArc(6, n3_2,'T');
		
		n4_1.addArc(3, n4_2,'T');
		n4_1.addArc(3, n2_3,'M');
		
		n1_2.addArc(5, end, 'T');
		
		n2_2.addArc(8, n2_3, 'T');
		n2_2.addArc(8, n3_2, 'M');
		
		n3_2.addArc(10, n3_3, 'T');
		n3_2.addArc(10, n4_2, 'M');
		
		n4_2.addArc(6, n4_3, 'T');
		
		n2_3.addArc(12, end, 'T');
		n3_3.addArc(7, end, 'T');
		
		n4_3.addArc(5, n4_4, 'T');
		n4_4.addArc(4, end, 'T');
		
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
		System.out.printf("Cout de la solution:  %d \n",sol);
	}
}
