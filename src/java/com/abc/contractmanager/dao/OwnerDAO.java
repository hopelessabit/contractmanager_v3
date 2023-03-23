/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.utils.DBUtils;
import com.abc.contractmanager.utils.Utilities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mical
 */
public class OwnerDAO {
    public static OwnerDTO getOwnerByEmailAndPassword(String email, String password){
        OwnerDTO owner = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select * from [dbo].[Owner] where status=1 and Email = ? and Password = ? COLLATE SQL_Latin1_General_CP1_CS_AS ";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                owner = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner;
    }
    
    public static OwnerDTO getOwnerByEmail(String email){
        OwnerDTO owner = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select * from [dbo].[Owner] where email=? and [Status] =1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                owner = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner;
    }
    
    public static OwnerDTO getOwnerByCID(String CID){
        OwnerDTO owner = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select * from [dbo].[Owner] where [CID]= ? and [Status] =1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, CID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                owner = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner;
    }
    
    public static OwnerDTO getOwnerByOID(int OID){
        OwnerDTO owner = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select * from [dbo].[Owner] where OID = ? ";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, OID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                owner = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner;
    }
    
    public static String getOwnerNameByID(int OID){
        String name = "";
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select * from [dbo].[Owner] where OID = ? ";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, OID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
    
    public static int changePass(String newPass, String email) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[Owner] set password=? where email=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, newPass);
            pr.setString(2, email);
            result = pr.executeUpdate();
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(changePass("1234567", "owner@gmail.com"));
    }
    
    public static int updateProfile(String name, Date dob, String address, String CID, int OID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Owner] \n"
                    + "set [Fullname] = ?, [DateOfBirth] = ?, [Address] = ?, [CID] = ?\n"
                    + "where [OID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, name);
            pr.setDate(2, dob);
            pr.setString(3, address);
            pr.setString(4, CID);
            pr.setInt(5, OID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static ArrayList getOwnerList(){
        ArrayList<OwnerDTO> list = new ArrayList<>();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[Owner]";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                OwnerDTO user = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static int countOwner(){
        int result = 0;
        ArrayList<OwnerDTO> list = new ArrayList<>();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[Owner]";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                result++;
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static ArrayList getOwnerListByName(String keyWord) {
        ArrayList<OwnerDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[Owner] where fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                OwnerDTO user = new OwnerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static int updateOwner(int OID, String CID, Date dob, String name, String address) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Ơner] \n"
                    + "set [Fullname] = ?, [DateOfBirth] = ?, [Address] = ?, [CID] = ?\n"
                    + "where OID = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, name);
            pr.setDate(2, dob);
            pr.setString(3, address);
            pr.setString(4, CID);
            pr.setInt(5, OID);
            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int insertOwner(String email, String password, String cid, String phone, String name, String dob, String address) {
        int rs = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into [Owner]([Email],[CID],[Password],[DateOfBirth],[Fullname],[Phone],[Address],[Status]) values(?,?,?,?,?,?,?,?,1)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, cid);
            pst.setString(3, password);
            pst.setDate(4, Utilities.convert(dob));
            pst.setString(5, name);
            pst.setString(6, phone);
            pst.setString(7, address);
            rs = pst.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public static int ban(int OID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Owner] \n"
                    + "set [Status] = 0\n"
                    + "where [OID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, OID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int unban(int OID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Owner] \n"
                    + "set [Status] = 1\n"
                    + "where [OID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, OID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void setAvatar(String avatar, int oid){
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[Owner] set [Avartar] =? where [OID]=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, avatar);
            pr.setInt(2, oid);
            pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
