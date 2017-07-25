package DB_Project;

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
@WebServlet(name="SecondPage")
public class SecondPage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<br>");
        out.println("<form action=\"AdminOp\" method=\"post\">");
        out.println("<table align=\"center\" border=1>");
        out.println("<th><b>Add Operators Details....!!!</b></th>");
        out.println("<tr><td>ENTER OPERATOR USERNAME : <input type=\"text\" name=\"oname\"/></td></tr>");
        out.println("<tr><td>ENTER OPERATOR PASSWORD : <input type=\"text\" name=\"opass\"/></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"REGISTER\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }
}
