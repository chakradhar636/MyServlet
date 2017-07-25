package DB_Project;

import Utilities.Constants;
import Utilities.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Created by donuric on 7/19/2017.
 */
@WebServlet(name = "ServletFindSpare")
public class ServletFindSpare extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        String n = request.getParameter("sid");

        try {
            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection
                    (Constants.URL, Constants.UID, Constants.PASSWORD);
            System.out.println("hello");
            String sql = "Select * from spareparts where sparepartid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, n);
            ps.execute();
            rs = ps.getResultSet();
            if(rs.next()) {
                out.print("<table align=\"center\" border=1>");

                out.print("<th>Sparepart ID</th><th>SparePart Name</th><th>Price</th><th>Tax</th><th>Units</th><th>Vehicle Model</th>");

                out.print("<tr><td>"+rs.getObject(1).toString()+"</td>");
                out.print("<td>"+rs.getObject(2).toString()+"</td>");
                out.print("<td>"+rs.getObject(3).toString()+"</td>");
                out.print("<td>"+rs.getObject(4).toString()+"</td>");
                out.print("<td>"+rs.getObject(5).toString()+"</td>");
                out.print("<td>"+rs.getObject(6).toString()+"</td></tr>");
                out.println("</table>");
            }
            else{
            }

        } catch (SQLException e) {
            System.out.print("Data Base Error"+e.getMessage());
        } catch (ClassNotFoundException f){
            f.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
