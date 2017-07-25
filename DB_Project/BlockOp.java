package DB_Project;

import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Operator;
import entities.Orders;

import javax.servlet.ServletException;
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
@WebServlet(name="BlockOp")
public class BlockOp extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
HttpSession session=request.getSession(false);
        PrintWriter out = response.getWriter();
        String un = (String) request.getParameter("oname");
        OperatorDaoImpl operator = new OperatorDaoImpl();
        operator.blockOperator(un);
        out.println("Operater"+session.getAttribute("oname")+" blocked Successfully");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

