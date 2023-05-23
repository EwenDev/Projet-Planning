package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.layout.HBox;

/**
 * Classe Projet2Application qui permet de lancer l'application
 */
public class Projet2Application extends Application{
    /**
     * Méthode permettant de lancer l'application en créant la fenêtre principale
     * @param stage : la fenêtre principale de l'application
     */
    public void start(Stage stage){
        HBox root = new HBoxRoot();
        Scene scene = new Scene(root,1350,375);
        File [] fichierCss = new File("css").listFiles();
        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");

        stage.show();
    }

    /**
     * Méthode main qui permet de lancer l'application
     * @param args : les arguments de la ligne de commande
     */
    public static void main(String[] args){
        Application.launch(args);
    }
}
