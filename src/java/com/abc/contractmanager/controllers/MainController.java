/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.controllers;

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
public class MainController extends HttpServlet {

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
            String action = request.getParameter("action");
            String url = "";
            switch (action) {
                case "Login":
                    url = "LoginServlet";
                    break;
                case "Create New Account":
                    url = "RegistrationServlet";
                    break;
                case "Change password":
                    url = "ChangePassServlet";
                    break;
                case "View Profile":
                    url = "ViewSelfProfileServlet";
                    break;
                case "Find2contracts":
                    url = "FindTwoContractsServlet";
                    break;
                case "FindAllContracts":
                    url = "FindAllContractsServlet";
                    break;
                case "Logout":
                    url = "LogOutServlet";
                    break;
                case "View Contract":
                    url = "ViewAllSelfContractsServlet";
                    break;
                case "viewSellerProfile":
                    url = "ViewSellerProfileServlet";
                    break;
                case "ViewAdmin":
                    url = "ViewAdminServlet";
                    break;
                case "Search Admin":
                    url = "SearchAdmin.jsp";
                    break;
                case "Update Admin":
                    url = "UpdateAdminServlet";
                    break;
                case "Add Admin":
                    url = "AddAdminServlet";
                    break;
                case "ViewContract":
                    url = "ViewContractDetailServlet";
                    break;
                case "viewResidentProfile":
                    url = "ViewResidentProfileServlet";
                    break;
                case "viewOwnerProfile":
                    url = "ViewOwnerProfileServlet";
                    break;
                case "viewCustomerProfile":
                    url = "ViewCustomerProfileServlet";
                    break;
                case "Save Profile":
                    url = "SaveProfileServlet";
                    break;
                case "Search User":
                    url = "SearchUserServlet";
                    break;
                case "ViewUser":
                    url = "ViewUser";
                    break;
                case "Update User":
                    url = "UpdateUserServlet";
                    break;
                case "Add New Account":
                    url = "AddUserServlet";
                    break;
                case "Update Fee":
                    url = "UpdateFeeServlet";
                    break;
                case "userChangePass":
                    url = "ChangePassLoggedInServlet";
                    break;
                case "Forgot password":
                    url = "ForgotPasswordServlet";
                    break;
                case "Search Contract":
                    url = "SearchContractServlet";
                    break;
                case "Create Contract":
                    url = "CreateContractServlet";
                    break;
                case "Sign this Contract":
                    url = "SignContractServlet";
                    break;
                case "SearchAllContract":
                    url = "SearchContractForAdminServlet";
                    break;
                case "getInfo":
                    url = "GetInfoServlet";
                    break;
                case "Submit Contract":
                    url = "SubmitContractServlet";
                    break;
                case "Set Avatar":
                    url = "SetAvatarServlet";
                    break;
                case "Delete Avatar":
                    url = "DeleteAvatarServlet";
                    break;
                case "GetRoomForImg":
                    url = "GetRoomImageServlet";
                    break;
                case "ViewAllRoom":
                    url = "GetAllRoomsServlet";
                    break;
                case "Delete this picture":
                    url = "DeleteRoomPictureServlet";
                    break;
                case "GetOwner":
                    url = "GetOwnerByCIDServlet";
                    break;
                case "AddRoom":
                    url = "AddRoomForOwnerServlet";
                    break;
                case "Pending contract":
                    url = "GetPendingContractServlet";
                    break;
                case "BAN/UNBAN":
                    url = "BanUserServlet";
                    break;
                case "Create Admin":
                    url = "AddAdminServlet";
                    break;
                case "EDIT":
                    url = "GetProfileDetaiServlet";
                    break;
                case "SaveProfileForUser":
                    url = "EditProfileServlet";
                    break;
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
