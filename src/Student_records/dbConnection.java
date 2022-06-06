package Student_records;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Tietokanta yhteyden luova javaclass sekä tietokannan metodit
 * @author Miska
 */

public class dbConnection {

    /**
     * Tietokantaan yhdistys metodi
     * @param connString Tähän asetataan tietokannan osoite ja kirjautumistiedot
     * @return conn
     * @throws SQLException SQL poikkeus
     */

    public static Connection openConnection(String connString) throws SQLException {
        Connection conn = DriverManager.getConnection(connString);
        System.out.println("\t>> Yhteys ok");

        return conn;
    }

    /**
     * Tietokannan yhteyden sulkeva metodi
     * @param c yhteys muuttuja
     * @throws SQLException SQL poikkeus
     */

    public static void closeConnection(Connection c) throws SQLException {
        if (c != null) {
            c.close();
        }
        System.out.println("\t>> Tietokantayhteys suljettu");
    }

    /**
     * Tietokannan luova ja käyttävä metodi
     * @param c yhteys muuttuja
     * @param db tietokanta muuttuja
     * @throws SQLException SQL poikkeus
     */

    public static void createDatabase(Connection c, String db) throws SQLException {
        Statement stmt = c.createStatement();
        stmt.executeQuery("DROP DATABASE IF EXISTS " + db);
        System.out.println("\t>> Tietokanta" + db + "tuhottu");

        stmt.executeQuery("CREATE DATABASE " + db);
        System.out.println("\t>> Tietokanta " + db + " luotu");

        stmt.executeQuery("USE " + db);
        System.out.println("\t>> Käytetään tietokantaa " + db);
    }

    /**
     * Käytä tietokantaa metodi
     * @param c yhteys muuttuja
     * @param db tietokanta muuttuja (mitä tietokantaa käytetään)
     * @throws SQLException SQL poikkeus
     */

    public static void useDatabase(Connection c, String db) throws SQLException {
        Statement stmt = c.createStatement();
        stmt.executeQuery("USE " + db);
        System.out.println("\t>> Tietokanta käytössä");


    }

    /**
     * Luo tietokantaan taulun metodi
     * @param c yhteys muuttuja
     * @param sql SQL käsky
     * @throws SQLException SQL poikkeus
     */

    public static void createTable(Connection c, String sql) throws SQLException {
        Statement stmt = c.createStatement();
        stmt.executeQuery(sql);
        System.out.println("\t>> Taulu luotu");

    }

}






