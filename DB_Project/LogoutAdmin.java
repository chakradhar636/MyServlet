package DB_Project;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.Time;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            HttpSession session=request.getSession(false);

            out.print((String)session.getAttribute("aname")+" you have been logged out"+"<br>");
            App1.loggedin=false;
            out.println("</form method=\"get\">");
            out.println("Click here to Re-Login "+"<input type=\"button\" onclick=location.href=\"FirstPage.html\" value=\"LOGIN\"/>");
            out.println("</form>");

            out.close();

        }catch(Exception e){System.out.println(e);}
    }

}