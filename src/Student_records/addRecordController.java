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

/**
 * Lisää suoritus FXML tiedoston controller
 * @author Miska
 */

public class addRecordController {


    public TextField studentIDField;
    public TextField courseIDField;
    public TextField dateField;
    public TextField gradeField;

    /**
     * Lisää suoritus metodi - Lisää tietorekisteriin käyttäjän syöttämän suorituksen ja ilmoittaa käyttäjälle onnistuneen
     * @param event  Lisää tietorekisteriin suorituksen
     */

    public void okBtn(ActionEvent event) {


        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            // Tietokantaan suoritukset taulun luova koodi
        //    dbConnection.createTable(conn, "CREATE TABLE suoritukset (" +
        //            "suoritus_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
        //            "opiskelija_id INT," +
        //            "kurssi_id INT," +
        //            "suoritusPVM DATE," +
        //            "arvosana INT NOT NULL," +
        //            "FOREIGN KEY (opiskelija_id) REFERENCES opiskelijat(opiskelija_id)," +
        //            "FOREIGN KEY (kurssi_id) REFERENCES kurssit(kurssi_id))"
        //    );


            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO suoritukset(opiskelija_id, kurssi_id, suoritusPVM, arvosana)"
                            + "VALUES (?, ?, ?, ?)"

            );

            String stdID = studentIDField.getText();
            String crsID = courseIDField.getText();
            String rcdDate = dateField.getText();
            String crsGrade = gradeField.getText();

            ps.setString(1, stdID);
            ps.setString(2, crsID);
            ps.setString(3, rcdDate);
            ps.setString(4, crsGrade);
            ps.execute();
            System.out.println("\t >> Lisätty suoritus ");

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Suoritus lisätty tietorekisteriin!");
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
