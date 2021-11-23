package com.imooc.spring.ioc.entity;

public class Computer {
    private String brand;
    private String type;
    private String seriesNumber;
    private float price;

    public Computer() {
    }

    public Computer(String brand, String type, String seriesNumber, float price) {
        this.brand = brand;
        this.type = type;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", seriesNumber='" + seriesNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
