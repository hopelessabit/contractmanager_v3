/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.AdminDAO;
import com.abc.contractmanager.dao.BoardManagerDAO;
import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.BoardManagerDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
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
public class ChangePassLoggedInServlet extends HttpServlet {

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
            String email = "";
            String txtpass = request.getParameter("txtPassword");
            String password = request.getParameter("oldPasstxt");
            String newPass = request.getParameter("newPasstxt");
            String confirm = request.getParameter("confirmPasstxt");
            String durl = request.getParameter("durl");
            char role = ((String) request.getSession().getAttribute("userType")).charAt(0);
            Object user = request.getSession().getAttribute("user");
            boolean fault = false;
            if (!txtpass.equals(password)) {
                fault = true;
                request.setAttribute("noti", "Input old password is wrong!");
            } else if (newPass.trim().length() < 6 || newPass.trim().length() > 30) {
                fault = true;
                request.setAttribute("noti", "Requires 6-30 chars");
            } else if (!newPass.equals(confirm)) {
                fault = true;
                request.setAttribute("noti", "New password is not matched");
            }
            if (!fault) {
                switch (role) {
                    case 'U':
                        UserDAO.changePass(newPass, ((UserDTO) user).getEmail());
                        request.setAttribute("noti", "Change password successfully!");
                        user = (UserDTO) request.getSession().getAttribute("user");
                        user = UserDAO.getUserByUID(((UserDTO) user).getUID());
                        break;
                    case 'O':
                        OwnerDAO.changePass(newPass, ((OwnerDTO) user).getEmail());
                        request.setAttribute("noti", "Change password successfully!");
                        user = (OwnerDTO) request.getSession().getAttribute("user");
                        user = OwnerDAO.getOwnerByOID(((OwnerDTO) user).getOID());
                        break;
                    case 'A':
                        AdminDAO.changePass(newPass, ((AdminDTO) user).getEmail());
                        request.setAttribute("noti", "Change password successfully!");
                        user = (AdminDTO) request.getSession().getAttribute("user");
                        user = AdminDAO.getAdminDetail(((AdminDTO) user).getAID());
                        break;
                    case 'B':
                        BoardManagerDAO.changePass(newPass, ((BoardManagerDTO) user).getEmail());
                        request.setAttribute("noti", "Change password successfully!");
                        user = (BoardManagerDTO) request.getSession().getAttribute("user");
                        user = BoardManagerDAO.getAccount(((BoardManagerDTO) user).getEmail());
                        break;

                }
            }
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher(durl).forward(request, response);
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
