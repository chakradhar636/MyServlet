package com.cdk.ServletD;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
  @WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

      static final String UNAME = "com.mysql.jdbc.Driver";
      static final String URL = "jdbc:mysql://localhost/cdk";
      static final String UID = "root";
      static final String PASS = "CDKcdk11";
      Statement stmt = null;
      Connection con = null;
      public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {}
      public void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {


          response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          String n = request.getParameter("userName");
          String p = request.getParameter("userPass");

          //out.println("Before if statement");
          if (validateLogin(n, p))//success
          {
              out.println("Welcome"+n);
              RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
              //request.setAttribute("abc", "this_parameter_added_by_servlet");
              //forwards request to WelcomeServlet, and discards output from
              //current servlet(if any)
              rd.forward(request, response);
              // rd.forward(request,response);
          } else //failure
          {
              out.print("Sorry UserName or Password Error!");

              //instead of index.html, any servlet also can be used or included
              RequestDispatcher rd = request.getRequestDispatcher("/Dispatcher.html");

              //request.setAttribute("def", "this_parameter_added_by_servlet");

              //index.html page is included in the output along with message from current servlet
              rd.include(request, response);
              //rd.include(request, response);
              // RequestDispatcher rd1=request.getRequestDispatcher("/Session.html");
              //rd1.include(request, response);

              //out.print("This is after include");
          }
      }

      private boolean validateLogin(String n1, String n2) {
          boolean x=false;

          try {
              Class.forName(UNAME);

              con = DriverManager.getConnection(URL, UID, PASS);

              String queryString = "select username,password from admin";
              stmt = con.createStatement();

              ResultSet results = stmt.executeQuery(queryString);

              while (results.next()) {
                  String uname = results.getString("username");
                  String password = results.getString("password");

                  if ((n1.equals(uname)) && (n2.equals(password))) {

                      System.out.println("Success");
                      x=true;
                      break;
                  } else {
                      System.out.println("Fail");
                      x=false;
                      break;
                  }

              }
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          } catch (SQLException sql) {

              System.out.println(sql);
          }
      return x;
      }

  }

