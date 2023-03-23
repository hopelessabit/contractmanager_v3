/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author mical
 */
public class ViewSelfProfileServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            Object viewProfile = new Object();
            char userType = ((String) session.getAttribute("userType")).charAt(0);

//            viewProfile = (OwnerDTO) session.getAttribute("user");
            String edit = "true";
            switch (userType) {
                case 'U':
                    viewProfile = (UserDTO) session.getAttribute("user");
                    if (null == request.getAttribute("txtFullName")) {
                        request.setAttribute("txtFullName", ((UserDTO) viewProfile).getFullName());
                    }
                    if (null == request.getAttribute("txtcid")) {
                        request.setAttribute("txtcid", ((UserDTO) viewProfile).getCID());
                    }
                    if (null == request.getAttribute("txtDate")) {
                        request.setAttribute("txtDate", ((UserDTO) viewProfile).getDateOfBirth());
                    }
                    if (null == request.getAttribute("address")) {
                        request.setAttribute("address", ((UserDTO) viewProfile).getAddress());
                    }
                    request.setAttribute("profileType", "C");
                    request.setAttribute("viewProfile", viewProfile);
                    request.setAttribute("edit", edit);
                    request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
                    break;
                case 'O':
                    viewProfile = (OwnerDTO) session.getAttribute("user");
                    if (null == request.getAttribute("txtFullName")) {
                        request.setAttribute("txtFullName", ((OwnerDTO) viewProfile).getFullName());
                    }
                    if (null == request.getAttribute("txtcid")) {
                        request.setAttribute("txtcid", ((OwnerDTO) viewProfile).getCID());
                    }
                    if (null == request.getAttribute("txtDate")) {
                        request.setAttribute("txtDate", ((OwnerDTO) viewProfile).getDateOfBirth());
                    }
                    if (null == request.getAttribute("address")) {
                        request.setAttribute("address", ((OwnerDTO) viewProfile).getAddress());
                    }
                    request.setAttribute("profileType", "O");
                    request.setAttribute("viewProfile", viewProfile);
                    request.setAttribute("edit", edit);
                    request.getRequestDispatcher("OwnerProfile.jsp").forward(request, response);
                    break;
                case 'A':
                    viewProfile = (AdminDTO) session.getAttribute("user");
                    if (null == request.getAttribute("txtFullName")) {
                        request.setAttribute("txtFullName", ((AdminDTO) viewProfile).getFullName());
                    }
                    if (null == request.getAttribute("txtcid")) {
                        request.setAttribute("txtcid", ((AdminDTO) viewProfile).getCID());
                    }
                    if (null == request.getAttribute("address")) {
                        request.setAttribute("address", ((AdminDTO) viewProfile).getAddress());
                    }
                    request.setAttribute("profileType", "A");
                    request.setAttribute("viewProfile", viewProfile);
                    request.setAttribute("edit", edit);
                    request.getRequestDispatcher("AdminProfile.jsp").forward(request, response);
                    break;
                case 'B':
                    viewProfile = (BoardManagerDTO) session.getAttribute("user");
                    if (null == request.getAttribute("txtFullName")) {
                        request.setAttribute("txtFullName", ((BoardManagerDTO) viewProfile).getFullName());
                    }
                    if (null == request.getAttribute("txtcid")) {
                        request.setAttribute("txtcid", ((BoardManagerDTO) viewProfile).getCID());
                    }
                    if (null == request.getAttribute("address")) {
                        request.setAttribute("address", ((BoardManagerDTO) viewProfile).getAddress());
                    }
                    request.setAttribute("profileType", "B");
                    request.setAttribute("viewProfile", viewProfile);
                    request.setAttribute("edit", edit);
                    request.getRequestDispatcher("BoardManagerProfile.jsp").forward(request, response);
                    break;
                default:
                    out.print("Failed to get user type");
            }
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
