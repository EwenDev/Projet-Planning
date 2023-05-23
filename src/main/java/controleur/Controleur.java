package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.*;
import outils.LectureEcriture;

/**
 * Classe Controleur qui va gérer les évènements de l'application
 */
public class Controleur implements EventHandler {

    DateCalendrier date;
    PlanningCollections planning;

    /**
     * Méthode permettant de gérer les évènements de l'application comme l'enregistrement d'une réservation ou le changement de jour et de semaine
     * @param event : l'évènement à gérer
     */
    @Override
    public void handle(Event event) {
        planning = HBoxRoot.getPlanning();
        date = new DateCalendrier();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        VBoxAffichagePlanning tableauPane = HBoxRoot.getOneWeekTable();

        if (event.getSource() instanceof ToggleButton) {
            date = (DateCalendrier)(((ToggleButton) event.getSource()).getUserData());
            GridPaneFormulaireReservation.setDate(date);
            HBoxRoot.getOneWeekTable().update(date,HBoxRoot.getPlanning().getSemReservations(date.getWeekOfYear()));
        }

        if (event.getSource() instanceof Button) {
            switch (((Button) event.getSource()).getAccessibleText()){
                case "Enregistrer" :
                    try {
                        Reservation res = new Reservation(GridPaneFormulaireReservation.getDate(), new PlageHoraire(GridPaneFormulaireReservation.getHoraireDebut(), GridPaneFormulaireReservation.getHoraireFin()), GridPaneFormulaireReservation.getIntitule(), GridPaneFormulaireReservation.getNiveau());
                        planning.ajout(res);
                        LectureEcriture.ecriture(HBoxRoot.getPlanningFile(), planning);
                        GridPaneFormulaireReservation.fieldCours.setText(null);
                        GridPaneFormulaireReservation.radioGroup.selectToggle(null);
                        GridPaneFormulaireReservation.comboHeureDebut.setValue(null);
                        GridPaneFormulaireReservation.comboHeureFin.setValue(null);
                        GridPaneFormulaireReservation.comboMinDebut.setValue(null);
                        GridPaneFormulaireReservation.comboMinFin.setValue(null);

                        tableauPane.update(date,HBoxRoot.getPlanning().getSemReservations(date.getWeekOfYear()));

                    } catch (ExceptionPlanning e) {
                        e.printStackTrace();
                    }
                    break;
                case "Annuler":
                    GridPaneFormulaireReservation.fieldCours.setText(null);
                    GridPaneFormulaireReservation.comboHeureDebut.setValue(null);
                    GridPaneFormulaireReservation.comboHeureFin.setValue(null);
                    GridPaneFormulaireReservation.comboMinDebut.setValue(null);
                    GridPaneFormulaireReservation.comboMinFin.setValue(null);
                    GridPaneFormulaireReservation.radioGroup.selectToggle(null);
                    System.out.println("Annulation");
                    break;
                default :
                    break;

            }
        }
    }
}