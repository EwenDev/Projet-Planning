package Controleur;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import Calendrier.*;
import premiereVue.*;

public class Controleur implements EventHandler {

    DateCalendrier date;
    PlanningCollections planning;
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
                        //MEMO POUR MOI : SOUCIS AVEC L'ENREGISTREMENT DES RESERVATIONS - (sûrement dans la méthode ajout)
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
                case "Annuler":
                    GridPaneFormulaireReservation.fieldCours.setText(null);
                    GridPaneFormulaireReservation.comboHeureDebut.setValue(null);
                    GridPaneFormulaireReservation.comboHeureFin.setValue(null);
                    GridPaneFormulaireReservation.comboMinDebut.setValue(null);
                    GridPaneFormulaireReservation.comboMinFin.setValue(null);
                    GridPaneFormulaireReservation.radioGroup.selectToggle(null);
                    System.out.println("Annulation");

            }
        }
    }
}