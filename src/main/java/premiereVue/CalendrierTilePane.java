package premiereVue;

import Calendrier.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

public class CalendrierTilePane extends VBox implements ConstanteCalendrier {
    private int mois;

    public CalendrierTilePane(){

        super(15); //espacement
        Date today = new Date();
        mois = today.getMois();
        Label labelTitle = new Label(MOIS[mois-1] + " " + today.getAnnee());
        Button buttonMoisPrecedent = new Button("<");
        Button buttonMoisSuivant = new Button(">");
        Button buttonPremierMois = new Button("<<");
        Button buttonDernierMois = new Button(">>");
        HBox boiteLabel = new HBox();
        HBox.setMargin(labelTitle, new Insets(7));
        HBox.setMargin(buttonMoisPrecedent, new Insets(2));
        HBox.setMargin(buttonMoisSuivant, new Insets(2));
        HBox.setMargin(buttonPremierMois, new Insets(2));
        HBox.setMargin(buttonDernierMois, new Insets(2));

        boiteLabel.getChildren().addAll(buttonPremierMois,buttonMoisPrecedent,buttonMoisSuivant,buttonDernierMois, labelTitle);

        StackPane stackPaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();

        for (int numMois = 1;numMois<=12 ; numMois++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois,today.getAnnee());
            //un conteneur tilePane par mois
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            //1 ligne pour les jours +4,5,6 lignes pour les boutons
            tilePane.setPrefRows(monthCalendar.getDates().size()%7+1);
            //à utiliser dans la feuille de style pour donner une couleur de fond au tilePane
            tilePane.setId("Opaque");
            //La boucle qui crée les labels de la 1ère ligne
            for (String jourAb : JOURS_SEMAINE_ABR){
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }
            for (DateCalendrier date : monthCalendar.getDates()){
                //un toggleButton par date instanciée avec le n° du jour
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
                //insère le toggleButton dans le groupe de boutons
                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);
                //associe une date au toggleButton utilisée par la suite
                boutonDate.setUserData(date);
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent){
                        System.out.println(boutonDate.getUserData());
                    }
                });
                if (date.getMois() != monthCalendar.getMois()){
                    boutonDate.setId("dateHorsMois");
                }
                if (date.isToday()){
                    boutonDate.setId("today");
                }
            }
            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackPaneMois.getChildren().add(tilePane);
        }
        List<Node> paneMois = stackPaneMois.getChildren();
        final int lastIndice = paneMois.size()-1;
        //placer le mois courant en haut de la piste

        while (!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            System.out.println(paneMois.get(lastIndice).getAccessibleText());
            paneMois.get(lastIndice).toBack();
        }
        this.getChildren().addAll(stackPaneMois,boiteLabel);

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
                    paneMois.get(lastIndice).setVisible(false);
                }
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });
    }
}
