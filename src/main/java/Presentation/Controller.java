/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Orders;
import Data.User;
import Logic.DAO;
import Logic.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renz
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    DAO d = new DAO();
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");

        String origin = request.getParameter("origin");
        try {
            switch (origin) {
                case "index":
                    index(request, response);
                    break;
                case "checkLogin":
                    checkLogin(request, response);
                    break;
                case "shop":
                    shop(request, response);
                    break;
                case "makeCustomer":
                    makeCustomer(request, response);
                    break;
                case "calBricks":
                    calBricks(request, response);
                case "makeOrder":
                    makeOrder(request, response);
                    break;
                case "myOrders":
                    myOrders(request, response);
                    break;
                case "viewBricks":
                    viewBricks(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head><title>PANIC Page</title></head>");
            out.println("  <body>");
            out.println("    <h3>" + e.getMessage() + "</h3><hr/>");
            out.println("    <pre>");
            e.printStackTrace(out); // Don't do this in production code!
            out.print("</pre>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = d.getUser(email);

        session.setAttribute("user", user);

        boolean valid = d.checkLogin(email, password);

        if (valid && email != null && password != null && !("".equals(email))
                && !("".equals(password))) {
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void makeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) session.getAttribute("user");
        int[] brickList = (int[]) session.getAttribute("brickList");

        int width = (int) session.getAttribute("Width");
        int length = (int) session.getAttribute("Length");
        int height = (int) session.getAttribute("Height");
        String bandType = (String) session.getAttribute("Band");

        d.makeOrder(width, length, height, bandType, u.getEmail());

        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    private void calBricks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = Integer.parseInt(request.getParameter("Width"));
        int length = Integer.parseInt(request.getParameter("Length"));
        int height = Integer.parseInt(request.getParameter("Height"));
        int bandType = Integer.parseInt(request.getParameter("Band"));

        String band = "";
        switch (bandType) {
            case 1:
                band = "½-stensforbandt";
                break;
            case 2:
                band = "1/4-stensforbandt";
                break;
            case 3:
                band = "Blok forbandt";
                break;
            case 4:
                band = "Kryds forbandt";
                break;
            default:
                throw new AssertionError();
        }

        int[] brickList = d.calBricks(width, length, height, bandType);
        session.setAttribute("brickList", brickList);
        session.setAttribute("Width", width);
        session.setAttribute("Length", length);
        session.setAttribute("Height", height);
        session.setAttribute("Band", band);

        request.getRequestDispatcher("calBricks.jsp").forward(request, response);
    }

    private void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) session.getAttribute("user");
        ArrayList<Orders> myOrders = d.getMyOrderList(u.getEmail());
        myOrders.clear();
        myOrders = d.getMyOrderList(u.getEmail());
        session.setAttribute("myOrders", myOrders);
        request.getRequestDispatcher("view_orders.jsp").forward(request, response);
    }

    private void viewBricks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int viewBricksID = Integer.parseInt(request.getParameter("viewBricksID"));
        Orders order = d.getOrder(viewBricksID);

        int width = order.getWidth();
        int length = order.getLength();
        int height = order.getHeight();
        int bandType = 0;
        String band = order.getBandType();

        switch (band) {
            case "½-stensforbandt":
                bandType = 1;
                break;
            case "1/4-stensforbandt":
                bandType = 2;
                break;
            case "Blok forbandt":
                bandType = 3;
                break;
            case "Kryds forbandt":
                bandType = 4;
                break;
            default:
                throw new AssertionError();
        }
        int[] brickList = d.calBricks(width, length, height, bandType);

        int x4 = brickList[0] + brickList[3];
        int x2 = brickList[1] + brickList[4];
        int x1 = brickList[2] + brickList[5];

        session.setAttribute("viewBricksList", brickList);
        /*
        session.setAttribute("x4", x4);
        session.setAttribute("x2", x2);
        session.setAttribute("x1", x1);
         */
        request.getRequestDispatcher("view_bricks.jsp").forward(request, response);
    }

    private void makeCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        d.createUser(email, password);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
