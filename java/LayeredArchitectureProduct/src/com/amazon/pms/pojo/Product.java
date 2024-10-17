package com.amazon.pms.pojo;

import java.time.LocalDate;

public class Product {
    private int pid;
    private String pname;
    private double price;
    private LocalDate purchaseDate;

    public Product() {
        // Default constructor
    }

    // Constructor with all fields
    public Product(int pid, String pname, double price, LocalDate purchaseDate) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Getters and Setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", purchaseDate=" + purchaseDate + "]";
    }
}
