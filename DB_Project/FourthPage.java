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
@WebServlet(name="FourthPage")
public class FourthPage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<br>");
        out.println("<form action=\"AdminOp2\" method=\"post\">");
        out.println("<table align=\"center\" border=1");
        out.println("<b><th>Place your Orders ....!!!</th></b>");
        out.println("<tr><td>Enter ID:<input type=\"text\" name=\"id\"></td></tr>");
        out.println("<tr><td>Enter Your Name:<input type=\"text\" name=\"yname\"></td></tr>");
        out.println("<tr><td>Enter Vehicle Model:<input type=\"text\" name=\"vm\"></td></tr>");
        out.println("<tr><td>Enter Operation:<input type=\"text\" name=\"op\"></td></tr>");
        out.println("<tr><td>Enter Date(dd/mm/yyyy):<input type=\"text\" name=\"date\"></td></tr>");
        out.println("<tr><td>Enter No Units:<input type=\"text\" name=\"unit\"></td></tr>");
        out.println("<tr><td>Enter Price:<input type=\"text\" name=\"price\"></td></tr>");
        out.println("<tr><td>Enter Tax:<input type=\"text\" name=\"tax\"></td></tr>");
        out.println("<tr><td>Enter SparePartId:<input type=\"text\" name=\"spid\"></td></tr>");
        out.println("<tr><td>Enter SparePartName:<input type=\"text\" name=\"spnm\"></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"PLACE-ORDER\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" value=\"LOGOUT\" /><p>");
        out.println("</form>");

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }
}
