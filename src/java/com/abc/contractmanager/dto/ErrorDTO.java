/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dto;

/**
 *
 * @author mical
 */
public class ErrorDTO {
    private String emailErr;
   private String passwordErr;
   private String confirmErr;
   private String idErr;
   private String phoneErr;
   private String existed;

    public ErrorDTO() {
    }

    public ErrorDTO(String emailErr, String passwordErr, String confirmErr, String idErr, String existed) {
        this.emailErr = emailErr;
        this.passwordErr = passwordErr;
        this.confirmErr = confirmErr;
        this.idErr = idErr;
        this.existed = existed;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    

    public String getExisted() {
        return existed;
    }

    public void setExisted(String existed) {
        this.existed = existed;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmErr() {
        return confirmErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    public String getIdErr() {
        return idErr;
    }

    public void setIdErr(String idErr) {
        this.idErr = idErr;
    }
}
