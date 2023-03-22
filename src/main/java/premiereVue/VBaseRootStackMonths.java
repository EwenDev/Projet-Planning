package premiereVue;

import Calendrier.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.List;

public class VBaseRootStackMonths extends VBox implements ConstanteCalendrier{

    private int mois;

    public VBaseRootStackMonths(){

        super(15); //espacement
        DateCalendrier today = new DateCalendrier();
        mois = today.getMois();
        Label labelTitle = new Label(MOIS[mois-1] + " " + today.getAnnee());
        Button buttonMoisPrecedent = new Button("<");
        Button buttonMoisSuivant = new Button(">");
        Button buttonPremierMois = new Button("<<");
        Button buttonDernierMois = new Button(">>");
        HBox boiteLabel = new HBox();
        HBox.setMargin(labelTitle, new Insets(5));
        HBox.setMargin(buttonMoisPrecedent, new Insets(5));
        HBox.setMargin(buttonMoisSuivant, new Insets(5));
        HBox.setMargin(buttonPremierMois, new Insets(5));
        HBox.setMargin(buttonDernierMois, new Insets(5));

        boiteLabel.getChildren().addAll(buttonPremierMois,buttonMoisPrecedent,buttonMoisSuivant,buttonDernierMois, labelTitle);

        StackPane stackPaneMois = new StackPane();
        for (int i = 1; i<13; i++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i,2023);
            VBox boiteDates = new VBox();

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);
            VBox.setMargin(scrollPaneDates, new Insets(4));
            //ici faut modif

            for (DateCalendrier date : monthCalendar.getDates()){
                Label labelDate = new Label(date.toString());

                //les attributs id sont utilisés dans la feuille de style css
                if (date.getMois() != monthCalendar.getMois()){
                    labelDate.setId("dateHorsMois");
                }

                if (date.isToday()){
                    labelDate.setId("today");
                    labelDate.setStyle("-fx-font-weight: bold;");
                }

                VBox.setMargin(labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }

            scrollPaneDates.setAccessibleText(MOIS[i-1]);
            stackPaneMois.getChildren().add(scrollPaneDates);

        }
        List<Node> paneMois = stackPaneMois.getChildren();
        final int lastIndice = paneMois.size()-1;
        //placer le mois courant en haut de la piste

        while (!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            System.out.println(paneMois.get(lastIndice).getAccessibleText());
            paneMois.get(lastIndice).toBack();
        }
        this.getChildren().addAll(boiteLabel, stackPaneMois);

        buttonMoisSuivant.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                paneMois.get(0).toFront();
                labelTitle.setText(paneMois.get(0).getAccessibleText() + " " + today.getAnnee());

            }
        });
        buttonMoisPrecedent.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                paneMois.get(lastIndice).toBack();
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });

        buttonDernierMois.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while(!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[11])) {
                    paneMois.get(lastIndice).toBack();
                }
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });

        buttonPremierMois.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while(!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[0])) {
                    paneMois.get(lastIndice).toBack();
                }
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });
    }
}


