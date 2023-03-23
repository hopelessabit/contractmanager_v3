/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.abc.contractmanager.utils.DBUtils;
import java.sql.SQLException;

/**
 *
 * @author mical
 */
public class RoomDAO {

    public static ArrayList<Integer> getRoomID(int OID) {
        ArrayList<Integer> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [RoID],[UID],[status]\n"
                        + "FROM [dbo].[Room]\n"
                        + "where [OID] = ? and status = 0 and [UID] IS NULL";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, OID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }
    
    public static ArrayList<Integer> getAllRoomIDFree() {
        ArrayList<Integer> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [RoID]\n"
                        + "FROM [dbo].[Room]\n"
                        + "where [OID] IS NULL";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        } 
        return result;
    }
    
    public static ArrayList<Integer> getAllRoomID(int OID) {
        ArrayList<Integer> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [RoID],[UID],[status]\n"
                        + "FROM [dbo].[Room]\n"
                        + "where [OID] = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, OID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }

    public static void updateRoomIn(int userID, int roomID) {
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Room]\n"
                        + "set [UID] = ?, [status]= 1\n"
                        + "where [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setInt(2, roomID);
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
    }
    
    public static boolean updateOwner(int OID, int RoID) {
        boolean result = false;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Room]\n"
                        + "set [OID] = ?\n"
                        + "where [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, OID);
                pst.setInt(2, RoID);
                pst.executeUpdate();
                result = true;
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static void updateRoomOut(int roomID) {
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Room]\n"
                        + "set [UID] = NULL, [status]= 0\n"
                        + "where [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, roomID);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
    }
    
    public static void updateRoomUID(int roomID, int UID) {
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Room]\n"
                        + "set [UID] = ?, [status]= 0\n"
                        + "where [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, UID);
                pst.setInt(2, roomID);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static int addRoomPicture(String imgPath, int RoID) {
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[RoomImage]([RoID],[ImgPath]) values(?,?)";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, RoID);
                pr.setString(2, imgPath);
                rs = pr.executeUpdate();
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int deleteRoomPicture(String imgPath, int RoID) {
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "delete from [dbo].[RoomImage] where [RoID]=? and [ImgPath]=?";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, RoID);
                pr.setString(2, imgPath);
                rs = pr.executeUpdate();
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ArrayList<String> getRoomImage(int RoID) {
        ArrayList<String> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [ImgPath] "
                        + "FROM [dbo].[RoomImage] "
                        + "WHERE [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, RoID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        result.add(rs.getString(1));
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static String getRoomImg(int RoID) {
        String result = "";
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP 1 [ImgPath]\n"
                        + "FROM [dbo].[RoomImage]\n"
                        + "where [RoID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, RoID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    result = rs.getString(1);
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getRoomImg(1));
    }
}
