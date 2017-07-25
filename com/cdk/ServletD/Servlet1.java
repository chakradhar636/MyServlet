package com.cdk.ServletD;

import javax.servlet.Servlet;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by donuric on 7/17/2017.
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (Login.log == true) {
            if (request.getSession(false) == null) {
                out.println("Session Timed out.....Please login to continue ");
                out.println("<form method=\"get\">");
                out.println("Click here to move to Login page" + "<input type=\"button\" onclick=location.href=\"A1.html\" value=\"Login Page\"/><br>");
                out.println("</form>");
            }else{
            out.print("Welcome " + (String) session.getAttribute("uname") + "<br>" + " You are in Servlet1" + "<br>");
            // out.println("<form action=\"Session1.html\">");
            // out.println("<p>Go to Home Login page <a href=\"A1.html\">Login page</a></p>");

            out.println("</form method=\"get\">");
            out.println("Click here to move to Login page" + "<input type=\"button\" onclick=location.href=\"A1.html\" value=\"Login Page\"/>" + "<br>");
            out.println("</form>");

            out.println("<form action=\"Welcome\" method=\"get\">");
            out.println("Click here to move to Welcome page" + "<input type=\"submit\" name=\"log\" value=\"Welcome\" />"+"<br>");
            out.println("</form>");

            out.println("<form action=\"Logout\" method=\"get\">");
            out.println("Click here to Logout" + "<input type=\"submit\" name=\"log\" value=\"logoff\" />");
            out.println("</form>");

            //RequestDispatcher rd1=request.getRequestDispatcher("Session1");
            //rd1.include(request, response);
        }} else {
            PrintWriter pw = response.getWriter();
            pw.println("Please login to continue.....!!!");

        }


    }
}
