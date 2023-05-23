package modele;

import java.io.Serializable;
import java.util.TreeSet;
import java.util.Collection;

/**
 * Classe CalendrierDuMois qui permet de créer un calendrier du mois en prenant en compte les jours de la semaine
 */
public class CalendrierDuMois implements Serializable {

    private int mois;
    private int annee;
    private Collection <DateCalendrier> treeSetDate;

    /**
     * Constructeur de la classe CalendrierDuMois
     * @param mois
     * @param annee
     */
    public CalendrierDuMois ( int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet <DateCalendrier> ();
        DateCalendrier date = new DateCalendrier (1,mois,annee);
        int indiceJour = date.getJourSemaine() ;
        for (int x = indiceJour ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.dateDeLaVeille();
        }
        date = new DateCalendrier (2,mois,annee);
        indiceJour = indiceJour % 7 ;
        while (date.getMois () == mois) {
            while(indiceJour<7) {
                treeSetDate.add(date);
                date = date.dateDuLendemain();
                indiceJour++ ;
            }
            indiceJour=0;
        }
    }

    /**
     * Getter des dates du mois sous forme de TreeSet
     * @return Collection <DateCalendrier> : les dates du mois sous forme de TreeSet
     */
    public Collection <DateCalendrier> getDates() {
        return treeSetDate;
    }

    /**
     * Donne le treeSetDate sous forme de String avec sa taille
     * @return String : le treeSetDate sous forme de String
     */
    public String toString () {
        return treeSetDate.size() + " " +treeSetDate.toString();
    }

    /**
     * Getter du mois de l'année
     * @return int : le mois de l'année
     */
    public int getMois () {
        return mois;
    }

    /**
     * Getter de l'année
     * @return int : l'année
     */
    public int getAnnee() {
        return annee;
    }

}