package DB_Project;

/**
 * Created by donuric on 7/22/2017.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by donuric on 7/21/2017.
 */
@WebServlet(name="SixthPage")
public class SixthPage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("Welcome "+session.getAttribute("aname"));
        out.println("<br>");
        out.println("<form action=\"ServletSpare\" method=\"post\">");
        out.println("<table align=\"center\" border=1");
        out.println("<th><h4>Spare Part Orders ....!!!</h4></th>");
        out.println("<tr><td>Enter Spare-part ID:<input type=\"text\" name=\"sid\"></td></tr>");
        out.println("<tr><td>Enter Spare Part Name:<input type=\"text\" name=\"sname\"></td></tr>");
        out.println("<tr><td>Enter Vehicle Model:<input type=\"text\" name=\"vmodel\"></td></tr>");
        out.println("<tr><td>Enter No Units:<input type=\"text\" name=\"units\"></td></tr>");
        out.println("<tr><td>Enter Price:<input type=\"text\" name=\"price\"></td></tr>");
        out.println("<tr><td>Enter Tax:<input type=\"text\" name=\"tax\"></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"Add Spare-Part\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }
}

