/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.ContractDAO;
import com.abc.contractmanager.dao.RoomDAO;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.BoardManagerDTO;
import com.abc.contractmanager.dto.ContractDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ViewAllSelfContractsServlet extends HttpServlet {

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
            Object user = new Object();
            int userID = 0;
            char userType = ((String) session.getAttribute("userType")).charAt(0);
            switch (userType) {
                case 'U':
                    user = (UserDTO) session.getAttribute("user");
                    userID = ((UserDTO) user).getUID();
                    break;
                case 'O':
                    user = (OwnerDTO) session.getAttribute("user");
                    userID = ((OwnerDTO) user).getOID();
                    break;
                case 'B':
                    user = (BoardManagerDTO) session.getAttribute("user");
                    userID = ((BoardManagerDTO) user).getBID();
                    break;
                case 'A':
                    user = (AdminDTO) session.getAttribute("user");
                    userID = ((AdminDTO) user).getAID();
                    break;
            }
            ArrayList<ContractDTO> list = ContractDAO.getContracts(userType, userID);
             ArrayList<String> img = new ArrayList<>();
            for (ContractDTO contract : list) {
                int RoIDa = contract.getRoID();
                img.add(RoomDAO.getRoomImg(RoIDa));
            }
            request.setAttribute("imgList", img);
            request.setAttribute("contractList", list);
//            out.println("<p>"+list.size()+"</p>");
//            for (ContractDTO contract : list) {
//                out.println(contract.toString() + "<br/>");
//            }
            request.getRequestDispatcher("ContractPage.jsp").forward(request, response);
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
