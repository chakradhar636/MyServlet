package com.cdk.ServletD;

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
@WebServlet(name = "ServletD")
public class ServletD extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration paramNames = request.getParameterNames();
        PrintWriter pw = response.getWriter();
       // pw.println("Ochina nenu");
        pw.println("<br><font color=\"#FF0000\">Can u see this message from servlet</font>");
        int i = 1;
        String paramName;
        pw.println("<table border=2><tr><td>ParameterName</td><td>ParameterValue</td></tr>");
        while(paramNames.hasMoreElements())
        {
            paramName = (String)paramNames.nextElement();

            pw.println("<tr><td>"+paramName+"</td>");

            i++;
            String paramValue = request.getParameter(paramName);
            pw.println("<td>"+paramValue+"</td></tr><br>");
        }
        pw.println("</table>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }


}
