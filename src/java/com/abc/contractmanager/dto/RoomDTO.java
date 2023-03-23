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
public class RoomDTO {
    private int RoID;
    private int OID;
    private int status;

    public RoomDTO() {
    }

    public RoomDTO(int RoID, int OID, int status) {
        this.RoID = RoID;
        this.OID = OID;
        this.status = status;
    }

    public int getRoID() {
        return RoID;
    }

    public void setRoID(int RoID) {
        this.RoID = RoID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "RoID=" + RoID + ", OID=" + OID + ", status=" + status + '}';
    }
}
