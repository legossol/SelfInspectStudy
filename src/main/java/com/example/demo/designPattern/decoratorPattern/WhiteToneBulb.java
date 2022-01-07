package com.example.demo.designPattern.decoratorPattern;

public class WhiteToneBulb extends TreeDecorator{
    public WhiteToneBulb(ChristmasTree christmasTree){
        super(christmasTree); //이곳이 포인트
    }
    private String addWhiteToneBulb(){
        return "with whiteBulbTree";
    }

    public String decorate(){
        return super.decorate() + addWhiteToneBulb(); //이곳이 포인트
    }
}
