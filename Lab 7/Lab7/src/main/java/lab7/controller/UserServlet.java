/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab7.model.User;
import lab7.dao.UserDAO;

/**
 *
 * @author Zahier
 */
public class UserServlet extends HttpServlet {
 
    private static String INSERT = "/user.jsp";
    private static String EDIT = "/editUser.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private UserDAO userDAO;
    
    public UserServlet() throws ClassNotFoundException {
        super();
        userDAO = new UserDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String forward = "";
        String action = request.getParameter("action");
 
        if ( action.equalsIgnoreCase("delete") ) {
            String userID = request.getParameter("userID");
            userDAO.deleteUser(userID);
            forward = LIST_USER;
            request.setAttribute("users", userDAO.getAllUsers());
        }
        
        else if ( action.equalsIgnoreCase("edit") ) {
            forward = EDIT;
            String userID = request.getParameter("userID");
            User user = userDAO.getUserByID(userID);
            request.setAttribute("user", user);
        }
        
        else if ( action.equalsIgnoreCase("listUser") ) {
            forward = LIST_USER;
            request.setAttribute("users", userDAO.getAllUsers());
        }
        
        else if ( action.equalsIgnoreCase("insert") ) {
            forward = INSERT;
        }
 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String action = request.getParameter("action");
 
        User user = new User();
        user.setUserID(request.getParameter("userID"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
 
        if ( action.equalsIgnoreCase("edit") ) {
            userDAO.updateUser(user);
        }
        
        else {
            userDAO.addUser(user);
        }
 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", userDAO.getAllUsers());
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
    return "Short description";
    }
}