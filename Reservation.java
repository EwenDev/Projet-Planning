public class Reservation implements Comparable<Reservation>{

    private Date chDate;
    private PlageHoraire chPlageHoraire;
    private String chIntitule;

    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parIntitule) throws ExceptionPlanning{
        if (!parDate.estValide() || !parPlageHoraire.estValide() || parIntitule == null || parIntitule.equals("")){
            throw  new ExceptionPlanning(0);
        }
        chDate = parDate;
        chPlageHoraire = parPlageHoraire;
        chIntitule = parIntitule;
    }

    public String toString(){
        return chDate + ", " + chPlageHoraire + ", " + chIntitule;
    }

    /**this et la reservation reçue en argument sont supposés valides
     * @return un entier négatif si this est antérieur à la reservation reçue en argument
     * un entier positif si this est postérieur à la reservation reçue en argument
     * 0 si this et la reservation reçue en argument sont identiques
     * @param l'horaire comparée à this
     */
    public int compareTo (Reservation parReservation){
        int compareDate = this.chDate.compareTo(parReservation.chDate);
        if (compareDate != 0){
            return compareDate;
        }
        return this.chPlageHoraire.compareTo(parReservation.chPlageHoraire);
    }

    public Date getDate() {return chDate;}

    public boolean estValide(){
        return chDate.estValide() && chPlageHoraire.estValide();
    }
}

