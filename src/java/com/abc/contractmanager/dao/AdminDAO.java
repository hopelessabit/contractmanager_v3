/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.abc.contractmanager.dto.AdminDTO;
import com.abc.contractmanager.dto.OwnerDTO;
import com.abc.contractmanager.utils.DBUtils;

/**
 *
 * @author mical
 */
public class AdminDAO {

    public static AdminDTO getAccount(String email, String password) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where email=? and password=? COLLATE SQL_Latin1_General_CP1_CS_AS and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    
    public static int insertAdmin(String email, String password, String cid, String phone, String name, String address) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into [Admin]([Email],[CID],[Password],[Fullname],[Phone],[Avartar],[Address],[Status]) values(?,?,?,?,?,?,?,1)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, cid);
            pst.setString(3, password);
            pst.setString(4, name);
            pst.setString(5, phone);
            pst.setString(6, "default_avatar.png");
            pst.setString(7, address);
            result = pst.executeUpdate();
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int ban(int AID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Admin] \n"
                    + "set [Status] = 0\n"
                    + "where [AID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, AID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int unban(int AID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Admin] \n"
                    + "set [Status] = 1\n"
                    + "where [AID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, AID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static AdminDTO getAccount(String email) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where email=? and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public static ArrayList getAdminList() {
        ArrayList<AdminDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin order by AID desc";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                AdminDTO admin = new AdminDTO(rs.getInt(1), rs.getString(5), rs.getInt(9));
                list.add(admin);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList getAdminList(String keyWord) {
        ArrayList<AdminDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where fullname like ?";

            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                AdminDTO admin = new AdminDTO(rs.getInt(1), rs.getString(5), rs.getInt(9));
                list.add(admin);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

//    public static void main(String[] args) {
//        System.out.println(getAdminList());
//    }
    public static AdminDTO getAdminDetail(int id) {
        AdminDTO admin = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from Admin where AID=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {

                admin = new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
    
    public static int changePass(String newPass, String email) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[Admin] set password=? where email=?";
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


    public static int updateAdmin(String cid, String name, String address, int AID) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Admin]\n"
                    + "SET [CID] = ?, [Fullname] = ?, [Address]= ?\n"
                    + "WHERE [AID]= ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, cid);
            pr.setString(2, name);
            pr.setString(3, address);
            pr.setInt(4, AID);
            result = pr.executeUpdate();
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int updateAdmin(String cid, String name, String address, String phone, int AID) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Admin]\n"
                    + "SET [CID] = ?, [Fullname] = ?, [Address]= ?, [Phone] = ?\n"
                    + "WHERE [AID]= ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, cid);
            pr.setString(2, name);
            pr.setString(3, address);
            pr.setString(4, phone);
            pr.setInt(5, AID);
            result = pr.executeUpdate();
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int insertAdmin(String email, String password, String name, String cid) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into  Admin(email,ACID,password,fullname,status) values(?,?,?,?,1)";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, cid);
            pr.setString(3, password);
            pr.setString(4, name);

            result = pr.executeUpdate();

            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public static ArrayList getAdminListByName(String keyWord) {
        ArrayList<AdminDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[Admin] where fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new AdminDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     
    public static void main(String[] args) {
        System.out.println(getAdminListByName("N").size());
    }
    public static void setAvatar(String avatar, int aid){
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[Admin] set [Avartar] =? where [AID]=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, avatar);
            pr.setInt(2, aid);
            pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
