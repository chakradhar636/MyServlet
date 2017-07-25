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
@WebServlet(name="AdminOp")
public class AdminOp2 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out=response.getWriter();
            out.println("Order placed successfully");
            String yname = (String) request.getParameter("yname");
            String id = (String) request.getParameter("id");
            String vm = (String) request.getParameter("vm");
            String op = (String) request.getParameter("op");
            String d = (String) request.getParameter("date");
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(d);
            int unit = Integer.parseInt(request.getParameter("unit"));
            double price = Double.parseDouble(request.getParameter("price"));
            double tax = Double.parseDouble(request.getParameter("tax"));
            String spid = (String) request.getParameter("spid");
            String spnm = (String) request.getParameter("spnm");
            OrderDaoImpl ord = new OrderDaoImpl();
            ord.placeOrder(new Orders(yname, id, vm, spid, spnm, op, unit, price, tax, date1));
            out.println("<form action=\"LogoutAdmin\" method=\"get\">");
            out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
            out.println("</form>");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}