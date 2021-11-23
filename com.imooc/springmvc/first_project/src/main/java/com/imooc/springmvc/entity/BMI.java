package com.imooc.springmvc.entity;

public class BMI {
    private int height;
    private int weight;
    private String result;

    public BMI(int height, int weight, String result) {
        this.height = height;
        this.weight = weight;
        this.result = result;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
