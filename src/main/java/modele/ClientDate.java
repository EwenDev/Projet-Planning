package modele;
public class ClientDate {

    public static void main (String [] args){

        // Date dateTestConstructeur = new Date () ;
        // System.out.println(dateTestConstructeur );

        Date datePremierCoursJava = new Date (2022);
        datePremierCoursJava = Date.lireDate();
        System.out.println(datePremierCoursJava + " " + datePremierCoursJava.estValide() );
    }
}
