package tables;

public class Conductor implements Table {
    private int conductorID;
    private String conductorName;

    public Conductor(int conductorID, String conductorName) {
        this.conductorID = conductorID;
        this.conductorName = conductorName;
    }

    public int getConductorID() {
        return conductorID;
    }

    public void setConductorID(int conductorID) {
        this.conductorID = conductorID;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }
}
