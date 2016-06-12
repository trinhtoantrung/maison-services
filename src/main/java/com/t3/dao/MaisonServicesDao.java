package com.t3.dao;

import com.t3.beans.requests.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by TrungTrinh on 6/12/16.
 */
public class MaisonServicesDao {
    private static final String KEY = "";

    public static boolean createCustomer(Customer customer) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = MaisonConnection.getConnection();

            String sql = "INSERT INTO customers(full_name, email, mobile, address) " +
                         "VALUES (AES_ENCRYPT(?,KEY), AES_ENCRYPT(?,KEY)" +
                         ", AES_ENCRYPT(?,KEY), AES_ENCRYPT(?,KEY))";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, customer.getFullName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getMobile());
            stmt.setString(4, customer.getAddress());

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}
