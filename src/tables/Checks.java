package tables;

public class Checks implements Table {
    int ticketID;
    int conductorID;

    public Checks(int ticketID, int conductorID) {
        this.ticketID = ticketID;
        this.conductorID = conductorID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getConductorID() {
        return conductorID;
    }

    public void setConductorID(int conductorID) {
        this.conductorID = conductorID;
    }
}
