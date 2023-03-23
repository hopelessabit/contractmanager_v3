/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.contractmanager.dao;

import com.abc.contractmanager.dto.ContractDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.abc.contractmanager.utils.DBUtils;
import com.abc.contractmanager.utils.Utilities;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mical
 */
public class ContractDAO {

    public static ArrayList<ContractDTO> getContracts(char userType, int id) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]";
                if (userType == 'U') {
                    sql = sql + " where [dbo].[Contract].[UID]=?";
                } else {
                    sql = sql + " where [dbo].[Contract].[OID]=?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ArrayList<ContractDTO> getContracts() {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]";
                ResultSet rs = cn.createStatement().executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(8)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractByName(String name) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [dbo].[Contract].[Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]"
                        + "where [dbo].[ContractInformation].[Name] like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContract(String name, Date from, Date to, int userID, char userType) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]";
                switch (userType) {
                    case 'U':
                        sql = sql + "where Contract.[UID]=? and \n"
                                + "(dbo.Owner.fullname like ?";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=? and \n"
                                + "(dbo.User.fullname like ?";
                        break;
                }
                sql = sql + " or [dbo].[ContractInformation].[Name] like ?";
                if (from != null) {
                    if (to != null) {
                        sql = sql + ") and ([createDate]>=? or [endDate] <=?)";
                        type = 3;
                    } else {
                        sql = sql + ") and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + ") and ([endDate] <=?)";
                        type = 1;
                    }
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, "%" + name + "%");
                pst.setString(3, "%" + name + "%");
                switch (type) {
                    case 3:
                        pst.setDate(4, from);
                        pst.setDate(5, to);
                        break;
                    case 2:
                        pst.setDate(4, from);
                        break;
                    case 1:
                        pst.setDate(4, to);
                        break;

                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
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

    public static ArrayList<ContractDTO> searchContract(String name, Date from, Date to, int userID, char userType, int Status) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID] ";
                switch (userType) {
                    case 'U':
                        sql = sql + "where Contract.[UID]=? and \n"
                                + "([dbo].[Owner].[Fullname] like ?";
                        break;
                    case 'O':
                        sql = sql + "where Contract.[OID]=? and \n"
                                + "([dbo].[User].[Fullname] like ?";
                        break;
                }
                sql = sql + " or [dbo].[ContractInformation].[Name] like ?)";
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? and [createDate]<=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([createDate] <=?)";
                        type = 1;
                    } else {
                        sql = sql + "";
                    }
                }
                if (Status != -1) {
                    sql = sql + " and [Contract].[status] = ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setString(2, "%" + name + "%");
                pst.setString(3, "%" + name + "%");
                switch (type) {
                    case 3:
                        pst.setDate(4, from);
                        pst.setDate(5, to);
                        if (Status != -1) {
                            pst.setInt(6, Status);
                        }
                        break;
                    case 2:
                        pst.setDate(4, from);
                        if (Status != -1) {
                            pst.setInt(5, Status);
                        }
                        break;
                    case 1:
                        pst.setDate(4, to);
                        if (Status != -1) {
                            pst.setInt(5, Status);
                        }
                        break;
                    case 0:
                        if (Status != -1) {
                            pst.setInt(4, Status);
                        }
                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ArrayList<ContractDTO> searchContractByStatus(int status, int userID, char userType) {
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Contract.[CoID],[RoID],Contract.[CID],[dbo].[Contract].[RID],[dbo].[Owner].[OID],[dbo].[Contract].[SID],[dbo].[Contract].[status],[fee],[total],[createDate],[endDate],\n"
                        + "[dbo].[Customer].[fullname] AS [CName], [dbo].[Owner].[fullname] AS [OName], [dbo].[Seller].[fullname] AS [SName], [dbo].[Resident].[fullname] AS [RName]\n"
                        + "from Contract \n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID]\n"
                        + "left join [dbo].[Customer] on [dbo].[Contract].CID = [dbo].[Customer].CID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                        + "left join [dbo].[Seller] on [dbo].[Contract].[SID] = [dbo].[Seller].[SID]\n"
                        + "left join [dbo].[Resident] on [dbo].[Contract].[RID] = [dbo].[Resident].[RID]\n"
                        + "where [Contract].[status] = ? ";
                switch (userType) {
                    case 'U':
                        sql = sql + "and Contract.[UID]=?";
                        break;
                    case 'O':
                        sql = sql + "and Contract.[OID]=?";
                        break;
                }

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setInt(2, userID);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static ContractDTO getContractDetail(String id) {
        ContractDTO contract = null;
        try {
            Connection cn = DBUtils.getConnection();
            String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                    + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [dbo].[ContractInformation].[RentalFee],[dbo].[ContractInformation].[SystemFee],\n"
                    + "[dbo].[ContractInformation].[CreateDate], [dbo].[ContractInformation].[EndDate], [dbo].[ContractInformation].[Name],\n"
                    + "[dbo].[ContractInformation].[Description], [dbo].[Contract].[Status]\n"
                    + "from Contract \n"
                    + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                    + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                    + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n"
                    + "where [dbo].[Contract].[CoID] = ? ";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                        contract = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
            }
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return contract;
    }

    public static int getContract(int RoID, int UID, int OID) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "";
                sql = " select [CoID]\n"
                        + "  from [dbo].[Contract]\n"
                        + "  where [RoID]= ? and [UID]= ? and [OID]= ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, RoID);
                pst.setInt(2, UID);
                pst.setInt(3, OID);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    result = rs.getInt("CoID");
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

    public static ArrayList<ContractDTO> searchContract2(String name, Date from, Date to, int Status) {
        if (name == null) {
            name = "";
        }
        ArrayList<ContractDTO> result = new ArrayList<>();
        Connection cn = null;
        int type = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID] ";
                sql = sql + "where ([dbo].[User].[Fullname] like ? or [dbo].[Owner].[Fullname] like ? )";
                if (from != null) {
                    if (to != null) {
                        sql = sql + " and ([createDate]>=? and [createDate]<=?)";
                        type = 3;
                    } else {
                        sql = sql + " and ([createDate]>=?)";
                        type = 2;
                    }
                } else {
                    if (to != null) {
                        sql = sql + " and ([createDate] <=?)";
                        type = 1;
                    } else {
                        sql = sql + "";
                    }
                }
                if (Status != -1) {
                    sql = sql + " and [Contract].[status] = ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setString(2, "%" + name + "%");
                switch (type) {
                    case 3:
                        pst.setDate(3, from);
                        pst.setDate(4, to);
                        if (Status != -1) {
                            pst.setInt(5, Status);
                        }
                        break;
                    case 2:
                        pst.setDate(3, from);
                        if (Status != -1) {
                            pst.setInt(4, Status);
                        }
                        break;
                    case 1:
                        pst.setDate(3, to);
                        if (Status != -1) {
                            pst.setInt(4, Status);
                        }
                        break;
                    case 0:
                        if (Status != -1) {
                            pst.setInt(3, Status);
                        }
                }
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.getCause();
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ContractDTO> list = getContracts();
        for (ContractDTO contractDTO : list) {
            System.out.println(contractDTO.getRentalFee());
        }
    }

    public static void createContract(int RoID, int UID, int OID, BigDecimal rentalFee, Date from, Date to, String name, String description) {
        Connection cn = null;
        float systemFee = Utilities.calculateSystemFee(Utilities.countMonth(from.toString(), to.toString())).floatValue();
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "";
                sql = "INSERT [dbo].[Contract] ([RoID], [UID], [OID], [Status]) \n"
                        + "VALUES (?, ?, ?, 0)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, RoID);
                pst.setInt(2, UID);
                pst.setInt(3, OID);
                pst.executeUpdate();
                int CoID = getContract(RoID, UID, OID);
                String sql1 = "INSERT [dbo].[ContractInformation] ([CoID], [RentalFee], [SystemFee], [createDate], [endDate], [name], [description]) "
                        + "VALUES (?,?,?,?,?,?,?)";
                PreparedStatement pst1 = cn.prepareStatement(sql1);
                pst1.setInt(1, CoID);
                pst1.setFloat(2, rentalFee.floatValue());
                pst1.setFloat(3, systemFee);
                pst1.setDate(4, from);
                pst1.setDate(5, to);
                pst1.setString(6, name);
                pst1.setString(7, description);
                pst1.executeUpdate();
                cn.close();
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

    public static int updateFee(int rentalFee, String id) {
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update ContractInformation set [SystemFee]=? where CoID=?";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, rentalFee);
                pr.setString(3, id);
                rs = pr.executeUpdate();
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ArrayList<ContractDTO> getPendingContract(int UID) {
        Connection cn = null;
        ArrayList<ContractDTO> result = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                        + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                        + "[EndDate], [Name], [Description], [dbo].[Contract].[Status]\n"
                        + "from [dbo].[Contract]\n"
                        + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                        + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                        + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID] \n"
                        + "where [dbo].[Contract].[UID] = ? and [dbo].[Contract].[Status] = 0";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, UID);
                ResultSet rs = pr.executeQuery();
                if (result != null) {
                    while (rs.next()) {
                        ContractDTO nw = new ContractDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), BigDecimal.valueOf(rs.getDouble(7)), BigDecimal.valueOf(rs.getDouble(7)), rs.getDate(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                        result.add(nw);
                    }
                }
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int countAvailableContracts() {
        Connection cn = null;
        int result = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select *\n"
                        + "from [dbo].[Contract]\n"
                        + "where [Status] = 1";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        result++;
                    }
                }
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int countContract(char userType, int id) {
        int result = 0;
        if (userType != 'C') {
            Connection cn = null;
            try {
                cn = DBUtils.getConnection();
                if (cn != null) {
                    String sql = "select [dbo].[Contract].[CoID], [dbo].[Contract].[RoID], [dbo].[Contract].[UID], [dbo].[User].[Fullname],\n"
                            + "[dbo].[Contract].[OID], [dbo].[Owner].[Fullname], [RentalFee], [SystemFee], [CreateDate],\n"
                            + "[EndDate], [EndDate], [Description], [dbo].[Contract].[Status]\n"
                            + "from [dbo].[Contract]\n"
                            + "left join [dbo].[ContractInformation] on Contract.[CoID] = [dbo].[ContractInformation].[CoID] \n"
                            + "left join [dbo].[User] on [dbo].[Contract].UID = [dbo].[User].UID\n"
                            + "left join [dbo].[Owner] on [dbo].[Contract].[OID] = [dbo].[Owner].[OID]\n";
                    if (userType == 'R') {
                        sql = sql + " where Contract.[UID]=?";
                    } else {
                        sql = sql + " where Contract.[OID]=?";
                    }
                    sql = sql + " and [dbo].[Contract].[Status] = 1";
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.setInt(1, id);
                    ResultSet rs = pst.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            result++;
                        }
                    }
                    cn.close();
                }
            } catch (Exception e) {
                e.getCause();
            }
        }
        return result;
    }
    
    public static int submitContract(int CoID){
        Connection cn = null;
        int rs = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Contract] set Status = 1 where CoID = ?";
                PreparedStatement pr = cn.prepareStatement(sql);
                pr.setInt(1, CoID);
                rs = pr.executeUpdate();
                cn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
