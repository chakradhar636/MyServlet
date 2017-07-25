package DB_Project;
import DAO.*;
import DAO.AdminDaoImpl;
import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Admin;
import entities.Operator;
import entities.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
 * Hello world!
 *
 */
@WebServlet(name="App1")
public class App1 extends HttpServlet {
    static boolean loggedin = false;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        PrintWriter out = response.getWriter();
        Scanner sc = new Scanner(System.in);
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        int valid = 0;
        valid = login(u, p);
        if (loggedin == true) {

            if (valid == 0) {
                out.println("<p align=\"center\"> Login or password Error.....:(</p>");
                RequestDispatcher rd = request.getRequestDispatcher("FirstPage.html");
                rd.include(request, response);
                return;
            } else if (valid == 1) {
                out.println("<p align=\"center\">Welcome " + u + "</p>");
                HttpSession session = request.getSession();
                session.setAttribute("aname", u);
                out.println("<br>");
                out.println("<table align=\"center\" border=2>");
                out.println("<th align=\"center\">ADMIN OPTIONS</th>");

                out.println("<tr>");
                out.println("<td>Click to Add Operator : </td>");
                out.println("<td>");
                out.println("<form action=\"SecondPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Add Operator\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Block Operator : </td>");
                out.println("<td>");
                out.println("<form action=\"ThirdPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Block Operator\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Place orders : </td>");
                out.println("<td>");
                out.println("<form action=\"FourthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Place Order\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to search orders : </td>");
                out.println("<td>");
                out.println("<form action=\"FifthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Search Orders\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to display orders : </td>");
                out.println("<td>");
                out.println("<form action=\"DisplayServlet\" method=\"post\">");
                out.println("<input type=\"submit\" value=\"Display Orders\" />");
                out.println("</form>");
                out.println("</td></tr>");
                out.println("</table>");


                out.println("<table align=\"center\" border=2>");
                out.println("<th>SPARE-PART OPTIONS</th>");


                out.println("<tr>");
                out.println("<td>Click to Find Spare-Part : </td>");
                out.println("<td>");
                out.println("<form action=\"SeventhPage\" method=\"post\">");
                out.println("<input type=\"submit\" value=\"Find Spare-Part\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Remove Spare-Part : </td>");
                out.println("<td>");
                out.println("<form action=\"EigthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Remove Spare-Part\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Display Spare-Parts : </td>");
                out.println("<td>");
                out.println("<form action=\"DisplayServlet1\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Display Spare-Parts\" />");
                out.println("</form>");
                out.println("</td></tr>");
                out.println("</table>");


                out.println("<form action=\"LogoutAdmin\" method=\"get\">");
                out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
                out.println("</form>");
            } else if (valid == 2) {
                out.println("<p align=\"center\">Welcome " + u + "</p>");
                HttpSession session = request.getSession();
                session.setAttribute("aname", u);
                out.println("<br>");
                out.println("<table align=\"center\" border=2>");
                out.println("<th align=\"center\">OPERATOR OPTIONS</th>");

                out.println("<tr>");
                out.println("<td>Click to Place orders : </td>");
                out.println("<td>");
                out.println("<form action=\"FourthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Place Order\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to search orders : </td>");
                out.println("<td>");
                out.println("<form action=\"FifthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Search Orders\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to display orders : </td>");
                out.println("<td>");
                out.println("<form action=\"DisplayServlet\" method=\"post\">");
                out.println("<input type=\"submit\" value=\"Display Orders\" />");
                out.println("</form>");
                out.println("</td></tr>");
                out.println("</table>");

                out.println("<table align=\"center\" border=2>");
                out.println("<th align=\"center\">SPARE-PART OPTIONS</th>");


                out.println("<tr>");
                out.println("<td>Click to Find Spare-Part : </td>");
                out.println("<td>");
                out.println("<form action=\"SeventhPage\" method=\"post\">");
                out.println("<input type=\"submit\" value=\"Find Spare-Part\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Remove Spare-Part : </td>");
                out.println("<td>");
                out.println("<form action=\"EigthPage\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Remove Spare-Part\" />");
                out.println("</form>");
                out.println("</td></tr>");

                out.println("<tr>");
                out.println("<td>Click to Display Spare-Parts : </td>");
                out.println("<td>");
                out.println("<form action=\"DisplayServlet1\" method=\"post\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"Display Spare-Parts\" />");
                out.println("</form>");
                out.println("</td></tr>");
                out.println("</table>");

                out.println("<form action=\"LogoutAdmin\" method=\"get\">");
                out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
                out.println("</form>");


            } else {

            }
        }else{
            PrintWriter pw=response.getWriter();
            pw.println("Please login to continue");
        }
}


    private static int login(String username, String password) {
        AdminDaoImpl admin = new AdminDaoImpl();
        OperatorDaoImpl operator = new OperatorDaoImpl();
        if(admin.validate(new Admin(username, password))) {
            loggedin=true;
            return 1;
        }
        else if(operator.validate(username, password)){
            loggedin=true;
            return 2;
        }
        else {
            loggedin=true;
            return 0;
        }
    }
}
