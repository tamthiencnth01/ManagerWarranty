package com.thien.model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private String image;

    public Product() {
    }

    public Product(int id, String nameProduct, double price, String image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
    }

    public Product(String nameProduct, double price, String image) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
