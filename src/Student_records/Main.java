/** Käyttöliittymäohjelmointi harjoitustyö - Opintorekisteri
 * Ohjelma on opintorekisteri, jossa käyttäjä voi tarkastellä, lisätä, etsiä ja muokata opiskelijoiden, kurssien ja suoritusten tietoja. Tiedot tallennetaan SQL:n avulla tietokantaan.
 * Pääohjelma
 * (C) Miska Nevalainen
 * PVM : 9.4.2021
 */


package Student_records;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Käynnistä pääikkunan
     * @param primaryStage pääikkuna
     * @throws Exception FXMLloaderin exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Opintorekisteri login");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Käynnistää ohjelman
     * @param args käynnistys
     */


    public static void main(String[] args) {
        launch(args);
    }
}
