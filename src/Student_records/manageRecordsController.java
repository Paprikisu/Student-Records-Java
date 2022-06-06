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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Suoritusten tietoja etsivän, muokkaavan ja poistavan FXML tiedoston controller
 * @author Miska
 */

public class manageRecordsController {


    public TextField studentIDField;
    public TextField courseIDField;
    public TextField dateField;
    public TextField gradeField;
    public TextField idField;
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * Etsi suoritus metodi - Etsii kurssin tiedot tietokannasta suoritus_id:n perusteella ja tuo ne esille
     * @param event Etsi suorituksen tiedot
     */

    public void searchRecord(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();

            int recordID = Integer.parseInt(idField.getText());

            String sql = "SELECT * FROM suoritukset WHERE suoritus_id = '" + recordID + "'";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                studentIDField.setText(rs.getString("opiskelija_id"));
                courseIDField.setText(rs.getString("kurssi_id"));
                dateField.setText(rs.getString("suoritusPVM"));
                gradeField.setText(rs.getString("arvosana"));

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Virhe");
                alert.setHeaderText(null);
                alert.setContentText("Tietoja ei löytynyt");
                alert.showAndWait();
            }

            dbConnection.closeConnection(conn);


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Päivitä suorituksen tiedot metodi - Suorituksen tietojen etsittyä ne voidaan päivittää tällä metodilla tietokantaan
     * @param event Päivittää suorituksen tiedot
     */

    public void updateRecords(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            int recordID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE suoritukset SET opiskelija_id = ?, kurssi_id = ?, suoritusPVM = ?, arvosana = ? WHERE suoritus_id = '" + recordID + "'"

            );

            String stdID = studentIDField.getText();
            String crsID = courseIDField.getText();
            String date = dateField.getText();
            String grade = gradeField.getText();

            ps.setString(1, stdID);
            ps.setString(2, crsID);
            ps.setString(3, date);
            ps.setString(4, grade);
            ps.executeUpdate();
            System.out.println("\t >> Muokattu " + stdID);

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Suorituksen tiedot muokattu!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Suorituksen tiedot poistava metodi - Suorituksen tiedot etsittyä ne voidaan poistaa tällä metodilla tietokannasta
     * @param event Poista suorituksen tiedot
     */

    public void deleteRecord(ActionEvent event) {


        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();
            int recordID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM suoritukset WHERE suoritus_id = '" + recordID + "'"


            );
            ps.executeUpdate();

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Suorituksen tiedot poistettu!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Mene takaisin metodi - Avaa aikaisemman ikkunan
     * @param event Avaa valinta ikkunan
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
}
