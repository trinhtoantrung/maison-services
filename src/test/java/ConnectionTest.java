import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by TrungTrinh on 6/12/16.
 */
public class ConnectionTest {
    @Test
    public void testConnection() throws Exception {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://112.109.90.13:3306/maison","maison", "M@1s0n");

            if (connection != null) {
                System.out.println("You made it, take control your database now!");

                stmt = connection.createStatement();
                String sql = "INSERT INTO customers(full_name, email, mobile, address) " +
                        "VALUES (AES_ENCRYPT('test_name','t3'), AES_ENCRYPT('test@gmail.com','t3'), AES_ENCRYPT('09334324348','t3'), AES_ENCRYPT('adreese','t3'))";
                stmt.executeUpdate(sql);
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null)
                    connection.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    @Before
    public void setUp() throws Exception {
        

    }
}
