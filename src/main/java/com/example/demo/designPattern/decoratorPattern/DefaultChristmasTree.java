package com.example.demo.designPattern.decoratorPattern;

public class DefaultChristmasTree implements ChristmasTree{
    @Override
    public String decorate(){
        return "Christmas tree";
    }
}
