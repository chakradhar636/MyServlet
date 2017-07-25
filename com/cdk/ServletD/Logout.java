package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.Time;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Logout")
public class Logout extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            HttpSession session=request.getSession();

            out.print((String)session.getAttribute("uname")+" you have been logged out"+"<br>");
            Login.log=false;
            out.println("</form method=\"get\">");
            long a=session.getCreationTime();
            long b=System.currentTimeMillis();
            out.println("User "+(String)session.getAttribute("uname")+" has spent "+(b-a)/1000+"seconds"+"<br>");

            out.println("Click here to Re-Login page"+"<input type=\"button\" onclick=location.href=\"A1.html\" value=\"Login Page\"/>");
            out.println("</form>");

            out.close();

        }catch(Exception e){System.out.println(e);}
    }

}