package DB_Project;

import Utilities.Constants;

import java.io.*;
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
@WebServlet(name="DisplayServlet1")
public class DisplayServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {}
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        //  String username=request.getParameter("Username");
        // String password=request.getParameter("Password");
        HttpSession session=request.getSession(false);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\">");
        out.println("</script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\">");
        out.println("</script>");
        out.println("</head>");
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<p align=\"center\"><b>SPARE PARTS TABLE</b>....!!!</p>");

        out.println("</body></html>");
        // connecting to database
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection
                    (Constants.URL, Constants.UID, Constants.PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM spareparts");
            // displaying records

            out.print("<table align=\"center\" border=1>");

            out.print("<th>Sparepart ID</th><th>SparePart Name</th><th>Price</th><th>Tax</th><th>Units</th><th>Vehicle Model</th>");

            while (rs.next()) {
                out.print("<tr><td>"+rs.getObject(1).toString()+"</td>");
                out.print("<td>"+rs.getObject(2).toString()+"</td>");
                out.print("<td>"+rs.getObject(3).toString()+"</td>");
                out.print("<td>"+rs.getObject(4).toString()+"</td>");
                out.print("<td>"+rs.getObject(5).toString()+"</td>");
                out.print("<td>"+rs.getObject(6).toString()+"</td>");
            }
            out.print("</table>");
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
            out.println("</form>");


        } catch (SQLException e) {
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