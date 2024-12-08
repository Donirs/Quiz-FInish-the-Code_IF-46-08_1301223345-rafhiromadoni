/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import models.User;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author rafhi
 */

@WebServlet("/users")
public class UserController extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private UserService userService = new UserService();
    
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ArrayList<User> users = userService.findAllUsers();
        req.setAttribute("users", users);
        RequestDispatcher rd = req.getRequestDispatcher("showUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String method = req.getParameter("_method");
        if ("put".equalsIgnoreCase(method)) {
            doPut(req, resp);
        } else if ("delete".equalsIgnoreCase(method)) {
            doDelete(req, resp);
        } else {        
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User(username, password);
            userService.saveUser(user);
            resp.sendRedirect("/QUIZ/users");
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT");
        int id = Integer.parseInt(req.getParameter("id"));
        User user =userService.findUserById(id);
        if (user != null) {
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            userService.updateUser(user);
        }
        resp.sendRedirect("/QUIZ/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(userService.findUserById(id).getId());
        resp.sendRedirect("/QUIZ/users");
    }

}
