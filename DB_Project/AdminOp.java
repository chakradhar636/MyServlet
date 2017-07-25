package DB_Project;

import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Operator;
import entities.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by donuric on 7/20/2017.
 */
@WebServlet(name="AdminOp")
public class AdminOp extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Operation done Successfully");
        String un = (String) request.getParameter("oname");
        String password = (String) request.getParameter("opass");
        if (un.equals("") || password.equals("")) {
            out.println("<html><head>");
            out.println("<script>");
            out.println("alert(\"Please provide details \")");
            out.println("</script>");
            out.println("</head>");
            out.println("<body></body></html>");

        } else {
            OperatorDaoImpl operator = new OperatorDaoImpl();
            operator.addOpertor(new Operator(un, password, true));
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
            out.println("</form>");
            out.println("Operation done Successfully");

        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

