package GraphSolution;

public class Arc {
	private Node next;
	private char restraintype; // Machinebound or Taskbound
	public Arc(Node next,char type) {
		this.next=next;
		this.restraintype = type;
	}
	public Node getNext() {
		return next;
	}
	public char getType(){return restraintype;}

}
