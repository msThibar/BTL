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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Van Toan
 */
public class BillLineDAO extends DAO{

    public BillLineDAO() {
    }
    public List<MoneyByProd> StatisByProd(){
        List<MoneyByProd> list= new ArrayList<>();
        String sql= "select idProduct, Sum(price), Sum(price*amount) from tblBillLine group by tblBillLine.idProduct";
        PreparedStatement ps= null;
        ResultSet rs= null;
        try {
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MoneyByProd(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<MoneyByMonth> StatisByMonth(){
        List<MoneyByMonth> list=new ArrayList<>();
        String sql="select FORMAT(date,'yyyy-MM'), sum(money.total) from (select idBill, sum(price*amount) as total from tblBillLine Group by idBill) as money "
                + "inner join tblBill "
                + "On tblBill.id=money.idBill "
                + "Group by FORMAT(date,'yyyy-MM') "
                + "order by FORMAT(date,'yyyy-MM') asc";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MoneyByMonth(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public List<BillLine> getByMonth(String month){
        List<BillLine> list = new ArrayList<>();
        try {
            String sql = "select idProduct, price, amount from tblBillLine inner join tblBill on tblBill.id=tblBillLine.idBill where FORMAT(tblBill.date, 'yyyy-MM') = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillLine tmp= new BillLine();
                tmp.setProduct(new Product(rs.getInt(1)));
                tmp.setPrice(rs.getInt(2));
                tmp.setAmount(rs.getInt(3));
                list.add(tmp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BillLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<BillLine> getByProd(String prod){
        List<BillLine> list = new ArrayList<>();
        try {
            String sql = "select tblBill.date, price, amount from tblBillLine "
                    + "inner join tblBill on tblBill.id=tblBillLine.idBill where tblBillLine.idProduct = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, prod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillLine tmp= new BillLine();
                tmp.setBill(new Bill(rs.getString(1)));
                tmp.setPrice(rs.getInt(2));
                tmp.setAmount(rs.getInt(3));
                list.add(tmp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BillLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
