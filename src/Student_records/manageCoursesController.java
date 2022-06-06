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
 * Kurssin tietoja etsivän, muokkaavan ja poistavan FXMl tiedoston controller
 * @author Miska
 */

public class manageCoursesController {


    public TextField courseNameField;
    public TextField pointsField;
    public TextField idField;
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * Etsi kurssi metodi - Etsii kurssin tiedot tietokannasta kurssi_id:n perusteella ja tuo ne esille
     * @param event Etsi kurssin tiedot
     */

    public void searchCourse(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();

            int courseID = Integer.parseInt(idField.getText());

            String sql = "SELECT * FROM kurssit WHERE kurssi_id = '" + courseID + "'";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                courseNameField.setText(rs.getString("Nimi"));
                pointsField.setText(rs.getString("Laajuus"));
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
     * Päivitä kurssin tiedot metodi - Kurssin tietojen etsittyä ne voidaan päivittää tällä metodilla tietokantaan
     * @param event Päivittää kurssin tiedot
     */

    public void updateCourses(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            int courseID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE kurssit SET Nimi = ?, Laajuus = ? WHERE kurssi_id = '" + courseID + "'"

            );

            String crsName = courseNameField.getText();
            String crsPoints = pointsField.getText();

            ps.setString(1, crsName);
            ps.setString(2, crsPoints);
            ps.executeUpdate();
            System.out.println("\t >> Muokattu " + crsName);

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Kurssin tiedot muokattu!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Kurssin tiedot poistava metodi - Kurssin tiedot etsittyä ne voidaan poistaa tällä metodilla tietokannasta
     * @param event Poista kurssin tiedot
     */

    public void deleteCourse(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();
            int courseID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM kurssit WHERE kurssi_id = '" + courseID + "'"


            );
            ps.executeUpdate();

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Kurssin tiedot poistettu!");
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
