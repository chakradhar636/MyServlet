package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  @WebServlet(name = "HttpSessionDemo1")
public class HttpSessionDemo1 extends HttpServlet {  
  
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        //retrieve existing ssn, hence false parameter is sent
        HttpSession ssn=request.getSession(false);
            String s1=(String)ssn.getAttribute("uname");
        //retrieve the attribute uname, from the ssn
           // boolean b=(boolean)ssn.getAttribute("log");
            //out.println(b);
            //out.println(n+" "+n1);
        if((s1).equals("cdk")) {
        out.print(s1+ " You have been Logged out.....!!!");
            ssn.invalidate();
            out.close();
        }else{
            out.println(s1+" u r alive");
            ssn.invalidate();
            out.close();
        }
    //invoke removeAttribute() if you want to remove any attribute
    //stored in the ssn
    //session.removeAttribute("attribute_name");

    //use invalidate method to completely destroy current ssn
    //so that it doesn't exist any more



  
                }catch(Exception e){System.out.println(e);}  
    }  
      
  
}  