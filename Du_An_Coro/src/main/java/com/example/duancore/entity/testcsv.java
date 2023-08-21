package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "testcsv")
@Entity
public class testcsv {

    @Id
    @Column(name = "mCSV")
    private String maCSV;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "title")
    private String title;

    public testcsv() {
    }

    public testcsv(String maCSV, String image, String name, float price, int soLuong, String title) {
        this.maCSV = maCSV;
        this.image = image;
        this.name = name;
        this.price = price;
        this.soLuong = soLuong;
        this.title = title;
    }

    public String getMaCSV() {
        return maCSV;
    }

    public void setMaCSV(String maCSV) {
        this.maCSV = maCSV;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
