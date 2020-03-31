package tables;

public class Technician implements Table{
    private int technicianID;
    private String technicianName;

    public Technician(int technicianID, String technicianName) {
        this.technicianID = technicianID;
        this.technicianName = technicianName;
    }

    public int getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
}
