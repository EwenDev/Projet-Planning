package modele;

import java.io.Serializable;

/**
 * Classe d'exception pour les classes de gestion des plannings et des réservations
 */
public class ExceptionPlanning extends Exception implements Serializable {
    private int codeErreur;

    /**
     * Constructeur de la classe ExceptionPlanning qui permet de créer une exception
     * @param parCodeErreur
     */
    public ExceptionPlanning(int parCodeErreur){
        super(); //Appel au constructeur de la classe mère
        this.codeErreur = parCodeErreur;
    }

    /**
     * Getter du code d'erreur de l'exception
     * @return int : le code d'erreur
     */
    public int getCodeErreur(){
        return codeErreur;
    }
}
