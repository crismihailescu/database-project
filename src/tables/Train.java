package tables;

public abstract class Train implements Table{
    private String isUnderMaintenance;
    private Integer modelID;

    public Train(int ID, String isUnderMaintenance, Integer modelID) {
        this.isUnderMaintenance = isUnderMaintenance;
        this.modelID = modelID;
        initializeID(ID);
    }

    public abstract void initializeID (int ID);

    public String getIsUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setIsUnderMaintenance(String isUnderMaintenance) {
        this.isUnderMaintenance = isUnderMaintenance;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModel(Integer modelID) {
        this.modelID = modelID;
    }
}
