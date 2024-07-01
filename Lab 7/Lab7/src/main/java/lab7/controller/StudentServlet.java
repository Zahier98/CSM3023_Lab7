/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab7.dao.StudentDAO;
import lab7.model.Student;

/**
 *
 * @author Zahier
 */
public class StudentServlet extends HttpServlet {

    private StudentDAO studentDAO;
    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String studID = request.getParameter("studID");
        String studName = request.getParameter("studName");
 
        HttpSession session = request.getSession();
        session.setAttribute("studID", studID);
        session.setAttribute("studName", studName);
        response.sendRedirect("confirmRegister.jsp");
 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        try {
            String studID = request.getParameter("studID");
            String studName = request.getParameter("studName");
 
            Student student = new Student();
            student.setStudID(studID);
            student.setStudName(studName);
 
            boolean addSuccess = studentDAO.insertStudent(student);
 
            HttpSession session = request.getSession();
            session.setAttribute("addSuccess", addSuccess);
 
            ServletContext sc = getServletContext();
            RequestDispatcher dispatcher = sc.getRequestDispatcher("/notificationRegister.jsp");
            dispatcher.forward(request, response);
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}