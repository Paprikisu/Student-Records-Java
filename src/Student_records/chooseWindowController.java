package Student_records;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class chooseWindowController {

    /**
     * Menee takaisin hallintapaneeli ikkunaan
     * @param event Mene takaisin hallintapaneeli ikkunaan
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

    /**
     * Avaa ikkunan, josta opiskelijan tietoja voidaan etsiä ja päivittää
     * @param event Avaa opiskelijan editointi ikkunan
     * @throws IOException openStream poikkeus
     */


    public void updateStudents(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/optionWindow.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Valitse...");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Avaa ikkunan, josta suoritusten tietoja voidaan etsiä ja päivittää
     * @param event Avaa suoritusten editointi ikkunan
     * @throws IOException openStream poikkeus
     */



    public void updateRecords(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/manageRecord.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Suoritusten hallinta");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    /**
     * Avaa ikkunan, josta kurssin tietoja voidaan etsiä ja päivittää
     * @param event Avaa kurssin editointi ikkunan
     * @throws IOException openStream poikkeus
     */

    public void updateCourses(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/Student_records/optionWindowCourses.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Valitse...");
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
