package Utilities;

/**
 * Created by prajapas on 7/13/2017.
 */

import java.sql.*;

public class JDBCHelper {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    static final String DB_URL = "jdbc:mysql://localhost/cdk";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "CDKcdk11";



    public static Connection getConnection() {
        Connection con = null;
        CallableStatement stmt = null;
        try{
            //STEP 2: Register JDBC driver

            //STEP 3: Open a connection

            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);
            return con;
        }




        catch (SQLException e) {
            System.out.println("error connecting data base..!! try again..!! " + e.getMessage());
            return null;
        }
         catch (ClassNotFoundException e) {
            System.out.println("error connecting data base..!! try again..!! " + e.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}