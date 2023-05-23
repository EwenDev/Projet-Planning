package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

/**
 * Classe PlanningCollections qui permet de créer une collection de réservations et de les gérer
 */
public class PlanningCollections implements Serializable {
    private ArrayList <Reservation> chReserv;
    private TreeSet <Reservation> chTrReserv;
    private Map <Integer, Set <Reservation>> chSemRes;

    /**
     * Constructeur de la classe PlanningCollections
     */
    public PlanningCollections() {
        chReserv = new ArrayList <Reservation> ();
        chTrReserv = new TreeSet <Reservation> ();
        chSemRes = new TreeMap <>();
    }

    /**
     * Constructeur de la classe PlanningCollections
     * @param parReserv : ArrayList de réservations
     * @param parTrReserv : TreeSet de réservations
     */
    public PlanningCollections(ArrayList<Reservation> parReserv,TreeSet<Reservation> parTrReserv){
        chReserv = parReserv;
        chTrReserv = parTrReserv;
        chSemRes = new TreeMap<>();
    }

    /**
     * Retourne les champs de la classe sous forme de String
     * @return String : les champs de la classe sous forme de String avec leur taille
     */
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
     * Ajoute une réservation à la collection de réservations si elle est valide et si elle n'existe pas déjà
     * @param parRes : la réservation à ajouter
     * @throws ExceptionPlanning : si la réservation n'est pas valide ou si elle existe déjà
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
     * @param parDate : la date à laquelle on veut récupérer les réservations
     * @return TreeSet <Reservation> : les réservations à la date en paramètre
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
     * @param parString : le libellé à laquelle on veut récupérer les réservations
     * @return TreeSet <Reservation> : les réservations au libellé en paramètre
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

    /**
     * Retourne les réservations de la semaine en paramètre
     * @param parSemaine : la semaine dont on veut récupérer les réservations
     * @return Set <Reservation> : les réservations de la semaine en paramètre
     */
    public Set <Reservation> getSemReservations(int parSemaine) {
        return chSemRes.get(parSemaine);
    }

}