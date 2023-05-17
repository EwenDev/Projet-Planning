package vue;

import modele.*;
import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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
        Controleur controleur = HBoxRoot.getControleur();
        Date today = new Date();
        mois = today.getMois();
        Label labelTitle = new Label(MOIS[mois-1] + " " + today.getAnnee());
        Button buttonMoisPrecedent = new Button("<");
        Button buttonMoisSuivant = new Button(">");
        Button buttonPremierMois = new Button("<<");
        Button buttonDernierMois = new Button(">>");
        HBox boiteLabel = new HBox();
        HBox.setMargin(labelTitle, new Insets(10));
        HBox.setMargin(buttonMoisPrecedent, new Insets(2));
        HBox.setMargin(buttonMoisSuivant, new Insets(2));
        HBox.setMargin(buttonPremierMois, new Insets(2));
        HBox.setMargin(buttonDernierMois, new Insets(2,100,2,2));

        boiteLabel.getChildren().addAll(buttonPremierMois,buttonMoisPrecedent,buttonMoisSuivant,buttonDernierMois);

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
                int jour = date.getJour();
                //un toggleButton par date instanciée avec le n° du jour
                ToggleButton boutonDate = new ToggleButton(Integer.toString(jour));
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
                boutonDate.addEventHandler(ActionEvent.ACTION, controleur);

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

        for (Node node : paneMois){
            node.setVisible(false);
        }
        while (!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            System.out.println(paneMois.get(lastIndice).getAccessibleText());
            paneMois.get(lastIndice).toBack();
        }
        paneMois.get(lastIndice).setVisible(true);
        this.getChildren().addAll(labelTitle,boiteLabel,stackPaneMois);

        buttonMoisSuivant.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                paneMois.get(lastIndice).setVisible(false);
                paneMois.get(0).toFront();
                paneMois.get(lastIndice).setVisible(true);
                labelTitle.setText(paneMois.get(0).getAccessibleText() + " " + today.getAnnee());
            }
        });
        buttonMoisPrecedent.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                paneMois.get(lastIndice).setVisible(false);
                paneMois.get(lastIndice).toBack();
                paneMois.get(lastIndice).setVisible(true);
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });

        buttonDernierMois.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while(!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[11])) {
                    paneMois.get(lastIndice).setVisible(false);
                    paneMois.get(lastIndice).toBack();
                }
                paneMois.get(lastIndice).setVisible(true);
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });

        buttonPremierMois.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while(!paneMois.get(lastIndice).getAccessibleText().equals(MOIS[0])) {
                    paneMois.get(lastIndice).setVisible(false);
                    paneMois.get(lastIndice).toBack();

                }
                paneMois.get(lastIndice).setVisible(true);
                labelTitle.setText(paneMois.get(lastIndice).getAccessibleText() + " " + today.getAnnee());
            }
        });
    }
}
