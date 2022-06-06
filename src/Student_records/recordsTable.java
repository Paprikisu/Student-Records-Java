package Student_records;

/**
 * Suoritustietojen olio
 * @author Miska
 */

public class recordsTable {

    int suoritus_id, opiskelija_id, kurssi_id, arvosana;
    String suoritusPVM;

    /**
     * Konstruktori recordsTable
     * @param suoritus_id suoritus_id
     * @param opiskelija_id opiskelija_id
     * @param kurssi_id kurssi_id
     * @param suoritusPVM suoritusPVM
     * @param arvosana arvosana
     */

    public recordsTable(int suoritus_id, int opiskelija_id, int kurssi_id, String suoritusPVM, int arvosana) {
        this.suoritus_id = suoritus_id;
        this.opiskelija_id = opiskelija_id;
        this.kurssi_id = kurssi_id;
        this.suoritusPVM = suoritusPVM;
        this.arvosana = arvosana;


    }

    /**
     * Palauttaa suorituksen ID:n
     * @return suoritus_id
     */

    public int getSuoritus_id() {
        return suoritus_id;
    }

    /**
     * Palauttaa suorituksen opiskelijan ID:n
     * @return opiskelija_id
     */

    public int getOpiskelija_id() {
        return opiskelija_id;
    }

    /**
     * Palauttaa suoritetun kurssin ID:n
     * @return kurssi_id
     */

    public int getKurssi_id() {
        return kurssi_id;
    }

    /**
     * Palauttaa suorituksen päivämäärän
     * @return suoritusPVM
     */

    public String getSuoritusPVM() {
        return suoritusPVM;
    }

    /**
     * Palauttaa suorituksen arvosanan
     * @return arvosana
     */

    public int getArvosana() {
        return arvosana;
    }


}
