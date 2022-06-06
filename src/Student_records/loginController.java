package Student_records;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Sisäänkirjautumis ikkunan login controller
 * @author Miska
 */


public class loginController {

    @FXML
    private Button loginBtn;

    /**
     * Sisäänkirjautumis metodi - Kirjautuu sisään ohjelmaan
     * @param event Kirjaudu sisään
     * @throws IOException openStream poikkeus
     */


    @FXML
    private void login(ActionEvent event) throws IOException {

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
     * Ohjelman sammuttava metodi
     */

    @FXML
    private void exit() {
        System.exit(0);

    }


}
