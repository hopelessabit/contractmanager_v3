/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

import com.abc.contractmanager.dao.OwnerDAO;
import com.abc.contractmanager.dao.UserDAO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author mical
 */
public class ForgotPasswordServlet extends HttpServlet {

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
            String email = request.getParameter("emailtxt");
            String password = "";

            String url = "ForgotPassWord.jsp";
//            out.print("hi");
//            out.print("email: "+email);
//            out.print("password: "+ password);
//            CustomerDTO user = CustomerDAO.getAccount("khachhanga@gmail.com", "123");
//            out.print(user.toString());

            UserDTO user = UserDAO.getUserByEmail(email);
            OwnerDTO owner = OwnerDAO.getOwnerByEmail(email);

            if (user != null) {
                password = user.getPassword();
            } else if (owner != null) {
                password = owner.getPassword();
            } else {
                request.setAttribute("notification", "Account is not found");
                request.getRequestDispatcher(url).forward(request, response);
            }
            //Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");

            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("phuhungpham297@gmail.com", "aqlbpnrzkdygigov");//Put your email id and password here
                }
            });

//compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("phuhungpham297@gmail.com"));//change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject("Forgot password");
                message.setText("Your password: " + password);

                //send message
                Transport.send(message);
                request.setAttribute("notification", "Please check your email");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
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
