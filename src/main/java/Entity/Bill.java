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
public class Bill {
    private int id;
    private Customer customer;
    private Staff staff;
    private String date;
    private String transCode;

    public Bill(int id, Customer customer, Staff staff, String date, String transCode) {
        this.id = id;
        this.customer = customer;
        this.staff = staff;
        this.date = date;
        this.transCode = transCode;
    }

    public Bill() {
    }

    public Bill(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }
    
}
