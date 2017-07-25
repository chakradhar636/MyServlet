package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name="Welcome")
public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Login.log == true) {
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession(false);
            if (request.getSession(false) == null) {
                out.println("Session Timed out.....Please login to continue ");
                out.println("<form method=\"get\">");
                out.println("Click here to move to Login page" + "<input type=\"button\" onclick=location.href=\"A1.html\" value=\"Login Page\"/><br>");
                out.println("</form>");
            } else {
                response.setContentType("text/html");

                out.print("Welcome " + (String) session.getAttribute("uname") + "<br>");
                out.println("<form method=\"get\">");
                out.println("Click here to move to Login page" + "<input type=\"button\" onclick=location.href=\"A1.html\" value=\"Login Page\"/><br>");
                out.println("</form>");
                out.println("<form action=\"Servlet1\" method=\"get\">");
                out.println("Click here to move to Servlet1" + "<input type=\"submit\" name=\"log\" value=\"Servlet1\" />");
                out.println("</form>");
                out.println("<form action=\"Logout\" method=\"get\">");
                out.println("<input type=\"submit\" name=\"log\" value=\"logoff\" />");
                out.println("</form>");
            }
        }else {
            PrintWriter pw = response.getWriter();
            pw.println("Please login to continue.....!!!");

        }

    }
}