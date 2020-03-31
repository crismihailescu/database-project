package tables;

public class Accesses implements Table {
    int passengerTrainID;
    int ticketID;

    public Accesses(int passengerTrainID, int ticketID) {
        this.passengerTrainID = passengerTrainID;
        this.ticketID = ticketID;
    }

    public int getPassengerTrainID() {
        return passengerTrainID;
    }

    public void setPassengerTrainID(int passengerTrainID) {
        this.passengerTrainID = passengerTrainID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
}
