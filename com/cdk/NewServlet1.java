package com.cdk;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *
 * @author ADMIN
 */
public class NewServlet1 extends HttpServlet {

    String param_val,param_val1;
    
	public void init(ServletConfig config)
	{
            System.out.println("Am from Init method...!");
            param_val = config.getInitParameter("myParam");
            System.out.println("Param Val:"+param_val);

            param_val1 = config.getInitParameter("myParam1");
            System.out.println("Param Val1:"+param_val1);

            //to get enumeration of parameters
            Enumeration enm = config.getInitParameterNames();
	}
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
        
        pw.println("first value:"+param_val);
        
        pw.println("<br>second vale:"+param_val1);
    }

}
