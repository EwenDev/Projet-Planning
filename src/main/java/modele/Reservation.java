package modele;

import java.io.Serializable;

/**
 * Classe permettant de gérer les réservations
 */
public class Reservation implements Comparable<Reservation>, Serializable {
    private Date ChDate;
    private PlageHoraire ChPlageHoraire;
    private String ChIntitule;
    private String ChNiveau;

    /**
     * Constructeur de la classe Reservation
     * @param parDate
     * @param parPlageHoraire
     * @param parIntitule
     * @throws ExceptionPlanning si la date ou la plage horaire ne sont pas valides
     */
    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionPlanning{
        if (!parDate.estValide() || !parPlageHoraire.estValide() || parIntitule == null || parIntitule.equals("")){
            throw  new ExceptionPlanning(0);
        }
        ChDate = parDate;
        ChPlageHoraire = parPlageHoraire;
        ChIntitule = parIntitule;
    }

    /**
     * Constructeur de la classe Reservation
     * @param parDate
     * @param parPlageHoraire
     * @param parIntitule
     * @param parNiveau
     * @throws ExceptionPlanning si la date ou la plage horaire ne sont pas valides
     */
    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parIntitule, String parNiveau) throws ExceptionPlanning{
        if (!parDate.estValide() || !parPlageHoraire.estValide() || parIntitule == null || parIntitule.equals("")){
            throw  new ExceptionPlanning(0);
        }
        ChDate = parDate;
        ChPlageHoraire = parPlageHoraire;
        ChIntitule = parIntitule;
        ChNiveau = parNiveau;
    }

    /**
     * Retourne un string de la réservation (ex : 01-01-2020, 08h00-10h00, Réunion)
     * @return String : la réservation en String
     */
    public String toString(){
        return ChDate + ", " + ChPlageHoraire + ", " + ChIntitule;
    }

    /**
     * Compare this et la reservation reçue en argument (sont supposés valides)
     * @param parReservation : la reservation à comparer à this
     * @return un entier négatif si this est antérieur à la reservation reçue en argument
     * un entier positif si this est postérieur à la reservation reçue en argument
     * 0 si this et la reservation reçue en argument sont identiques
     */
    public int compareTo (Reservation parReservation){
        int compareDate = this.ChDate.compareTo(parReservation.ChDate);
        if (compareDate != 0){
            return compareDate;
        }
        return this.ChPlageHoraire.compareTo(parReservation.ChPlageHoraire);
    }

    /**
     * Retourne la date de la réservation
     * @return Date : la date de la réservation
     */
    public Date getChDate() {return ChDate;}

    /**
     * Retourne l'intitulé de la réservation
     * @return String : l'intitulé de la réservation
     */
    public String getChIntitule(){
        return ChIntitule;
    }

    /**
     * Retourne le niveau de la réservation
     * @return String : le niveau de la réservation
     */
    public String getChNiveau() {
        return ChNiveau;
    }

    /**
     * Retourne la plage horaire de la réservation
     * @return PlageHoraire : la plage horaire de la réservation
     */
    public PlageHoraire getChPlageHoraire() {return ChPlageHoraire;}

    /**
     * Vérifie si la réservation est valide (date et plage horaire)
     * @return boolean : true si la réservation est valide, false sinon
     */
    public boolean estValide(){
        return ChDate.estValide() && ChPlageHoraire.estValide();
    }
}