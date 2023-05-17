package vue;

import modele.*;
import outils.LectureEcriture;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import controleur.Controleur;
import outils.LectureEcriture;

import java.io.File;


public class HBoxRoot extends HBox implements ConstanteCalendrier {

    private static PlanningCollections planning;
    private static Controleur controleur;
    private static GridPaneFormulaireReservation reservationPane;
    private static CalendrierTilePane calendrierPane;

    private static VBoxAffichagePlanning oneWeekTable;

    private static File planningFile;

    public HBoxRoot(){
        super(40);
        planningFile = new File("sauvegarde"+File.separator+"planning-sports-2023.ser");
        if (planningFile.exists()){
            planning = (PlanningCollections) LectureEcriture.lecture(planningFile);
        }
        else{
            planning = new PlanningCollections();
        }
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

    public static File getPlanningFile() {
        return planningFile;
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
