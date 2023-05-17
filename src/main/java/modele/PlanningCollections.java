package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;


public class PlanningCollections implements Serializable {
    private ArrayList <Reservation> chReserv;
    private TreeSet <Reservation> chTrReserv;
    private Map <Integer, Set <Reservation>> chSemRes;

    public PlanningCollections() {
        chReserv = new ArrayList <Reservation> ();
        chTrReserv = new TreeSet <Reservation> ();
        chSemRes = new TreeMap <>();
    }

    public PlanningCollections(ArrayList<Reservation> parReserv,TreeSet<Reservation> parTrReserv){
        chReserv = parReserv;
        chTrReserv = parTrReserv;
        chSemRes = new TreeMap<>();
    }

    public String toString() {
        String strTab = new String();
        strTab += chReserv.size() + "\n";
        strTab += chReserv.toString() + "\n";
        strTab += chTrReserv.size() + "\n";
        strTab += chTrReserv.toString() + "\n";
        strTab += chSemRes.size() + "\n";
        strTab += chSemRes;
        return strTab;
    }

    /**
     * Vérifie si la fonction en paramètre est valide puis si elle ne chevauche pas une autre est insérée
     *
     * @param parRes
     */
    public void ajout(Reservation parRes) throws ExceptionPlanning {
        if (!parRes.estValide())
            throw new ExceptionPlanning(0);
        Iterator <Reservation> itr = chReserv.iterator();
        while (itr.hasNext()){
            if (itr.next().compareTo(parRes) == 0)
                throw new ExceptionPlanning(2);
        }
        chReserv.add(parRes);
        chTrReserv.add(parRes);

        DateCalendrier tempDate = new DateCalendrier(parRes.getChDate().chJour, parRes.getChDate().chMois, parRes.getChDate().chAnnee);
        int numSem = tempDate.getWeekOfYear();
        Set <Reservation> set = chSemRes.get(numSem);

        if (set  == null) {
            set = new TreeSet<>();
            set.add(parRes);
            chSemRes.put(numSem, set);
        }
        else {
            set.add(parRes);
        }

    }

    /**
     * Parcours le TreeSet de this, quand une reservation correspondant à la date en paramètre est trouvée,
     * elle est ajoutée à un nouveau TreeSet qui est renvoyé à la fin
     *
     * @param parDate
     * @return
     */
    public TreeSet <Reservation> getReservations(DateCalendrier parDate) {
        TreeSet <Reservation> result = new TreeSet <Reservation>();
        Iterator <Reservation> itr = chTrReserv.iterator();
        while (itr.hasNext()){
            Reservation tempRes = itr.next();
            if (tempRes.getChDate().compareTo(parDate) == 0)
                result.add(tempRes);
        }
        if (result.isEmpty())
            return null;
        return result;
    }

    /**
     * Parcours le TreeSet de this, quand une reservation correspondant au libellé en paramètre est trouvée,
     * elle est ajoutée à un nouveau TreeSet qui est renvoyé à la fin
     *
     * @param parString
     * @return
     */
    public TreeSet <Reservation> getReservations(String parString) {
        TreeSet <Reservation> result = new TreeSet <Reservation>();
        Iterator <Reservation> itr = chTrReserv.iterator();
        while (itr.hasNext()){
            Reservation tempRes = itr.next();
            if (tempRes.getChIntitule().contains(parString))
                result.add(tempRes);
        }
        if (result.isEmpty())
            return null;
        return result;
    }

    public Set <Reservation> getSemReservations(int parSemaine) {
        return chSemRes.get(parSemaine);
    }

}