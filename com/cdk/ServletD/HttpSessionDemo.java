package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
  @WebServlet(name = "HttpSessionDemo")
public class HttpSessionDemo extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response){  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String n=request.getParameter("userName");
        //String n1=request.getParameter("nickname");
        out.print("Welcome "+n);
                //String n=request.getParameter("userName");
                //out.print("Welcome "+n+"<br>");
        //create new session
        HttpSession session=request.getSession();
        
        //set the attribute uname to the session
        //which can be further retrieved, in other servlets
        //as long as session is valid
        //Attribute value can be of any type, since Object is expected parameter
        session.setAttribute("userName",n);
        //session.setAttribute("nickname",n1);
        out.println("<form action=\"HttpSessionDemo1\" method=\"get\">");
        //setMaxInactiveInterval(int interval), 
        //container invalidates session, if no requests from client, for a certain time(in seconds)
                out.println("<input type=\"submit\" name=\"log\" value=\"logoff\" />");
        //out.print("<a href='n.html'> visit</a>");
                  out.println("</form>");
        out.close();  
  
                }catch(Exception e){System.out.println(e);}  
    }  
  
}  