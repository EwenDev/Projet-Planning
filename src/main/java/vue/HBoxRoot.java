package vue;

import modele.*;
import outils.LectureEcriture;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import controleur.Controleur;
import outils.LectureEcriture;

import java.io.File;

/**
 * Classe HBoxRoot qui contient les 3 panes principaux de l'application
 */
public class HBoxRoot extends HBox implements ConstanteCalendrier {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static GridPaneFormulaireReservation reservationPane;
    private static CalendrierTilePane calendrierPane;
    private static VBoxAffichagePlanning oneWeekTable;
    private static File planningFile;

    /**
     * Constructeur de la classe HBoxRoot qui va créer les différents panes et les ajouter à la HBox et qui va initialiser le planning à partir d'un fichier de réservations
     */
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

    /**
     * Méthode permettant de récupérer le planning
     * @return le planning
     */
    public static PlanningCollections getPlanning(){
        return planning;
    }

    /**
     * Méthode permettant de récupérer le controleur
     * @return le controleur
     */
     public static Controleur getControleur() {
         return controleur;
     }

    /**
     * Méthode permettant de récupérer le fichier de sauvegarde du planning
     * @return le fichier de sauvegarde du planning
     */
    public static File getPlanningFile() {
        return planningFile;
    }

    /**
     * Méthode permettant de récupérer le GridPane du formulaire de réservation
     * @return le GridPane du formulaire de réservation
     */
    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    /**
     * Méthode permettant de récupérer le CalendrierTilePane
     * @return le CalendrierTilePane
     */
    public static CalendrierTilePane getCalendrierPane() {
        return calendrierPane;
    }

    /**
     * Méthode permettant de récupérer le VBoxAffichagePlanning
     * @return le VBoxAffichagePlanning
     */
    public static VBoxAffichagePlanning getOneWeekTable() {
        return oneWeekTable;
    }
}
