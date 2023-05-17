package modele;

import java.io.Serializable;

public interface ConstanteCalendrier{
    final String [] JOURS_SEMAINE = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
    final String [] JOURS_SEMAINE_ABR = {"Lu", "Ma", "Me", "Je", "Ve", "Sa", "Di"};
    final String [] MOIS = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
    final String [] HEURES = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00"};
    final String[] MINUTES = {"00", "15", "30", "45"};

    final String SAVE_BUTTON = "Enregistrer";
}
