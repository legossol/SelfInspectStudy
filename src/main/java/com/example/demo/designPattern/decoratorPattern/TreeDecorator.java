package com.example.demo.designPattern.decoratorPattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree christmasTree;

    @Override
    public String decorate(){
        return christmasTree.decorate();
    }
}
