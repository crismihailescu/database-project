package tables;

import java.sql.Timestamp;

public class Arrival implements Table {
    private int passengerTrainID;
    private int cargoTrainID;
    private Timestamp arrivalTime;
    private String locationID;
    private String isDelayed;

    public Arrival(int passengerTrainID, int cargoTrainID, Timestamp arrivalTime, String locationID, String isDelayed) {
        this.passengerTrainID = passengerTrainID;
        this.cargoTrainID = cargoTrainID;
        this.arrivalTime = arrivalTime;
        this.locationID = locationID;
        this.isDelayed = isDelayed;
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

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(String isDelayed) {
        this.isDelayed = isDelayed;
    }
}
