package premiereVue;

import Calendrier.DateCalendrier;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import Calendrier.*;
import java.util.Set;


public class VBoxAffichagePlanning extends VBox{
    DateCalendrier date;
    Label labelWeekOfYear;
    TableView<Reservation> tableDesReservations; //partie 2
    public VBoxAffichagePlanning(Set<Reservation> reservations){
        super(14);
        labelWeekOfYear = new Label();
        tableDesReservations = new TableView();
        TableColumn<Reservation,DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Reservation,String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("cours"));
        TableColumn<Reservation,String> niveauColumn = new TableColumn<>("Niveau");
        niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        TableColumn<Reservation,Horaire> horaireColumn = new TableColumn<>("Horaire");
        niveauColumn.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        tableDesReservations.getColumns().addAll(dateColumn,coursColumn,niveauColumn,horaireColumn);
        this.update(new DateCalendrier(),reservations);
        this.getChildren().addAll(labelWeekOfYear,tableDesReservations);
    }

    public void update(DateCalendrier date, Set<Reservation> reservations){
        this.date = date;
        labelWeekOfYear.setText("Semaine " + date.getWeekOfYear());
        tableDesReservations.getItems().clear();
        if (reservations != null) {
            for (Reservation res : reservations) {
                tableDesReservations.getItems().add(res);
            }
        }
    }
}
