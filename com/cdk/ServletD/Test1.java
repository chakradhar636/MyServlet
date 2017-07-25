package com.cdk.ServletD;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name="Test1")
public class Test1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session=request.getSession(false);
        session.getAttribute("val");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println((System.currentTimeMillis()-session.getCreationTime())/1000);
        out.println("Test1 servlet says hi");
        session.invalidate();
    }

}