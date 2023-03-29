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
public class Product {
    private int id;
    private String name;
    private int price;
    private String tittle;
    private String image;
    private Classify classify;

    public Product(int id, String name, int price, String tittle, String image, Classify cla) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tittle = tittle;
        this.image = image;
        this.classify = cla;
    }

    public Product(String name) {
        this.name = name;
    }
    
    public Product(int id) {
        this.id= id;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }
    
}
