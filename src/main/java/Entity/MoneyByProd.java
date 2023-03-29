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
public class MoneyByProd {
    int name;
    int price;
    int totalMoney;

    public MoneyByProd() {
    }

    public MoneyByProd(int name, int price, int totalMoney) {
        this.name = name;
        this.price = price;
        this.totalMoney = totalMoney;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    
}
