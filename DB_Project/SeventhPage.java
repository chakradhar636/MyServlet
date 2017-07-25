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
@WebServlet(name="SeventhPage")
public class SeventhPage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("<p align=\"center\">Welcome "+session.getAttribute("aname")+"</p>");
        out.println("<br>");
        out.println("<form action=\"ServletFindSpare\" method=\"post\">");
        out.println("<table align=\"center\" border=1>");
        out.println("<th><b>Find Spare-Parts ....!!!</b></th>");
        out.println("<tr><td>ENTER SPARE-PART ID : <input type=\"text\" name=\"sid\"/></td></tr>");
        out.println("<tr><td align=\"right\"><input type=\"submit\" value=\"FIND\"/></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<form action=\"LogoutAdmin\" method=\"get\">");
        out.println("<p align=\"right\"><input type=\"submit\" name=\"log\" value=\"LOGOUT\" />");
        out.println("</form>");

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }
}
