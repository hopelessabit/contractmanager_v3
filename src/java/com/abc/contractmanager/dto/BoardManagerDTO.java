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
public class BoardManagerDTO {
    
    private int BID;
    private String email;   
    private String CID;   
    private String password;
    private String fullName;
    private String phoneNumber;      
    private String avatar;      
    private String address;
    private int status;

    public BoardManagerDTO(int BID, String email, String CID, String password, String fullName, String phoneNumber, String avatar, String address, int status) {
        this.BID = BID;
        this.email = email;
        this.CID = CID;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
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
        return "BoardManagerDTO{" + "BID=" + BID + ", email=" + email + ", CID=" + CID + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", avatar=" + avatar + ", address=" + address + ", status=" + status + '}';
    }

}
