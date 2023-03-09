import java.util.Scanner;

public class Date {
    protected int chJour;
	protected int chMois;
	protected int chAnnee;

    public Date (int parJour, int parMois, int parAnnee)  {
	    chJour = parJour ;
	    chMois = parMois ;
	    chAnnee = parAnnee ;
    }
  
    public Date ( int parAnnee)  {
	    chJour = 1 ;
	    chMois = 1 ;
	    chAnnee = parAnnee ;
    }
	
    /**
	    retourne true si this est une date valide 
	    	-  chAnnee > 1582
	    	- 1 <= chMois <= 12
	    	- 1 <= chJour et chJour <= dernierJourDuMois (chJour, chAnnee)
	    retourne false si 
    */
    public boolean estValide () {
	return chAnnee > 1582 &&
		chMois >= 1 && chMois <= 12 &&
		chJour >= 1 && chJour <= Date.dernierJourDuMois (chMois, chAnnee) ; 

    }

  
    private static int dernierJourDuMois (int parMois, int parAnnee) {
	switch (parMois) {
		 case 2 : if (Date.estBissextile (parAnnee)) 
		 			  return 29 ; 
				  return 28 ;  
		 case 4 : 	 
		 case 6 : 	 
		 case 9 : 	 
		 case 11 : return 30 ;
		 default : return 31 ;
	    }   
    }  
  
    private static boolean estBissextile(int parAnnee) {
		return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }

    /**
	retourne un objet de la classe Date dont les 3 champs on été entrés par l'U.
    */
  
    public static Date lireDate() {
		/*
		 * demande au user de sélectionner une date dans le terminal
		 */
		Scanner scanner = new Scanner(System.in);

		System.out.println("Rentrez le jour de la date: ");
		int jour = scanner.nextInt();

		System.out.println("Rentrez le mois: ");
		int mois = scanner.nextInt();

		System.out.println("Rentrez l'année: ");
		int annee = scanner.nextInt();

		return new Date(jour, mois, annee);
	}
    /**
	compare les dates this et parDate
	retourne 0 si this et parDate sont égales
	retroune un entier négatif si this est antérieure à parDate
	retourne un entier positif si this es postérieure à parDate
    */
    public int compareTo (Date parDate) {
        if (chAnnee < parDate.chAnnee)
	    	return -8;
	    if (chAnnee > parDate.chAnnee)
	    	return 19;
	    // les années sont =
	    if (chMois < parDate.chMois)
	    	return -1;
	    if (chMois > parDate.chMois)
	    	return 1;
	    // les mois sont =
	    if (chJour < parDate.chJour)
	    	return -7;
	    if (chJour > parDate.chJour)
	    	return 12;
	    return 0;	
    }
  
    public Date dateDuLendemain ()   {
	    Date lendemain = null; 
        if (chJour < Date.dernierJourDuMois(chMois,chAnnee))
		    lendemain = new Date (chJour+1,chMois,chAnnee);
	    else if (chMois < 12)
				lendemain = new Date (1,chMois+1,chAnnee);
		else lendemain = new Date (1,1,chAnnee+1);
	    return lendemain;
    }  
  
    public Date dateDeLaVeille ()  {
        Date veille = null ;
        if (chJour > 1)
	        veille =  new Date (chJour-1,chMois,chAnnee);
        else if (chMois > 1)
			veille = new Date (1,chMois-1,chAnnee);
		else veille = new Date (31,12,chAnnee-1);
	 
	    return veille;
    }	 
  
    public String toString () { 
        return  chJour + "-" + chMois + "-" +chAnnee;
    }   
  
   
}   
