package com.example.demo.designPattern.decoratorPattern;

public class WhiteToneFlower extends TreeDecorator{
    public WhiteToneFlower(ChristmasTree christmasTree){
        super(christmasTree); //이곳이 포인트
    }
    public String addWhiteToneFlower(){
        return "with whiteBulbTree";
    }
    @Override
    public String decorate(){
        return super.decorate() + addWhiteToneFlower(); //이곳이 포인트
    }
}
