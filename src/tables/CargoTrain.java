package tables;

public class CargoTrain extends Train{
    private int cargoTrainID;

    public CargoTrain(int cargoTrainID, String isUnderMaintenance, Integer modelID) {
        super(cargoTrainID, isUnderMaintenance, modelID);
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
}
