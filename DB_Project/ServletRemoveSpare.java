package DB_Project;

/**
 * Created by donuric on 7/22/2017.
 */

import Utilities.Constants;
import Utilities.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.*;

import Utilities.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletRemoveSpare")
public class ServletRemoveSpare extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("sid");
        int i=Integer.parseInt(id);
        Connection con = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        PrintWriter out=response.getWriter();
        out.println("Operation Done Successfully");
        try{
                Class.forName(Constants.UNAME);
                con = DriverManager.getConnection
                        (Constants.URL, Constants.UID, Constants.PASSWORD);
            con.setAutoCommit(false);

            String sql = "DELETE from spareparts WHERE sparepartid="+i;

            ps = con.prepareStatement(sql);
            System.out.print("deleted");
            ps.executeUpdate();
            con.commit();
            System.out.print("DELETE from spareparts WHERE sparepartid="+i);
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
            out.println("</form>");
        }
        catch (ClassNotFoundException f) {
        f.printStackTrace();
        }catch(SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

