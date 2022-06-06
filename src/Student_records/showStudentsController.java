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
 * Näytä opiskelijat FXMl tiedoston controller
 * @author Miska
 */

public class showStudentsController {


    @FXML
    public TableView<OpiskelijaTable> table;
    public Button showStudentsBtn;
    @FXML
    private TableColumn<OpiskelijaTable, Integer> col_id;
    @FXML
    private TableColumn<OpiskelijaTable, String> col_name;
    @FXML
    private TableColumn<OpiskelijaTable, String> col_surname;
    @FXML
    private TableColumn<OpiskelijaTable, String> col_email;
    @FXML
    private TableColumn<OpiskelijaTable, String> col_phone;
    @FXML
    private TableColumn<OpiskelijaTable, String> col_field;

    ObservableList<OpiskelijaTable> oblist = FXCollections.observableArrayList();




    /**
     * Näytä opiskelijat metodi - Näyttää tietokannan opiskelijat taulukossa
     */

    public void showStudents() {
        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM opiskelijat");

            while (rs.next()) {
                oblist.add(new OpiskelijaTable(
                        rs.getInt("opiskelija_id"),
                        rs.getString("Etunimi"),
                        rs.getString("Sukunimi"),
                        rs.getString("Sähköposti"),
                        rs.getString("Puhelin"),
                        rs.getString("Koulutusala")));
            }

            dbConnection.closeConnection(conn);


        } catch (Exception e) {
            System.out.println(e);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("opiskelija_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("Etunimi"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("Sukunimi"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Sähköposti"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("Puhelin"));
        col_field.setCellValueFactory(new PropertyValueFactory<>("Koulutusala"));

        table.setItems(oblist);

        showStudentsBtn.setDisable(true);


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
