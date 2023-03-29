/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
 
/**
 *
 * @author Nguyen Van Toan
 */

public class DAO {
    public static Connection con=null;
     
    public DAO(){
        if(con == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LTW;", "sa","password");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
