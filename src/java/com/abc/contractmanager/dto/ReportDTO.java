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
public class ReportDTO {
    private int RpID;
    private String content;
    private Date createDate;

    public ReportDTO() {
    }

    public ReportDTO(int RpID, String content, Date createDate) {
        this.RpID = RpID;
        this.content = content;
        this.createDate = createDate;
    }

    public int getRpID() {
        return RpID;
    }

    public void setRpID(int RpID) {
        this.RpID = RpID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ReportDTO{" + "RpID=" + RpID + ", content=" + content + ", createDate=" + createDate + '}';
    }
    
}
