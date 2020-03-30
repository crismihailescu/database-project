package tables;

public class Maintains implements Table {
    int technicianID;
    int passengerTrainID;
    int cargoTrainID;

    public Maintains(int technicianID, int passengerTrainID, int cargoTrainID) {
        this.technicianID = technicianID;
        this.passengerTrainID = passengerTrainID;
        this.cargoTrainID = cargoTrainID;
    }

    public int getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
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
}
