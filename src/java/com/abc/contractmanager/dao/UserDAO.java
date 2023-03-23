/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import com.abc.contractmanager.dto.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.abc.contractmanager.utils.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mical
 */
public class UserDAO {
    public static UserDTO getUserByEmailAndPassword(String email, String password) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where email = ? and password = ? COLLATE SQL_Latin1_General_CP1_CS_AS and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static UserDTO getUserByEmail(String email) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where email = ? status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static UserDTO getUserByNameAndCID(String name, String CID) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [fullname] like ? and [CID] = ? and [Status] = 1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + name + "%");
            pr.setString(2, CID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static UserDTO getUserByUID(int UID) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [UID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, UID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static int insertCustomer(String email, String password, String cid, String phone, String name, String dob, String address) {
        int rs = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into [User]([Email],[CID],[Password],[DateOfBirth],[Fullname],[Phone],[Address],[Type],[Status]) values(?,?,?,?,?,?,?,0,1)";
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

    public static int insertResident(String email, String password, String cid, String phone, String name, String dob, String address) {
        int rs = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "insert into [User]([Email],[CID],[Password],[DateOfBirth],[Fullname],[Phone],[Address],[Type],[Status]) values(?,?,?,?,?,?,?,1,1)";
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
    
    public static int updatePassword(int UID, String newPass) {
        int rs = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[User] set password=? where UID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newPass);
            pst.setInt(2, 1);
            rs = pst.executeUpdate();

            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int updateProfile(String CID, Date dob, String name, String address, int UID) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[User] \n"
                    + "set [Fullname] = ?, [DateOfBirth] = ?, [Address] = ?, [CID] = ?\n"
                    + "where UID = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, name);
            pr.setDate(2, dob);
            pr.setString(3, address);
            pr.setString(4, CID);
            pr.setInt(5, UID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static ArrayList getUserList() {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User]";
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static ArrayList getUserListByName(String keyWord) {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static ArrayList getCustomerListByName(String keyWord) {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 0 and fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static UserDTO getCustomerByID(int UID) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 0 and [UID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, UID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static ArrayList getResidentListByName(String keyWord) {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 1 and fullname like ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, "%" + keyWord + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static UserDTO getResidentByID(int UID) {
        UserDTO user = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 1 and [UID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, UID);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static ArrayList getCustomer() {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 0";
            ResultSet rs = cn.createStatement().executeQuery(sql);
            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static ArrayList getResident() {
        ArrayList<UserDTO> list = new ArrayList();
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from [dbo].[User] where [Type] = 1";
            ResultSet rs = cn.createStatement().executeQuery(sql);
            while (rs.next()) {
                UserDTO user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
                list.add(user);
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static int changePass(String newPass, String email) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[User] set password=? where email=?";
            PreparedStatement pr = cn.prepareStatement(sql);

            pr.setString(1, newPass);
            pr.setString(2, email);
            result = pr.executeUpdate();

            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void setNameWithAccented(){
        String str = "á ắ b đã";
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[User] set [Fullname] =? where [UID]=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, str);
            pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setAvatar(String avatar, int uid){
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[User] set [Avartar] =? where [UID]=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, avatar);
            pr.setInt(2, uid);
            pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int upRoleResident(int UID){
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[User] set [Type]= 1 where UID = ?";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, UID);
                rs = pr.executeUpdate();
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public static int ban(int UID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[User] \n"
                    + "set [Status] = 0\n"
                    + "where [UID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, UID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static int unban(int UID){
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[User] \n"
                    + "set [Status] = 1\n"
                    + "where [UID] = ?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, UID);
            result = pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        UserDTO user = getUserByUID(1);
        System.out.println(user.toString());
        setNameWithAccented();
        user = getUserByUID(1);
        System.out.println(user.toString());
    }
}
