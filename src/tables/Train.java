package tables;

public abstract class Train implements Table{
    private String isUnderMaintenance;
    private Integer model;

    public Train(int ID, String isUnderMaintenance, Integer model) {
        this.isUnderMaintenance = isUnderMaintenance;
        this.model = model;
        initializeID(ID);
    }

    public abstract void initializeID (int ID);

    public String getIsUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setIsUnderMaintenance(String isUnderMaintenance) {
        this.isUnderMaintenance = isUnderMaintenance;
    }

    public int getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
