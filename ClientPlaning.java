import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ClientPlaning implements ConstantesErreur{
    public static void main(String [] args){
        Planning planingSalleSport = new Planning(1);
        try{
            ArrayList<Reservation> array = new ArrayList<Reservation>();
            TreeSet<Reservation> tree = new TreeSet<Reservation>();
            Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt")).useDelimiter(",");
            while(scanner.hasNext()){
                String intitule = scanner.next();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();
                int h1 = scanner.nextInt();
                int m1 = scanner.nextInt();
                int h2 = scanner.nextInt();
                int m2 = scanner.nextInt();
                Reservation res = new Reservation(new Date(jour, mois, annee), new PlageHoraire(new Horaire(h1,m1), new Horaire(h2,m2)),intitule);
                array.add(res);
                tree.add(res);
            }
            PlanningCollections collec = new PlanningCollections(array,tree);
            System.out.println(collec.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("4-"+e.getMessage());
        }
        catch (ExceptionPlanning e){
            System.out.println("code :"+e.getCodeErreur());
            System.out.println(ERREURS_PLANNING[e.getCodeErreur()]);
        }
    }
}


