package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    static final String UNAME = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/cdk";
    static final String UID = "root";
    static final String PASS = "CDKcdk11";
    Statement stmt = null;
    Connection con = null;

    static boolean log = false;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println("im in login");
        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");

        if (validateLogin1(n, p)) {
            // out.println(n+"U have been logged in");
            HttpSession session = request.getSession();
            session.setAttribute("uname", n);
            log = true;
            //session.setMaxInactiveInterval(1);
            RequestDispatcher rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);

        } else //failure
        {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = request.getRequestDispatcher("/A1.html");
            rd.include(request, response);
        }
    }

    private boolean validateLogin1(String n1, String n2) {
        boolean y = false;

        try {
            Class.forName(UNAME);
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = DriverManager.getConnection(URL, UID, PASS);

            String sql = "Select * from admin where username = ? && password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, n1);
            ps.setString(2, n2);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                y = true;
            } else {
                y = false;
            }
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
        return y;
    }

}

