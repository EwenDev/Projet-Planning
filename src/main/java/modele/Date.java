package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Classe Date qui permet de représenter une date avec un jour, un mois et une année
 */
public class Date implements Serializable {
	protected int chJour;
	protected int chMois;
	protected int chAnnee;

	/** Construit un objet Date à partir de parJour, parMois, parAnnee
	 * @param parJour
	 * @param parMois
	 * @param parAnnee
	 */
	public Date (int parJour, int parMois, int parAnnee)  {
		chJour = parJour ;
		chMois = parMois ;
		chAnnee = parAnnee ;
	}

	/** Construit un objet Date à partir de parAnnee
	 * @param parAnnee
	 */
	public Date ( int parAnnee)  {
		chJour = 1 ;
		chMois = 1 ;
		chAnnee = parAnnee ;
	}

	/** Construit un objet Date*/
	public Date () {
		Calendar dateAuj = Calendar.getInstance();
		chAnnee = dateAuj.get (Calendar.YEAR);
		chMois = dateAuj.get (Calendar.MONTH) + 1;
		chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
	}

	/** Donne la validité d'une date
	 * @return true si la date est valide, donc si :
	 * - l'année est supérieure à 1582
	 * - le mois est compris entre 1 et 12
	 * - le jour est compris entre 1 et le dernier jour du mois
	 * false sinon
	 */
	public boolean estValide () {
		return chAnnee > 1582 &&
				chMois >= 1 && chMois <= 12 &&
				chJour >= 1 && chJour <= Date.dernierJourDuMois (chMois, chAnnee) ;

	}

	/** Crée un input dans la console pour rentrer une date
	 * @return objet Date construit sur la date rentrée
	 */
	public static Date lireDate() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Rentrez le jour de la date: ");
		int jour = scanner.nextInt();

		System.out.println("Rentrez le mois: ");
		int mois = scanner.nextInt();

		System.out.println("Rentrez l'année: ");
		int annee = scanner.nextInt();

		return new Date(jour, mois, annee);
	}


	/** Donne le dernier jour du mois parMois de l'année parAnnee
	 * @param parMois
	 * @param parAnnee
	 * @return le dernier jour du mois parMois de l'année parAnnee
	 */
	protected static int dernierJourDuMois (int parMois, int parAnnee) {
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

	/** Définit si une année est bissextile ou non
	 * @param parAnnee
	 * @return true si l'année est bissextile donc si :
	 * - l'année est divisible par 4 et non divisible par 100
	 * - l'année est divisible par 400
	 * false sinon
	 */
	private static boolean estBissextile(int parAnnee) {
		return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
	}


	/**
	 Compare deux dates
	 @param parDate la date à comparer avec l'objet courant
	 @return un int < 0 si la date parDate est antérieure à l'objet courant, 0 si les deux dates sont égales, > 0 si la date parDate est postérieure à l'objet courant
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
			return 18;
		// les mois sont =
		if (chJour < parDate.chJour)
			return -7;
		if (chJour > parDate.chJour)
			return 12;
		return 0;
	}

	/**
	 * Donne la date du lendemain de l'objet courant en contrôlant si le jour est en fin de mois et si je mois est en fin d'année
	 * @return la date du lendemain de l'objet courant sous forme d'un objet date
	 */
	public Date dateDuLendemain ()   {
		if (chJour < Date.dernierJourDuMois(chMois,chAnnee))
			return new Date (chJour+1,chMois,chAnnee);
		if (chMois < 12)
			return  new Date (1,chMois+1,chAnnee);
		return  new Date (1,1,chAnnee+1);
	}

	/**
	 * Donne la date de la veille de l'objet courant en contrôlant si le jour est en début de mois et si je mois est en début d'année
	 * @return la date de la veille de l'objet courant sous forme d'un objet date
	 */
	public Date dateDeLaVeille ()  {
		if (chJour > 1)
			return  new Date (chJour-1,chMois,chAnnee);
		if (chMois > 1)
			return new Date (Date.dernierJourDuMois(chMois-1, chAnnee),chMois-1,chAnnee);
		return new Date (31,12,chAnnee-1);
	}

	/** Getter du champ année
	 * @return l'année de l'objet courant
	 */
	public int getAnnee() {
		return chAnnee;
	}

	/** Getter du champ jour
	 * @return le jour de l'objet courant
	 */
	public int getJour() {
		return chJour;
	}

	/** Getter du champ mois
	 * @return le mois de l'objet courant
	 */
	public int getMois() {
		return chMois;
	}

	/** Retourne une version String de l'objet courant
	 * @return une version String de l'objet courant
	 */
	public String toString () {
		return  chJour + "-" + chMois + "-" +chAnnee;
	}


}