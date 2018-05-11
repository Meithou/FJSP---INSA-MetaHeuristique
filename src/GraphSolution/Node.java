package GraphSolution;
import java.util.ArrayList;

public class Node {
	private int machine;
	private int job;
	private int task;
	private int time_start;
	ArrayList<Arc> SuccList;
	ArrayList<Arc> PredList;
	
	public int getTime() {return time_start;}
	public void setTime(int time_start) {this.time_start=time_start;}
	public ArrayList<Arc> getSucc(){
		return SuccList;
	}
	public Node(int job,int task,int machine) {
		this.machine = machine;
		this.task = task;
		this.job = job;
		SuccList = new ArrayList<Arc>();
		PredList = new ArrayList<Arc>();
	}
	
	public void addArc(int cost, Node next,char type) {
		Arc e = new Arc(cost,next,type);
		SuccList.add(e);
		next.addPred(cost, this, type);
	}
	private void addPred(int cost, Node before,char type) {
		Arc e = new Arc(cost,before,type);
		PredList.add(e);
	}
}