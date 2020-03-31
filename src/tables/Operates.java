package tables;

public class Operates implements Table{
    int passengerTrainID;
    int cargoTrainID;
    int conductorID;

    public Operates(int passengerTrainID, int cargoTrainID, int conductorID) {
        this.passengerTrainID = passengerTrainID;
        this.cargoTrainID = cargoTrainID;
        this.conductorID = conductorID;
    }

    public int getPassengerTrainID() {
        return passengerTrainID;
    }

    public void setPassengerTrainID(int passengerTrainID) {
        this.passengerTrainID = passengerTrainID;
    }

    public int getCargoTrainID() {
        return cargoTrainID;
    }

    public void setCargoTrainID(int cargoTrainID) {
        this.cargoTrainID = cargoTrainID;
    }

    public int getConductorID() {
        return conductorID;
    }

    public void setConductorID(int conductorID) {
        this.conductorID = conductorID;
    }
}
