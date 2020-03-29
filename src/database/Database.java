package database;

import oracle.sql.TIMESTAMP;
import tables.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private static Database instance = null;
    private Connection connection;

    private Database() {
        try {
            String username = "zhentl2z";
            String password = "a25224149";
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(ORACLE_URL, username, password);
        }
        catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.exit(-1);
        }
    }

    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public List<Ticket> viewTicket() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from Ticket";
        ResultSet rs = s.executeQuery(query);

        List<Ticket> t = new ArrayList<>();
        int pd;
        int ti;
        int pr;

        while (rs.next()) {
            pd = rs.getInt("PassengerID");
            ti = rs.getInt("TicketID");
            pr = rs.getInt("Price");
            t.add(new Ticket(ti,pd,pr));
        }

        return t;
    }

    public List<CargoTrain> viewCargoTrain() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from CargoTrain";
        ResultSet rs = s.executeQuery(query);

        List<CargoTrain> ct = new ArrayList<>();
        int cgID;
        String maint;
        int c;

        while (rs.next()) {
            cgID = rs.getInt("CargoTrainID");
            maint = rs.getString("IsUnderMaintenance");
            c = rs.getInt("Model");
            ct.add(new CargoTrain(cgID,maint,c));
        }

        return ct;
    }

    public List<PassengerTrain> viewPassengerTrain() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from PassengerTrain";
        ResultSet rs = s.executeQuery(query);

        List<PassengerTrain> pt = new ArrayList<>();
        int pgID;
        String maint;
        int c;

        while (rs.next()) {
            pgID = rs.getInt("PassengerTrainID");
            maint = rs.getString("IsUnderMaintenance");
            c = rs.getInt("Model");
            pt.add(new PassengerTrain(pgID,maint,c));
        }

        return pt;
    }

    public List<CargoShipment> viewCargoShipment() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from CargoShipment";
        ResultSet rs = s.executeQuery(query);

        List<CargoShipment> cs = new ArrayList<>();
        int sID;
        String type;
        int cID;

        while (rs.next()) {
            sID = rs.getInt("ShipmentID");
            type = rs.getString("CargoType");
            cID = rs.getInt("CargoID");
            cs.add(new CargoShipment(sID, cID, type));
        }

        return cs;
    }

    public List<Arrival> viewArrival() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from Arrival";
        ResultSet rs = s.executeQuery(query);

        List<Arrival> a = new ArrayList<>();
        int pID;
        int cID;
        Timestamp time;
        String location;
        String d;

        while (rs.next()) {
            pID = rs.getInt("PassengerTrainID");
            cID = rs.getInt("CargoTrainID");
            time = rs.getTimestamp("ArrivalTime");
            location = rs.getString("LocationID");
            d = rs.getString("IsDelayed");
            a.add(new Arrival(pID, cID, time, location, d));
        }

        return a;
    }

    public List<Departure> viewDeparture() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from Departure";
        ResultSet rs = s.executeQuery(query);

        List<Departure> a = new ArrayList<>();
        int pID;
        int cID;
        Timestamp time;
        String location;
        String d;

        while (rs.next()) {
            pID = rs.getInt("PassengerTrainID");
            cID = rs.getInt("CargoTrainID");
            time = rs.getTimestamp("DepartureTime");
            location = rs.getString("LocationID");
            d = rs.getString("IsDelayed");
            a.add(new Departure(pID, cID, time, location, d));
        }

        return a;
    }

    public List<Technician> viewTechnician() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from Technician";
        ResultSet rs = s.executeQuery(query);

        List<Technician> t = new ArrayList<>();
        int ID;
        String name;

        while (rs.next()) {
            ID = rs.getInt("TechnicianID");
            name = rs.getString("TechnicianName");
            t.add(new Technician(ID, name));
        }

        return t;
    }

    public List<Conductor> viewConductor() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select * from Conductor";
        ResultSet rs = s.executeQuery(query);

        List<Conductor> c = new ArrayList<>();
        int ID;
        String name;

        while (rs.next()) {
            ID = rs.getInt("ConductorID");
            name = rs.getString("ConductorName");
            c.add(new Conductor(ID, name));
        }

        return c;
    }
}
