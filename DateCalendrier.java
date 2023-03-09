import java.util.Calendar;

public class DateCalendrier extends Date implements ConstanteCalendrier {
    private int chJourSemaine;

    /* construit la date d'aujourd'hui */
    public DateCalendrier() {
        super(22);
        Calendar dateAuj = Calendar.getInstance();
        chJour = dateAuj.get(Calendar.DAY_OF_MONTH);
        chMois = dateAuj.get(Calendar.MONTH) + 1;
        chAnnee = dateAuj.get(Calendar.YEAR);
        chJourSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1) {
            chJourSemaine = 7;
        } else {
            chJourSemaine--;
        }
    }

    public DateCalendrier(int parJour, int parMois, int parAnnee){
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(chJour, chMois - 1, chAnnee);
        chJourSemaine = date.get(Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1) {
            chJourSemaine = 7;
        } else {
            chJourSemaine--;
        }

    }

    /*ClientDateCalendrier instancie des objets de la classe DateCalendrier et affiche leur contenu*/
    public static void ClientDateCalendrier() {
        DateCalendrier date1 = new DateCalendrier();
        DateCalendrier date2 = new DateCalendrier(22, 12, 2019);
        System.out.println(date1);
        System.out.println(date2);
    }

    public Date dateDuLendemain() {
        return super.dateDuLendemain();
    }

    public Date dateDeLaVeille() {
        return super.dateDeLaVeille();
    }

    public String toString() {
        return ConstanteCalendrier.JOURS_SEMAINE[chJourSemaine] + " " + chJour + " " + ConstanteCalendrier.MOIS[chMois - 1] + " " + chAnnee;
    }
}
