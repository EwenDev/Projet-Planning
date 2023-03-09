import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList<Reservation> chList;
    private TreeSet<Reservation> chTree;

    public PlanningCollections(ArrayList<Reservation> parList,TreeSet<Reservation> parTree){
        chList = parList;
        chTree = parTree;
    }

    public String toString(){
        return chList.size() + chList.toString() + chTree.size() + chTree.toString();
    }
}
