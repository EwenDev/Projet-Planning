module com.example.projetihm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.projetihm to javafx.fxml;
    exports com.example.projetihm;
    exports premiereVue;
    exports premiereVue.Entrainement;
}