package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class WelcomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    out.print("Welcome "+n+"<br>");
        //out.println("<form action=\"HttpSessionDemo1\" method=\"get\">");
        out.println("<form >");
        out.println("<input type=\"submit\" name=\"log\" value=\"logoff\" />");
        out.println("</form>");
        HttpSession session=request.getSession();
        session.setAttribute("userName",n);

        //out.print("abc:"+request.getAttribute("abc"));
        RequestDispatcher rd1=request.getRequestDispatcher("Session1.html");
        //request.setAttribute("abc", "this_parameter_added_by_servlet");
        rd1.include(request, response);

       // RequestDispatcher rd1=request.getRequestDispatcher("/Session.html");
        //rd1.include(request, response);
    }  
  
}  