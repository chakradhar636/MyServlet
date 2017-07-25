package com.cdk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by donuric on 7/14/2017.
 */
@WebServlet(name = "ServletE")
public class ServletE{
public ServletE()
        {
        System.out.println("Am from default constructor");
        }

public void init(ServletConfig config)
        {
        System.out.println("Am from Init method...!");
        }

public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException
        {
        System.out.println("Am from doGet method...!");
        PrintWriter out = res.getWriter();

        out.println(" from doGet()<br>");
        }

public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException
        {
        System.out.println("Am from doPost method...!");
        PrintWriter out = res.getWriter();

        out.println(" from doPost()<br>");
        }

public void destroy()
        {
        System.out.println("Am from Destroy methods");
        }


        }
