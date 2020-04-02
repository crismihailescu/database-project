package tables;

public class PassengerTrain extends Train {
    private int passengerTrainID;
    private String isUnderMaintenance;
    private Integer modelID;

    public PassengerTrain(int passengerTrainID, String isUnderMaintenance, Integer modelID) {
        super(passengerTrainID, isUnderMaintenance, modelID);
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

}
