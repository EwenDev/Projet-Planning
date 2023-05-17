package modele;

import java.io.Serializable;

public class Reservation implements Comparable<Reservation>, Serializable {

    private Date ChDate;
    private PlageHoraire ChPlageHoraire;
    private String ChIntitule;

    private String ChNiveau;

    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionPlanning{
        if (!parDate.estValide() || !parPlageHoraire.estValide() || parIntitule == null || parIntitule.equals("")){
            throw  new ExceptionPlanning(0);
        }
        ChDate = parDate;
        ChPlageHoraire = parPlageHoraire;
        ChIntitule = parIntitule;
    }

    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parIntitule, String parNiveau) throws ExceptionPlanning{
        if (!parDate.estValide() || !parPlageHoraire.estValide() || parIntitule == null || parIntitule.equals("")){
            throw  new ExceptionPlanning(0);
        }
        ChDate = parDate;
        ChPlageHoraire = parPlageHoraire;
        ChIntitule = parIntitule;
        ChNiveau = parNiveau;
    }

    public String toString(){
        return ChDate + ", " + ChPlageHoraire + ", " + ChIntitule;
    }

    /**this et la reservation reçue en argument sont supposés valides
     * @return un entier négatif si this est antérieur à la reservation reçue en argument
     * un entier positif si this est postérieur à la reservation reçue en argument
     * 0 si this et la reservation reçue en argument sont identiques
     * @param l'horaire comparée à this
     */
    public int compareTo (Reservation parReservation){
        int compareDate = this.ChDate.compareTo(parReservation.ChDate);
        if (compareDate != 0){
            return compareDate;
        }
        return this.ChPlageHoraire.compareTo(parReservation.ChPlageHoraire);
    }

    public Date getChDate() {return ChDate;}

    public String getChIntitule(){
        return ChIntitule;
    }

    public String getChNiveau() {
        return ChNiveau;
    }

    public PlageHoraire getChPlageHoraire() {return ChPlageHoraire;}

    public boolean estValide(){
        return ChDate.estValide() && ChPlageHoraire.estValide();
    }
}