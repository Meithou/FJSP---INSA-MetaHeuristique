package ProblemRepresentation;

import java.io.*;
import java.util.ArrayList;

public class Problem {
    public ArrayList<Machine> machines;
    public ArrayList<Job> jobs;
    private int nbMachines;
    private int nbJobs;
    public Problem()
    {
        this.machines = new ArrayList<>();
        this.jobs = new ArrayList<>();
        nbMachines =0;
        nbJobs = 0;
    }
    public Problem(String path){
        this.jobs = new ArrayList<Job>();
        this.machines = new ArrayList<Machine>();

        //Partie lecture de fichier
        File filename = new File(path);
        String current = null;
        try {
            current = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            line = line.trim().replaceAll(" +", " ");
            line = line.trim().replaceAll("\t+", " ");

            String[] ligneJob = line.split(" ");
            int nb_job = Integer.parseInt(ligneJob[0]);
            //Initialisation des machines
            int nb_machine = Integer.parseInt(ligneJob[1]);
            addMachine(nb_machine);

            // Lecture du fichier
            int i = 0;
            for (i = 0; i < nb_job; i++) {
                //A chaque ligne il y a création d'un Job
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Creation du i eme Job
                line = line.trim().replaceAll(" +", " ");
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMachine(int nb){
        for(int i=0;i<nb;i++) {
            nbMachines++;
            machines.add(new Machine(nbMachines));
        }
    }
    public void addJob(int nb){
        for(int i=0;i<nb;i++) {
            nbJobs++;
            jobs.add(new Job(nbJobs));
        }
    }
    public void addTask(int jobid,Task t){
        jobs.get(jobid).addTask(t);
    }
    public Machine getLowestCost(){
        Machine lowest=machines.get(0);
        for(Machine m : machines){
            if(m.currentCost<lowest.currentCost)
                lowest = m;
        }
        return lowest;
    }
}
