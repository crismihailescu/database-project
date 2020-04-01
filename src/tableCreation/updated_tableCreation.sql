drop table CargoTrain;
drop table Model;
drop table PassengerTrain;
drop table CargoShipment;
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

CREATE TABLE Model(
    ModelID INTEGER PRIMARY KEY,
    CargoCapacity INTEGER,
    PassengerCapacity INTEGER
    );

CREATE TABLE CargoTrain(
    CargoTrainID INTEGER PRIMARY KEY,
    IsUnderMaintenance CHAR(3),
    ModelID INTEGER,
    FOREIGN KEY (ModelID) REFERENCES Model ON DELETE SET NULL
    );

CREATE TABLE PassengerTrain(
    PassengerTrainID INTEGER PRIMARY KEY,
    IsUnderMaintenance CHAR(3),
    ModelID INTEGER,
    FOREIGN KEY (ModelID) REFERENCES Model ON DELETE SET NULL
    );

CREATE TABLE CargoType(
    CargoType CHAR(20) PRIMARY KEY,
    SpecialConsiderations CHAR(20)
    );

CREATE TABLE Technician(
    TechnicianID INTEGER PRIMARY KEY,
    TechnicianName CHAR(20)
    );

CREATE TABLE Conductor(
    ConductorID INTEGER PRIMARY KEY,
    ConductorName CHAR(20)
    );

CREATE TABLE Purchaser(
    PurchaserID INTEGER PRIMARY KEY,
    PurchaserName CHAR(20)
    );

CREATE TABLE Passenger(
    PassengerID INTEGER PRIMARY KEY,
    Name CHAR(20),
    DateOfBirth DATE
    );

CREATE TABLE Ticket(
    TicketID INTEGER PRIMARY KEY,
    Price INTEGER,
    PassengerID INTEGER,
    FOREIGN KEY (PassengerID) references Passenger ON DELETE CASCADE
);

CREATE TABLE Arrival(
    CargoTrainID INTEGER,
    PassengerTrainID INTEGER,
    ArrivalTime TIMESTAMP,
    LocationID CHAR(3),
    IsDelayed CHAR(3),
    PRIMARY KEY (CargoTrainID, PassengerTrainID, ArrivalTime, LocationID)
    );

CREATE TABLE Departure(
    CargoTrainID INTEGER,
    PassengerTrainID INTEGER,
    DepartureTime TIMESTAMP,
    LocationID CHAR(3),
    IsDelayed CHAR(3),
    PRIMARY KEY (CargoTrainID, PassengerTrainID, DepartureTime, LocationID)
    );

CREATE TABLE Maintains(
    TechnicianID INTEGER,
    PassengerTrainID INTEGER,
    CargoTrainID INTEGER,
    PRIMARY KEY (TechnicianID, PassengerTrainID, CargoTrainID),
    FOREIGN KEY (TechnicianID) references Technician ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) references PassengerTrain ON DELETE CASCADE,
    FOREIGN KEY (CargoTrainID) references CargoTrain ON DELETE CASCADE
    );

CREATE TABLE Operates(
    CargoTrainID INTEGER,
    PassengerTrainID INTEGER,
    ConductorID INTEGER,
    PRIMARY KEY (ConductorID, PassengerTrainID, CargoTrainID),
    FOREIGN KEY (ConductorID) references Conductor ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) references PassengerTrain ON DELETE CASCADE,
    FOREIGN KEY (CargoTrainID) references CargoTrain ON DELETE CASCADE
    );

CREATE TABLE Checks(
    TicketID INTEGER,
    ConductorID INTEGER,
    PRIMARY KEY (TicketID, ConductorID),
    FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,
    FOREIGN KEY (ConductorID) REFERENCES Conductor ON DELETE CASCADE
    );

CREATE TABLE Accesses(
    TicketID INTEGER,
    PassengerTrainID INTEGER,
    PRIMARY KEY (TicketID, PassengerTrainID),
    FOREIGN KEY (TicketID) REFERENCES Ticket ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE
    );

CREATE TABLE Boards(
    PassengerID INTEGER,
    PassengerTrainID INTEGER,
    PRIMARY KEY (PassengerID, PassengerTrainID),
    FOREIGN KEY (PassengerID) REFERENCES Passenger ON DELETE CASCADE,
    FOREIGN KEY (PassengerTrainID) REFERENCES PassengerTrain ON DELETE CASCADE
    );

CREATE TABLE CargoShipment(
    ShipmentID INTEGER PRIMARY KEY,
    PurchaserID INTEGER,
    CargoType CHAR(20),
    FOREIGN KEY (PurchaserID) REFERENCES Purchaser,
    FOREIGN KEY (CargoType) REFERENCES CargoType
    );

insert into Departure
values('0', '1', '04-APR-19 05:05:00.00', 'YVR', 'YES');

insert into Departure
values('6', '0', '03-APR-19 18:05:00.00', 'LAX', 'NO');

insert into Departure
values('7', '0', '04-APR-19 05:05:00.00', 'YYZ', 'NO');

insert into Departure
values('0', '4', '04-APR-19 11:20:00.00', 'NYC', 'NO');

insert into Departure
values('0', '5', '04-APR-19 17:55:00.00', 'CGY', 'NO');

insert into Arrival
values('0', '1', '04-APR-19 02:05:00.00', 'YVR', 'YES');

insert into Arrival
values('0', '2', '06-APR-19 05:05:00.00', 'LAX', 'NO');

insert into Arrival
values('6', '0', '04-APR-19 14:05:00.00', 'YVR', 'NO');

insert into Arrival
values('8', '0', '04-APR-19 19:45:00.00', 'LAX', 'YES');

insert into Arrival
values('0', '5', '05-APR-19 01:05:00.00', 'NYC', 'NO');

insert into Passenger
values('1', 'Alan', '1980-12-12');

insert into Passenger
values('2', 'Abigaile', '1981-02-20');

insert into Passenger
values('3', 'Miguel', '1999-05-30');

insert into Passenger
values('4', 'Xiao', '1995-01-12');

insert into Passenger
values('5', 'Mohammad', '2000-10-19');

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
values('Bulk Goods', 'Prone to leakage');

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
values('6', '7');

insert into Accesses
values('2', '7');

insert into Accesses
values('1', '9');

insert into Accesses
values('4', '10');

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