package com.cdk.ServletD;


        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.Enumeration;

        import javax.servlet.*;
        import javax.servlet.FilterChain;
        import javax.servlet.FilterConfig;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;

public class Myfilter1 implements Filter {

    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();
        out.println("Name : " + filterConfig.getInitParameter("name"));
        out.println("<br/><br/>Parameters:<br/>");
        //out.println(servletRequest.getAttribute("user"));
        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        if (parameterNames.hasMoreElements()) {
            while (parameterNames.hasMoreElements()) {
                    String name = parameterNames.nextElement();
                    String value = servletRequest.getParameter(name);
                    if(!name.equals("a")){

                    out.println("name:" + name + ", value: " + value + "<br/>");
                }else{

                        out.println("Removed element name is :"+name+"<br>");
                    }
            }
        } else {
            out.println("---None---<br/>");
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

}
