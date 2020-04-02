import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.Database;

import database.Triplet;
import tables.*;

public class databaseLayout extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField cargoTrainIDTextField;
    private JTextField passengerTrainIDTextField;
    private JTextField modelTextField;
    private JTextField modelTextField1;
    private JComboBox comboBox1;
    private JButton submitCargoTrainButton;
    private JButton submitPassengerTrainButton;
    private JButton submitButton;
    private JTextField passengerIDTextField;
    private JButton submitButton1;
    private JTextField shipmentIDTextField;
    private JComboBox comboBox2;
    private JButton submitButton2;
    private JTextField maxPriceTextField;
    private JButton submitButton3;
    private JComboBox comboBox3;
    private JTextField locationIDTextField;
    private JButton submitButton4;
    private JButton runAggregationQueryButton;
    private JTextField trainIDTextField;
    private JButton submitButton5;
    private JButton runDivisionQueryButton;
    private JComboBox JComboBoxPassenger;
    private JTable tableInsertCargoTrain;
    private JTable tableInsertPassengerTrain;
    private JTable tableUpdateCargoShipment;
    private JTable tableDeleteTicket;
    private JTable tableSelectTicketPrice;
    private JTable tableProjectArrival;
    private JTable tableJoinArrivalDeparture;
    private JTable tableAggregation;
    private JTable tableNestedAggregation;
    private JTable tableDivision;

    public databaseLayout() {
        add(panel1);

        setTitle("Database Panel");
        setSize(1000, 600);

        // Insert CargoTrain Query
        submitCargoTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cargoTrainID = cargoTrainIDTextField.getText();
                String isUnderMaintenanceCargoTrain = (String) comboBox1.getSelectedItem();
                String cargoTrainModel = modelTextField.getText();
                try {
                    if (Database.getInstance().insertCargoTrain(Integer.parseInt(cargoTrainID), isUnderMaintenanceCargoTrain, Integer.parseInt(cargoTrainModel))) {
                        JOptionPane.showMessageDialog(null, "Inserted " + "successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not insert.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    List<CargoTrain> cargoTrainsTable = Database.getInstance().viewCargoTrain();
                    Object cargoTrainJTABLE[][] = new Object[0][0];
                    if (!cargoTrainsTable.isEmpty()) {
                        cargoTrainJTABLE = new Object[cargoTrainsTable.size()][3];
                        Iterator<CargoTrain> iterator = cargoTrainsTable.iterator();
                        CargoTrain cg = null;
                        for (int r = 0; r < cargoTrainsTable.size(); r++) {
                            cg = iterator.next();
                            cargoTrainJTABLE[r][0] = cg.getCargoTrainID();
                            cargoTrainJTABLE[r][1] = cg.getIsUnderMaintenance();
                            cargoTrainJTABLE[r][2] = cg.getModel();
                        }
                    }
                    Object[] cargoTrainColumnNames = {"CargoTrainID", "IsUnderMaintenance", "Model"};
                    tableInsertCargoTrain = new JTable(cargoTrainJTABLE, cargoTrainColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Must enter a number");
                    err.printStackTrace();
                }
            }
        });

        // Insert PassengerTrain Query
        submitPassengerTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerTrainID  = passengerTrainIDTextField.getText();
                String isUnderMaintenancePassengerTrain = (String) JComboBoxPassenger.getSelectedItem();
                String passengerTrainModel = modelTextField1.getText();
                try {
                    if (Database.getInstance().insertPassengerTrain(Integer.parseInt(passengerTrainID), isUnderMaintenancePassengerTrain, Integer.parseInt(passengerTrainModel))) {
                        JOptionPane.showMessageDialog(null, "Inserted " + "successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not insert.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    List<PassengerTrain> passengerTrainsTable = Database.getInstance().viewPassengerTrain();
                    Object passengerTrainJTABLE[][] = new Object[0][0];
                    if (!passengerTrainsTable.isEmpty()) {
                        passengerTrainJTABLE = new Object[passengerTrainsTable.size()][3];
                        Iterator<PassengerTrain> iterator = passengerTrainsTable.iterator();
                        PassengerTrain pg;
                        for (int r = 0; r < passengerTrainsTable.size(); r++) {
                            pg = iterator.next();
                            passengerTrainJTABLE[r][0] = pg.getPassengerTrainID();
                            passengerTrainJTABLE[r][1] = pg.getIsUnderMaintenance();
                            passengerTrainJTABLE[r][2] = pg.getModel();
                        }
                    }
                    Object[] passengerTrainColumnNames = {"PassengerTrainID", "IsUnderMaintenance", "Model"};
                    tableInsertPassengerTrain = new JTable(passengerTrainJTABLE, passengerTrainColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Must enter a number");
                    err.printStackTrace();
                }
            }
        });

        // Delete Query
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerIDFieldDelete = passengerIDTextField.getText();
                try {
                    if (Database.getInstance().deleteTicket(Integer.parseInt(passengerIDFieldDelete))) {
                        JOptionPane.showMessageDialog(null, "Deleted " + passengerIDFieldDelete + " successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not delete ticketID: " + passengerIDFieldDelete + ".", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    List<Ticket> t = Database.getInstance().viewTicket();
                    Object[][] tid = new Object[0][0];
                    if (!t.isEmpty()) {
                        tid = new Object[t.size()][3];
                        Iterator<Ticket> iterator = t.iterator();
                        Ticket temp;
                        for (int i = 0; i < t.size(); i++) {
                            temp = iterator.next();
                            tid[i][0] = temp.getTicketID();
                            tid[i][1] = temp.getPassengerID();
                            tid[i][2] = temp.getPrice();
                        }
                    }
                    Object[] columnNames = {"TicketID", "PassengerID", "Price"};
                    tableDeleteTicket = new JTable(tid, columnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Must enter a number");
                    err.printStackTrace();
                }
            }
        });

        // Update Query
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updateShipmentID = shipmentIDTextField.getText();
                String updateShipmentType = (String) comboBox2.getSelectedItem();
                try {
                    if (Database.getInstance().updateCargoShipment(Integer.parseInt(updateShipmentID), updateShipmentType)) {
                        JOptionPane.showMessageDialog(null, "Updated " + updateShipmentID + " successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not update: " + updateShipmentID + ".", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    List<CargoShipment> cs = Database.getInstance().viewCargoShipment();
                    Object[][] c = new Object[0][0];
                    if (!cs.isEmpty()) {
                        c = new Object[cs.size()][3];
                        Iterator<CargoShipment> iterator = cs.iterator();
                        CargoShipment temp;
                        for (int i = 0; i < cs.size(); i++) {
                            temp = iterator.next();
                            c[i][0] = temp.getShipmentID();
                            c[i][1] = temp.getCargoType();
                            c[i][2] = temp.getPurchaserID();
                        }
                    }
                    Object[] columnNames = {"ShipmentID", "CargoType", "PurchaserID"};
                    tableUpdateCargoShipment = new JTable(c, columnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Must enter a number");
                    err.printStackTrace();
                }
            }
        });

        // Select Query
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectTicketsBelowPrice = maxPriceTextField.getText();
                try {
                    List<Map<Integer, Integer>> result = Database.getInstance().filterPrice(Integer.parseInt(selectTicketsBelowPrice));
                    Iterator<Map<Integer, Integer>> iterator = result.iterator();
                    Map<Integer, Integer> temp;
                    Object[][] priceData = new Object[result.size()][2];
                    Object[] priceColumnNames = { "TicketID", "Price"} ;
                    for (int i = 0; i < result.size(); i++) {
                        temp = iterator.next();
                        priceData[i][0] = temp.get("TicketID");
                        priceData[i][1] = temp.get("Price");
                    }
                    tableSelectTicketPrice = new JTable(priceData, priceColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Must enter a number");
                    err.printStackTrace();
                }
            }
        });

        // Projection Query
        submitButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectionColumnName = (String) comboBox3.getSelectedItem();
                try {
                    if (projectionColumnName.equals("PassengerTrainID") || projectionColumnName.equals("CargoTrainID")) {
                        List<Integer> result = Database.getInstance().projectIntArrivals(projectionColumnName);
                        Iterator<Integer> iterator = result.iterator();
                        Integer temp;
                        Object[][] pa = new Object[result.size()][1];
                        Object[] pColumnName = {projectionColumnName};
                        for (int i = 0; i < result.size(); i++) {
                            temp = iterator.next();
                            pa[i][0] = temp;
                        }
                        tableProjectArrival = new JTable(pa, pColumnName);
                    } else if (projectionColumnName.equals("LocationID") || projectionColumnName.equals("IsDelayed")){
                        List<String> result = Database.getInstance().projectStrArrivals(projectionColumnName);
                        Iterator<String> iterator = result.iterator();
                        String temp;
                        Object[][] pa = new Object[result.size()][1];
                        Object[] pColumnName = {projectionColumnName};
                        for (int i = 0; i < result.size(); i++) {
                            temp = iterator.next();
                            pa[i][0] = temp;
                        }
                        tableProjectArrival = new JTable(pa, pColumnName);
                    } else if (projectionColumnName.equals("ArrivalTime")){
                        List<Timestamp> result = Database.getInstance().projectTSArrivals(projectionColumnName);
                        Iterator<Timestamp> iterator = result.iterator();
                        Timestamp temp;
                        Object[][] pa = new Object[result.size()][1];
                        Object[] pColumnName = {projectionColumnName};
                        for (int i = 0; i < result.size(); i++) {
                            temp = iterator.next();
                            pa[i][0] = temp;
                        }
                        tableProjectArrival = new JTable(pa, pColumnName);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error has occured", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
            }
        });

        // Join Query
        submitButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String joinLocationID = locationIDTextField.getText();
                try {
                    List<Triplet<Integer, Timestamp, Timestamp>> result = Database.getInstance().joinArrivalDeparture(Integer.parseInt(joinLocationID));
                    Iterator<Triplet<Integer, Timestamp, Timestamp>> iterator = result.iterator();
                    Triplet<Integer, Timestamp, Timestamp> temp;
                    Object[][] ADJoin = new Object[result.size()][3];
                    Object[] ADJoinColumnNames = { "TrainID", "ArrivalTime", "DepartureTime"} ;
                    for (int i = 0; i < result.size(); i++) {
                        temp = iterator.next();
                        ADJoin[i][0] = temp.getFirst();
                        ADJoin[i][1] = temp.getSecond();
                        ADJoin[i][2] = temp.getThird();
                    }
                    tableJoinArrivalDeparture = new JTable(ADJoin, ADJoinColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
            }
        });

        // Aggregation Query (No fields to input, just run query when pressed)
        runAggregationQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = Database.getInstance().numberTechnicians();
                    Object[][] temp = new Object[1][1];
                    Object[] tempColumnNames = { "COUNT(TechnicianID)"} ;
                    temp[0][0] = result;
                    tableAggregation = new JTable(temp, tempColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
            }
        });

        // Nested Aggregation Query
        submitButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nestedAggregationColumn = trainIDTextField.getText();
                try {
                    Map<Integer, Integer> result = Database.getInstance().maxPassengerCapacity();
                    Object[][] temp = new Object[1][2];
                    Object[] tempColumnNames = {"PassengerTrainID", "MAXCOUNT"};
                    temp[0][0] = result.get("PassengerTrainID");
                    temp[0][1] = result.get("MAXCOUNT");
                    tableNestedAggregation = new JTable(temp, tempColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
            }
        });

        // Division Query (No fields to input, just run query when pressed)
        runDivisionQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Integer> result = Database.getInstance().conductingTrains();
                    Object[][] temp = new Object[result.size()][1];
                    Object[] tempColumnNames = {"ConductorID"};
                    Iterator<Integer> iterator = result.iterator();
                    Integer id;
                    for (int i = 0; i < result.size(); i++) {
                        id = iterator.next();
                        temp[i][0] = id;
                    }
                    tableDivision = new JTable(temp, tempColumnNames);
                } catch(SQLException er) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                    er.printStackTrace();
                }
            }
        });
    }
}
