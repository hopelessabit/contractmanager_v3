/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author mical
 */
public class ContractDTO {
    private int CoID;
    private int RoID;
    private int UID;
    private String UName;
    private int OID;
    private String OName;
    private BigDecimal rentalFee;
    private BigDecimal systemFee;
    private Date createDate;
    private Date endDate;
    private String name;
    private String description;
    private int status;

    public ContractDTO() {
    }

    public ContractDTO(int CoID, int RoID, int UID, String UName, int OID, String OName, BigDecimal rentalFee, BigDecimal systemFee, Date createDate, Date endDate, String name, String description, int status) {
        this.CoID = CoID;
        this.RoID = RoID;
        this.UID = UID;
        this.UName = UName;
        this.OID = OID;
        this.OName = OName;
        this.rentalFee = rentalFee;
        this.systemFee = systemFee;
        this.createDate = createDate;
        this.endDate = endDate;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getCoID() {
        return CoID;
    }

    public void setCoID(int CoID) {
        this.CoID = CoID;
    }

    public int getRoID() {
        return RoID;
    }

    public void setRoID(int RoID) {
        this.RoID = RoID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public BigDecimal getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(BigDecimal rentalFee) {
        this.rentalFee = rentalFee;
    }

    public BigDecimal getSystemFee() {
        return systemFee;
    }

    public void setSystemFee(BigDecimal systemFee) {
        this.systemFee = systemFee;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContractDTO{" + "CoID=" + CoID + ", RoID=" + RoID + ", UID=" + UID + ", UName=" + UName + ", OID=" + OID + ", OName=" + OName + ", rentalFee=" + rentalFee + ", systemFee=" + systemFee + ", createDate=" + createDate + ", endDate=" + endDate + ", name=" + name + ", description=" + description + ", status=" + status + '}';
    }
}
