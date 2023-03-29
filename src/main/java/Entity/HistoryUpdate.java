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
public class HistoryUpdate {
    private Staff staff;
    private Product product;
    private String date;
    private String status;

    public HistoryUpdate(Staff staff, Product product, String date, String status) {
        this.staff = staff;
        this.product = product;
        this.date = date;
        this.status = status;
    }

    public HistoryUpdate() {
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
