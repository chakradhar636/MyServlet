package com.cdk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by donuric on 7/14/2017.
 */
@WebServlet(name = "ServletCDK")
public class ServletC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        int x=Integer.parseInt(request.getParameter("no1"));
        int y=Integer.parseInt(request.getParameter("no2"));

        out.println("Sum of "+x+" and "+y+" is"+(x+y));


    }
}
