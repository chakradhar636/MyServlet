package com.cdk.ServletD;

import javax.servlet.Servlet;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by donuric on 7/17/2017.
 */
@WebServlet(name = "IncludeAssign1")
public class IncludeAssign1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession(false);
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("We are in the Second servlet "+"<br>");
        //RequestDispatcher rd1 = request.getRequestDispatcher("IncludeAssign2");
        //rd1.include(request, response);
        out.close();

    }
}