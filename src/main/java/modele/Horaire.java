package modele;

import java.io.Serializable;

/**
 * Classe permettant de gérer les horaires des réservations
 */
public class Horaire implements Serializable {
    private int chHeure;
    private int chQuartHeure;

    /**
     * Constructeur de la classe Horaire
     * @param parHeure
     * @param parQuartHeure
     */
    public Horaire (int parHeure, int parQuartHeure) {
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }

    /**
     * Convertit l'horaire en minutes (ex : 8h30 -> 510)
     * @return int : l'horaire en minutes
     */
    public int toMinutes () {
        return chHeure*60 + chQuartHeure;
    }

    /**
     * Getter de l'heure de l'horaire (ex : 8h30 -> 8)
     * @return int : l'heure de l'horaire
     */
    public int getHeure () {
        return chHeure;
    }

    /**
     * Getter du quart d'heure de l'horaire (ex : 8h30 -> 30)
     * @return int : le quart d'heure de l'horaire
     */
    public int getQuartHeure () {
        return chQuartHeure;
    }

    /**
     * Setter de l'heure de l'horaire
     * @param parHeure
     */
    public void setHeure (int parHeure) {
        chHeure = parHeure;
    }

    /**
     * Setter du quart d'heure de l'horaire
     * @param parQuartHeure
     */
    public void setQuartHeure (int parQuartHeure) {
        chQuartHeure = parQuartHeure;
    }

    /**
     * Donne l'horaire sous forme de String (ex : 8h30 -> "8h30")
     * @return String : l'horaire sous forme de String
     */
    public String toString () {
        return chHeure + "h" + chQuartHeure;
    }
}
