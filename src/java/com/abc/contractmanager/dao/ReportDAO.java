/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import com.abc.contractmanager.dto.ReportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.abc.contractmanager.utils.DBUtils;

/**
 *
 * @author mical
 */
public class ReportDAO {
    public static ArrayList getReports() throws SQLException {
         ArrayList<ReportDTO> list=new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Report";
            PreparedStatement pr = cn.prepareStatement(sql);
         
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                 ReportDTO rp=new ReportDTO(rs.getInt(1),rs.getString(2),rs.getDate(3));
                 list.add(rp);
             }
            cn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
   public static void main(String[] args) throws SQLException {
         ArrayList<ReportDTO> list=getReports();
         for(ReportDTO rp:list){
             System.out.println(rp);
         }
    }
}
