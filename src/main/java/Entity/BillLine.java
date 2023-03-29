/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Nguyen Van Toan
 */
public class BillLine {
    private Bill bill;
    private Product product;
    private int amount;
    private int price;

    public BillLine(Bill bill, Product product, int amount, int price) {
        this.bill = bill;
        this.product = product;
        this.amount = amount;
        this.price = price;
    }
    public BillLine(String product, int amount, int price) {
        this.product.setName(product);
        this.amount = amount;
        this.price = price;
    }

    public BillLine() {
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
