package DB_Project;

import DAO.AdminDaoImpl;
import DAO.OperatorDaoImpl;
import DAO.OrderDaoImpl;
import entities.Admin;
import entities.Operator;
import entities.Orders;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
@WebServlet(name="App")
public class App {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Press 1 For Login or 0 for Exit");
        int input = sc.nextInt();
        if (input == 0) {
            return;
        } else {

            System.out.print("Enter username : ");
            String username = sc.next();
            //String username=request.getParameter("username");
            System.out.print("Enter password : ");
            String password = sc.next();
            //String password=request.getParameter("password");

            int valid = 0;
            valid = login(username, password);
            if (valid == 0) {
                System.out.println("User Not Valid");
                return;
            } else if (valid == 1) {
                System.out.println("Admin Choose From Options");
                System.out.println("1. Add Operator");
                System.out.println("2. Block Operator");
                System.out.println("3. Place Order");
                System.out.println("4. View Orders Between Dates");
                int adminOption = sc.nextInt();
                adminOperation(adminOption, sc, username);
            } else if (valid == 2) {
                System.out.println("Operator Choose From Options");
                System.out.println("1. Place Order");
                System.out.print("2. Exit");
                int option = sc.nextInt();
                if (option == 1) {
                    placeOrder(username, sc);
                }
            }

        }
    }

    private static void adminOperation(int adminOption, Scanner sc,String username) {
        OperatorDaoImpl operator = new OperatorDaoImpl();
        switch (adminOption){
            case 1: {
                System.out.print("Enter Username :");
                String un = sc.next();
                System.out.print("Enter Password :");

                String password = sc.next();
                operator.addOpertor(new Operator(un, password, true));
            }
                break;
            case 2: {
                System.out.print("Enter Username : ");
                String un = sc.next();
                operator.blockOperator(un);
            } break;
            case 3: {
                placeOrder(username, sc);
                break;
            }
            case 4:{
                OrderDaoImpl od = new OrderDaoImpl();
                System.out.print("enter dates in dd/mm/yyyy");
                System.out.print("Enter date-1 : ");
                String date1 = sc.next();
                System.out.print("Enter date-2 : ");
                String date2 = sc.next();
                try {
                    Date date_1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
                    Date date_2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
                    List<Orders> ls = od.getOrders(date_1, date_2);
                    System.out.print(ls);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } break;
            default:
                System.out.println("wrong choice");
                return;

        }
    }

    private static void placeOrder(String username, Scanner sc) {
        OrderDaoImpl od = new OrderDaoImpl();
        System.out.println("Enter Following detail :");
        System.out.print("Enter order-id : ");
        String oId = sc.next();
        System.out.print("Enter model : ");
        String vm = sc.next();
        System.out.print("Enter sparepart-id : ");
        String spi = sc.next();
        System.out.print("Enter sparepart-name : ");
        String spn = sc.next();
        System.out.print("Enter operation : ");
        String op = sc.next();
        System.out.print("Enter units : ");
        int num = sc.nextInt();
        System.out.print("Enter price : ");
        double pr = sc.nextDouble();
        System.out.print("Enter tax : ");
        double tax = sc.nextDouble();
        System.out.print("Enter date in dd/mm/yyy format : ");
        String dt = sc.next();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
            od.placeOrder(new Orders(username, oId, vm, spi, spn, op, num, pr, tax, date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static int login(String username, String password) {
        AdminDaoImpl admin = new AdminDaoImpl();
        OperatorDaoImpl operator = new OperatorDaoImpl();
        if(admin.validate(new Admin(username, password))) {
            return 1;
        }
        else if(operator.validate(username, password)){
            return 2;
        }
        else {
            return 0;
        }
    }
}



