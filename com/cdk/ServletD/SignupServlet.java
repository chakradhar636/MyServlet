package com.cdk.ServletD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by donuric on 7/18/2017.
 */
@WebServlet(name="SignupServlet")
public class SignupServlet extends HttpServlet {
    static final String UNAME = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/cdk";
    static final String UID = "root";
    static final String PASS = "CDKcdk11";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String fn=request.getParameter("fname");
        String ln=request.getParameter("lname");
        long numb=Long.parseLong(request.getParameter("num"));
        String addr=request.getParameter("address");
        if(!fn.equals("")||!ln.equals("")) {

            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                //STEP 2: Register and Load JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection to database server
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(URL, UID, PASS);

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.prepareStatement("insert into s1 values(?,?,?,?)");
                //Scanner sc=new Scanner((System.in));
                stmt.setString(1, fn);
                stmt.setString(2, ln);
                stmt.setLong(3, numb);
                stmt.setString(4, addr);

                int cnt = stmt.executeUpdate();
                if (cnt > 0) {
                    out.println(fn+" your details have been registered...:)");
                    System.out.println("Successfully inserted...");
                } else {
                    out.println("Error inserting...");

                    System.out.println("Error inserting...");
                }


                //STEP 6: Clean-up environment
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
            }
            System.out.println("Done...");
            out.close();
        }else{
            out.println("Enter correct details......!!!");
        }
    }



    }

