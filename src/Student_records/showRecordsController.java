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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Näytä suoritukset FXML tiedoston controller
 * @author Miska
 */

public class showRecordsController {

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
     * Näytä suoritukset metodi - Näyttää tietokannan suoritukset taulukossa
     * @param event Listaa suoritukset tauluun
     */


    public void showRecords(ActionEvent event) {


        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM suoritukset");

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

        showRecordsBtn.setDisable(true);


    }

    /**
     * Mene takaisin aikaisempaan ikkunaan (Hallintapaneeli)
     * @param event Mene takaisin hallintapaneliin
     * @throws IOException openStream poikkeus
     */

    public void backBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/homePage.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hallintapaneeli");
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
