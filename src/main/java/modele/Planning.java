package modele;

import java.io.Serializable;

/**
 * Classe permettant de créer un planning contenant des réservations et de gérer ces réservations
 */
public class Planning implements Serializable {
    private Reservation [] chTabReservations;
    private final int TAILLE;

    /**
     * Constructeur de la classe Planning
     * @param parTaille : la taille du tableau de réservations (donc du planning)
     */
    public Planning(int parTaille){
        TAILLE = parTaille;
        chTabReservations = new Reservation[TAILLE];
    }

    /**
     * Ajoute une réservation au planning si elle est valide
     * @param parReservation : la réservation à ajouter
     * @throws ExceptionPlanning : si la réservation n'est pas valide, si le planning est plein ou si la réservation existe déjà
     */
    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        if (!parReservation.estValide())
            throw new ExceptionPlanning(0);
        if (chTabReservations[TAILLE- 1] != null)
            throw new ExceptionPlanning(1);
        for (int i=0;i< chTabReservations.length;i++){
            if(chTabReservations[i]==null){
                chTabReservations[i]=parReservation;
                break;
            }
            if (chTabReservations[i].compareTo(parReservation) == 0)
                throw new ExceptionPlanning(2);
        }
    }

    /**
     * Retourne un string de toutes les réservations du planning
     * @return String : les réservations du planning en String
     */
    public String toString(){
        String chaine = new String();
        for (Reservation reserv : chTabReservations){
            chaine += reserv.toString() + "\n";
        }
        return chaine;
    }

    /**
     * Retourne la première réservation de la date passée en paramètre
     * @param parDate : la date de la réservation à retourner
     * @return Reservation : reservation de la date passée en paramètre
     * @return null : si aucune réservation n'a été trouvée
     */
    public Reservation getReservation (Date parDate){
        for (Reservation reserv : chTabReservations){
            if (reserv.getChDate().compareTo(parDate)==0){
                return reserv;
            }
        }
        return null;
    }

    /**
     * Retourne un tableau de réservations de la date passée en paramètre
     * @param parDate : la date des réservations à retourner
     * @return Reservation [] : tableau de réservations de la date passée en paramètre
     */
    public Reservation [] getReservations(Date parDate){
        Reservation [] tabReservations = new Reservation[TAILLE];
        int nbReservations = 0;
        for (Reservation reserv : chTabReservations){
            if (reserv.getChDate().compareTo(parDate)==0){
                tabReservations[nbReservations] = reserv;
                nbReservations++;
            }
        }
        return tabReservations;
    }
}
