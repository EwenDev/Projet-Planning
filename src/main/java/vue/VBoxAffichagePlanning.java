package vue;

import java.util.Set;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.*;

public class VBoxAffichagePlanning extends VBox {
    private DateCalendrier date;
    private Label weekOfYear;
    private TableView <Reservation> tableReservations;

    public VBoxAffichagePlanning(Set<Reservation> reservations){
        super(15);
        weekOfYear = new Label();
        weekOfYear.setId("date");
        tableReservations = new TableView <Reservation>();
        TableColumn <Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("ChDate"));
        dateColumn.setReorderable(false);
        dateColumn.setResizable(false);
        dateColumn.setPrefWidth(100);
        dateColumn.setId("Colonne");
        TableColumn <Reservation, String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("ChIntitule"));
        coursColumn.setReorderable(false);
        coursColumn.setResizable(false);
        coursColumn.setSortable(false);
        coursColumn.setPrefWidth(150);
        coursColumn.setId("Colonne");
        TableColumn <Reservation, String> nivColumn = new TableColumn<>("Niveau");
        nivColumn.setCellValueFactory(new PropertyValueFactory<>("ChNiveau"));
        nivColumn.setReorderable(false);
        nivColumn.setResizable(false);
        nivColumn.setSortable(false);
        nivColumn.setPrefWidth(60);
        nivColumn.setId("Colonne");
        TableColumn <Reservation, PlageHoraire> horColumn = new TableColumn<>("Horaire");
        horColumn.setCellValueFactory(new PropertyValueFactory<>("ChPlageHoraire"));
        horColumn.setReorderable(false);
        horColumn.setResizable(false);
        horColumn.setPrefWidth(170);
        horColumn.setId("Colonne");

        tableReservations.getColumns().addAll(dateColumn, horColumn, coursColumn, nivColumn);
        tableReservations.setId("tab");
        this.update(new DateCalendrier(), reservations);
        this.getChildren().addAll(weekOfYear, tableReservations);
    }

    public void update(DateCalendrier parDate, Set <Reservation> reservations){
        this.date = parDate;
        weekOfYear.setText("Semaine " + date.getWeekOfYear());
        tableReservations.getItems().clear();
        if (reservations!= null) {
            for (Reservation resa : reservations){
                tableReservations.getItems().add(resa);
            }
        }
    }
}