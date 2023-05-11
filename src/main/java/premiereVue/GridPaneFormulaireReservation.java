package premiereVue;

import Controleur.Controleur;
import Calendrier.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireReservation extends GridPane implements ConstanteCalendrier {
    public static ComboBox<String> comboHeureDebut;
    public static ComboBox<String> comboHeureFin;
    public static ComboBox<String> comboMinDebut;
    public static ComboBox<String> comboMinFin;
    public static TextField fieldCours;
    public static ToggleGroup radioGroup;
    public static DateCalendrier date;
    public static Label labelTitle;

    public GridPaneFormulaireReservation() {
        Controleur controleur = HBoxRoot.getControleur();
        DateCalendrier today = new DateCalendrier();
        date = new DateCalendrier();
        // int mois = today.getMois();
        // int jour = today.getJourSemaine();
        // Label labelTitle = new Label(JOURS_SEMAINE[jour-1] + " " + jour + " " + MOIS[mois-1] + " " + today.getAnnee());
        labelTitle = new Label(JOURS_SEMAINE[date.getJourSemaine()] + " " + date.getJour() + " " + MOIS[date.getMois() - 1] + " " + date.getAnnee());
        Label labelCours = new Label("Cours");
        TextField textFieldCours = new TextField();
        fieldCours = new TextField();

        fieldCours.setText("Cours");

        Label labelNiveau = new Label("Niveau");
        radioGroup = new ToggleGroup();
        RadioButton buttonDebutant = new RadioButton("Débutant");
        RadioButton buttonMoyen = new RadioButton("Moyen");
        RadioButton buttonAvance = new RadioButton("Avancé");
        RadioButton buttonExpert = new RadioButton("Expert");
        buttonDebutant.setSelected(true);

        buttonDebutant.setToggleGroup(radioGroup);
        buttonMoyen.setToggleGroup(radioGroup);
        buttonAvance.setToggleGroup(radioGroup);
        buttonExpert.setToggleGroup(radioGroup);

        labelCours.setLabelFor(textFieldCours);

        labelCours.setMnemonicParsing(true);

        Label labelHoraire = new Label("Horaire");
        Label labelHoraireDe = new Label("de");
        Label labelHoraireA = new Label("à");
        Label labelHoraireH1 = new Label("h");
        Label labelHoraireMn1 = new Label("mn");
        Label labelHoraireH2 = new Label("h");
        Label labelHoraireMn2 = new Label("mn");

        comboHeureDebut = peupleComboBox(HEURES);
        comboHeureFin = peupleComboBox(HEURES);
        comboMinDebut = peupleComboBox(MINUTES);
        comboMinFin = peupleComboBox(MINUTES);

        comboHeureDebut.setValue(HEURES[0]);
        comboHeureFin.setValue(HEURES[1]);
        comboMinDebut.setValue(MINUTES[0]);
        comboMinFin.setValue(MINUTES[0]);

        Button buttonAnnuler = new Button("Annuler");
        buttonAnnuler.setId("buttonAnnuler");
        Button buttonEnregistrer = new Button("Enregistrer");
        // this.setGridLinesVisible(true);

        this.setPadding(new Insets(10));
        this.setVgap(20);
        this.setHgap(20);

        this.add(labelTitle,0,0,6,1);

        this.add(new Separator(),0,1,6,1);

        this.add(labelCours,0,2);
        this.add(fieldCours,1,2,5,1);

        this.add(labelNiveau,0,3);

        this.add(buttonDebutant,1,3,2,1);
        this.add(buttonMoyen,3,3,2,1);
        this.add(buttonAvance,1,4,2,1);
        this.add(buttonExpert,3,4,2,1);

        this.add(labelHoraire,0,5);
        this.add(labelHoraireDe,1,5);
        this.add(comboHeureDebut,2,5);
        this.add(labelHoraireH1,3,5);
        this.add(comboMinDebut,4,5);
        this.add(labelHoraireMn1,5,5);
        this.add(labelHoraireA,1,6);
        this.add(comboHeureFin,2,6);
        this.add(labelHoraireH2,3,6);
        this.add(comboMinFin,4,6);
        this.add(labelHoraireMn2,5,6);

        this.add(new Separator(),0,7,6,1);

        this.add(buttonAnnuler,3,8);
        this.add(buttonEnregistrer,4,8);


        buttonEnregistrer.setAccessibleText("Enregistrer");
        buttonEnregistrer.addEventHandler(ActionEvent.ACTION, controleur);

        buttonAnnuler.setAccessibleText("Annuler");
        buttonAnnuler.addEventHandler(ActionEvent.ACTION, controleur);
    }

    private ComboBox<String> peupleComboBox (String [] strings){
        ComboBox<String> comboBox = new ComboBox<>();
        for(String string : strings){
            comboBox.getItems().add(string);
        }
        return comboBox;
    }

    public static void setDate(DateCalendrier parDate){
        date = parDate;
        labelTitle.setText((JOURS_SEMAINE[date.getJourSemaine() - 1] + " " + date.getJour() + " " + MOIS[date.getMois() - 1] + " " + date.getAnnee()));
    }

    public static DateCalendrier getDate(){
        return date;
    }

    public static Horaire getHoraireDebut(){
        return new Horaire(Integer.valueOf(comboHeureDebut.getValue()), Integer.valueOf(comboMinDebut.getValue()));
    }

    public static Horaire getHoraireFin(){
        return new Horaire(Integer.valueOf(comboHeureFin.getValue()), Integer.valueOf(comboMinFin.getValue()));
    }

    public static String getIntitule(){
        return fieldCours.getText();
    }

    public static String getNiveau(){
        return ((Labeled) radioGroup.getSelectedToggle()).getText();
    }
}