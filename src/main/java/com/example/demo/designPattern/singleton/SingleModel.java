package com.example.demo.designPattern.singleton;

public class SingleModel {

    private int num;
    public static int staticNum;
    private String faile = "합격";

    static {
        staticNum = 5;
    }

    public SingleModel() {
        this.num = 5;

    }

    public int plus() {
        num++;
        return num;
    }

    public int getNum() {
        return this.num;
    }
}
