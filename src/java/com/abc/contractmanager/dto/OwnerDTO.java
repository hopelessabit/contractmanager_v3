/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dto;

import java.sql.Date;

/**
 *
 * @author mical
 */
public class OwnerDTO {
    private int OID;
    private String email;
    private String CID;
    private String password;
    private Date dateOfBirth;
    private String fullName;
    private String phoneNumber;
    private String avatar;
    private String address;
    private int status;
    

    public OwnerDTO() {
    }

    public OwnerDTO(int OID, String email, String CID, String password, Date dateOfBirth, String fullName, String phoneNumber, String avatar, String address, int status) {
        this.OID = OID;
        this.email = email;
        this.CID = CID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" + "OID=" + OID + ", email=" + email + ", CID=" + CID + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", avatar=" + avatar + ", address=" + address + ", status=" + status + '}';
    }
}
