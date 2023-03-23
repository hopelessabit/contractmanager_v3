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
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
import com.abc.contractmanager.utils.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mical
 */
public class EditProfileServlet extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            String emailRegex = "[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+.+[a-zA-Z0-9.-]$";
            String keyword = request.getParameter("keyword");
            request.setAttribute("keyword", keyword);
            char role = request.getParameter("role").charAt(0);
            int id = Integer.parseInt(request.getParameter("id"));
            String fullName = request.getParameter("txtFullName");
            String CID = request.getParameter("txtcid");
            String address = request.getParameter("txtAddress");
            Date dateOfBirth = new Date(0, 0, 0);
            request.setAttribute("accountID", id);
            request.setAttribute("txtFullName", fullName);
            request.setAttribute("txtcid", CID);
            request.setAttribute("txtAddress", address);
            boolean ready = true;
            if (role != 'A') {
                //date compare: 1 - lon hon; 0 - bang; -1 - nho hon
                dateOfBirth = Date.valueOf(request.getParameter("txtDob"));
                request.setAttribute("txtDate", dateOfBirth);
            }
            if (fullName.equals("")) {
                out.print("Name cannnot be null");
                request.setAttribute("nameError", "Name cannnot be null!");
                ready = false;
            }
            if (CID.equals("")) {
                out.print("CID cannot be null");
                request.setAttribute("CIDError", "CID cannot be null!");
                ready = false;
            }
            if (!Validation.onlyNumber(CID)) {
                out.print("CID must be all number");
                request.setAttribute("CIDError", "CID must be all number");
                ready = false;
            }
            if (CID.length() != 12) {
                out.print("CID must be 12 length number");
                request.setAttribute("CIDError", "CID must be 12 length number");
                ready = false;
            }
            if (address.equals("")) {
                out.print("Addresscan not be null");
                request.setAttribute("addressError", "Addresscan not be null!");
                ready = false;
            }
            if ((new Date(System.currentTimeMillis())).compareTo(dateOfBirth) < 0) {
                out.print("Invalid date");
                request.setAttribute("DoBError", "Invalid date!");
                ready = false;
            }
            if (ready) {
                if (role == 'C' || role == 'R') {
                    UserDTO user = UserDAO.getUserByUID(id);
                    UserDAO.updateProfile(CID, dateOfBirth, fullName, address, id);
                    request.getSession().setAttribute("account", user);
                } else if (role == 'O') {
                    OwnerDTO owner = OwnerDAO.getOwnerByOID(id);
                    OwnerDAO.updateProfile(fullName, dateOfBirth, address, CID, id);
                    request.getSession().setAttribute("account", owner);
                } else if (role == 'A') {
                    AdminDTO admin = AdminDAO.getAdminDetail(id);
                    AdminDAO.updateAdmin(CID, fullName, address, id);
                    request.getSession().setAttribute("account", admin);
                }
            }
            request.setAttribute("noti", "Update profile success!");
            request.getRequestDispatcher("SearchUserServlet").forward(request, response);
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
