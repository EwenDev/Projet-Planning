package modele;

import java.io.Serializable;

/**
 * Permet de gérer les plages horaires des réservations avec une heure de début et une heure de fin (ex : 8h30 - 9h30)
 */
public class PlageHoraire implements Serializable {
    final static int DUREE_MIN = 60;
    Horaire chHoraireDebut;
    Horaire chHoraireFin;

    /**
     * Constructeur de la classe PlageHoraire
     * @param parHoraireDebut
     * @param parHoraireFin
     * @throws ExceptionPlanning
     */
    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) throws ExceptionPlanning{
        if (parHoraireFin.toMinutes()-parHoraireDebut.toMinutes() < DUREE_MIN)
            throw new ExceptionPlanning(0);
        chHoraireDebut = parHoraireDebut;
        chHoraireFin = parHoraireFin;
    }

    /**
     * Retourne la durée de la plage horaire en minutes
     * @return int : la durée de la plage horaire en minutes
     */
    public int duree(){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();
    }

    /**
     * Retourne la durée de la plage horaire en String (ex : 1h30)
     * @return String : la durée de la plage horaire en String
     */
    public String dureeToString(){
        int duree = this.duree();
        if (duree < 60){
            return duree + " mn";
        }
        else if (duree % 60 == 0){
            return duree / 60 + "h";
        }
        else{
            return duree / 60 + "h" + duree % 60 + "mn";
        }
    }

    /**
     * Retourne un string de la plage horaire (ex : 8h30 - 9h30, durée : 1h)
     * @return String : la plage horaire en String
     */
    public String toString(){
        return chHoraireDebut + " - " + chHoraireFin + ", durée : " + dureeToString();
    }

    /**
     * Vérifie si la plage horaire est valide (durée >= 1h)
     * @return boolean : true si la plage horaire est valide, false sinon
     */
    public boolean estValide(){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= DUREE_MIN;
    }

    /**
     * Compare deux plages horaires et retourne un int en fonction de la comparaison
     * @param parPlageHoraire
     * @return int : négatif si la plage horaire est avant, positif si la plage horaire est après, 0 si les plages horaires se chevauchent
     */
    public int compareTo (PlageHoraire parPlageHoraire){
        if (this.chHoraireFin.toMinutes() <= parPlageHoraire.chHoraireDebut.toMinutes()){
            return -1;
        }
        if (parPlageHoraire.chHoraireFin.toMinutes() <= this.chHoraireDebut.toMinutes()){
            return 1;
        }
        else return 0;
    }
}
