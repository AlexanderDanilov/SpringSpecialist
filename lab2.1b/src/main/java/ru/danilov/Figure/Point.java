package ru.danilov.Figure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Point extends Shape {
    private Cords cords;


    @Autowired
    public Point(@Value("${point.x}") int x, @Value("${point.y}") int y, @Value("${point.color}") String color) {
        this.cords = new Cords();
        this.cords.setX(x);
        this.cords.setY(y);
        setColor(color);
    }

    @Override
    public void draw() {
        System.out.println("Draw point with cords: " + cords + " color: " + getColor());
    }
}
