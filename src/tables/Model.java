package tables;

public class Model implements Table{
    private int model;
    private int cargoCapacity;
    private int passengerCapacity;

    public Model(int model, int cargoCapacity, int passengerCapacity) {
        this.model = model;
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
