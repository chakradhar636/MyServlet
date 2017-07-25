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
@WebServlet(name = "IncludeAssign")
public class SendParam1 extends HttpServlet {
    String s="chakri";
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("We are in Send param servlet-1 "+"<br>");
        out.println(request.getAttribute("user"));
    }
}