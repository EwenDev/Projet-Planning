package premiereVue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;

public class Projet2Application extends Application{
    public void start(Stage stage){
        VBox root = new VBaseRootStackMonths();
        Scene scene = new Scene(root,400,380);
        File [] fichierCss = new File("css").listFiles();
        for (File fichier : fichierCss){
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");

        stage.show();
    }
    public static void main(String[] args){
        Application.launch(args);
    }
}
