package GraphSolution;
import java.util.ArrayList;

public class Node {
	private int machine;
	private int job;
	private int task;
	private int time_start;
	private int cost;
	private ArrayList<Arc> SuccList;
	private ArrayList<Arc> PredList;


	public int getCost(){return cost;}
	public void setCost(int cost){this.cost = cost;}
	public int getTime() {return time_start;}
	public void setTime(int time_start) {this.time_start=time_start;}
	public ArrayList<Arc> getSuccList(){
		return SuccList;
	}

	public ArrayList<Arc> getPredList() {
		return PredList;
	}

	public Node(int job, int task, int machine, int cost) {
		this.machine = machine;
		this.task = task;
		this.job = job;
		this.cost = cost;
		SuccList = new ArrayList<Arc>();
		PredList = new ArrayList<Arc>();
	}
	public String getID(){
		return "ID"+this.machine+this.job+this.task;
	}
	public Node(Node n){
		this.machine = n.machine;
		this.task = n.task;
		this.job = n.job;
		this.cost = n.cost;
		this.SuccList = new ArrayList<Arc>();
		this.PredList = new ArrayList<Arc>();
	}
	public void addArc( Node next,char type) {
		Arc e = new Arc(next,type);
		SuccList.add(e);
		next.addPred(this, type);
	}
	public void delArc(Node next){
		SuccList.remove(next); // Deleting from succlist
		if(next!=null)
		next.PredList.remove(this); // Deleting from predlist
	}
	private void addPred( Node before,char type) {
		Arc e = new Arc(before,type);
		PredList.add(e);
	}
	public String toString(){
		if(this.machine==-1)
			return "Node:Start";
		if(this.machine==-2)
			return "Node:End";
		return "Node: M"+this.machine+"J"+this.job+"T"+this.task+"C"+this.cost;
	}
}