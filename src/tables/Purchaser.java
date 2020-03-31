package tables;

public class Purchaser implements Table {
    private int purchaserID;
    private String purchaserName;

    public Purchaser(int purchaserID, String purchaserName) {
        this.purchaserID = purchaserID;
        this.purchaserName = purchaserName;
    }

    public int getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(int purchaserID) {
        this.purchaserID = purchaserID;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }
}
