package premiereVue;

import Calendrier.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import Controleur.Controleur;
import javafx.scene.control.Label;
import javafx.geometry.Insets;


public class HBoxRoot extends HBox implements ConstanteCalendrier {

    private static PlanningCollections planning;
    private static Controleur controleur;
    private static GridPaneFormulaireReservation reservationPane;
    private static CalendrierTilePane calendrierPane;

    private static VBoxAffichagePlanning oneWeekTable;

    public HBoxRoot(){
        super(40);
        planning = new PlanningCollections();
        controleur = new Controleur();
        oneWeekTable = new VBoxAffichagePlanning(null);
        VBox boiteCalendrier = new CalendrierTilePane();
        GridPane formulaire = new GridPaneFormulaireReservation();
        this.getChildren().addAll(boiteCalendrier,formulaire,oneWeekTable);
    }

    public static PlanningCollections getPlanning(){
        return planning;
    }
     public static Controleur getControleur() {
         return controleur;
     }

    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    public static CalendrierTilePane getCalendrierPane() {
        return calendrierPane;
    }

    public static VBoxAffichagePlanning getOneWeekTable() {
        return oneWeekTable;
    }
}
