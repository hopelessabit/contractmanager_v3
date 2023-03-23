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
import com.abc.contractmanager.dto.BoardManagerDTO;
import com.abc.contractmanager.utils.DBUtils;

/**
 *
 * @author mical
 */
public class BoardManagerDAO {
    public static BoardManagerDTO getAccount(String email, String password) {
        BoardManagerDTO boardManager = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from BoardManager where email=? and password=? COLLATE SQL_Latin1_General_CP1_CS_AS and status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                boardManager = new BoardManagerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return boardManager;
    }
    public static void main(String[] args) {
        System.out.println(getAccount("chutich@gmail.com","123").toString());;
    }

    public static BoardManagerDTO getAccount(String email) {
        BoardManagerDTO boardManager = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from BoardManager where email=? and   status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, email);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                boardManager = new BoardManagerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return boardManager;
    }
    
    public static int changePass(String newPass, String email) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[BoardManager] set password=? where email=?";
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

    
    public static BoardManagerDTO getAccount(int BID) {
        BoardManagerDTO boardManager = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "Select * from BoardManager where [BID]=? and   status=1";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, BID);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                boardManager = new BoardManagerDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return boardManager;
    }
    
    public static int updateAdmin(String cid, String name, String address, int AID) {
        int result = 0;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[BoardManager]\n"
                    + "SET [CID] = ?, [Fullname] = ?, [Address]= ?\n"
                    + "WHERE [BID]= ?";
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
    public static void setAvatar(String avatar, int bid){
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "update [dbo].[BoardManager] set [Avartar] =? where [BID]=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, avatar);
            pr.setInt(2, bid);
            pr.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
