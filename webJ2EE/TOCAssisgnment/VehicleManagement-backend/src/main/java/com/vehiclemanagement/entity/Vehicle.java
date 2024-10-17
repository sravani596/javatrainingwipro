package com.vehiclemanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Vehicle_Info")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(name = "vehicle_number")
    //@NotNull
    //@NotBlank
   
    private String vehicleNumber;

    @Column(name = "vehicle_name")
    //@NotNull
   // @NotBlank
    //@Pattern(regexp = "[A-Z][a-z]{4,}")
    private String vehicleName;

    @Column(name = "price")
    private double price;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    // Default constructor
    public Vehicle() {
    }

    // Parameterized constructor
    public Vehicle(int vehicleId, String vehicleNumber, String vehicleName, double price, LocalDate purchaseDate) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Getters and Setters
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
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
        return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName
                + ", price=" + price + ", purchaseDate=" + purchaseDate + "]";
    }
}
