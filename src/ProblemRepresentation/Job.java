package ProblemRepresentation;

import java.util.ArrayList;

public class Job {
    public int id;
    public ArrayList<Task> tasks;
    private int nbTask;

    public Job(int id) {
        this.id = id;
        tasks = new ArrayList<Task>();
        nbTask=0;
    }

    public void addTask(Task t) {
        nbTask++;
        t.job = this;
        t.id=nbTask;
        tasks.add(t);
    }
}
