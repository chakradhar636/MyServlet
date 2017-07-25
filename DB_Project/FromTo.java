package DB_Project;

import Utilities.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import Utilities.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import Utilities.Constants;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

@WebServlet(name="DisplayServlet")
public class FromTo extends HttpServlet {
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {}
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        //  String username=request.getParameter("Username");
        // String password=request.getParameter("Password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>FromTo</title></head>");
        out.println("<body>");
        out.println("<h3>Servlet JDBC</h3>");
        out.println("</body></html>");
        // connecting to database
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sd1=(String )request.getParameter("d1");
        String sd2=(String )request.getParameter("d2");
        try{
        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(sd1);
        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(sd2);

            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection
                    (Constants.URL, Constants.UID, Constants.PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM orders");
            // displaying records
            out.print("<table align=\"center\" border=1>");

            out.print("<th>Id</th><th>Done By</th><th>Vehicle Model</th><th>Operation</th><th>Date</th><th>Units</th><th>Price</th><th>tax</th><th>SparePartId</th><th>SparePartName</th>");

            while (rs.next()) {
                Date tempDate = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date"));
                if (tempDate.after(d1) && tempDate.before(d2)) {
                    out.print("<tr><td>" + rs.getObject(1).toString() + "</td>");
                    out.print("<td>" + rs.getObject(2).toString() + "</td>");
                    out.print("<td>" + rs.getObject(3).toString() + "</td>");
                    out.print("<td>" + rs.getObject(4).toString() + "</td>");
                    out.print("<td>" + rs.getObject(5).toString() + "</td>");
                    out.print("<td>" + rs.getObject(6).toString() + "</td>");
                    out.print("<td>" + rs.getObject(7).toString() + "</td>");
                    out.print("<td>" + rs.getObject(8).toString() + "</td>");
                    out.print("<td>" + rs.getObject(9).toString() + "</td>");
                    out.print("<td>" + rs.getObject(10).toString() + "</td></tr>");

            }}                out.print("</table>");
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
            out.println("</form>");

        } catch(ParseException e){
            e.printStackTrace();
        }catch (SQLException e) {
            throw new ServletException("Servlet Could not display records.", e);
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
        out.close();
    }
}

