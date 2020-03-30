package tables;

public class CargoShipment implements Table{
    private int shipmentID;
    private int purchaserID;
    private String cargoType;

    public CargoShipment(int shipmentID, int purchaserID, String cargoType) {
        this.shipmentID = shipmentID;
        this.purchaserID = purchaserID;
        this.cargoType = cargoType;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(int purchaserID) {
        this.purchaserID = purchaserID;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
