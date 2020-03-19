package tables;

public class CargoTrain {
    private int cargoTrainID;
    private String isUnderMaintenance;
    private int model;

    public CargoTrain(int cargoTrainID, String isUnderMaintenance, int model) {
        this.cargoTrainID = cargoTrainID;
        this.isUnderMaintenance = isUnderMaintenance;
        this.model = model;
    }

    public int getCargoTrainID() {
        return cargoTrainID;
    }

    public void setCargoTrainID(int cargoTrainID) {
        this.cargoTrainID = cargoTrainID;
    }

    public String getIsUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setIsUnderMaintenance(String isUnderMaintenance) {
        this.isUnderMaintenance = isUnderMaintenance;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}
