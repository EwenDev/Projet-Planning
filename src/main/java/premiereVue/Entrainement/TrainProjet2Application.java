package premiereVue.Entrainement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import premiereVue.CalendrierTilePane;
import premiereVue.TrainVBoxRoot;

import java.io.File;

public class TrainProjet2Application extends Application {

    public void start(Stage stage)   {
        VBox root = new TrainVBoxRoot();
        Scene scene = new Scene(root,260,300);
        File[] fichierCss = new File("css").listFiles();
        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }

}