package com.cdk.ServletD;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name="Test")
public class Test extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int x=1;
        HttpSession session=request.getSession();
        session.setAttribute("val",x);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("TestServlet says hi");
        out.println("<form action=\"Test1\" method=\"post\">");
        out.println("Click here to move to Test1" + "<input type=\"submit\" name=\"log\" value=\"Test1\" />");
        out.println("</form>");
        out.println((System.currentTimeMillis()-session.getCreationTime())/1000);
        session.invalidate();
        System.out.println("xs");
    }

}