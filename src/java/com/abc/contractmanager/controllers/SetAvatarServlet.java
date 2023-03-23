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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mical
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, //1MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 100 //100MB
)
public class SetAvatarServlet extends HttpServlet {

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
            final String PATH = "E:\\STUDY DATA\\ContractManager-GITHUB\\contractmanager-ver2";
            /* TODO output your page here. You may use following sample code. */
            Part filePart = request.getPart("avatar");
            String fileName = filePart.getSubmittedFileName();
            String[] sp = fileName.split("\\.");
            String ext = sp[(sp.length) - 1];
//            for (Part part : request.getParts()) {
//                part.write(PATH + "\\web\\images\\" + fileName);
//            }
            filePart.write(PATH + "\\web\\images\\" + fileName);
            char userType = ((String) request.getSession().getAttribute("userType")).charAt(0);
            Path source = Paths.get(PATH + "\\web\\images\\" + fileName);
            String fileSName = String.valueOf(System.currentTimeMillis()) + "." + ext;
            Files.move(source, source.resolveSibling(fileSName));
            String url = "";
            int id = 0;
            switch (userType) {
                case 'O':
                    url = "OwnerProfile.jsp";
                    id = ((OwnerDTO)request.getSession().getAttribute("user")).getOID();
                    OwnerDAO.setAvatar(fileSName, id);
                    request.getSession().setAttribute("user", (OwnerDTO)OwnerDAO.getOwnerByOID(id));
                    break;
                case 'U':
                    url = "UserProfile.jsp";
                    id = ((UserDTO)request.getSession().getAttribute("user")).getUID();
                    UserDAO.setAvatar(fileSName, id);
                    request.getSession().setAttribute("user", (UserDTO)UserDAO.getUserByUID(id));
                    break;
                case 'A':
                    url = "AdminProfile.jsp";
                    id = ((AdminDTO)request.getSession().getAttribute("user")).getAID();
                    AdminDAO.setAvatar(fileSName, id);
                    request.getSession().setAttribute("user", (AdminDTO)AdminDAO.getAdminDetail(id));
                    break;
                case 'B':
                    url = "BoardManagerProfile.jsp";
                    id = ((BoardManagerDTO)request.getSession().getAttribute("user")).getBID();
                    BoardManagerDAO.setAvatar(fileSName, id);
                    request.getSession().setAttribute("user", (BoardManagerDTO)BoardManagerDAO.getAccount(id));
                    break;
            }

            request.setAttribute("noti", "Upload avatar success!");
            
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
