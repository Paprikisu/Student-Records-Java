package Student_records;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Etsi kurssikohtaisia suorituksia FXMl tiedoston controller
 * @author Miska
 */

public class searchCourseRecordsController {

    public TextField searchBar;

    /**
     * Mene takaisin valinta ikkunaan metodi
     * @param event Mene takaisin valinta ikkunaan
     * @throws IOException openStream poikkeus
     */



    public void backBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/chooseWindow.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Valitse");
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    @FXML
    public TableView<recordsTable> table;
    @FXML
    public TableColumn<recordsTable, Integer> col_id;
    @FXML
    public TableColumn<recordsTable, Integer> col_studentID;
    @FXML
    public TableColumn<recordsTable, Integer> col_courseID;
    @FXML
    public TableColumn<recordsTable, String> col_date;
    @FXML
    public TableColumn<recordsTable, Integer> col_grade;
    public Button showRecordsBtn;

    ObservableList<recordsTable> oblist = FXCollections.observableArrayList();

    /**
     * Etsii kurssikohtaisia suorituksia metodi - Etsii tietokannasta kurssikohtaisia suorituksia syötetyn kurssi_id:n perusteella
     * @param event Etsi kurssikohtaisia suorituksia
     */

    public void searchCoursesBtn(ActionEvent event) {


        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            table.getItems().clear();

            int courseID = Integer.parseInt(searchBar.getText());


            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM suoritukset WHERE kurssi_id = '" + courseID + "'");

            while (rs.next()) {
                oblist.add(new recordsTable(
                        rs.getInt("suoritus_id"),
                        rs.getInt("opiskelija_id"),
                        rs.getInt("kurssi_id"),
                        rs.getString("suoritusPVM"),
                        rs.getInt("arvosana")));
            }

            dbConnection.closeConnection(conn);


        } catch (Exception e) {
            System.out.println(e);
        }


        col_id.setCellValueFactory(new PropertyValueFactory<>("suoritus_id"));
        col_studentID.setCellValueFactory(new PropertyValueFactory<>("opiskelija_id"));
        col_courseID.setCellValueFactory(new PropertyValueFactory<>("kurssi_id"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("suoritusPVM"));
        col_grade.setCellValueFactory(new PropertyValueFactory<>("arvosana"));

        table.setItems(oblist);


    }
}
