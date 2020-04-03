import database.Database;
import tables.PassengerTrain;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        databaseLayout myDatabasePanel = new databaseLayout();
        myDatabasePanel.setVisible(true);
    }
}
