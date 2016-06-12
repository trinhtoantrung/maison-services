package com.t3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by TrungTrinh on 6/12/16.
 */
public class MaisonConnection {
    private static final String CONNECTION_URL = "";
    private static final String USER = "";
    private static final String PASS = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return connection;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USER, PASS);

            if (connection != null) {
                System.out.println("You made it, take control your database now!");
            }
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
            ex.printStackTrace();
        }
        return connection;
    }
}
