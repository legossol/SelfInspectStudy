package com.example.demo.designPattern.decoratorPattern;

public class WhiteToneBulb extends TreeDecorator{
    public WhiteToneBulb(ChristmasTree christmasTree){
        super(christmasTree); //이곳이 포인트
    }
    public String addWhiteToneBulb(){
        return "with whiteBulbTree";
    }
    @Override
    public String decorate(){
        return super.decorate() + addWhiteBulb(); //이곳이 포인트
    }
}
