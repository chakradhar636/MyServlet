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

/**
 *
 * @author ADMIN
 */
public class InitParamServlet2 extends HttpServlet {

    public void init(ServletConfig sc)
    {
        System.out.println("SecondServlet init() "+sc.getInitParameter("myparam2"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext s=request.getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecondServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SecondServlet  " + s.getInitParameter("Country") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
