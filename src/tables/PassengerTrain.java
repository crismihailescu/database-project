package tables;

public class PassengerTrain {
    private int passengerTrainID;
    private String isUnderMaintenance;
    private int model;

    public PassengerTrain(int passengerTrainID, String isUnderMaintenance, int model) {
        this.passengerTrainID = passengerTrainID;
        this.isUnderMaintenance = isUnderMaintenance;
        this.model = model;
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

    public void setModel(int model) {
        this.model = model;
    }
}
