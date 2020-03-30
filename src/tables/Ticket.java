package tables;

public class Ticket implements Table {
    private int TicketID;
    private int PassengerID;
    private int Price;

    public Ticket(int ticketID, int passengerID, int price) {
        TicketID = ticketID;
        PassengerID = passengerID;
        Price = price;
    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int ticketID) {
        TicketID = ticketID;
    }

    public int getPassengerID() {
        return PassengerID;
    }

    public void setPassengerID(int passengerID) {
        PassengerID = passengerID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
