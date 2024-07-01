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
import java.util.logging.Level;
import java.util.logging.Logger;
import lab7.dao.ProfileDAO;
import lab7.model.Profile;

/**
 *
 * @author Zahier
 */
public class ProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        PrintWriter out = response.getWriter();
        ProfileDAO profileDAO = new ProfileDAO();
        Profile profile = new Profile();
 
        String username = request.getParameter("username");
        String icno = request.getParameter("icno");
        String firstname = request.getParameter("firstname");
 
        profile.setUsername(username);
        profile.setIcno(icno);
        profile.setFirstname(firstname);
 
        if (!profile.equals(profileDAO.getProfileByUsername(username)) ) {
            profileDAO.addProfile(profile);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/processProfile.jsp");
            request.setAttribute("profile", profile);
            requestDispatcher.forward(request, response);
        }
        
        else {
            out.println("<script>");
            out.println("alert('Profile with username \\'" + username + "\\' already exists.');");
            out.println("window.location.href = 'registerProfile.html';");
            out.println("</script>");
        }
 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } 
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } 
    
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}