import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField cargoCapacityTextField;
    private JTextField passengerCapacityTextField;
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
    private JTable table1;

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
                String cargoCapacity = cargoCapacityTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Insert PassengerTrain Query
        submitPassengerTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerTrainID  = passengerTrainIDTextField.getText();
                String isUnderMaintenancePassengerTrain = (String) JComboBoxPassenger.getSelectedItem();
                String passengerTrainModel = modelTextField1.getText();
                String passengerCapacity = passengerCapacityTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Delete Query
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerIDFieldDelete = passengerIDTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Update Query
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updateShipmentID = shipmentIDTextField.getText();
                String updateShipmentType = (String) comboBox2.getSelectedItem();
                // TODO: RUN QUERY
            }
        });

        // Select Query
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectTicketsBelowPrice = maxPriceTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Projection Query
        submitButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectionColumnName = (String) comboBox3.getSelectedItem();
                // TODO: RUN QUERY
            }
        });

        // Join Query
        submitButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String joinLocationID = locationIDTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Aggregation Query (No fields to input, just run query when pressed)
        runAggregationQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: RUN QUERY
            }
        });

        // Nested Aggregation Query
        submitButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nestedAggregationTrainID = trainIDTextField.getText();
                // TODO: RUN QUERY
            }
        });

        // Division Query (No fields to input, just run query when pressed)
        runDivisionQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: RUN QUERY
            }
        });
    }
}
