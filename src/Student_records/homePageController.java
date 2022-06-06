package Student_records;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hallintapaneelin controller ohjelma
 *
 * @author Miska Nevalainen
 */

public class homePageController {


    /**
     * Kirjaudu ulos metodi - kirjautuu ulos ohjelmasta
     * @param event kirjaudu ulos tapahtuma
     */
    public void SignOut(MouseEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/Student_records/login.fxml").openStream());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Opintorekisteri login");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
            // handle exception
        }


    }

    /**
     * Lisää opiskelija metodi - avaa ikkunan jossa voi lisätä opiskelijan tietorekisteriin
     * @param event avaa lisää opiskelija ikkunan
     * @throws IOException openStream poikkeus
     */

    public void addStudent(ActionEvent event) throws IOException {


        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/Student_records/addStudent.fxml").openStream());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Lisää opiskelija");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Näytä opiskelijat metodi - avaa ikkunan, jossa voi nähdä opiskelijat listassa
     * @param event avaa näytä opiskelijat ikkunan
     * @throws IOException openStream poikkeus
     */

    public void showStudents(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/showStudents.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Opiskelijalista");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * Päivitä tietoja metodi - avaa ikkunan, josta päästään valikkoon jossa päätetään minkä asian tietoja tarkastellaan tai muutetaan
     * @param event avaa valintaikkunan tietojen tarkastelulle tai muuttamiselle
     * @throws IOException openStream poikkeus
     */

    public void updateInfo(ActionEvent event) throws IOException {

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
     * Lisää kurssi metodi - avaa ikkunan jossa voi lisätä kurssin tietorekisteriin
     * @param event avaa lisää kurssi ikkunan
     * @throws IOException openStream poikkeus
     */

    public void addCourse(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/addCourse.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lisää kurssi");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Näytä kurssit metodi - Avaa ikkunan jossa voi nähdä kurssit taulukossa
     * @param event Avaa näe kurssit ikkunan
     * @throws IOException openStream poikkeus
     */

    public void showCourses(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/showCourses.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kurssilista");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Lisää suoritus metodi - Avaa ikkunan, jossa voidaan lisätä suoritus tietorekisteriin
     * @param event Avaa lisää suoritus ikkunan
     * @throws IOException openStream poikkeus
     */

    public void addRecord(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/addRecord.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lisää suoritus");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Näytä suoritukset metodi - Avaa ikkunan, jossa voidaan tarkastella suorituksia taulukossa
     * @param event avaa näe suoritukset ikkunan
     * @throws IOException openStream poikkeus
     */

    public void showRecords(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/showRecords.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Suorituslista");
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
