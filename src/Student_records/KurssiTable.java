package Student_records;

/**
 * Kurssitietojen olio
 * @author Miska
 */

public class KurssiTable {


    String nimi;
    int kurssi_id, laajuus;


    /**
     * Konstruktori kurssitable
     * @param kurssi_id kurssi_id
     * @param nimi nimi
     * @param laajuus laajuus
     */
    public KurssiTable(int kurssi_id, String nimi, int laajuus) {
        this.kurssi_id = kurssi_id;
        this.nimi = nimi;
        this.laajuus = laajuus;


    }

    /**
     * palauttaa kurssi_id:n
     * @return kurssi_id
     */

    public int getKurssi_id() {
        return kurssi_id;
    }

    /**
     * palauttaa kurssin nimen
     * @return nimi
     */

    public String getNimi() {
        return nimi;
    }

    /**
     * palauttaa kurssin laajuuden
     * @return laajuus
     */

    public int getLaajuus() {
        return laajuus;
    }


}
