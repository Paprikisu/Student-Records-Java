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
 * Opiskelijan tietoja etsivä, muokkaava ja poistava FXML tiedoston controller
 * @author Miska
 */

public class managaStudentsController {

    public TextField idField;
    public TextField nameField;
    public TextField surnameField;
    public TextField emailField;
    public TextField phoneField;
    public TextField fieldField;
    Statement stmt = null;
    ResultSet rs = null;

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

    /**
     * Etsi opiskelija metodi - Etsii opiskelijan tiedot tietokannasta opiskelija_id:n perusteella ja tuo ne esille
     * @param event Etsi opiskelijan tiedot
     */

    public void searchStudent(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();

            int studentID = Integer.parseInt(idField.getText());

            String sql = "SELECT * FROM opiskelijat WHERE opiskelija_id = '" + studentID + "'";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                nameField.setText(rs.getString("Etunimi"));
                surnameField.setText(rs.getString("Sukunimi"));
                emailField.setText(rs.getString("Sähköposti"));
                phoneField.setText(rs.getString("Puhelin"));
                fieldField.setText(rs.getString("Koulutusala"));
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
     * Päivitä opiskelijan tiedot metodi - Opiskelijan tietojen etsittyä ne voidaan päivittää tällä metodilla tietokantaan
     * @param event Päivittää opiskelijan tiedot
     */

    public void updateStudents(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");


            int studentID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE opiskelijat SET Etunimi = ?, Sukunimi = ?, Sähköposti = ?, Puhelin = ?, Koulutusala = ? WHERE opiskelija_id = '" + studentID + "'"

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
            ps.executeUpdate();
            System.out.println("\t >> Muokattu " + stdName);

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Opiskelijan tiedot muokattu!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Opiskelijan tiedot poistava metodi - Opiskelijan tiedot etsittyä ne voidaan poistaa tällä metodilla tietokannasta
     * @param event Poista opiskelijan tiedot
     */

    public void deleteStudent(ActionEvent event) {

        try {
            Connection conn = dbConnection.openConnection("jdbc:mariadb://maria.westeurope.cloudapp.azure.com:"

                    + "3306?user=opiskelija&password=opiskelija1"
            );
            dbConnection.useDatabase(conn, "karelia_miskaneva2006297");

            stmt = conn.createStatement();
            int studentID = Integer.parseInt(idField.getText());

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM opiskelijat WHERE opiskelija_id = '" + studentID + "'"


            );
            ps.executeUpdate();

            dbConnection.closeConnection(conn);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Onnistui");
            alert.setHeaderText(null);
            alert.setContentText("Opiskelijan tiedot poistettu!");
            alert.showAndWait();


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
