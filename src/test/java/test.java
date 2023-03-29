
import DAO.*;
import Entity.*;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Van Toan
 */
public class test {
    public static void main(String[] args) {
        BillLineDAO dao= new BillLineDAO();
        System.out.println("hello");
        List<MoneyByMonth> list= dao.StatisByMonth();
        for(MoneyByMonth i:list){
            System.out.println(i.getMonth()+" "+i.getTotalMoney());
        }
    }
}
