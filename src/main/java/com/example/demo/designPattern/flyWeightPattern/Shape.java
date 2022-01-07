package com.example.demo.designPattern.flyWeightPattern;

import java.util.HashMap;
import lombok.Setter;

public interface Shape {
    public void draw();

}
@Setter
class Circle implements Shape{
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
    }

    @Override
    public void draw() {
        System.out.println("Circle color= "+color+",x = "+x+"y = "+y+",radius = "+radius);
    }
}
class ShapeFactory{
    private static final HashMap<String, Circle> circleMap = new HashMap<>();

    public static Shape getCircle(String color){
        Circle circle = circleMap.get(color);

        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("new obejct generated =" + color + " color");
        }
        return circle;
    }
}
class Main{

    public static void main(String[] args) {
        String[] color = {"Red", "Blue", "Orange", "purple"};

        for(int i = 0; i < 10; i ++){
            Circle circle = (Circle) ShapeFactory.getCircle(color[(int)(Math.random()*4)]);
            circle.setX((int) (Math.random()*100));
            circle.setY((int) (Math.random()*4));
            circle.setRadius((int) (Math.random()*10));
            circle.draw();
        }
    }
}