/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Entity.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Nguyen Van Toan
 */
public class StaffDAO extends DAO{

    public StaffDAO() {
        super();
    }

    
    public void getStaff(Staff staff){
        PreparedStatement ps= null;
        ResultSet rs = null;
        boolean f=true;
        try {
            
            String sql = "SELECT * FROM tblStaff WHERE username = ? and password= ?";
            ps= con.prepareStatement(sql);
            ps.setString(1, staff.getUsername());
            ps.setString(2, staff.getPassword());
            rs= ps.executeQuery();
            if (rs.next()) {
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getNString("name"));
                staff.setUsername(rs.getNString("username"));
                staff.setPassword(rs.getNString("password"));
                staff.setIdCard(rs.getNString("idCard"));
                staff.setAddress(rs.getNString("address"));
                staff.setPhone(rs.getNString("phone"));
                staff.setBirth(rs.getDate("birth"));
                staff.setEmail(rs.getNString("email"));
                staff.setPosition(rs.getNString("position"));
                f= false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(f) staff= null;
    }
}
