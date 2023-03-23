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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class DeleteAvatarServlet extends HttpServlet {

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
            final String avatarName = "default_avatar.png";
            char userType = ((String) request.getSession().getAttribute("userType")).charAt(0);
            String url = "";
            int id = 0;
            switch (userType) {
                case 'O':
                    url = "OwnerProfile.jsp";
                    id = ((OwnerDTO)request.getSession().getAttribute("user")).getOID();
                    OwnerDAO.setAvatar(avatarName, id);
                    request.getSession().setAttribute("user", (OwnerDTO)OwnerDAO.getOwnerByOID(id));
                    break;
                case 'U':
                    url = "UserProfile.jsp";
                    id = ((UserDTO)request.getSession().getAttribute("user")).getUID();
                    UserDAO.setAvatar(avatarName, id);
                    request.getSession().setAttribute("user", (UserDTO)UserDAO.getUserByUID(id));
                    break;
                case 'A':
                    url = "AdminProfile.jsp";
                    id = ((AdminDTO)request.getSession().getAttribute("user")).getAID();
                    AdminDAO.setAvatar(avatarName, id);
                    request.getSession().setAttribute("user", (AdminDTO)AdminDAO.getAdminDetail(id));
                    break;
                case 'B':
                    url = "BoardManagerProfile.jsp";
                    id = ((BoardManagerDTO)request.getSession().getAttribute("user")).getBID();
                    BoardManagerDAO.setAvatar(avatarName, id);
                    request.getSession().setAttribute("user", (BoardManagerDTO)BoardManagerDAO.getAccount(id));
                    break;
            }

            request.setAttribute("noti", "Dont you see your avatar !?");
            
            request.getRequestDispatcher(url).forward(request, response);
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
