/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdk.ServletD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 *
 * @author ADMIN
 */
public class InitParamServlet extends HttpServlet {

    String param_val,param_val1;

    public void init(ServletConfig config)
    {
        System.out.println("Am from Init method...!");
        param_val = config.getInitParameter("myParam");
        System.out.println("Param Val:"+param_val);

        param_val1 = config.getInitParameter("myParam1");
        System.out.println("Param Val1:"+param_val1);
        //to get enumeration of parameters
       // Enumeration enm = config.getInitParameterNames();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("p1",param_val);
        PrintWriter pw = response.getWriter();
        ServletContext sc = request.getServletContext();

        String coun = sc.getInitParameter("Country");
        String age = sc.getInitParameter("Age");
        System.out.println(coun);
        pw.println( coun + age);
        pw.println("first value:"+param_val);

        pw.println("<br>second vale:"+param_val1);
    }

}
