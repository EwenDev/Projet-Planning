package modele;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe DateCalendrier
 * Hérite de la classe Date
 * Ajoute un attribut chJourSemaine
 * Permet de créer une date avec le jour de la semaine qui est comparable avec les autres dates de la classe
 */
public class DateCalendrier extends Date implements Comparable <Date> ,ConstanteCalendrier, Serializable {

    private int chJourSemaine ;

    /**
     * Constructeur de la classe DateCalendrier
     * Initialise la date à la date du jour
     */
    public DateCalendrier ()   {
        // GregorianCalendar dateAuj = new GregorianCalendar ();
        Calendar dateAuj = Calendar.getInstance();
        chAnnee = dateAuj.get (Calendar.YEAR);
        chMois = dateAuj.get (Calendar.MONTH) + 1;
        chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
        chJourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1)
            chJourSemaine = 7;
        else chJourSemaine -= 1;
    }

    /**
     * Constructeur de la classe DateCalendrier
     * @param parJour
     * @param parMois
     * @param parAnnee
     */
    public DateCalendrier (int parJour, int parMois, int parAnnee)   {
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(chAnnee,chMois-1,chJour);
        chJourSemaine = date.get (Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1)
            chJourSemaine = 7;
        else chJourSemaine -= 1;
    }

    /**
     * Donne la date sous le format d'un string (ex: "Lundi 1 Janvier")
     * @return String : la date sous le format d'un string
     */
    public String toString () {
        return  JOURS_SEMAINE [chJourSemaine -1] + " " + chJour + " " + MOIS [chMois-1];
    }

    /**
     * Getter de l'attribut chJourSemaine
     * @return int : le jour de la semaine
     */
    public int getJourSemaine () {
        return chJourSemaine;
    }

    /**
     * Retourne un booléen qui dit si la date est aujourd'hui ou non
     * @return boolean : true si la date est aujourd'hui, false sinon
     */
    public boolean isToday() {
        return this.compareTo(new DateCalendrier()) == 0;
    }

    /**
     * Donne le numéro de la semaine dans l'année de la date
     * @return int : le numéro de la semaine dans l'année de la date
     */
    public int getWeekOfYear() {
        Calendar date  = Calendar.getInstance();
        date.set(chAnnee, chMois-1, chJour);
        return date.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Donne la date du lendemain
     * @return DateCalendrier : la date du lendemain
     */
    public DateCalendrier dateDuLendemain ()   {
        Date dateLendemain =  super.dateDuLendemain();
        return new DateCalendrier (dateLendemain.chJour,dateLendemain.chMois,dateLendemain.chAnnee);
    }

    /**
     * Donne la date de la veille
     * @return DateCalendrier : la date de la veille
     */
    public DateCalendrier dateDeLaVeille ()  {
        Date dateVeille =  super.dateDeLaVeille();
        return new DateCalendrier (dateVeille.chJour,dateVeille.chMois,dateVeille.chAnnee);
    }
}