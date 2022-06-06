package Student_records;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Valitse kahdesta kurssin vaihtoehdosta FXMl tiedoston controller
 * @author Miska
 */

public class optionWindowCoursesController {

    /**
     * Avaa ikkunan jossa kursseja voi etsiä, muokata ja poistaa
     * @param event Avaa kurssien editointi ikkunan
     * @throws IOException openStream poikkeus
     */

    public void searchEditBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/manageCourse.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etsi ja muokkaa");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Avaa ikkunan, jossa voi etsiä kurssin kaikki suoritukset
     * @param event Avaa kurssien suoritukset etsintä ikkunan
     * @throws IOException openStream poikkeus
     */

    public void listRecordsBtn(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/searchCourseRecords.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etsi kurssin suoritukset");
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
