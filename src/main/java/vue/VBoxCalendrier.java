package vue;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import modele.*;

/**
 * Classe permettant de créer un calendrier avec des boutons pour changer de mois sous la forme d'un TilePane
 */
public class VBoxCalendrier extends VBox implements ConstanteCalendrier{
    /**
     * Constructeur de la classe CalendrierTilePane qui va créer les différents éléments du calendrier et les ajouter à la VBox
     */
    public VBoxCalendrier(){
        CalendrierDuMois monthCalendar = new CalendrierDuMois(3,2023);
        System.out.println(monthCalendar);

        Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + "" + monthCalendar.getAnnee());
        VBox.setMargin(labelTitle, new Insets(14));

        VBox boiteDates = new VBox();
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(boiteDates);
        VBox.setMargin(scrollPaneDates, new Insets(4));

        for (DateCalendrier date : monthCalendar.getDates()){
            Label labelDate = new Label(date.toString());

            //les attributs id sont utilisés dans la feuille de style css
            if (date.getMois() != monthCalendar.getMois()){
                labelDate.setId("dateHorsMois");
            }

            if (date.isToday()){
                labelDate.setId("today");
            }

            VBox.setMargin(labelDate, new Insets(8));
            boiteDates.getChildren().add(labelDate);


        }
        this.getChildren().addAll(labelTitle, scrollPaneDates);
    }
}
