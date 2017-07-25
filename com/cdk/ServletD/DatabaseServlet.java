package com.cdk.ServletD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * Created by donuric on 7/14/2017.
 */
@WebServlet(name = "DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cdk";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "CDKcdk11";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 2: Register and Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection to database server
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement("insert into m1 values(?, ?, ?)");
            //Scanner sc=new Scanner((System.in));
            stmt.setInt(1, 12);

            stmt.setString(2, "Kal");
            stmt.setInt(3, 1009);

            int cnt = stmt.executeUpdate();
            if(cnt>0)
            {
                System.out.println("Successfully inserted...");
            }
            else
            {
                System.out.println("Error inserting...");
            }


            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }//// nothing we can do
        }
    }



