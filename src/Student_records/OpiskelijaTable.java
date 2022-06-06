package Student_records;

/**
 * Opiskelijatietojen olio
 * @author Miska
 */

public class OpiskelijaTable {


    String Etunimi, Sukunimi, Sahkoposti, Puhelin, Koulutusala;
    int opiskelija_id;

    /**
     * Konstruktori OpiskelijaTable
     * @param opiskelija_id opiskelija_id
     * @param Etunimi Etunimi
     * @param Sukunimi Sukunimi
     * @param Sahkoposti Sähköposti
     * @param Puhelin Puhelin
     * @param Koulutusala Koulutusala
     */

    public OpiskelijaTable(int opiskelija_id, String Etunimi, String Sukunimi, String Sahkoposti, String Puhelin, String Koulutusala) {
        this.opiskelija_id = opiskelija_id;
        this.Etunimi = Etunimi;
        this.Sukunimi = Sukunimi;
        this.Sahkoposti = Sahkoposti;
        this.Puhelin = Puhelin;
        this.Koulutusala = Koulutusala;

    }

    /**
     * Palauttaa opiskelijan ID:n
     * @return opiskelija_id
     */

    public int getOpiskelija_id() {
        return opiskelija_id;
    }

    /**
     * Palauttaa opiskelijan etunimen
     * @return Etunimi
     */

    public String getEtunimi() {
        return Etunimi;
    }

    /**
     * Palauttaa opiskelijan sukunimen
     * @return Sukunimi
     */

    public String getSukunimi() {
        return Sukunimi;
    }

    /**
     * Palauttaa opiskelijan sähköpostin
     * @return Sähköposti
     */

    public String getSahkoposti() {
        return Sahkoposti;
    }

    /**
     * Palauttaa opiskelijan puhelin numeron
     * @return Puhelin
     */

    public String getPuhelin() {
        return Puhelin;
    }

    /**
     * Palauttaa opiskelijan koulutusalan
     * @return Koulutusala
     */

    public String getKoulutusala() {
        return Koulutusala;
    }

}
