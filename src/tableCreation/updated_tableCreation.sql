drop table Model;
drop table CargoTrain;
drop table PassengerTrain;
drop table CargoType;
drop table Technician;
drop table Conductor;
drop table Purchaser;
drop table Passenger;
drop table Ticket;
drop table Arrival;
drop table Departure;
drop table Maintains;
drop table Operates;
drop table Checks;
drop table Accesses;
drop table Boards;
drop table CargoShipment;

CREATE TABLE Model(
    ModelID INTEGER PRIMARY KEY,
    CargoCapacity INTEGER,
    PassengerCapacity INTEGER
    );

CREATE TABLE CargoTrain(
    CargoTrainID INTEGER PRIMARY KEY,
    IsUnderMaintenance CHAR(5) NOT NULL,
    ModelID INTEGER NOT NULL,
    FOREIGN KEY (ModelID) REFERENCES Model ON DELETE SET NULL
    );

CREATE TABLE PassengerTrain(
    PassengerTrainID INTEGER PRIMARY KEY,
    IsUnderMaintenance CHAR(5) NOT NULL,
    ModelID INTEGER NOT NULL,
    FOREIGN KEY (ModelID) REFERENCES Model ON DELETE SET NULL
    );

CREATE TABLE CargoType(
    CargoType CHAR(20) PRIMARY KEY,
    SpecialConsiderations CHAR(20) NOT NULL
    );

CREATE TABLE Technician(
    TechnicianID INTEGER PRIMARY KEY,
    TechnicianName CHAR(20) NOT NULL
    );

CREATE TABLE Conductor(
    ConductorID INTEGER PRIMARY KEY,
    ConductorName CHAR(20) NOT NULL
    );

CREATE TABLE Purchaser(
    PurchaserID INTEGER PRIMARY KEY,
    PurchaserName CHAR(20) NOT NULL
    );

CREATE TABLE Passenger(
    PassengerID INTEGER PRIMARY KEY,
    Name CHAR(20) NOT NULL,
    DateOfBirth DATE NOT NULL
    );

CREATE TABLE Ticket(
    TicketID INTEGER PRIMARY KEY,
    Price INTEGER NOT NULL,
    PassengerID INTEGER NOT NULL,
    FOREIGN KEY (PassengerID) references Passenger ON DELETE CASCADE
);

CREATE TABLE Arrival(
    CargoTrainID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    ArrivalTime TIMESTAMP NOT NULL,
    LocationID CHAR(5) NOT NULL,
    IsDelayed CHAR(5) NOT NULL,
    PRIMARY KEY (CargoTrainID, PassengerTrainID, ArrivalTime, LocationID),
    FOREIGN KEY (CargoTrainID) REFERENCES CargoTrain ON DELETE SET NULL,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE SET NULL
    );

CREATE TABLE Departure(
    CargoTrainID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    DepartureTime TIMESTAMP NOT NULL,
    LocationID CHAR(5) NOT NULL,
    IsDelayed CHAR(5) NOT NULL,
    PRIMARY KEY (CargoTrainID, PassengerTrainID, DepartureTime, LocationID),
    FOREIGN KEY (CargoTrainID) REFERENCES CargoTrain ON DELETE CASCADE ,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE
);

CREATE TABLE Maintains(
    TechnicianID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    CargoTrainID INTEGER NOT NULL,
    PRIMARY KEY (TechnicianID, PassengerTrainID, CargoTrainID),
    FOREIGN KEY (TechnicianID) references Technician ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) references PassengerTrain ON DELETE CASCADE,
    FOREIGN KEY (CargoTrainID) references CargoTrain ON DELETE CASCADE
    );

CREATE TABLE Operates(
    CargoTrainID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    ConductorID INTEGER NOT NULL,
    PRIMARY KEY (ConductorID, PassengerTrainID, CargoTrainID),
    FOREIGN KEY (ConductorID) references Conductor ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) references PassengerTrain ON DELETE CASCADE,
    FOREIGN KEY (CargoTrainID) references CargoTrain ON DELETE CASCADE
    );

CREATE TABLE Checks(
    TicketID INTEGER NOT NULL,
    ConductorID INTEGER NOT NULL,
    PRIMARY KEY (TicketID, ConductorID),
    FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,
    FOREIGN KEY (ConductorID) REFERENCES Conductor ON DELETE CASCADE
    );

CREATE TABLE Accesses(
    TicketID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    PRIMARY KEY (TicketID, PassengerTrainID),
    FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE
    );

CREATE TABLE Boards(
    PassengerID INTEGER NOT NULL,
    PassengerTrainID INTEGER NOT NULL,
    PRIMARY KEY (PassengerID, PassengerTrainID),
    FOREIGN KEY (PassengerID) REFERENCES Passenger ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE
    );

CREATE TABLE CargoShipment(
    ShipmentID INTEGER PRIMARY KEY,
    PurchaserID INTEGER NOT NULL,
    CargoType CHAR(20) NOT NULL,
    FOREIGN KEY (PurchaserID) REFERENCES Purchaser,
    FOREIGN KEY (CargoType) REFERENCES CargoType
    );


insert into Model
values('101', '50', '0');

insert into Model
values('102', '75', '0');

insert into Model
values('103', '100', '0');

insert into Model
values('104', '80', '0');

insert into Model
values('105', '0', '120');

insert into Model
values('106', '0', '250');

insert into Model
values('107', '0', '500');

insert into Model
values('108', '0', '400');

insert into Model
values('0', '0', '0');

insert into CargoTrain
values('0', 'NA', '0');

insert into CargoTrain
values('1', 'Yes', '101');

insert into CargoTrain
values('2', 'No', '102');

insert into CargoTrain
values('3', 'No', '103');

insert into CargoTrain
values('4', 'Yes', '103');

insert into CargoTrain
values('5', 'No', '104');

insert into PassengerTrain
values('0', 'NA', '0');

insert into PassengerTrain
values('6', 'No', '105');

insert into PassengerTrain
values('7', 'No', '106');

insert into PassengerTrain
values('8', 'No', '107');

insert into PassengerTrain
values('9', 'No', '106');

insert into PassengerTrain
values('10', 'No', '108');

insert into CargoType
values('Produce', 'Delicate');

insert into CargoType
values('Furniture', 'Heavy');

insert into CargoType
values('Glass', 'Fragile');

insert into CargoType
values('Oil and Gas', 'Explosive');

insert into CargoType
values('Frozen Foods', 'Prone to leakage');

insert into CargoType
values('Electronics', 'Shock Possible');

insert into Technician
values('1', 'Miguel Torrez');

insert into Technician
values('2', 'Jean-Jacques Ruee');

insert into Technician
values('3', 'Jon Bon Jovi');

insert into Technician
values('4', 'Bluth Corleone');

insert into Technician
values('5', 'Fernando Alonso');

insert into Conductor
values('1', 'Boris');

insert into Conductor
values('2', 'Tariq');

insert into Conductor
values('3', 'Bryce');

insert into Conductor
values('4', 'Brianne');

insert into Conductor
values('5', 'Xi');

insert into Purchaser
values('1', 'Arlene');

insert into Purchaser
values('2', 'Tanisha');

insert into Purchaser
values('3', 'Satchee');

insert into Purchaser
values('4', 'Christopher');

insert into Purchaser
values('5', 'Sahand');

insert into Passenger
values('1', 'Alan', '12-DEC-80');

insert into Passenger
values('2', 'Abigaile', '20-OCT-81');

insert into Passenger
values('3', 'Miguel', '30-MAY-99');

insert into Passenger
values('4', 'Xiao', '12-JAN-95');

insert into Passenger
values('5', 'Mohammad', '19-AUG-01');

insert into Ticket
values('1', '90', '1');

insert into Ticket
values('2', '40', '1');

insert into Ticket
values('3', '30', '2');

insert into Ticket
values('4', '60', '3');

insert into Ticket
values('5', '100', '4');

insert into Ticket
values('6', '65', '5');

insert into Arrival
values('1', '0', '04-APR-19 02:05:00.00', 'YVR', 'YES');

insert into Arrival
values('2', '0', '06-APR-19 05:05:00.00', 'LAX', 'NO');

insert into Arrival
values('0', '6', '04-APR-19 02:05:00.00', 'YVR', 'YES');

insert into Arrival
values('0', '7', '05-APR-19 02:05:00.00', 'YVR', 'NO');

insert into Arrival
values('0', '9', '07-APR-19 02:05:00.00', 'YVR', 'YES');

insert into Arrival
values('0', '10', '08-APR-19 02:05:00.00', 'YVR', 'NO');

insert into Arrival
values('0', '6', '06-APR-19 02:05:00.00', 'LAX', 'NO');

insert into Arrival
values('0', '6', '08-APR-19 02:05:00.00', 'NYC', 'NO');

insert into Arrival
values('0', '8', '06-APR-19 10:45:00.00', 'YVR', 'YES');

insert into Arrival
values('0', '6', '10-APR-19 02:05:00.00', 'CGY', 'NO');

insert into Arrival
values('5', '0', '05-APR-19 01:05:00.00', 'NYC', 'NO');

insert into Departure
values('1', '0', '04-APR-19 05:05:00.00', 'YVR', 'YES');

insert into Departure
values('0', '6', '03-APR-19 12:05:00.00', 'LAX', 'NO');

insert into Departure
values('0', '7', '04-APR-19 05:05:00.00', 'YYZ', 'NO');

insert into Departure
values('4', '0', '04-APR-19 11:20:00.00', 'NYC', 'NO');

insert into Departure
values('5', '0', '04-APR-19 11:55:00.00', 'CGY', 'NO');

insert into Maintains
values('1', '6', '0');

insert into Maintains
values('2', '8', '0');

insert into Maintains
values('3', '0', '2');

insert into Maintains
values('4', '0', '5');

insert into Maintains
values('5', '10', '0');

insert into Operates
values('0', '6', '1');

insert into Operates
values('0', '8', '2');

insert into Operates
values('1', '0', '3');

insert into Operates
values('3', '0', '4');

insert into Operates
values('0', '10', '5');

insert into Checks
values('4', '1');

insert into Checks
values('1', '5');

insert into Checks
values('2', '5');

insert into Checks
values('4', '2');

insert into Checks
values('5', '4');

insert into Accesses
values('3', '6');

insert into Accesses
values('3', '7');

insert into Accesses
values('3', '8');

insert into Accesses
values('3', '9');

insert into Accesses
values('3', '10');

insert into Accesses
values('6', '7');

insert into Accesses
values('2', '7');

insert into Accesses
values('2', '8');

insert into Accesses
values('2', '9');

insert into Accesses
values('2', '10');

insert into Accesses
values('2', '6');

insert into Accesses
values('1', '9');

insert into Accesses
values('4', '10');

insert into Accesses
values('4', '9');

insert into Accesses
values('4', '8');

insert into Accesses
values('4', '7');

insert into Accesses
values('4', '6');

insert into Accesses
values('1', '6');

insert into Accesses
values('1', '7');

insert into Accesses
values('1', '8');

insert into Accesses
values('1', '10');

insert into Boards
values('1', '6');

insert into Boards
values('2', '7');

insert into Boards
values('3', '9');

insert into Boards
values('4', '9');

insert into Boards
values('5', '10');

insert into CargoShipment
values('1', '1', 'Produce');

insert into CargoShipment
values('2', '2', 'Produce');

insert into CargoShipment
values('3', '3', 'Furniture');

insert into CargoShipment
values('4', '3', 'Oil and Gas');

insert into CargoShipment
values('5', '4', 'Glass');