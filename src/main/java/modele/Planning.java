package modele;

import java.io.Serializable;

public class Planning implements Serializable {

    private Reservation [] chTabReservations;
    private final int TAILLE;

    public Planning(int parTaille){
        TAILLE = parTaille;
        chTabReservations = new Reservation[TAILLE];
    }

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

    public String toString(){
        String chaine = new String();
        for (Reservation reserv : chTabReservations){
            chaine += reserv.toString() + "\n";
        }
        return chaine;
    }

    public Reservation getReservation (Date parDate){
        for (Reservation reserv : chTabReservations){
            if (reserv.getChDate().compareTo(parDate)==0){
                return reserv;
            }
        }
        return null;
    }

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
