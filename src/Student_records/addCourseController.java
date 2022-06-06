package Student_records;

import javafx.event.ActionEvent;
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

/** Lisää opiskelija FXML tiedoston controller
 * @author Miska Nevalainen
 */

public class addCourseController {


    public TextField courseNameField;
    public TextField pointsField;

    /**
     * Lisää kurssi metodi - Lisää tietorekisteriin käyttäjän syöttämät tiedot ja ilmoittaa käyttäjälle onnistuneen
     * @param event lisää kurssin tietokantaan
     */

    public void okBtn(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            // Tietokantaan kurssit taulun luova koodi
        //    dbConnection.createTable(conn, "CREATE TABLE kurssit (" +
        //            "kurssi_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        //            "nimi VARCHAR(50) NOT NULL," +
        //            "laajuus INT NOT NULL)"
        //    );


            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO kurssit(nimi, laajuus)"
                            + "VALUES (?, ?)"

            );

            String courseName = courseNameField.getText();
            String coursePoints = pointsField.getText();

            ps.setString(1, courseName);
            ps.setString(2, coursePoints);
            ps.execute();
            System.out.println("\t >> Lisätty " + courseName + " kurssi");

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Kurssi lisätty tietorekisteriin!");
            alert.showAndWait();


        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VIRHE");
            alert.setHeaderText(null);
            alert.setContentText(String.valueOf(e));
            alert.showAndWait();
        }


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
