package GraphSolution;

public class Arc {
	private int cost;
	private Node next;
	private char restraintype; // Timebound or Taskbound
	public Arc(int cost,Node next,char type) {
		this.cost = cost;
		this.next=next;
		this.restraintype = type;
	}
	public Node getNext() {
		return next;
	}

	public int getCost() {
		return cost;
	}

}
