package com.thien.model;

public class Service {
    private int id;
    private String description;
    private String units;
    private int quantities;
    private double unitPrice;
    private double amount;

    public Service() {
        super();
    }

    public Service(int id, String description, String units, int quantities, double unitPrice, double amount) {
        super();
        this.id = id;
        this.description = description;
        this.units = units;
        this.quantities = quantities;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public Service(String description) {
        this.description = description;
    }

    public Service(String description, String units, int quantities, double unitPrice, double amount) {
        super();
        this.description = description;
        this.units = units;
        this.quantities = quantities;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public Service(String description, double amount) {
        super();
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
