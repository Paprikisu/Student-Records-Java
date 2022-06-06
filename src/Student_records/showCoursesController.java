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
 * Näytä kurssit FXML tiedoston controller
 * @author Miska
 */

public class showCoursesController {


    @FXML
    public TableView<KurssiTable> table;
    @FXML
    public TableColumn<KurssiTable, Integer> col_id;
    @FXML
    public TableColumn<KurssiTable, String> col_name;
    @FXML
    public TableColumn<KurssiTable, Integer> col_laajuus;
    public Button showCoursesBtn;

    ObservableList<KurssiTable> oblist = FXCollections.observableArrayList();

    /**
     * Näytä kurssit metodi - Listaa tietokannan kurssit taulukkoon
     * @param event Näyttää kurssit taulukossa
     */


    public void showCourses(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kurssit");

            while (rs.next()) {
                oblist.add(new KurssiTable(
                        rs.getInt("kurssi_id"),
                        rs.getString("Nimi"),
                        rs.getInt("Laajuus")
                ));
            }

            dbConnection.closeConnection(conn);


        } catch (Exception e) {
            System.out.println(e);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("kurssi_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("Nimi"));
        col_laajuus.setCellValueFactory(new PropertyValueFactory<>("Laajuus"));

        table.setItems(oblist);

        showCoursesBtn.setDisable(true);


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
