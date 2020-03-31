package tables;

public class CargoTrain extends Train{
    private int cargoTrainID;
    private String isUnderMaintenance;
    private Integer model;

    public CargoTrain(int cargoTrainID, String isUnderMaintenance, Integer model) {
        super(cargoTrainID, isUnderMaintenance, model);
    }

    @Override
    public void initializeID(int ID) {
        this.cargoTrainID = ID;
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

    public void setModel(Integer model) {
        this.model = model;
    }
}
