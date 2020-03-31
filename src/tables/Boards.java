package tables;

public class Boards implements Table{
    int passengerTrainID;
    int passengerID;

    public Boards(int passengerTrainID, int passengerID) {
        this.passengerTrainID = passengerTrainID;
        this.passengerID = passengerID;
    }

    public int getPassengerTrainID() {
        return passengerTrainID;
    }

    public void setPassengerTrainID(int passengerTrainID) {
        this.passengerTrainID = passengerTrainID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }
}
