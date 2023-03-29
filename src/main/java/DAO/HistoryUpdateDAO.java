/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Van Toan
 */
public class HistoryUpdateDAO extends DAO {

    public HistoryUpdateDAO() {
        super();
    }

    public void addHis(HistoryUpdate his) {
        PreparedStatement ps = null;
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        String sql = "insert into tblHistoryUpdate (idP, idS, date, statusUpdate) "
                + "values (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, his.getProduct().getId());
            ps.setInt(2, his.getStaff().getId());
            ps.setString(3, format.format(date));
            ps.setString(4, his.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoryUpdateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
