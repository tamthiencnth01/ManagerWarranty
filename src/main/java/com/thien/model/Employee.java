package com.thien.model;

import java.util.Date;

public class Employee {
    private int id;
    private String nameEmp;
    private String address;
    private Date dob;
    private String gender;
    private String nation;
    private String phone;
    private String image;


    public Employee(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public Employee(String nameEmp, String address, Date dob, String gender, String nation, String phone, String image) {
        this.nameEmp = nameEmp;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.nation = nation;
        this.phone = phone;
        this.image = image;
    }

    public Employee() {
    }

    public Employee(int id, String nameEmp, String address, Date dob, String gender, String nation, String phone, String image) {
        this.id = id;
        this.nameEmp = nameEmp;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.nation = nation;
        this.phone = phone;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nameEmp='" + nameEmp + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", nation='" + nation + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
