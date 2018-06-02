package GraphSolution;
import java.util.ArrayList;

public class Node {
	private int machine;
	private int job;
	private int task;
	private int time_start;
	private int cost;
	ArrayList<Arc> SuccList;
	ArrayList<Arc> PredList;


	public int getCost(){return cost;}
	public int getTime() {return time_start;}
	public void setTime(int time_start) {this.time_start=time_start;}
	public ArrayList<Arc> getSucc(){
		return SuccList;
	}
	public Node(int job,int task,int machine,int cost) {
		this.machine = machine;
		this.task = task;
		this.job = job;
		this.cost = cost;
		SuccList = new ArrayList<Arc>();
		PredList = new ArrayList<Arc>();
	}
	public void addArc( Node next,char type) {
		Arc e = new Arc(next,type);
		SuccList.add(e);
		next.addPred(this, type);
	}
	private void addPred( Node before,char type) {
		Arc e = new Arc(before,type);
		PredList.add(e);
	}
}