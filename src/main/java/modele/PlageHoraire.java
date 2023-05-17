package modele;

import java.io.Serializable;

public class PlageHoraire implements Serializable {
    final static int DUREE_MIN = 60;
    Horaire chHoraireDebut;
    Horaire chHoraireFin;

    public int duree(){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();
    }

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

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) throws ExceptionPlanning{
        if (parHoraireFin.toMinutes()-parHoraireDebut.toMinutes() < DUREE_MIN)
            throw new ExceptionPlanning(0);
        chHoraireDebut = parHoraireDebut;
        chHoraireFin = parHoraireFin;
    }

    public String toString(){
        return chHoraireDebut + " - " + chHoraireFin + ", durée : " + dureeToString();
    }

    public boolean estValide(){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= DUREE_MIN;
    }

    public int compareTo (PlageHoraire parPlageHoraire){
        if (this.chHoraireFin.toMinutes() <= parPlageHoraire.chHoraireDebut.toMinutes()){
            return -18;
        }
        if (parPlageHoraire.chHoraireFin.toMinutes() <= this.chHoraireDebut.toMinutes()){
            return +14;
        }
        else return 0;
    }
}
