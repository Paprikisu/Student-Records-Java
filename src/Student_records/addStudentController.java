package Student_records;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Lisää opiskelija FXML tiedoston controller
 * @author Miska
 */

public class addStudentController {


    public TextField nameField;
    public TextField surnameField;
    public TextField emailField;
    public TextField phoneField;
    public TextField fieldField;




    /**
     * Lisää opiskelija metodi - Lisää tietorekisteriin käyttäjän syöttämän opiskelijan tiedot ja ilmoittaa käyttäjälle onnistuneen.
     * @param event Lisää tietokantaan opiskelijan
     */

    @FXML
    private void okBtn(ActionEvent event) {
        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");



            // Tietokantaan opiskelijat taulun luova koodi
          //  dbConnection.createTable(conn, "CREATE TABLE opiskelijat (" +
          //         "opiskelija_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
          //          "Etunimi VARCHAR(50) NOT NULL," +
          //          "Sukunimi VARCHAR(50) NOT NULL," +
          //          "Sähköposti VARCHAR(100) NOT NULL," +
          //          "Puhelin VARCHAR(20)," +
          //          "Koulutusala VARCHAR(50) NOT NULL)"
          //  );

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO opiskelijat(Etunimi, Sukunimi, Sähköposti, Puhelin, Koulutusala)"
                            + "VALUES (?, ?, ?, ?, ?)"

            );

            String stdName = nameField.getText();
            String stdSurname = surnameField.getText();
            String stdEmail = emailField.getText();
            String stdPhone = phoneField.getText();
            String stdField = fieldField.getText();

            ps.setString(1, stdName);
            ps.setString(2, stdSurname);
            ps.setString(3, stdEmail);
            ps.setString(4, stdPhone);
            ps.setString(5, stdField);
            ps.execute();
            System.out.println("\t >> Lisätty " + stdName);

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Opiskelija lisätty tietorekisteriin!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Mene takaisin aikaisempaan ikkunaan (Hallintapaneeli)
     * @param event Mene takaisin hallintapaneliin
     * @throws IOException openStream poikkeus
     */

    @FXML
    private void backBtn(ActionEvent event) throws IOException {

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
