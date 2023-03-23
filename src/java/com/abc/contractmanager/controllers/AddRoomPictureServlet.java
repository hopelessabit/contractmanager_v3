/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
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
        maxFileSize = 1024 * 1024 * 10,      //10MB
        maxRequestSize = 1024 * 1024 * 100   //100MB
)

public class AddRoomPictureServlet extends HttpServlet {

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
            Part p = request.getPart("picture");
            int RoID = Integer.parseInt(request.getParameter("RoID"));
//            Collection<Part> q = request.getParts();
            String[] sp;
            String ext, fileName, paths;
            Path source;
            String path = "E:\\STUDY DATA\\ContractManager-GITHUB\\contractmanager-ver2\\" + "web\\room_images\\";
            Collection<Part> a = request.getParts();
            for (Part part : request.getParts()) {
                fileName = part.getSubmittedFileName();
                part.write(path + fileName);
                sp = part.getSubmittedFileName().split("\\.");
                ext = sp[(sp.length)-1];
                source = Paths.get(path + fileName);
                paths = String.valueOf(System.currentTimeMillis()) + "." + ext;
                Files.move(source, source.resolveSibling(paths));
                RoomDAO.addRoomPicture(paths, RoID);
            }
            response.sendRedirect("GetRoomImageServlet?RoID=" + RoID);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
