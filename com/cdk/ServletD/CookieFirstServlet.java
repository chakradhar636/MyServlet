package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
  @WebServlet(name="CookieFirstServlet")
public class CookieFirstServlet extends HttpServlet {  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response){  
    try{  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("no1");
    out.print("Welcome "+n);  
  
    Cookie ck=new Cookie("uuname",n);//creating cookie object  
    response.addCookie(ck);//adding cookie in the response  
  
    //creating submit button  
    out.print("<form action=\"http://localhost:8080/CookieSecondServlet\" method=\"post\">");
    out.print("<input type=\"submit\" value=\"go\">");  
    out.print("</form>");  
          
    out.close();  
  
        }catch(Exception e){System.out.println(e);}  
  }  
}  