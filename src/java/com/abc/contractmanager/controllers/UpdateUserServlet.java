/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.utils.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class UpdateUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            String role = request.getParameter("role");
            String email = request.getParameter("email");
            String cid = request.getParameter("cid");
            String password = request.getParameter("password");
            String dob = request.getParameter("date");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String avatar = request.getParameter("avatar");
            int status = Integer.parseInt(request.getParameter("status"));
            int result = 0;
            switch (role) {
                case "U":
                    result = UserDAO.updateProfile(cid, Utilities.convert(dob), name, address, result);
                    if (result > 0) {
                        request.setAttribute("noti", "Update successfully");
                    } else {
                        request.setAttribute("noti", "Can not update");
                    }
                    break;
                case "O":
                    result = OwnerDAO.updateOwner(Integer.parseInt(id), cid, Utilities.convert(dob), name, address);
                    if (result > 0) {
                        request.setAttribute("noti", "Update successfully");
                    } else {
                        request.setAttribute("noti", "Can not update");
                    }
                    break;
            }
            request.getRequestDispatcher("ViewUser?id=" + id + "&role=" + role).forward(request, response);
        }
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
