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
public class Classify {
    private int id;
    private String tittle;

    public Classify() {
    }

    public Classify(int id, String tittle) {
        this.id = id;
        this.tittle = tittle;
    }

    public Classify(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
