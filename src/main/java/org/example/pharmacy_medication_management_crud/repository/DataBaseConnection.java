package org.example.pharmacy_medication_management_crud.repository;

import java.sql.*;

public class DataBaseConnection {
    private final String databaseLink = "jdbc:mysql://localhost:3306/crud_pharmacy"; // the hostname in the link is different than the username for connection
    private final String username = System.getenv("DB_USERNAME"); // getenv is a static method from System class that reads ambient variables
    private final String password = System.getenv("DB_PASSWORD");

    public Connection connect() {
        Connection connection = null; // handles the connection

        try {
            connection = DriverManager.getConnection(databaseLink, username, password);
        } // end of try

        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end of catch
        return connection;
    } // end of connection method
} // end of class structure