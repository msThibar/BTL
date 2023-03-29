
import DAO.ProductDAO;
import Entity.Product;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Van Toan
 */
public class NewClass {
    public static void main(String[] args) {
        ProductDAO dao= new ProductDAO();
        Scanner sc= new Scanner(System.in);
        
        String name= sc.nextLine();
        System.out.println(name);
        List<Product> list= dao.getProductsByName(name);
        for(Product i: list){
            System.out.println(i.getId());
            System.out.println(i.getName());
        }
    }
}
