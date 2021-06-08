package com.thien.model;

import java.util.Date;

public class Customer {
    private int id;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String description;
    private String nameEmp;
    private double amount;
    private Date startDate;
    private int quantities;



    public Customer() {
        super();
    }

    public Customer(int id, String fullName, String address, String email, String phone) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Customer(String fullName, String address, String email, String phone) {
        super();
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Customer(int id, String fullName, String address) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.address = address;
    }

    public Customer(int id, String fullName, String address, String description, String nameEmp,  Date startDate,double amount) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.description = description;
        this.nameEmp = nameEmp;
        this.amount = amount;
        this.startDate = startDate;
    }

    public Customer(int id, String fullName, String address, String description, double amount) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.description = description;
        this.amount = amount;
    }

    public Customer(int id, String fullName, String address, String description, String nameEmp, Date startDate) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.description = description;
        this.nameEmp = nameEmp;
        this.amount = amount;
        this.startDate = startDate;
    }

    public Customer(int id, String fullName, String address, String email, String phone, String description, String nameEmp, int quantities) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.nameEmp = nameEmp;
        this.quantities = quantities;
    }

    public Customer(int id, String fullName, String address, String email, String phone, String description, String nameEmp) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.nameEmp = nameEmp;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
