package tables;

public class PassengerTrain extends Train {
    private int passengerTrainID;
    private String isUnderMaintenance;
    private Integer model;

    public PassengerTrain(int passengerTrainID, String isUnderMaintenance, Integer model) {
        super(passengerTrainID, isUnderMaintenance, model);
    }

    @Override
    public void initializeID(int ID) {
        this.passengerTrainID = ID;
    }

    public int getPassengerTrainID() {
        return passengerTrainID;
    }

    public void setPassengerTrainID(int passengerTrainID) {
        this.passengerTrainID = passengerTrainID;
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
