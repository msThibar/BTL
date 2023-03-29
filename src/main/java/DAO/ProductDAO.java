/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Entity.Classify;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Van Toan
 */
public class ProductDAO extends DAO{

    public ProductDAO() {
        super();
    }
    public List<Product> getAllProduct(){
        List<Product> list= new ArrayList<>();
        PreparedStatement ps= null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT * FROM tblProduct inner join tblClassify on tblProduct.classify=tblClassify.id";
            //statement = con.createStatement();
            //rs = statement.executeQuery(sql);
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getNString(2),
                        rs.getInt(3), rs.getNString(4),
                        rs.getNString(6),
                        new Classify(rs.getInt(7), rs.getNString(8))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getTop3(){
        List<Product> list= new ArrayList<>();
        String sql="SELECT top 3 * FROM tblProduct inner join tblClassify on tblProduct.classify=tblClassify.id";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getNString(2),
                        rs.getInt(3), rs.getNString(4),
                        rs.getNString(6),
                        new Classify(rs.getInt(7), rs.getNString(8))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Product> getNext3(int num){
        List<Product> list= new ArrayList<>();
        String sql="SELECT * FROM tblProduct inner join tblClassify on tblProduct.classify=tblClassify.id "
                + "order by tblProduct.id OFFSET ? ROWS "
                + "FETCH NEXT 3 ROWS ONLY";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getNString(2),
                        rs.getInt(3), rs.getNString(4),
                        rs.getNString(6),
                        new Classify(rs.getInt(7), rs.getNString(8))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Product> getProductsByName(String name){
        List<Product> list= new ArrayList<>();
        PreparedStatement ps= null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT * FROM tblProduct inner join tblClassify on"
                    + " tblProduct.classify=tblClassify.id  where tblProduct.name Like ?";
            //statement = con.createStatement();
            //rs = statement.executeQuery(sql);
            ps= con.prepareStatement(sql);
            ps.setNString(1, "%"+name+"%");
            rs= ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getNString(2),
                        rs.getInt(3), rs.getNString(4),
                        rs.getNString(6),
                        new Classify(rs.getInt(7), rs.getNString(8))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Product> getProductsByClassify(int id){
        List<Product> list= new ArrayList<>();
        PreparedStatement ps= null;
        ResultSet rs= null;
        try{
            String sql= "SELECT * FROM tblProduct inner join tblClassify on"
                    + " tblProduct.classify=tblClassify.id where classify = ?";
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getNString(2),
                        rs.getInt(3), rs.getNString(4),
                        rs.getNString(6),
                        new Classify(rs.getInt(7), rs.getNString(8))));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public void getProdById(Product prod){
        PreparedStatement ps= null;
        ResultSet rs= null;
        try{
            String sql= "SELECT * FROM (select * from tblProduct where id = ?) as prod"
                    + " inner join tblClassify on  prod.classify=tblClassify.id ";
            ps= con.prepareStatement(sql);
            ps.setInt(1, prod.getId());
            rs= ps.executeQuery();
            if(rs.next()){
                prod.setName(rs.getNString(2));
                prod.setPrice(rs.getInt(3));
                prod.setTittle(rs.getNString(4));
                prod.setImage(rs.getNString(6));
                prod.setClassify(new Classify(rs.getInt(7), rs.getNString(8)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void add(Product prod){
        PreparedStatement ps= null;
        ResultSet rs= null;
        String sql= "INSERT INTO tblProduct (name, price, tittle, classify, image) " +
            "values (?, ?, ?, ?, ?)";
        String sql2="select top 1 id from tblProduct order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setNString(1, prod.getName());
            ps.setInt(2, prod.getPrice());
            ps.setNString(3, prod.getTittle());
            ps.setInt(4, prod.getClassify().getId());
            ps.setNString(5, prod.getImage());
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            rs= ps.executeQuery();
            if(rs.next()){
                prod.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void edit(Product prod){
        try {
            PreparedStatement ps= null;
            ResultSet rs= null;
            String sql="Update tblProduct set name= ?, price= ?, tittle = ?, classify = ?, [image] = ?"
                    + " where id=?";
            ps= con.prepareStatement(sql);
            ps.setNString(1, prod.getName());
            ps.setInt(2, prod.getPrice());
            ps.setNString(3, prod.getTittle());
            ps.setInt(4, prod.getClassify().getId());
            ps.setNString(5, prod.getImage());
            ps.setInt(6, prod.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void remove(int id){
        PreparedStatement ps= null;
        ResultSet rs= null;
        String sql= "Delete from tblProduct where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
