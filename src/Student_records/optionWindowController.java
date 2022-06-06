package Student_records;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Valitse kahdesta opiskelijan FXML tiedoston controller
 * @author Miska
 */

public class optionWindowController {

    /**
     * Avaa ikkunan, jossa opiskelijoita voi etsiä, muokata ja/tai poistaa
     * @param event Avaa opiskelijoiden editointi ikkunan
     * @throws IOException openStream poikkeus
     */


    public void searchEditBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/manageStudent.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Opiskelijoiden hallinta");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Avaa ikkunan, jossa tietyn opiskelijan suoritukset voidaan listata
     * @param event Avaa opiskelijan suoritusten tarkastelu ikkuna
     * @throws IOException openStream poikkeus
     */

    public void listRecordsBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/searchStudentRecords.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etsi suorituksia");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Menee takaisin valinta ikkunaan
     * @param event Mene takaisin valinta ikkunaan
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
