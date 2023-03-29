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
/**
 *
 * @author Nguyen Van Toan
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClassifyDAO extends DAO{

    public ClassifyDAO() {
        super();
    }
    public List<Classify> getAllClassify(){
        List<Classify> list= new ArrayList<>();
        PreparedStatement ps= null;
        ResultSet rs= null;
        String str= "SELECT * FROM tblClassify";
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Classify(rs.getInt(1), rs.getNString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassifyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
