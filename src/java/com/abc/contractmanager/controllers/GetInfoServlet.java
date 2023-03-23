/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.AdminDAO;
import com.abc.contractmanager.dao.ContractDAO;
import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.ContractDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mical
 */
public class GetInfoServlet extends HttpServlet {

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
            int ownerAvailable = 0, customerAvailable = 0, residentAvailable = 0;
            int ownerUnavailable = 0, customerUnavailable = 0, residentUnavaiable = 0;
            int contractAvaiable = 0, contractUnavailable = 0;
            BigDecimal revenue = BigDecimal.valueOf(0);
            ArrayList<ContractDTO> contractList = ContractDAO.getContracts();
            ArrayList<OwnerDTO> ownerList = OwnerDAO.getOwnerList();
            ArrayList<UserDTO> userList = UserDAO.getUserList();
            ArrayList<AdminDTO> addminList = AdminDAO.getAdminList();
            int adminAvailable = 0;
            int allUser = ownerList.size() + userList.size();

            for (ContractDTO contract : contractList) {
                if (contract.getStatus() == 1) {
                    contractAvaiable++;
                    revenue = revenue.add(contract.getSystemFee());
                } else {
                    contractUnavailable++;
                }
            }

            for (UserDTO user : userList) {
                if (user.getType() == 0) {
                    if (user.getStatus() == 1) {
                        customerAvailable++;
                    } else {
                        customerUnavailable++;
                    }
                } else {
                    if (user.getStatus() == 1) {
                        residentAvailable++;
                    } else {
                        residentUnavaiable++;
                    }
                }
            }

            for (OwnerDTO owner : ownerList) {
                if (owner.getStatus() == 1) {
                    ownerAvailable++;
                } else {
                    ownerUnavailable++;
                }
            }

            for (AdminDTO admin : addminList) {
                if (admin.getStatus() == 1) {
                    adminAvailable++;
                }
            }

            request.setAttribute("ownerAvailable", ownerAvailable);
            request.setAttribute("ownerUnavailable", ownerUnavailable);
            request.setAttribute("customerAvailable", customerAvailable);
            request.setAttribute("customerUnavailable", customerUnavailable);
            request.setAttribute("residentAvailable", residentAvailable);
            request.setAttribute("residentUnavaiable", residentUnavaiable);
            request.setAttribute("contractAvaiable", contractAvaiable);
            request.setAttribute("contractUnavailable", contractUnavailable);
            request.setAttribute("adminAvailable", adminAvailable);
            request.setAttribute("revenue", revenue);
//            out.print(allUser + ":" + ownerAvailable + "+" + ownerUnavailable + ":" + customerAvailable + "+" + customerUnavaiable + ":" + residentAvailable + "+" + residentUnavaiable);
            char userType = ((String) session.getAttribute("userType")).charAt(0);
            String url = "";
            if (userType == 'A') {
                url = "AdminIndex.jsp";
            } else {
                url = "BoardManagerIndex.jsp";
            }
//            out.print(url);

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
