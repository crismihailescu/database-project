package tableCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createNewTables {

    public createNewTables() {

        String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
        Connection connection = null;
        Statement stmt = null;
        String tableName;

        public void createPassengerTable() {

            try {
                String username = "zhentl2z";
                String password = "a25224149";
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                connection = DriverManager.getConnection(ORACLE_URL, username, password);

                // Create Passenger Table
                System.out.println("Creating Passenger table in given database...");
                stmt = connection.createStatement();

                String sqlPassenger = "CREATE TABLE Passenger " +
                        "(PassengerID INTEGER PRIMARY KEY, " +
                        " Name CHAR(20), " +
                        " DateOfBirth DATE )";

                stmt.executeUpdate(sqlPassenger);
                System.out.println("Created Passenger table in database...");

                // Create CargoTrain Table
                System.out.println("Creating Passenger table in given database...");
                stmt = connection.createStatement();

                String sqlCargoTrain = "CREATE TABLE CargoTrain " +
                        "(CargoTrainID INTEGER PRIMARY KEY, " +
                        " IsUnderMaintenance CHAR(3), " +
                        " Model INTEGER, )" +
                        "FOREIGN KEY (Model) REFERENCES Model ON DELETE SET NULL )";

                stmt.executeUpdate(sqlCargoTrain);
                System.out.println("Created Passenger table in database...");

                // Create PassengerTrain Table
                System.out.println("Creating Passenger table in given database...");
                stmt = connection.createStatement();

                String sqlPassengerTrain = "CREATE TABLE PassengerTrain " +
                        "(PassengerTrainID INTEGER PRIMARY KEY, " +
                        " IsUnderMaintenance CHAR(3), " +
                        " Model INTEGER, )" +
                        "FOREIGN KEY (Model) REFERENCES Model ON DELETE SET NULL )";

                stmt.executeUpdate(sqlPassengerTrain);
                System.out.println("Created Passenger table in database...");

                // Create Model Table
                System.out.println("Creating Model table in given database...");
                stmt = connection.createStatement();

                String sqlModel = "CREATE TABLE Model " +
                        "(Model INTEGER PRIMARY KEY, " +
                        " CargoCapacity INTEGER, " +
                        " PassengerCapacity INTEGER )";

                stmt.executeUpdate(sqlModel);
                System.out.println("Created Model table in database...");

                // Create CargoShipment Table
                tableName = "CargoShipment";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlCargoShipment = "CREATE TABLE CargoShipment" +
                        "(ShipmentID INTEGER PRIMARY KEY, " +
                        " PurchaserID INTEGER, " +
                        " CargoType CHAR(20), " +
                        "FOREIGN KEY (PurchaserID) REFERENCES PurchaserID," +
                        "FOREIGN KEY (CargoType) REFERENCES CargoType)";

                stmt.executeUpdate(sqlCargoShipment);
                System.out.println("Created "+ tableName +" table in database...");

                // Create CargoType Table
                tableName = "CargoType";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlCargoType = "CREATE TABLE CargoType" +
                        "(CargoType CHAR(20) PRIMARY KEY, " +
                        " SpecialConsiderations CHAR(20), " +
                        " ON DELETE SET NULL)";

                stmt.executeUpdate(sqlCargoType);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Technician Table
                tableName = "Technician";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlTechnician = "CREATE TABLE Technician" +
                        "(TechnicianID INTEGER PRIMARY KEY, " +
                        " TechnicianName CHAR(20))";

                stmt.executeUpdate(sqlTechnician);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Conductor Table
                tableName = "Conductor";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlConductor = "CREATE TABLE Conductor" +
                        "(ConductorID INTEGER PRIMARY KEY, " +
                        " ConductorName CHAR(20))";

                stmt.executeUpdate(sqlConductor);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Purchaser Table
                tableName = "Purchaser";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlPurchaser = "CREATE TABLE Purchaser" +
                        "(PurchaserID INTEGER PRIMARY KEY, " +
                        " PurchaserName CHAR(20))";

                stmt.executeUpdate(sqlPurchaser);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Ticket Table
                tableName = "Ticket";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlTicket = "CREATE TABLE Ticket" +
                        "(TicketID INTEGER PRIMARY KEY, " +
                        " PassengerID INTEGER,"+
                        "Price INTEGER,"+
                        "FOREIGN KEY (PassengerID) REFERENCES Passenger ON DELETE CASCADE)";

                stmt.executeUpdate(sqlTicket);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Arrival Table
                tableName = "Arrival";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlArrival = "CREATE TABLE Arrival" +
                        "(PassengerTrainID INTEGER, " +
                        " CargoTrainID INTEGER,"+
                        "ArrivalTime DATETIME,"+
                        "LocationID CHAR(3),"+
                        "IsDelayed CHAR(3),"+
                        "PRIMARY KEY (PassengerTrainID, CargoTrainID, ArrivalTime, LocationID) )";

                stmt.executeUpdate(sqlArrival);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Departure Table
                tableName = "Departure";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlDeparture = "CREATE TABLE Departure" +
                        "(PassengerTrainID INTEGER, " +
                        " CargoTrainID INTEGER,"+
                        "DepartureTime DATETIME,"+
                        "LocationID CHAR(3),"+
                        "IsDelayed CHAR(3),"+
                        "PRIMARY KEY (PassengerTrainID, CargoTrainID, DepartureTime, LocationID) )";

                stmt.executeUpdate(sqlDeparture);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Maintains Table
                tableName = "Maintains";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlMaintains = "CREATE TABLE Maintains" +
                        "(TechnicianID INTEGER," +
                        " PassengerTrainID INTEGER,"+
                        "CargoTrainID INTEGER,"+
                        "PRIMARY KEY (TechnicianID, PassengerTrainID, CargoTrainID),"+
                        "FOREIGN KEY (TechnicianID) REFERENCES Technician ON DELETE CASCADE,"+
                        "FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE,"+
                        "FOREIGN KEY (CargoTrainID) REFERENCES CargoTrain ON DELETE CASCADE)";

                stmt.executeUpdate(sqlMaintains);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Operates Table
                tableName = "Operates";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlOperates = "CREATE TABLE Operates" +
                        "(PassengerTrainID INTEGER," +
                        "CargoTrainID INTEGER,"+
                        "ConductorID INTEGER,"+
                        "PRIMARY KEY (ConductorID, PassengerTrainID, CargoTrainID),"+
                        "FOREIGN KEY (ConductorID) REFERENCES Conductor ON DELETE CASCADE,"+
                        "FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE,"+
                        "FOREIGN KEY (CargoTrainID) REFERENCES CargoTrain ON DELETE CASCADE)";

                stmt.executeUpdate(sqlOperates);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Checks Table
                tableName = "Checks";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlChecks = "CREATE TABLE Checks" +
                        "(TicketID INTEGER," +
                        "ConductorID INTEGER,"+
                        "PRIMARY KEY (TicketID, ConductorID),"+
                        "FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,"+
                        "FOREIGN KEY (ConductorID) REFERENCES Conductor ON DELETE CASCADE)";

                stmt.executeUpdate(sqlChecks);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Accesses Table
                tableName = "Accesses";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlAccesses = "CREATE TABLE Accesses" +
                        "(PassengerTrainID INTEGER," +
                        "TicketID INTEGER,"+
                        "PRIMARY KEY (TicketID, PassengerTrainID),"+
                        "FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,"+
                        "FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE)";

                stmt.executeUpdate(sqlAccesses);
                System.out.println("Created "+ tableName +" table in database...");

                // Create Boards Table
                tableName = "Boards";
                System.out.println("Creating "+ tableName + " table in given database...");
                stmt = connection.createStatement();

                String sqlBoards = "CREATE TABLE Boards" +
                        "(PassengerID INTEGER," +
                        "PassengerTrainID INTEGER,"+
                        "PRIMARY KEY (PassengerID, PassengerTrainID),"+
                        "FOREIGN KEY (PassengerID) REFERENCES Passenger ON DELETE CASCADE,"+
                        "FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE)";

                stmt.executeUpdate(sqlBoards);
                System.out.println("Created "+ tableName +" table in database...");

            } catch (SQLException e) {
                System.out.println("Message: " + e.getMessage());
                System.exit(-1);
            } finally {
                try {
                    if (stmt != null)
                        connection.close();
                } catch (SQLException se) {
                }
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }
    }
}
