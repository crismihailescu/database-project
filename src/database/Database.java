package database;

import tables.*;

import java.sql.*;
import java.util.*;

public class Database {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static Database instance = null;
    private Connection connection;

    private Database() {
        try {
            String username = "ora_cmihaile";
            String password = "a50835842";
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
            c = rs.getInt("ModelID");
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
        int m;

        while (rs.next()) {
            pgID = rs.getInt("PassengerTrainID");
            maint = rs.getString("IsUnderMaintenance");
            m = rs.getInt("ModelID");
            pt.add(new PassengerTrain(pgID,maint,m));
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
            cID = rs.getInt("PurchaserID");
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

    public boolean deleteTicket(int ticketID) throws SQLException{
        Statement s = connection.createStatement();
        String query = "delete from Ticket t where t.ticketID = " + ticketID;
        int result = s.executeUpdate(query);
        return result == 1;
    }

    public boolean insertPassengerTrain(int PassengerTrainID, String isUnderMaintenance, Integer model) throws SQLException {
        Statement s = connection.createStatement();
        String query;

        if (model == null) {
            query = "insert into PassengerTrain values(" + PassengerTrainID+ ",'" + isUnderMaintenance + "',null)";
        } else {
            query = "insert into PassengerTrain values(" + PassengerTrainID + ",'" + isUnderMaintenance + "'," + model + ")";
        }

        int result = s.executeUpdate(query);
        return result == 1;
    }

    public boolean insertCargoTrain(int CargoTrainID, String isUnderMaintenance, Integer model) throws SQLException {
        Statement s = connection.createStatement();
        String query;

        if (model == null) {
            query = "insert into CargoTrain values(" + CargoTrainID + ",'" + isUnderMaintenance + "',null')";
        } else {
            query = "insert into CargoTrain values(" + CargoTrainID + ",'" + isUnderMaintenance + "', " + model + ")";
        }

        int result = s.executeUpdate(query);
        return result == 1;
    }

    public boolean updateCargoShipment(int ID, String type) throws SQLException{
        Statement s = connection.createStatement();
        String query = "update CargoShipment set CargoType = '" + type + "' where ShipmentID = " + ID;
        int result = s.executeUpdate(query);
        return result == 1;
    }

    public List<Pair<Integer, Integer>> filterPrice(int p) throws SQLException{
        Statement s = connection.createStatement();
        String query = "select t.TicketID, t.Price from Ticket t where t.price < " + p;
        ResultSet rs = s.executeQuery(query);

        List<Pair<Integer, Integer>> tickets = new ArrayList<>();
        int id;
        int pr;
        while (rs.next()) {
            id = rs.getInt("TicketID");
            pr = rs.getInt("Price");
            tickets.add(new Pair<>(id, pr));
        }
        return tickets;
    }

    public List<Integer> projectIntArrivals() throws SQLException{
        Statement s = connection.createStatement();
        String query = "select CargoTrainID, PassengerTrainID from Arrival";
        ResultSet rs = s.executeQuery(query);

        List<Integer> temp = new ArrayList<>();

        while(rs.next()) {
            int id = rs.getInt("CargoTrainID");
            int id2 = rs.getInt("PassengerTrainID");
            if (id == 0) {
                temp.add(id2);
            } else {
                temp.add(id);
            }
        }
        return temp;
    }

    public List<String> projectStrArrivals(String column) throws SQLException{
        Statement s = connection.createStatement();
        String query = "select " + column + " from Arrival";
        ResultSet rs = s.executeQuery(query);

        List<String> temp = new ArrayList<>();

        while(rs.next()) {
            String st = rs.getString(column);
            temp.add(st);
        }
        return temp;
    }

    public List<Timestamp> projectTSArrivals(String column) throws SQLException{
        Statement s = connection.createStatement();
        String query = "select " + column + " from Arrival";
        ResultSet rs = s.executeQuery(query);

        List<Timestamp> temp = new ArrayList<>();

        while(rs.next()) {
            Timestamp st = rs.getTimestamp(column);
            temp.add(st);
        }
        return temp;
    }

    public List<Triplet<Integer, Timestamp, Timestamp>> joinArrivalDeparture (String location) throws SQLException {
        Statement s = connection.createStatement();
        String query = "select a.PassengerTrainID, a.CargoTrainID, a.ArrivalTime, d.DepartureTime from Arrival a, " +
                "Departure d where a.PassengerTrainID = d.PassengerTrainID AND a.CargoTrainID = d.CargoTrainID " +
                "AND a.LocationID = '" + location + "' AND d.locationID = '" + location + "'";
        ResultSet rs = s.executeQuery(query);

        List<Triplet<Integer, Timestamp, Timestamp>> joinAD = new ArrayList<>();

        int ct;
        int pt;
        Timestamp a;
        Timestamp d;

        while (rs.next()) {
            ct = rs.getInt("CargoTrainID");
            pt = rs.getInt("PassengerTrainID");
            a = rs.getTimestamp("ArrivalTime");
            d = rs.getTimestamp("DepartureTime");
            if (ct == 0) {
                joinAD.add(new Triplet<>(pt, a, d));
            } else {
                joinAD.add(new Triplet<>(ct, a ,d));
            }
        }
        return joinAD;
    }

    public int numberTechnicians() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select COUNT(TechnicianID) AS NumberTechnicians from Technician";
        ResultSet rs = s.executeQuery(query);

        int a = 0;
        while (rs.next()) {
            a = rs.getInt("NumberTechnicians");
        }
        return a;
    }

    public int avgPassengerCapacity() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select AVG(TicketCount) as average from (select COUNT(*) as TicketCount, PassengerTrainID " +
                "from Accesses a group by a.PassengerTrainID)";
        ResultSet rs = s.executeQuery(query);

        int avg = 0;
        while (rs.next()) {
            avg = rs.getInt("average");
        }
        return avg;
    }

    public List<String> locationHasAllTrains() throws SQLException {
        Statement s = connection.createStatement();
        String query = "select distinct a.locationid from arrival a where NOT EXISTS " +
                "(select p.passengertrainid from passengertrain p where NOT EXISTS " +
                "(select a2.passengertrainid from arrival a2 where a2.passengertrainid" +
                " = p.passengertrainid and a2.locationid = a.locationid))";
        ResultSet rs = s.executeQuery(query);

        List<String> result = new ArrayList<>();
        String str;

        while(rs.next()) {
            str = rs.getString("LocationID");
            result.add(str);
        }
        return result;
    }
}
