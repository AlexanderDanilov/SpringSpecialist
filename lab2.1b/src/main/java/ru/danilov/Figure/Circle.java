package ru.danilov.Figure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle extends Shape{
    private Cords center;
    private int radius;


    public Circle(@Value("${circle.x}") int x, @Value("${circle.y}") int y, @Value("${circle.radius}") int radius, @Value("${circle.color}") String color) {
        this.center = new Cords();
        this.center.setX(x);
        this.center.setY(y);
        this.radius = radius;
        setColor(color);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Draw circle with cords: %s(color:%s) radius: %d", center,getColor(),radius));
    }
}
