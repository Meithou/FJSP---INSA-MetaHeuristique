package GraphSolution;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LR {
    private ArrayList<Node> L;
    private ArrayList<Node> R;

    public LR (){
        L = new ArrayList<>();
        R = new ArrayList<>();
    }
    public void add_L(Node n){
        this.L.add(n);
    }

    public void add_R(Node n){
        this.R.add(n);
    }
}
