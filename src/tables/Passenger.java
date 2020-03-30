package tables;

import java.sql.Date;

public class Passenger implements Table {
    private int passengerID;
    private String name;
    private Date dateOfBirth;

    public Passenger(int passengerID, String name, Date dateOfBirth) {
        this.passengerID = passengerID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
