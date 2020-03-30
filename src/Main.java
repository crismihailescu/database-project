import tableCreation.createNewTables;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        createNewTables createNewTables = new createNewTables();
        databaseLayout myDatabasePanel = new databaseLayout();
        myDatabasePanel.setVisible(true);
    }

}
